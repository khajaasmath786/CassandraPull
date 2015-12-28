/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vz.ids.solutions.data.repo;

import com.vz.ids.solutions.data.db.IdsChannelObject;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author v086714
 */
public interface IdsChannelRepo extends CrudRepository<IdsChannelObject, String>
{
    @Query("Select * from ids_solutions.ids_channel where oemName = ?0 and topic = ?1")
    public IdsChannelObject fetchByTopic(@Param("oemName")String oemName, @Param("topic")String topic);
    
}
