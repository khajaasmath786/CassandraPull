package com.vz.ids.solutions.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vz.ids.solutions.data.db.IdsActuatorObject;
import com.vz.ids.solutions.data.repo.IdsActuatorRepo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
public class ActuatorController {
    @Autowired
    private IdsActuatorRepo actuatorRepository;
    @RequestMapping(value = "/actuator",method = RequestMethod.GET)
    @ResponseBody
    public List<IdsActuatorObject> fetchDevices() {
    	System.out.println("actuator----->");
        List<IdsActuatorObject> devices = new ArrayList<>();
        actuatorRepository.fetchAll().forEach(e->devices.add(e));
        return devices;
    }
    @RequestMapping(value = "/actuator/{virtualDeviceId}/",method = RequestMethod.GET)
    @ResponseBody
    public List<IdsActuatorObject> fetchByDevice(@PathVariable String virtualDeviceId) {
    	 List<IdsActuatorObject> devices = new ArrayList<>();
        actuatorRepository.fetchByDevice(virtualDeviceId).forEach(e -> devices.add(e));
        return devices;
    }
    @RequestMapping(value = "/actuator/{virtualDeviceId}/{actuatorId}",method = RequestMethod.GET)
    @ResponseBody
    public IdsActuatorObject fetchByDeviceId(@PathVariable String virtualDeviceId,String actuatorId) {
    	 
        return actuatorRepository.fetchById(virtualDeviceId,actuatorId);
        
    }
    
    @RequestMapping(value = "/actuator/{virtualactuatorid}/",method = RequestMethod.GET)
    @ResponseBody
    public IdsActuatorObject fetchByVirtualActuatorId(@PathVariable String virtualactuatorid) {
    	 
    	 return actuatorRepository.fetchByVirtualActuatorId(virtualactuatorid);
         
    }
    /*@RequestMapping(value = "/greeting",method = RequestMethod.POST)
    @ResponseBody
    public String saveGreeting(@RequestBody Greeting greeting) {
        greeting.setCreationDate(new Date());
        deviceRepository.save(greeting);
        return "OK";
    }*/
}
