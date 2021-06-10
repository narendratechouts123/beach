package com.training.btask.core.servlets;

 
import java.util.HashMap;
import java.util.Map;

import javax.jcr.Session;
import javax.servlet.Servlet;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.search.PredicateGroup;
import com.day.cq.search.Query;
import com.day.cq.search.QueryBuilder;
import com.day.cq.search.result.Hit;
import com.day.cq.search.result.SearchResult;

 
@Component(service = Servlet.class, property = { Constants.SERVICE_DESCRIPTION + "=Query Builder servlet",
		"sling.servlet.methods=" + HttpConstants.METHOD_GET, "sling.servlet.paths=" + "/com.beach/query" 

		})
public class QueryBuilderServlet extends SlingSafeMethodsServlet {
 
	private static final long serialVersionUID = 2610051404257637265L;
 
	private static final Logger log = LoggerFactory.getLogger(QueryBuilderServlet.class);
 
	@Reference
	private QueryBuilder builder;
 
	private Session session;
	 
	@Override
	protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) {

		try {

			log.info("----------< Executing Query Builder Servlet >----------");
 
			String param = request.getParameter("search");

			log.info("Search term is: {}", param);
			 
			ResourceResolver resourceResolver = request.getResourceResolver();
			
		 
			session = resourceResolver.adaptTo(Session.class);
			
			 
			Map<String, String> predicate = new HashMap<>();

		 
			predicate.put("path", "/content/beach/us/en");
			predicate.put("type", "cq:Page");
			predicate.put("group.p.or", "true");
 			predicate.put("p.limit","-1");

			predicate.put("group.1_fulltext.relPath", "jcr:content");
			
			/**
			 * Creating the Query instance
			 */
			Query query = builder.createQuery(PredicateGroup.create(predicate), session);
			
			query.setStart(0);
			query.setHitsPerPage(20);
	
			/**
			 * Getting the search results
			 */
			SearchResult searchResult = query.getResult();
			response.getWriter().println(param);

			for(Hit hit : searchResult.getHits()) {
				
				String path = hit.getPath();
				response.setContentType("text/html");
				if(hit.getPath().contains(param)) {
				response.getWriter().println("<a href='"+hit.getPath()+".html'>"+hit.getTitle()+"</a>");
				response.getWriter().print("<br>");
				}
			}
			response.getWriter().write("sample");
		} catch (Exception e) {

			log.error(e.getMessage(), e);
		} finally {
			
			if(session != null) {
				
				session.logout();
			}
		}
	}

}