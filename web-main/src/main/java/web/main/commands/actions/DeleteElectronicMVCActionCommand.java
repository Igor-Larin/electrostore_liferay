package web.main.commands.actions;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import electrostore.db.service.ElectronicLocalService;
import web.main.constants.WebMainPortletKeys;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + WebMainPortletKeys.WEBMAIN,
				"mvc.command.name=deleteElectronic"
		},
		service=MVCActionCommand.class
	)
public class DeleteElectronicMVCActionCommand implements MVCActionCommand {
	
	@Reference
	private ElectronicLocalService electronicLocalService;
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		try {
			long id = ParamUtil.getLong(actionRequest, "electronicId");
			electronicLocalService.deleteElectronic(id);
			actionResponse.getRenderParameters().setValue("mvcPath", "/electronics/electronics.jsp");	
		}	  
		catch(PortalException exception) {
			System.out.println(exception.getMessage()); return true; 
		}
		return false;
	}

}
