/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.data.repo;
import org.springframework.data.cassandra.repository.CassandraRepository;
import com.vz.ids.solutions.data.db.IdsActuatorModelObject;
import com.vz.ids.solutions.data.db.IdsSensorModelObject;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author v086714
 */
public interface IdsActuatorModelRepo extends CassandraRepository<IdsActuatorModelObject>
{
    @Query("Select * from ids_solutions.ids_actuator_model where actuatorModelName = ?0")
    public IdsActuatorModelObject fetchByName(@Param("actuatorModelName")String actuatorModelName);
    
    @Query("Select * from ids_solutions.ids_actuator_model")
    public Iterable<IdsActuatorModelObject> fetchAll();
}
