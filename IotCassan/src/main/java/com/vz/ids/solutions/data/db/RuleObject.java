/**
 * 
 */
package com.vz.ids.solutions.data.db;

import org.springframework.cassandra.core.PrimaryKeyType;
import org.springframework.data.cassandra.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.mapping.Table;

import lombok.Data;

/**
 * @author z923442
 *
 */
@Table("ids_rules")
@Data
public class RuleObject {
	
	  @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	  private String ruleId;
	  @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.PARTITIONED)
	  private String user;
	  private String data;	  
}
