package com.mytaxi.service.driver;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.exception.EntityNotFoundException;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface CarService {

    CarDO findCar(long carId) throws EntityNotFoundException;

    CarDO saveCar(CarDO carDO);

    CarDO create(CarDO carDO) throws ConstraintsViolationException;

    CarDO update(CarDO carDTO);

    void delete(Long carId);


    List<CarDO> findAll();
}
