/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.data.repo;

import com.vz.ids.solutions.data.db.IdsSensorModelFeatureObject;
import java.util.Collection;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author v086714
 */
public interface IdsSensorModelFeatureRepo extends CrudRepository<IdsSensorModelFeatureObject, String> {
    @Query("Select * from ids_solutions.ids_sensor_model_feature where type = ?0")
    public Collection<IdsSensorModelFeatureObject> fetchByType(@Param("type")String type);   

    @Query("Select * from ids_solutions.ids_sensor_model_feature where type = ?0 and feature = ?1")
    public IdsSensorModelFeatureObject fetchByFeature(@Param("type")String type, @Param("feature")String feature);   
    
}
