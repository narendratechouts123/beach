package com.training.btask.core.models;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables= {Resource.class,SlingHttpServletRequest.class},defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Food2 {
	
	 @ValueMapValue 
	 String title;
	 
	 @Inject
	 String k;

	public String getTitle() {
		return title+k;
	}
	 
	 @Inject()
	 List<Food2m> foodmulti;

	public List<Food2m> getFoodmulti() {
		return foodmulti;
	}

	 
}
