package web.main.commands.actions;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.theme.ThemeDisplay;

import electrostore.db.service.EmployeeLocalService;
import web.main.constants.WebMainPortletKeys;

@Component(
	immediate = true,
	property = {
			"javax.portlet.name=" + WebMainPortletKeys.WEBMAIN,
			"mvc.command.name=addEmployee"
	},
	service=MVCActionCommand.class
)
public class AddEmployeeMVCActionCommand implements MVCActionCommand {
	@Reference
	private EmployeeLocalService employeeLocalService;
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		try {
			System.out.println("in add employee");
			employeeLocalService.addEmployee(actionRequest);
			actionResponse.getRenderParameters().setValue("mvcPath", "/employees/employees.jsp");	
		}
		catch(Exception exception) {
			return true;
		}		
		return false;
	}
}
