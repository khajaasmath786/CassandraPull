package com.vz.ids.solutions.controller;
import com.vz.ids.solutions.data.db.IdsSensorObject;

import com.vz.ids.solutions.data.repo.IdsSensorRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
public class SensorController {
    @Autowired
    private IdsSensorRepo sensorRepository;
    @RequestMapping(value = "/sensor",method = RequestMethod.GET)
    @ResponseBody
    public List<IdsSensorObject> fetchSensors() {
        List<IdsSensorObject> sensors = new ArrayList<>();
        sensorRepository.fetchAll().forEach(e->sensors.add(e));
        return sensors;
    }
    @RequestMapping(value = "/sensor/{virtualDeviceId}/",method = RequestMethod.GET)
    @ResponseBody
    public List<IdsSensorObject> fetchBySensorUser(@PathVariable String virtualDeviceId) {
    	 List<IdsSensorObject> Sensors = new ArrayList<>();
        sensorRepository.fetchByDevice(virtualDeviceId).forEach(e -> Sensors.add(e));
        return Sensors;
    }
    @RequestMapping(value = "/sensor/{virtualDeviceId}/{sensorId}",method = RequestMethod.GET)
    @ResponseBody
    public IdsSensorObject fetchById(@PathVariable String virtualDeviceId,String sensorId) {
    	 
        return sensorRepository.fetchById(virtualDeviceId,sensorId);
        
    }
    
    @RequestMapping(value = "/sensor/{virtualSensorId}/",method = RequestMethod.GET)
    @ResponseBody
    public IdsSensorObject fetchByVirtualSensorId(@PathVariable String virtualSensorId) {
    	 
    	 return sensorRepository.fetchByVirtualSensorId(virtualSensorId);
         
    }
    /*@RequestMapping(value = "/greeting",method = RequestMethod.POST)
    @ResponseBody
    public String saveGreeting(@RequestBody Greeting greeting) {
        greeting.setCreationDate(new Date());
        deviceRepository.save(greeting);
        return "OK";
    }*/
}
