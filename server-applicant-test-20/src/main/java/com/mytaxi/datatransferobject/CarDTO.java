package com.mytaxi.datatransferobject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mytaxi.domainvalue.EngineType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CarDTO {
    private Long carId;

    private String licensePlate;

    private Integer seatCount;

    private String convertible;

    private Integer rating;

    private String manufacturer;

    private EngineType engineType;

    private Long driverId;

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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public EngineType getEngineType() {
        return engineType;
    }

    public void setEngineType(EngineType engineType) {
        this.engineType = engineType;
    }

    public Long getDriverId() {
        return driverId;
    }

    public void setDriverId(Long driverId) {
        this.driverId = driverId;
    }

    private CarDTO(Long carId, String licensePlate, Integer seatCount, String convertible,
                   Integer rating, String manufacturer, EngineType engineType, Long driverId) {
        this.carId = carId;
        this.licensePlate = licensePlate;
        this.seatCount = seatCount;
        this.convertible = convertible;
        this.rating = rating;
        this.manufacturer = manufacturer;
        this.engineType = engineType;
        this.driverId = driverId;
    }

    public CarDTO() {
    }

    public static class CarDTOBuilder {

        private Long carId;

        private String licensePlate;

        private Integer seatCount;

        private String convertible;

        private Integer rating;

        private String manufacturer;

        private EngineType engineType;

        private Long driverId;

        public CarDTOBuilder setCarId(Long carId) {
            this.carId = carId;
            return this;
        }

        public CarDTOBuilder setLicensePlate(String licensePlate) {
            this.licensePlate = licensePlate;
            return this;
        }

        public CarDTOBuilder setSeatCount(Integer seatCount) {
            this.seatCount = seatCount;
            return this;
        }

        public CarDTOBuilder setConvetible(String convertible) {
            this.convertible = convertible;
            return this;
        }

        public CarDTOBuilder setRating(Integer rating) {
            this.rating = rating;
            return this;
        }

        public CarDTOBuilder setManufacturer(String manufacturer) {
            this.manufacturer = manufacturer;
            return this;
        }

        public CarDTOBuilder setEngineType(EngineType engineType) {
            this.engineType = engineType;
            return this;
        }

        public CarDTO build() {
            return new CarDTO(carId, licensePlate, seatCount, convertible, rating, manufacturer, engineType, driverId);
        }

        public CarDTOBuilder setDriverId(Long id) {
            this.driverId = id;
            return this;
        }

    }
}
