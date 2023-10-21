package web.main.commands.actions;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import electrostore.db.service.ElectronicLocalService;
import web.main.constants.WebMainPortletKeys;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + WebMainPortletKeys.WEBMAIN,
				"mvc.command.name=addElectronic"
		},
		service=MVCActionCommand.class
	)
public class AddElectronicMVCActionCommand implements MVCActionCommand {
	
	@Reference
	private ElectronicLocalService electronicLocalService;
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		try {
			System.out.println("in add employee");
			electronicLocalService.addElectronic(actionRequest);
			actionResponse.getRenderParameters().setValue("mvcPath", "/electronics/electronics.jsp");	
		}
		catch(Exception exception) {
			return true;
		}		
		return false;
	}

}
