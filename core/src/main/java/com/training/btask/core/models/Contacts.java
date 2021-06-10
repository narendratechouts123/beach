package com.training.btask.core.models;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables= Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Contacts {
	
	@Inject
	String title;
	@Inject
	String heading;
	@Inject
	String address;
	@Inject
	String  phone;
	public String getTitle() {
		return title;
	}
	public String getHeading() {
		return heading;
	}
	public String getAddress() {
		return address;
	}
	public String getPhone() {
		return phone;
	}
	public String getFax() {
		return fax;
	}
	@Inject
	String fax;

}
