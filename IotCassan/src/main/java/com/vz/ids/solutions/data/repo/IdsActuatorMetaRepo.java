/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.data.repo;

import com.vz.ids.solutions.data.db.IdsActuatorMetaObject;
import java.util.Collection;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author v086714
 */
public interface IdsActuatorMetaRepo extends CrudRepository<IdsActuatorMetaObject, String> {
    @Query("Select * from ids_solutions.ids_actuator_meta where oemName = ?0 and model = ?1")
    public Collection<IdsActuatorMetaObject> fetchByModel(@Param("oemName")String oemName, @Param("model")String model);   
    
    @Query("Select * from ids_solutions.ids_actuator_meta where oemName = ?0 and model = ?1 and actuatorId = ?2")
    public IdsActuatorMetaObject fetchById(@Param("oemName")String oemName, @Param("model")String model, @Param("actuatorId")String actuatorId);   
}
