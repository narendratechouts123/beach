package com.training.btask.core.models;

import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ChildResource;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import com.day.cq.wcm.api.Page;

@Model(adaptables= {Resource.class} ,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class FoodMultiField {
	
	@Inject 
	List<Food> foodmulti;
	
	@ValueMapValue
	String title;
	
	 @SlingObject
	 Resource r;
 
	 @RequestAttribute(name = "k")
	 String pageTitle;
	 {
		 
	 }
	

	public List<Food> getFoodmulti() {
		return foodmulti;
	}
	
	public String getPath() {
		return  pageTitle;
	}

	public String getTitle() {
		return title;
	}

}
