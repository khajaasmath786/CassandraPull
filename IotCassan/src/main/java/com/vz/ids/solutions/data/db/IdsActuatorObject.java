/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.data.db;

import java.util.Map;
import lombok.Data;
import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

/**
 *
 * @author v086714
 */
@Table("ids_actuator")

public class IdsActuatorObject {
    public String getVirtualActuatorId() {
		return virtualActuatorId;
	}
	public void setVirtualActuatorId(String virtualActuatorId) {
		this.virtualActuatorId = virtualActuatorId;
	}
	public String getOemName() {
		return oemName;
	}
	public void setOemName(String oemName) {
		this.oemName = oemName;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getActuatorId() {
		return actuatorId;
	}
	public void setActuatorId(String actuatorId) {
		this.actuatorId = actuatorId;
	}
	public String getVirtualDeviceId() {
		return virtualDeviceId;
	}
	public void setVirtualDeviceId(String virtualDeviceId) {
		this.virtualDeviceId = virtualDeviceId;
	}
	public Map<String, String> getAttributes() {
		return attributes;
	}
	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	private String virtualActuatorId;
    private String oemName;
    private String model;
    @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
    private String actuatorId;
    @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
    private String virtualDeviceId;
    private Map<String, String> attributes;
}
