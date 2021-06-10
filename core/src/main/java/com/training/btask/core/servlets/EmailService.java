package com.training.btask.core.servlets;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;
import org.osgi.service.component.annotations.Component;

@Component(service = EmailService.class)
public class EmailService {

	public HtmlEmail getemail(String mail,String names,String subject,String data) throws EmailException {
		HtmlEmail email = new HtmlEmail();
		email.addTo(mail);
 		System.out.println("added");
		email.setSubject(subject);
		
		email.setHtmlMsg("<p style='color:red'>" +names+"<br>"+data+"<p>" );
				 
 		
		
		
		
		
		return email;
	}
	
	
}
