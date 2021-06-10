package com.training.btask.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables= Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class SideBarMultiModel {
	
	@Inject
	List<Sidebar> multi;

	public List<Sidebar> getMulti() {
		return multi;
	}
	

}
