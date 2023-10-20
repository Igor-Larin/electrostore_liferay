package web.main.commands.actions;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import electrostore.db.service.EmployeeLocalService;
import web.main.constants.WebMainPortletKeys;

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + WebMainPortletKeys.WEBMAIN,
			"mvc.command.name=updateEmployee"
	},
	service = MVCActionCommand.class
)
public class UpdateEmployeeMVCActionCommand implements MVCActionCommand {
	private EmployeeLocalService employeeLocalService;
	
	@Reference
	public void setEmployeeLocalService(EmployeeLocalService employeeLocalService) {
		this.employeeLocalService = employeeLocalService;
	}
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		try {
			System.out.println(ParamUtil.getLong(actionRequest, "employeeId"));
			employeeLocalService.updateEmployee(actionRequest);			
			actionResponse.getRenderParameters().setValue("mvcPath", "/employees.jsp");	
		}
		catch(PortalException exception) {
			return true;
		}
		return false;
	}

}
