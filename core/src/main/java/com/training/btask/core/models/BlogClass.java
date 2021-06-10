package com.training.btask.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables= Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class BlogClass {
	
	@Inject
	String cname;
	@Inject
	String date;
	@Inject
	String info;
	public String getCname() {
		return cname;
	}
	public String getDate() {
		return date;
	}
	public String getInfo() {
		return info;
	}
}
