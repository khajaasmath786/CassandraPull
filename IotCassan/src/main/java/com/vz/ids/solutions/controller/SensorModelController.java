package com.vz.ids.solutions.controller;
import com.vz.ids.solutions.data.db.IdsSensorModelObject;

import com.vz.ids.solutions.data.repo.IdsSensorModelRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@RestController
public class SensorModelController {
    @Autowired
    private IdsSensorModelRepo sensorRepository;
    @RequestMapping(value = "/sensormodel",method = RequestMethod.GET)
    @ResponseBody
    public List<IdsSensorModelObject> fetchSensors() {
        List<IdsSensorModelObject> sensors = new ArrayList<>();
        sensorRepository.fetchAll().forEach(e->sensors.add(e));
        return sensors;
    }
    
      
    @RequestMapping(value = "/sensormodel/{sensorModelName}/",method = RequestMethod.GET)
    @ResponseBody
    public IdsSensorModelObject fetchByName(@PathVariable String sensorModelName) {
    	 
    	 return sensorRepository.fetchByName(sensorModelName);
         
    }
    /*@RequestMapping(value = "/greeting",method = RequestMethod.POST)
    @ResponseBody
    public String saveGreeting(@RequestBody Greeting greeting) {
        greeting.setCreationDate(new Date());
        deviceRepository.save(greeting);
        return "OK";
    }*/
}
