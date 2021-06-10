package com.training.btask.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables= Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Food {
	
	@Inject
	String cat;
	@Inject
	String image;
	@Inject
	String name;
	@Inject
	String info;
	public String getCat() {
		return cat;
	}
	public String getImage() {
		return image;
	}
	public String getName() {
		return name;
	}
	public String getInfo() {
		return info;
	}

}
