/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.data.repo;
import org.springframework.data.cassandra.repository.CassandraRepository;

import com.vz.ids.solutions.data.db.IdsActuatorObject;
import com.vz.ids.solutions.data.db.IdsDeviceObject;

import java.util.Collection;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author v086714
 */
public interface IdsActuatorRepo extends CassandraRepository<IdsActuatorObject>
{
    @Query("Select * from ids_solutions.ids_actuator where virtualDeviceId = ?0 and actuatorId = ?1")
    public IdsActuatorObject fetchById(@Param("virtualDeviceId")String virtualDeviceId, @Param("actuatorId")String actuatorId);  
    
    @Query("Select * from ids_solutions.ids_actuator where virtualDeviceId = ?0")
    public Collection<IdsActuatorObject> fetchByDevice(@Param("virtualDeviceId")String virtualDeviceId); 
    
    @Query("Select * from ids_solutions.ids_actuator where virtualactuatorid = ?0")
    public IdsActuatorObject fetchByVirtualActuatorId(@Param("virtualactuatorid")String virtualactuatorid); 
    
    @Query("Select * from ids_solutions.ids_actuator")
    public Iterable<IdsActuatorObject> fetchAll();
}
