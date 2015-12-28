/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.data.repo;

import com.vz.ids.solutions.data.db.IdsDeviceObject;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.Collection;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author v086714
 */
public interface IdsDeviceRepo extends CassandraRepository<IdsDeviceObject>
{
    @Query("Select * from ids_solutions.ids_device where virtualDeviceId = ?0")
    public IdsDeviceObject fetchByVirtualDeviceId(String virtualDeviceId);  
    
    @Query("Select * from ids_solutions.ids_device where oemName = ?0 and deviceId = ?1")
    public IdsDeviceObject fetchByDeviceId(String oemName, String deviceId);
    
    @Query("Select * from ids_solutions.ids_device where user = ?0")
    public Collection<IdsDeviceObject> fetchByUser(String user);
    
    @Query("Select * from ids_solutions.ids_device")
    public Iterable<IdsDeviceObject> fetchAll();
    
}
