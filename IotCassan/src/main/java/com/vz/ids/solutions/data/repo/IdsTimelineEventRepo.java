/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.data.repo;

import com.vz.ids.solutions.data.db.IdsTimelineEventObject;
import java.util.Collection;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author v086714
 */
public interface IdsTimelineEventRepo extends CrudRepository<IdsTimelineEventObject, String> {
    @Query("Select * from ids_solutions.ids_timeline_event where objectId = ?0 and eventType = ?1 and entityGroup = ?2 and entityId = ?3")
    public IdsTimelineEventObject fetchOne(String objectId, String eventType, String entityGroup, String entityId);  
    @Query("Select * from ids_solutions.ids_timeline_event where objectId = ?0")
    public Collection<IdsTimelineEventObject> fetchByObjectId(String objectId);  
}
