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
@Table("ids_actuator_model")

public class IdsActuatorModelObject {
    public String getActuatorModelName() {
		return actuatorModelName;
	}
	public void setActuatorModelName(String actuatorModelName) {
		this.actuatorModelName = actuatorModelName;
	}
	public String getBaseType() {
		return baseType;
	}
	public void setBaseType(String baseType) {
		this.baseType = baseType;
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
    private String actuatorModelName;
    private String baseType;
    private String type;
    private String data;
}
