/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.data.repo;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.vz.ids.solutions.data.db.IdsDeviceObject;
import com.vz.ids.solutions.data.db.IdsSensorModelObject;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author v086714
 */
public interface IdsSensorModelRepo extends CassandraRepository<IdsSensorModelObject>
{
    @Query("Select * from ids_solutions.ids_sensor_model where sensorModelName = ?0")
    public IdsSensorModelObject fetchByName(String senstorModelName);
    
    @Query("Select * from ids_solutions.ids_sensor_model")
    public Iterable<IdsSensorModelObject> fetchAll();
}

