package com.mytaxi.domainobject;

import com.mytaxi.domainvalue.EngineType;

import javax.persistence.*;

@Entity
@Table(
        name = "car"
)
public class CarDO {

    @Id
    @GeneratedValue
    private Long carId;

    @Column(nullable = false)
    private String licensePlate;

    @Column(nullable = false)
    private Integer seatCount;

    @Column(nullable = false)
    private String convertible;

    @Column(nullable = false)
    private Integer rating;

    @Column(nullable = false)
    private String manufacturer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private EngineType engineType;


    @OneToOne
    @JoinColumn(name = "DRIVER_ID")
    private DriverDO driverDO;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public String getConvertible() {
        return convertible;
    }

    public void setConvertible(String convertible) {
        this.convertible = convertible;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public DriverDO getDriverDO() {
        return driverDO;
    }

    public void setDriverDO(DriverDO driverDO) {
        this.driverDO = driverDO;
    }

    public CarDO(Long carId, String licensePlate, Integer seatCount, String convertible,
                 Integer rating, EngineType engineType, String manufacturer) {
        this.carId = carId;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.convertible = convertible;
        this.rating = rating;
        this.engineType = engineType;
        this.manufacturer = manufacturer;
    }

    public CarDO() {
    }
}
