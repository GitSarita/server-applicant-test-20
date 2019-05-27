package com.mytaxi.service;

import com.mytaxi.dataaccessobject.CarRepository;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.exception.ConstraintsViolationException;
import com.mytaxi.service.driver.DefaultCarService;
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
public class CarServiceTest {

    @Mock
    CarRepository carRepository;

    @InjectMocks
    DefaultCarService carService;

    @Test
    public void testFindCar() {
        when(carRepository.findById(any())).thenReturn(Optional.of(new CarDO()));
        Assert.assertNotNull(carService.findCar(1L));
    }

    @Test
    public void testCreateCar() throws ConstraintsViolationException {
        when(carRepository.save(any())).thenReturn(new CarDO());
        Assert.assertNotNull(carService.create(new CarDO()));
    }

    @Test
    public void testUpdateCar(){
        when(carRepository.save(any())).thenReturn(new CarDO());
        Assert.assertNotNull(carService.update(new CarDO()));
    }
}
