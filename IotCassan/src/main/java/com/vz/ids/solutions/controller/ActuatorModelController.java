package com.vz.ids.solutions.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vz.ids.solutions.data.db.IdsActuatorModelObject;
import com.vz.ids.solutions.data.repo.IdsActuatorModelRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
public class ActuatorModelController {
    @Autowired
    private IdsActuatorModelRepo actuatorRepository;
    @RequestMapping(value = "/actuatormodel",method = RequestMethod.GET)
    @ResponseBody
    public List<IdsActuatorModelObject> fetchDevices() {
    	System.out.println("actuator----->");
        List<IdsActuatorModelObject> devices = new ArrayList<>();
        actuatorRepository.fetchAll().forEach(e->devices.add(e));
        return devices;
    }
    
    @RequestMapping(value = "/actuatormodel/{actuatorModelName}/",method = RequestMethod.GET)
    @ResponseBody
    public IdsActuatorModelObject fetchByName(@PathVariable String actuatorModelName) {
    	 
    	 return actuatorRepository.fetchByName(actuatorModelName);
         
    }
    /*@RequestMapping(value = "/greeting",method = RequestMethod.POST)
    @ResponseBody
    public String saveGreeting(@RequestBody Greeting greeting) {
        greeting.setCreationDate(new Date());
        deviceRepository.save(greeting);
        return "OK";
    }*/
}
