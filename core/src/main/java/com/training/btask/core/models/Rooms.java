package com.training.btask.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Model(adaptables =Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)


public class Rooms {
	private static final Logger log = LoggerFactory.getLogger(Tvariation.class);
	
	@Inject
	String image;
	@Inject
	String path;
	@Inject
	String desc;
	@Inject
	String no;
	 
	public String getNo() {
		return no;
	}
	public String getImage() {
		return image;
	}
	public String getPath() {
		return path;
	}
	public String getDesc() {
		return desc;
	}
	


}
