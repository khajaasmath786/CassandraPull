/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.data.repo;

import com.vz.ids.solutions.data.db.IdsSensorMetaObject;
import java.util.Collection;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author v086714
 */
public interface IdsSensorMetaRepo extends CrudRepository<IdsSensorMetaObject, String> {
    @Query("Select * from ids_solutions.ids_sensor_meta where oemName = ?0 and model = ?1")
    public Collection<IdsSensorMetaObject> fetchByModel(@Param("oemName")String oemName, @Param("model")String model);   
    @Query("Select * from ids_solutions.ids_sensor_meta where oemName = ?0 and model = ?1 and sensorId = ?2")
    public IdsSensorMetaObject fetchById(@Param("oemName")String oemName, @Param("model")String model, @Param("sensorId")String sensorId);   
    
}
