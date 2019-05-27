package com.mytaxi.controller;

import com.mytaxi.controller.mapper.DriverMapper;
import com.mytaxi.datatransferobject.DriverDTO;
import com.mytaxi.datatransferobject.SearchCriteria;
import com.mytaxi.service.driver.SearchDriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("v1/searches/drivers")
public class DriverSearchController {

    @Autowired
    private SearchDriverService searchDriverService;

    @GetMapping
    public List<DriverDTO> getSearchedResults(@Valid SearchCriteria searchCriteria) {
        return DriverMapper.makeDriverDTOList(searchDriverService.searchDrivers(searchCriteria));
    }
}
