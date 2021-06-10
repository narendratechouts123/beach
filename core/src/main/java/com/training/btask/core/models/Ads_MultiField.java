package com.training.btask.core.models;

import javax.inject.Inject;
import java.util.*;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

@Model(adaptables= Resource.class,defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Ads_MultiField {
	
	@Inject
	List<About_Ads> multi;
	

	@Inject
	List<About_community> com;

	public List<About_Ads> getMulti() {
		return multi;
	}

	public List<About_community> getCom() {
		return com;
	}
	
	

}
