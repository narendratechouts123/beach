package com.training.btask.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables =Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class DiveSite {
	
	@Inject
	String cat;
	@Inject
	String image;
	@Inject
	String p1;
	public String getP1() {
		return p1;
	}
	public String getP2() {
		return p2;
	}
	@Inject
	String p2;
	public String getCat() {
		return cat;
	}
	public String getImage() {
		return image;
	}
	 
	

}
