package com.vz.ids.solutions.controller;
import com.vz.ids.solutions.data.db.IdsDeviceObject;
import com.vz.ids.solutions.data.repo.IdsDeviceRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RestController
public class DeviceController {
    @Autowired
    private IdsDeviceRepo deviceRepository;
    @RequestMapping(value = "/device",method = RequestMethod.GET)
    @ResponseBody
    public List<IdsDeviceObject> fetchDevices() {
        List<IdsDeviceObject> devices = new ArrayList<>();
        deviceRepository.fetchAll().forEach(e->devices.add(e));
        return devices;
    }
    @RequestMapping(value = "/device/{user}/",method = RequestMethod.GET)
    @ResponseBody
    public List<IdsDeviceObject> fetchByDeviceUser(@PathVariable String user) {
    	 List<IdsDeviceObject> devices = new ArrayList<>();
        deviceRepository.fetchByUser(user).forEach(e -> devices.add(e));
        return devices;
    }
    @RequestMapping(value = "/device/{oemName}/{deviceId}",method = RequestMethod.GET)
    @ResponseBody
    public IdsDeviceObject fetchByDeviceId(@PathVariable String oemName,String deviceId) {
    	 
        return deviceRepository.fetchByDeviceId(oemName,deviceId);
        
    }
    
    @RequestMapping(value = "/device/{virtualDeviceId}/",method = RequestMethod.GET)
    @ResponseBody
    public IdsDeviceObject fetchByVirtualDeviceId(@PathVariable String virtualDeviceId) {
    	 
    	 return deviceRepository.fetchByVirtualDeviceId(virtualDeviceId);
         
    }
    /*@RequestMapping(value = "/greeting",method = RequestMethod.POST)
    @ResponseBody
    public String saveGreeting(@RequestBody Greeting greeting) {
        greeting.setCreationDate(new Date());
        deviceRepository.save(greeting);
        return "OK";
    }*/
}
