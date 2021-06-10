package com.training.btask.core.servlets;

 

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;

import javax.jcr.Node;
import javax.jcr.Session;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletException;

import org.apache.commons.mail.HtmlEmail;
import org.apache.jackrabbit.api.security.user.Authorizable;
import org.apache.jackrabbit.api.security.user.UserManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.SlingHttpServletResponse;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.api.servlets.HttpConstants;
import org.apache.sling.api.servlets.SlingSafeMethodsServlet;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.cq.dam.cfm.ContentFragment;
import com.adobe.cq.dam.cfm.FragmentTemplate;
import com.adobe.cq.dam.cfm.VariationTemplate;
import com.adobe.granite.workflow.model.VariableTemplate;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;



@Component(service=Servlet.class,
property={
     "sling.servlet.methods=" + HttpConstants.METHOD_GET,
		/*
		 * "sling.servlet.resourceTypes="+ "SeleSite/components/structure/taskpage",
		 * "sling.servlet.selectors=" + "Serv1"
		 */
     "sling.servlet.paths="+ "/com.beach/cF1",
     
     "sling.servlet.extensions="+".json"

})

 public class Json extends SlingSafeMethodsServlet{
	@Reference
	private MessageGatewayService messageGatewayService;
	private static final Logger LOG = LoggerFactory.getLogger(Json.class);

	 

	ContentFragment cf;

 @Reference
 EmailService eservice;
	 

@Override
protected void doGet(SlingHttpServletRequest request, SlingHttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");

PrintWriter 	out= response.getWriter();
 String names=request.getParameter("name");
 String mail=request.getParameter("email");
 String subject=request.getParameter("subject");
 String data=request.getParameter("data");

	  
	MessageGateway<HtmlEmail> messageGateway = messageGatewayService.getGateway(HtmlEmail.class);
 	try {
			/*
			 * Resource resolve=request.getResourceResolver().getResource(
			 * "/content/beach/us/en/contact");
			 * 
			 * UserManager userManager = resolve.adaptTo(UserManager.class); Authorizable
			 * authorizable = userManager.getAuthorizable("admin"); //String
			 * em=PropertiesUtil.toString(authorizable.getProperty("profile/email"), "");
			 * //System.out.println(em);
			 */ 		if (mail == null)
			return;
		HtmlEmail email = eservice.getemail(mail,names,subject,data);
	 
 		messageGateway.send(email);
		System.out.println("send");
		out.print("click Here to redirect to Home");
 
		 RequestDispatcher rd=request.getRequestDispatcher("/content/beach/us/en/home.html");
		 rd.forward(request, response);
	} catch (Exception e) {
		System.out.println(e.toString());
		LOG.error(e.getLocalizedMessage());
	}

}
}

