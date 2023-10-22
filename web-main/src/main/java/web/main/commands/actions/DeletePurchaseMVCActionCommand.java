package web.main.commands.actions;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;

import electrostore.db.service.PurchaseLocalService;
import web.main.constants.WebMainPortletKeys;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + WebMainPortletKeys.WEBMAIN,
				"mvc.command.name=deletePurchase"
		},
		service = MVCActionCommand.class
	)
public class DeletePurchaseMVCActionCommand implements MVCActionCommand {
	@Reference
	private PurchaseLocalService purchaseLocalService;
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		try {
			purchaseLocalService.deletePurchase(actionRequest);			
			actionResponse.getRenderParameters().setValue("orderByType", ParamUtil.getString(actionRequest, "orderByType"));
			actionResponse.getRenderParameters().setValue("mvcPath", "/purchases/purchases.jsp");	
		} catch (PortalException e) {
			System.out.println("Ошибка при удалении продажи " + e.getMessage());
		}
		return false;
	}

}
