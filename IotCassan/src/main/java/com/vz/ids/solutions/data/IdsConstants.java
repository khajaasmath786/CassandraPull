/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.data;

/**
 *
 * @author v086714
 */
public abstract class IdsConstants {
    private IdsConstants() {
        
    }
    // device meta attributes
    public static final String DEVICE_ACCESS_TOKEN = "accessToken";
    public static final String DEVICE_NAME = "name";
    public static final String DEVICE_TYPE = "deviceType";
    public static final String DEVICE_LATITUDE = "latitude";
    public static final String DEVICE_LONGITUDE = "longitude";
    
    // actuator meta attributes
    public static final String ACTUATOR_CATEGORY = "actuatorCategory";
    public static final String ACTUATOR_DESCRIPTION = "description";
    public static final String ACTUATOR_PLATFORM = "platform";
    public static final String ACTUATOR_STATUS = "status";
    
    // sensor meta attributes
    public static final String SENSOR_CATEGORY = "sensorCategory";
    public static final String SENSOR_DESCRIPTION = "description";
    public static final String SENSOR_PLATFORM = "platform";
}
