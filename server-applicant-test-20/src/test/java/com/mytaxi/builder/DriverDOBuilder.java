package com.mytaxi.builder;

import com.mytaxi.domainobject.DriverDO;
import com.mytaxi.domainvalue.OnlineStatus;

public class DriverDOBuilder {

    private DriverDO driverDO;

    public DriverDOBuilder(DriverDO driverDO) {
        this.driverDO = driverDO;
    }

    public DriverDOBuilder() {
        driverDO = new DriverDO("test","test");
    }

    public DriverDOBuilder withDriverDO(Long id, String username,
                                        String password, OnlineStatus onlineStatus) {
        driverDO.setId(id);
        driverDO.setUsername(username);
        driverDO.setPassword(password);
        driverDO.setOnlineStatus(onlineStatus);
        return this;
    }

    public DriverDO build() {
        return this.driverDO;
    }
}
