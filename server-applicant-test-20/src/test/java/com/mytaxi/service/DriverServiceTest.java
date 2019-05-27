package com.mytaxi.service;

import com.mytaxi.builder.CarDOBuilder;
import com.mytaxi.builder.DriverDOBuilder;
import com.mytaxi.dataaccessobject.DriverRepository;
import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.OnlineStatus;
import com.mytaxi.exception.EntityNotFoundException;
import com.mytaxi.service.driver.DefaultCarService;
import com.mytaxi.service.driver.DefaultDriverService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
public class DriverServiceTest {

    @Mock
    private DefaultCarService carService;

    @Mock
    private DriverRepository driverRepository;


    @InjectMocks
    private DefaultDriverService driverService;

    @Test
    public void testFindDriver() throws EntityNotFoundException {
        when(driverRepository.findById(any())).thenReturn(Optional.of(new DriverDO("user", "pass")));
        DriverDO driverDO = driverService.find(1L);
        Assert.assertNotNull(driverDO);
    }

    @Test
    public void testSelectCar() throws Exception {
        when(driverRepository.findByIdAndOnlineStatus(9L, OnlineStatus.ONLINE))
                .thenReturn(Optional.of(new DriverDOBuilder()
                        .withDriverDO(9L,"user","pass",OnlineStatus.ONLINE)
                        .build()));
        CarDO inputCar = new CarDOBuilder().withCarDetails(2L).build();
        when(carService.findCar(1)).thenReturn(inputCar);
        when(carService.saveCar(inputCar)).thenReturn(inputCar);
        CarDTO carDO = driverService.updateCarSelection(9, 1, "Select");
        Assert.assertNotNull(carDO);
        Assert.assertEquals(9L, (long) carDO.getDriverId());
    }

    @Test
    public void testDeSelectCar() throws Exception {
        DriverDO driverDO = new DriverDOBuilder()
                .withDriverDO(9L, "user", "pass", OnlineStatus.ONLINE)
                .build();
        when(driverRepository.findByIdAndOnlineStatus(9L, OnlineStatus.ONLINE))
                .thenReturn(Optional.of(driverDO));
        CarDO inputCar = new CarDOBuilder().withCarDetails(2L).build();
        inputCar.setDriverDO(driverDO);
        when(carService.findCar(1)).thenReturn(inputCar);
        when(carService.saveCar(inputCar)).thenReturn(inputCar);
        CarDTO carDO = driverService.updateCarSelection(9, 1, "UnSelect");
        Assert.assertNotNull(carDO);
        Assert.assertNull(carDO.getDriverId());
    }
}
