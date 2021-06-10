  package com.training.btask.core.models;

 
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.adobe.cq.sightly.WCMUsePojo;

@Model(adaptables= Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class BlogMultiField  {
	
		@Inject
 		String par;
	@Inject
	String heading;
 
	@Inject
	List<BlogClass> blogs;

	public String getHeading() {
		return heading;
	}

	public List<BlogClass> getBlogs() {
		return blogs;
	}

	 
	 

	 
	

}
