package com.mytaxi.builder;

import com.mytaxi.domainobject.CarDO;

public class CarDOBuilder {

    private CarDO carDO;

    public CarDOBuilder() {
        this.carDO = new CarDO();
    }

    public CarDOBuilder withCarDetails(Long carId) {
        carDO.setCarId(carId);
        return this;
    }

    public CarDO build() {
        return carDO;
    }
}
