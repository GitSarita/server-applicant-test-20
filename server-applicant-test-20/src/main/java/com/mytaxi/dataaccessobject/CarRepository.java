package com.mytaxi.dataaccessobject;

import com.mytaxi.domainobject.CarDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository  extends CrudRepository<CarDO, Long> {
//
//    Optional<CarDO> findByIdAndDriverId(Long Id, Long driverId);
}
