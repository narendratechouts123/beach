package com.training.btask.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables= Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class NewsMultiField {
	@Inject
	List<News> news;
	
	@Inject
	List<Vaction> tips ;
	
	@Inject
	String vtitle;
	public List<Vaction> getTips() {
		return tips;
	}

	public String getVtitle() {
		return vtitle;
	}

	@Inject
	String title;

	public List<News> getNews() {
		return news;
	}

	public String getTitle() {
		return title;
	}

}
