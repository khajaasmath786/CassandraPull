/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.data.db;

import lombok.Data;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

/**
 *
 * @author v086714
 */

@Table("ids_sensor_model")
public class IdsSensorModelObject {
    public String getSensorModelName() {
		return sensorModelName;
	}
	public void setSensorModelName(String sensorModelName) {
		this.sensorModelName = sensorModelName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	@PrimaryKey
    private String sensorModelName;
    private String type;
    private String data;    
}
