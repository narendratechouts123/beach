package workflows;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.mail.HtmlEmail;
import org.apache.jackrabbit.api.security.user.Authorizable;
import org.apache.jackrabbit.api.security.user.UserManager;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.commons.osgi.PropertiesUtil;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.mailer.MessageGateway;
import com.day.cq.mailer.MessageGatewayService;

@Component(service = WorkflowProcess.class, immediate = true, property = {
		Constants.SERVICE_DESCRIPTION + "=It will add attributes to page", "process.label=" + "Resort Email",
// "propertyPrivate=" + "true"
})
public class mailworkflow implements WorkflowProcess {
	@Reference
	private MessageGatewayService messageGatewayService;
	@Reference
	private ResourceResolverFactory resourceResolverFactory;
	ResourceResolver resolver = null;
	private static final Logger LOG = (Logger) LoggerFactory.getLogger(mailworkflow.class);

	@Activate
	protected void activate(Map<String, Object> properties) {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put(ResourceResolverFactory.SUBSERVICE, "cfuser1");
		resolver = null;
		try {
			resolver = this.resourceResolverFactory.getServiceResourceResolver(param);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap)
			throws WorkflowException {
		MessageGateway<HtmlEmail> messageGateway = messageGatewayService.getGateway(HtmlEmail.class);
		String pagePath = workItem.getWorkflowData().getPayload().toString();
		System.out.println("Email Started" + " ,page: " + pagePath);
		try {
			UserManager userManager = resolver.adaptTo(UserManager.class);
			Authorizable authorizable = userManager.getAuthorizable("admin");
			String userEmail = "narendra.k@techouts.com";//
			//String em=PropertiesUtil.toString(authorizable.getProperty("profile/email"), "");
			//System.out.println(em);
			System.out.println("Email ID:-" + userEmail );
			if (userEmail == null)
				return;
			HtmlEmail email = new HtmlEmail();
			email.addTo(userEmail);
			email.setSSL(true);
			System.out.println("added");
			email.setSubject("Page has modified!!");
			email.setHtmlMsg("<html><head></head><body><center><b>Following page is edited</b><br>" + pagePath
					+ "</center></body></html>");
			messageGateway.send(email);
			System.out.println("send");
		} catch (Exception e) {
			System.out.println(e.toString());
			LOG.error(e.getLocalizedMessage());
		}
	}

}