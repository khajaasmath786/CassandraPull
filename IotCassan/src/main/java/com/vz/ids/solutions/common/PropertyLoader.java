package com.vz.ids.solutions.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.io.ClassPathResource;

public class PropertyLoader {

	private static PropertyLoader instance = new PropertyLoader();
	private static Map<String, Properties> propertiesMap = new HashMap<String, Properties>();
	private static String DEFAULT_PROPERTIES = "application.yml";
	private PropertyLoader(){
		
	}
	
	public static PropertyLoader getInstance(){
		return instance;
	}
	
	public Properties getProperties(String propertiesFile){
		if(!propertiesMap.containsKey(propertiesFile)){
			propertiesMap.put(propertiesFile,loadProperties(propertiesFile));
		}
		if(propertiesMap.get(propertiesFile) != null){
			return propertiesMap.get(propertiesFile);
		}else{
			return null;
		}
		
	}
	
	public String getProperty(String key){
		return getProperty(key,DEFAULT_PROPERTIES);
	}
	
	public int getIntProperty(String key){
		return getIntProperty(key,DEFAULT_PROPERTIES);
	}
	
	public String getProperty(String key,String propertiesFile){
		
		Properties properties = getProperties(propertiesFile);
		if(properties!= null){
			return properties.getProperty(key);
		}else{
			return null;
		}
	}
	
	public int getIntProperty(String key,String propertiesFile){
		
		Properties properties = getProperties(propertiesFile);
		
		if(properties != null){
			return Integer.parseInt(String.valueOf(properties.get(key)));
		}else{
			return -1;
		}
		
	}
	
	private Properties loadProperties(String propertiesFile){
		YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
		factory.setResources(new ClassPathResource[]{new ClassPathResource(propertiesFile)});
		return factory.getObject();
	}
}
