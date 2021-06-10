package com.training.btask.core.models;

import java.util.Map;

import javax.jcr.RepositoryException;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import com.adobe.cq.sightly.WCMUsePojo;

@Model(adaptables= Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)


public class FragmentMap extends WCMUsePojo{
	public String getv() {

		Tvariation t=new Tvariation();
		String s=t.getVari();
		return s;
		
	}

	@Override
	public void activate() throws Exception {
		// TODO Auto-generated method stub
		
	}
		 
		
	 
	
	 
	 
}
