package com.mytaxi.controller.mapper;

import com.mytaxi.datatransferobject.CarDTO;
import com.mytaxi.domainobject.CarDO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class CarMapper {

    public static CarDO makeCarDO(CarDTO carDTO) {
        return new CarDO(carDTO.getCarId(), carDTO.getLicensePlate(), carDTO.getSeatCount(), carDTO.getConvertible(),
                carDTO.getRating(), carDTO.getEngineType(), carDTO.getManufacturer());
    }


    public static CarDTO makeCarDTO(CarDO carDO) {
        CarDTO carDTO = new CarDTO.CarDTOBuilder().setCarId(carDO.getCarId())
                .setConvetible(carDO.getConvertible())
                .setEngineType(carDO.getEngineType())
                .setLicensePlate(carDO.getLicensePlate())
                .setManufacturer(carDO.getManufacturer())
                .setRating(carDO.getRating())
                .setSeatCount(carDO.getSeatCount())
                .build();

        if (carDO.getDriverDO() != null && carDO.getDriverDO().getId() != null) {
            carDTO.setDriverId(carDO.getDriverDO().getId());
        }
        return carDTO;
    }


    public static List<CarDTO> makeCarDTOList(Collection<CarDO> Cars) {
        return Cars.stream()
                .map(CarMapper::makeCarDTO)
                .collect(Collectors.toList());
    }
}
