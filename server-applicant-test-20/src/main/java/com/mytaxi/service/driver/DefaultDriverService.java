package com.mytaxi.service.driver;

import com.mytaxi.controller.mapper.CarMapper;
import com.mytaxi.dataaccessobject.DriverRepository;
import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.Action;
import com.mytaxi.domainvalue.GeoCoordinate;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.CarSelectionException;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some driver specific things.
 * <p/>
 */
@Service
public class DefaultDriverService implements DriverService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultDriverService.class);

    private final DriverRepository driverRepository;
    private final CarService carService;

    @Autowired
    public DefaultDriverService(final DriverRepository driverRepository, final CarService carService) {
        this.driverRepository = driverRepository;
        this.carService = carService;
    }


    /**
     * Selects a driver by id.
     *
     * @param driverId
     * @return found driver
     * @throws EntityNotFoundException if no driver with the given id was found.
     */
    @Override
    public DriverDO find(Long driverId) throws EntityNotFoundException {
        return findDriverChecked(driverId);
    }


    /**
     * Creates a new driver.
     *
     * @param driverDO
     * @return
     * @throws ConstraintsViolationException if a driver already exists with the given username, ... .
     */
    @Override
    public DriverDO create(DriverDO driverDO) throws ConstraintsViolationException {
        DriverDO driver;
        try {
            driver = driverRepository.save(driverDO);
        } catch (DataIntegrityViolationException e) {
            LOG.warn("ConstraintsViolationException while creating a driver: {}", driverDO, e);
            throw new ConstraintsViolationException(e.getMessage());
        }
        return driver;
    }


    /**
     * Deletes an existing driver by id.
     *
     * @param driverId
     * @throws EntityNotFoundException if no driver with the given id was found.
     */
    @Override
    @Transactional
    public void delete(Long driverId) throws EntityNotFoundException {
        DriverDO driverDO = findDriverChecked(driverId);
        driverDO.setDeleted(true);
    }


    /**
     * Update the location for a driver.
     *
     * @param driverId
     * @param longitude
     * @param latitude
     * @throws EntityNotFoundException
     */
    @Override
    @Transactional
    public void updateLocation(long driverId, double longitude, double latitude) throws EntityNotFoundException {
        DriverDO driverDO = findDriverChecked(driverId);
        driverDO.setCoordinate(new GeoCoordinate(latitude, longitude));
    }


    /**
     * Find all drivers by online state.
     *
     * @param onlineStatus
     */
    @Override
    public List<DriverDO> find(OnlineStatus onlineStatus) {
        return driverRepository.findByOnlineStatus(onlineStatus);
    }

    /**
     * Find a driver by driver Id and online state.
     *
     * @param driverId
     * @param onlineStatus
     */
    @Override
    public DriverDO find(Long driverId, OnlineStatus onlineStatus) throws EntityNotFoundException {
        return driverRepository.findByIdAndOnlineStatus(driverId, onlineStatus)
                .orElseThrow(() -> new EntityNotFoundException("Either driver Id not Found or driver is Offline"));
    }

    @Override
    @Transactional
    public CarDTO updateCarSelection(long driverId, long carId, String action) throws Exception {
        if (Action.Select.name().equals(action)) {
            return CarMapper.makeCarDTO(selectCar(driverId, carId));
        } else {
            return CarMapper.makeCarDTO(deSelectCar(driverId, carId));
        }
    }

    @Override
    public List<DriverDO> findAll() {
        return (List<DriverDO>) driverRepository.findAll();
    }

    public CarDO selectCar(long driverId, long carId) throws Exception {
        CarDO selectedCarDO;
        DriverDO driverDO = find(driverId, OnlineStatus.ONLINE);
        if (driverDO.getCarDO() != null) {
            throw new CarSelectionException("Driver has already selected a car with ID: "
                    + driverDO.getCarDO().getCarId());
        }
        CarDO carDO = carService.findCar(carId);
        if (carDO.getDriverDO() == null) {
            carDO.setDriverDO(driverDO);
            selectedCarDO = carService.saveCar(carDO);
        } else {
            throw new CarSelectionException("car already allocated to driver : " + carDO.getDriverDO().getId());
        }
        return selectedCarDO;
    }

    public CarDO deSelectCar(long driverId, long carId) throws Exception {
        CarDO unSelectedCarDO;
        DriverDO driverDO = find(driverId, OnlineStatus.ONLINE);
        CarDO carDO = carService.findCar(carId);
        if (carDO.getDriverDO() != null) {
            carDO.setDriverDO(null);
            unSelectedCarDO = carService.saveCar(carDO);
        } else {
            throw new CarSelectionException("car already de allocated by driver : " + driverId);
        }
        return unSelectedCarDO;
    }


    private DriverDO findDriverChecked(Long driverId) throws EntityNotFoundException {
        return driverRepository.findById(driverId)
                .orElseThrow(() -> new EntityNotFoundException("Could not find entity with id: " + driverId));
    }


}
