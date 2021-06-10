package com.training.btask.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables= Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class About_Ads {
	@Inject
	String head;
	@Inject 
	String data;
	public String getHead() {
		return head;
	}
	public String getData() {
		return data;
	}

}
