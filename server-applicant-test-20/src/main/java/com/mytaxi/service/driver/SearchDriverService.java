package com.mytaxi.service.driver;

import com.mytaxi.datatransferobject.SearchCriteria;
import com.mytaxi.domainobject.CarDO;
import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.OnlineStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class SearchDriverService {

    private EntityManager entityManager;

    @Autowired
    public SearchDriverService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<DriverDO> searchDrivers(SearchCriteria input) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<DriverDO> q = cb.createQuery(DriverDO.class);
        Root<DriverDO> driverDORoot = q.from(DriverDO.class);
        Join<DriverDO, CarDO> driverJoinCar = driverDORoot.join("carDO",JoinType.LEFT);

        List<Predicate> predicates = getPredicates(input, cb, driverDORoot, driverJoinCar);

        q.where(cb.and(predicates.toArray(new Predicate[predicates.size()])));
        return entityManager.createQuery(q).getResultList();
    }

    private List<Predicate> getPredicates(SearchCriteria input, CriteriaBuilder cb,
                                          Root<DriverDO> driverDORoot, Join<DriverDO, CarDO> driverJoinCar) {
        List<Predicate> predicates = new ArrayList<>();
        if (input.getUsername() != null) {
            predicates.add(cb.equal(driverDORoot.get("username"), input.getUsername()));
        }
        if (input.getOnlineStatus() != null) {
            predicates.add(cb.equal(driverDORoot.get("onlineStatus"),
                    input.getOnlineStatus().equals(OnlineStatus.ONLINE.name())
                            ? OnlineStatus.ONLINE : OnlineStatus.ONLINE));
        }
        if (input.getDriverId() != null) {
            predicates.add(cb.equal(driverDORoot.get("id"), input.getDriverId()));
        }
        if (input.getRating() != null) {
            predicates.add(cb.equal(driverJoinCar.get("rating"), input.getRating()));
        }
        if (input.getManufacturer() != null) {
            predicates.add(cb.equal(driverJoinCar.get("manufacturer"), input.getManufacturer()));
        }
        if (input.getCarId() != null) {
            predicates.add(cb.equal(driverJoinCar.get("id"), input.getCarId()));
        }

        return predicates;
    }
}
