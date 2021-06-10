 package com.training.btask.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables= Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Footer {
	
	@Inject
	String year;
	@Inject
	String company;
	public String getYear() {
		return year;
	}
	public String getCompany() {
		return company;
	}
	 
	 

}
