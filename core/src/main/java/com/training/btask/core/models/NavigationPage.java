package com.training.btask.core.models;

 
 

import javax.inject.Inject;
 
import javax.jcr.RepositoryException;

 import org.apache.sling.api.SlingHttpServletRequest;
 import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
 import org.apache.sling.api.servlets.SlingAllMethodsServlet;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Source;

 import com.day.cq.wcm.api.Page;
 

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class NavigationPage extends SlingAllMethodsServlet{
	@Inject
	public String val;
	@Inject
	@Source("sling-object")
	private ResourceResolver resourceResolver;
public 	Page p1;

 
	 
	
public Page get() throws RepositoryException {
	
	Resource resource = resourceResolver.getResource("/content/beach/us/en");
  
 
  
	Page parentPage = resource.adaptTo(Page.class);	
			
	 

	return parentPage;
	 
}

 
  
 

}
