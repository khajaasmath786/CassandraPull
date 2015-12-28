/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.data.repo;

import org.springframework.data.cassandra.repository.CassandraRepository;
import com.vz.ids.solutions.data.db.IdsSensorObject;
import java.util.Collection;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author v086714
 */
public interface IdsSensorRepo extends CassandraRepository<IdsSensorObject>
{
    @Query("Select * from ids_solutions.ids_sensor where virtualDeviceId = ?0 and sensorId = ?1")
    public IdsSensorObject fetchById(@Param("virtualDeviceId")String virtualDeviceId, @Param("sensorId")String sensorId);  
    
    @Query("Select * from ids_solutions.ids_sensor where virtualDeviceId = ?0")
    public Collection<IdsSensorObject> fetchByDevice(@Param("virtualDeviceId")String virtualDeviceId);   
    
    @Query("Select * from ids_solutions.ids_sensor where virtualSensorId = ?0")
    public IdsSensorObject fetchByVirtualSensorId(@Param("virtualSensorId")String virtualSensorId);  
    
    @Query("Select * from ids_solutions.ids_sensor")
    public Iterable<IdsSensorObject> fetchAll();
}

