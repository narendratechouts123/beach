  package com.training.btask.core.models;

 
import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables= Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Sidebar {
	
	@Inject
	String image;
	@Inject
	String path;
	public String getImage() {
		return image;
	}
	public String getPath() {
		return path;
	}
	 
	 
	 

}
