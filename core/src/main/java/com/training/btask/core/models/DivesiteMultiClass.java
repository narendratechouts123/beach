package com.training.btask.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables =Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class DivesiteMultiClass {
	
	@Inject
	String title;
	
	@Inject
	List<DiveSite> dive;

	public List<DiveSite> getDive() {
		return dive;
	}

	public String getTitle() {
		return title;
	}

}
