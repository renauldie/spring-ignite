/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.dev.igniterestfull.controller;

import com.dev.igniterestfull.model.CityDTO;
import com.dev.igniterestfull.model.Country;
import com.dev.igniterestfull.model.CountryDTO;
import com.dev.igniterestfull.service.WorldDatabaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WorldDatabaseController {
    @Autowired
    public WorldDatabaseService service;


    @PostMapping("/api/countries")
    public void insertCountry(Country request) {
        service.insertCountry(request);
    }
    @GetMapping("/api/countries")
    public List<CountryDTO> getCountriesByPopulation(@RequestParam (value = "population", required = true) int population) {
        return service.getCountriesByPopulation(population);
    }

    @GetMapping("/api/cities")
    public List<CityDTO> getCitiesByPopulation(@RequestParam (value = "population", required = true) int population) {
        return service.getCitiesByPopulation(population);
    }

    @GetMapping("/api/cities/mostPopulated")
    public List<List<?>> getMostPopulatedCities(@RequestParam (value = "limit", required = false) Integer limit) {
        return service.getMostPopulatedCities(limit);
    }

    @PutMapping("/api/cities/{id}")
    public CityDTO updateCityPopulation(@PathVariable Integer id, @RequestBody CityDTO cityDTO) {
        return service.updateCityPopulation(id, cityDTO.getPopulation());
    }

}
