package com.example.demo.controller;

import com.example.demo.model.Household;
import com.example.demo.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/households")
public class HouseholdController {

    private final HouseholdService householdService;

    @Autowired
    public HouseholdController(HouseholdService householdService) {
        this.householdService = householdService;
    }

    /**
     * get all household product
     * @return 123
     */
    @GetMapping
    public List<Household> getAllHouseholds() {
        return householdService.getAllHouseholds();
    }

    /**
     * get household product by id
     * @param id 123
     * @return 123
     */
    @GetMapping("/{id}")
    public Optional<Household> getHouseholdById(@PathVariable Long id) {
        return householdService.getHouseholdById(id);
    }

    /**
     * add new household product
     * @param household 123
     * @return 123
     */
    @PostMapping
    public Household addHousehold(@RequestBody Household household) {
        return householdService.addHousehold(household);
    }

    /**
     * update household product
     * @param id 123
     * @param household 123
     * @return 123
     */
    @PutMapping("/{id}")
    public Household updateHousehold(@PathVariable Long id, @RequestBody Household household) {
        return householdService.updateHousehold(id, household);
    }

    /**
     * delete household product
     * @param id 123
     */
    @DeleteMapping("/{id}")
    public void deleteHousehold(@PathVariable Long id) {
        householdService.deleteHousehold(id);
    }
}
