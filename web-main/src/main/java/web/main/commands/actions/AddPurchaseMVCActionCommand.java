package web.main.commands.actions;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;

import electrostore.db.service.PurchaseLocalService;
import web.main.constants.WebMainPortletKeys;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + WebMainPortletKeys.WEBMAIN,
				"mvc.command.name=addPurchase"
		},
		service=MVCActionCommand.class
	)
public class AddPurchaseMVCActionCommand implements MVCActionCommand {
	@Reference
	private PurchaseLocalService purchaseLocalService;
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		try {
			purchaseLocalService.addPurchase(actionRequest);
			actionResponse.getRenderParameters().setValue("mvcPath", "/electronics/electronics.jsp");
		} catch (Exception e) {
			System.out.println("Ошибка при добавлении продажи " + e.getMessage());
		}
		return false;
	}

}
