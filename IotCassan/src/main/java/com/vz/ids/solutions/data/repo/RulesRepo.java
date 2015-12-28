/**
 * 
 */
package com.vz.ids.solutions.data.repo;

import java.util.Collection;

import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.vz.ids.solutions.data.db.RuleObject;

/**
 * @author z923442
 *
 */
public interface RulesRepo extends CrudRepository<RuleObject, String>{
	
	@Query("Select * from ids_solutions.ids_rules where ruleId = ?0")
    public RuleObject fetchByRuleId(@Param("ruleId")String ruleId);
	
	@Query("Select * from ids_solutions.ids_rules where user=?0")
    public Collection<RuleObject> fetchAllRules(@Param("user")String user);
	
	@Query("Update ids_solutions.ids_rules set data=?2 where user=?0 and ruleId =?1" )
    public Collection<RuleObject> update(@Param("user")String user,@Param("ruleId")String ruleId,@Param("data")String data);

}
