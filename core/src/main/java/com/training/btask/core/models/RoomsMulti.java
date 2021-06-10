package com.training.btask.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables =Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class RoomsMulti {

	@Inject
	String title;
	
	@Inject
	List<Rooms> rmulti;

	public String getTitle() {
		return title;
	}

	public List<Rooms> getRmulti() {
		return rmulti;
	}
}
