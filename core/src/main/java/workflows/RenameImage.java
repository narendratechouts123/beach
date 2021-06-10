package workflows;

 
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
 import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.AssetManager;
import com.day.cq.dam.api.Rendition;

/**
 * 
 * @author rahul This class is used to rename assets without white spaces
 */

@Component(immediate = true, enabled = true, service = WorkflowProcess.class, property = {
		Constants.SERVICE_DESCRIPTION + "=It will rename assets without white spaces",
		"process.label=" + "Rename Asset", "propertyPrivate=" + "true" })
public class RenameImage implements WorkflowProcess {

	private static final Logger LOG = LoggerFactory.getLogger(RenameImage.class);

	@Reference
	private  ResourceResolverFactory resourceResolverFactory;
//com.trainig.staticwebsite.core:cfuser=cfuser
	@Override
	public  void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) {
		String payloadPath = "";
		String renamedPayloadPath="";
		WorkflowData workflowData = workItem.getWorkflowData();
		payloadPath = workflowData.getPayload().toString();
		renamedPayloadPath=payloadPath.replace(' ','-');
		try {
			if(payloadPath.contains(" ")) {
			Map<String, Object> param = new HashMap<>();
			param.put(ResourceResolverFactory.SUBSERVICE,"cfuser1");
			ResourceResolver resolver = resourceResolverFactory.getServiceResourceResolver(param);
			Resource assetResource = resolver.getResource(payloadPath);
			Asset asset = assetResource.adaptTo(Asset.class);
			Rendition original = asset.getOriginal();
			InputStream is = original.getStream();
			String mimeType = StringUtils.isNotBlank(original.getMimeType()) ? original.getMimeType() : "image/jpeg";
			AssetManager assetMgr = resolver.adaptTo(AssetManager.class);
			assetMgr.createAsset(renamedPayloadPath, is, mimeType, true);
			
			is.close();
			}
		}
		 catch (LoginException | IOException e) {
				LOG.error("error while renaming the asset name",e);
		}
		
		
		
	}

}
