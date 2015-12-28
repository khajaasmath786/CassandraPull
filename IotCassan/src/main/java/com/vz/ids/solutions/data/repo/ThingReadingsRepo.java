package com.vz.ids.solutions.data.repo;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vz.ids.solutions.data.db.ThingReadingObject;

public interface ThingReadingsRepo extends CrudRepository<ThingReadingObject, String>{
	
				
    @Query("Select * from ids_solutions.ids_thing_readings where virtualDeviceId=?0 and thingId=?1 and thingCatagory=?2")
    public ThingReadingObject fetchThingReadingById(@Param("virtualDeviceId")String virtualDeviceId,@Param("thingId")String thingId,@Param("thingCatagory")String thingCatagory);
	
}
