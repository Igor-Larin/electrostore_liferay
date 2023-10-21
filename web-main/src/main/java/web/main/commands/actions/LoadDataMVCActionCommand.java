package web.main.commands.actions;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;

import electrostore.db.service.ElectronicLocalService;
import electrostore.db.service.ElectronicTypeLocalService;
import electrostore.db.service.Electrotype_EmployeeLocalService;
import electrostore.db.service.EmployeeLocalService;
import electrostore.db.service.PositionLocalService;
import electrostore.db.service.PurchaseLocalService;
import electrostore.db.service.PurchaseTypeLocalService;
import web.main.constants.WebMainPortletKeys;
import web.main.fileutils.ZipFileUtilsConstants;

@Component(
		immediate = true,
		property = {
				"javax.portlet.name=" + WebMainPortletKeys.WEBMAIN,
				"mvc.command.name=loadDatabase"
		},
		service=MVCActionCommand.class
)
public class LoadDataMVCActionCommand implements MVCActionCommand {
	
	@Reference
	private EmployeeLocalService employeeLocalService;
	@Reference
	private PositionLocalService positionLocalService;
	@Reference
	private PurchaseLocalService purchaseLocalService;
	@Reference
	private PurchaseTypeLocalService purchaseTypeLocalService;
	@Reference
	private ElectronicLocalService electronicLocalService;
	@Reference
	private ElectronicTypeLocalService electronicTypeLocalService;
	@Reference
	private Electrotype_EmployeeLocalService electrotype_EmployeeLocalService;
	
	@Override
	public boolean processAction(ActionRequest actionRequest, ActionResponse actionResponse) throws PortletException {
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		File datafile =  uploadPortletRequest.getFile("datafile");
		if(datafile != null && datafile.exists()) {
			System.out.println(datafile.getName());		
			try(ZipInputStream zin = new ZipInputStream(new FileInputStream(datafile))) {
	            ZipEntry entry;
	            while((entry = zin.getNextEntry()) != null) {
	            	System.out.println(entry.getName());
	            	createEntities(zin, entry.getName());
	            }
	        }
	        catch (Exception exception) {
	            System.out.println(exception.getMessage());
	            return true;
	        }
		}
		else {
			return true;
		}
		return false;
	}
	
	private void createEntities(ZipInputStream zin, String fileName) {		
		Scanner scanner = new Scanner(zin, "windows-1251");
		scanner.nextLine();
		switch(fileName) {
			case ZipFileUtilsConstants.EMPLOYEE:
				while(scanner.hasNext()) {
					employeeLocalService.addEmployeeFromZip(scanner.nextLine(), ZipFileUtilsConstants.DELIMETER); 
				}
				break;
			case ZipFileUtilsConstants.ELECTRONIC:
				while(scanner.hasNext()) {
					electronicLocalService.addElectronicFromZip(scanner.nextLine(), ZipFileUtilsConstants.DELIMETER);
				}
				break;
			case ZipFileUtilsConstants.PURCHASE:
				while(scanner.hasNext()) {
					purchaseLocalService.addPurchaseFromZip(scanner.nextLine(), ZipFileUtilsConstants.DELIMETER);
				}
				break;
			case ZipFileUtilsConstants.ELECTRO_EMPLOYEE:
				while(scanner.hasNext()) {
					electrotype_EmployeeLocalService.addElectrotype_EmployeeFromZip(scanner.nextLine(), ZipFileUtilsConstants.DELIMETER);
				}
				break;
			case ZipFileUtilsConstants.ELECTRO_TYPE:
				while(scanner.hasNext()) {
					electronicTypeLocalService.addElectronicTypeFromZip(scanner.nextLine(), ZipFileUtilsConstants.DELIMETER);
				}
				break;
			case ZipFileUtilsConstants.POSITION:
				while(scanner.hasNext()) {
					positionLocalService.addPositionFromZip(scanner.nextLine(), ZipFileUtilsConstants.DELIMETER);
				}
				break;
			case ZipFileUtilsConstants.PURCHASE_TYPE:
				while(scanner.hasNext()) {
					purchaseTypeLocalService.addPurchaseTypeFromZip(scanner.nextLine(), ZipFileUtilsConstants.DELIMETER);
				}
				break;
		}
		
	}
}
