package com.training.btask.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables= Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class About_community {
//ok	s
	@Inject
	String chead;
	@Inject 
	String cdata;
	public String getChead() {
		return chead;
	}
	public String getCdata() {
		return cdata;
	}
	 


}
