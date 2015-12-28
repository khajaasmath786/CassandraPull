/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.data.repo;

import com.vz.ids.solutions.data.db.IdsEntityObject;
import java.util.Collection;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author v086714
 */
public interface IdsEntityRepo extends CrudRepository<IdsEntityObject, String> {
    @Query("Select * from ids_solutions.ids_entity where entityGroup = ?0 and  entityId = ?1 allow filtering")
    public Collection<IdsEntityObject> fetchByEntity(String entityGroup, String entityId);  
    
    @Query("Select * from ids_solutions.ids_entity where virtualId = ?0 and thingType = ?1")
    public IdsEntityObject fetchThing(String virtualId, String thingType);  
        
    @Query("Select * from ids_solutions.ids_entity where entityGroup = ?0 and entityId = ?1 and thingType = ?2 allow filtering")
    public Collection<IdsEntityObject> fetchEntities(String entityGroup, String entityId, String thingType);  
    
}
