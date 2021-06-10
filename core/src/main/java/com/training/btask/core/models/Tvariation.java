package com.training.btask.core.models;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.RepositoryException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.osgi.service.component.annotations.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.sightly.WCMUsePojo;

 @Model(adaptables =Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
@Component(service=Tvariation.class)
public class Tvariation  extends WCMUsePojo{
		private static final Logger log = LoggerFactory.getLogger(Tvariation.class);

	@Inject
	public String vari;
	public String s;
 
	public String getVari() {
		return  vari;
	}
	 
	@Override
 public void activate()   {
		// TODO Auto-generated method stub

		FragmentDataClass f=new FragmentDataClass();
		 
		 s= f.m.toString()+vari+"hi";
		
	}
	
	

	 
	

}
