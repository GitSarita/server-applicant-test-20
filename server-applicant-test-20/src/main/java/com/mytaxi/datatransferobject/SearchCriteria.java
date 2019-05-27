package com.mytaxi.datatransferobject;

import com.mytaxi.domainvalue.EngineType;

public class SearchCriteria {

    private Long carId;

    private String licensePlate;

    private Integer seatCount;

    private String convertible;

    private Integer rating;

    private String manufacturer;

    private EngineType engineType;

    private Long driverId;

    private String username;

    private String onlineStatus;

    public String getOnlineStatus() {
        return onlineStatus;
    }

    public Long getCarId() {
        return carId;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public Integer getSeatCount() {
        return seatCount;
    }

    public String getConvertible() {
        return convertible;
    }

    public Integer getRating() {
        return rating;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public Long getDriverId() {
        return driverId;
    }

    public String getUsername() {
        return username;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setSeatCount(Integer seatCount) {
        this.seatCount = seatCount;
    }

    public void setConvertible(String convertible) {
        this.convertible = convertible;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
    }
}
