package com.training.btask.core.models;

import java.util.HashMap;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.jcr.Node;
import javax.jcr.Property;
import javax.jcr.PropertyIterator;
import javax.jcr.RepositoryException;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Source;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.dam.cfm.ContentElement;
import com.adobe.cq.dam.cfm.ContentFragment;
import com.adobe.cq.dam.cfm.FragmentData;
import com.adobe.cq.sightly.WCMUsePojo;

import jdk.internal.jline.internal.Log;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class FragmentDataClass  {

	private static final Logger log = LoggerFactory.getLogger(FragmentDataClass.class);

	@Inject
	public String val;

	@Inject
	@Source("sling-object")
	private ResourceResolver resourceResolver;

	public Map  m=new HashMap ();

	public Map getdataMap() throws RepositoryException {

		Resource resource = resourceResolver.getResource("/content/dam/beach/cfragment/contestfragment/jcr:content/data/"+val);
		Node n=resource.adaptTo(Node.class);
		PropertyIterator iterator= n.getProperties();
		while(iterator.hasNext()) {
			Property p=iterator.nextProperty();
			if(!p.isMultiple()) {
				m.put(p.getName(),p.getValue().toString());
			}


		}


		/*ContentFragment cf=resource.adaptTo(ContentFragment.class);
		Iterator i=cf.getElements();
		while(i.hasNext()) {
			ContentElement ce=(ContentElement) i.next();
			String s1=ce.getName();
			FragmentData s2=ce.getValue();
			String in=  (String) s2.getValue();
			m.put(s1, in);
			total=total+s1+" "+in+"<br>";*/

		return m;


	}



}
