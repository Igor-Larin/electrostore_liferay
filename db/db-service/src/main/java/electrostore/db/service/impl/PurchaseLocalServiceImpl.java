/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package electrostore.db.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;

import electrostore.db.model.Electronic;
import electrostore.db.model.Purchase;
import electrostore.db.service.base.PurchaseLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=electrostore.db.model.Purchase",
	service = AopService.class
)
public class PurchaseLocalServiceImpl extends PurchaseLocalServiceBaseImpl {
	
	public String getGainByCash() {
		return purchaseFinder.findTheGreatestGainByCash();
	}
	
	public String getElectrotechPurchasesCount() {
		return purchaseFinder.findElectrotechPurchasesCount();
	}
	
	public List<Purchase> getPurchasesByOrder(int start, int end, String order) {
		if(order.trim().equals("none"))
			return purchasePersistence.findAll(start, end);
		else {
			boolean ascOrder = order.trim().equals("asc");
			OrderByComparator<Purchase> purchaseComparator = OrderByComparatorFactoryUtil.create("purchases", "purchase_date", ascOrder);
			return purchasePersistence.findAll(start, end, purchaseComparator);
		}
	}
	
	public void deletePurchase(ActionRequest request) throws PortalException {
		long purchaseId = ParamUtil.getLong(request, "purchaseId");
		Purchase purchase = purchasePersistence.findByPrimaryKey(purchaseId);
		Electronic electronic = electronicPersistence.findByPrimaryKey(purchase.getElectronic_id());
		if(electronic.getIs_archive())
			electronic.setIs_archive(false);
		int count = electronic.getElectronic_count() + 1;
		electronic.setElectronic_count(count);
		electronicPersistence.update(electronic);
		deletePurchase(purchaseId);
	}
	
	public void addPurchase(ActionRequest request) throws PortalException {
		long id = counterLocalService.increment();
		long electroId = ParamUtil.getLong(request, "electronicId");
		int electroCount;
		Purchase purchase = purchasePersistence.create(id);
		purchase.setElectronic_id(electroId);
		purchase.setEmployee_id(ParamUtil.getLong(request, "employee"));
		purchase.setPurchasetype_id(ParamUtil.getLong(request, "purchasetype"));
		String dateParam = ParamUtil.getString(request, "purchaseDate").replace('T', ' ');
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			Date purchaseDate = formatter.parse(dateParam);
			purchase.setPurchase_date(purchaseDate);
		}
		catch(Exception exc) {
			System.out.println("Ошибка преобразования даты покупки " + exc.getMessage());
		}		
		Electronic electronic = electronicPersistence.findByPrimaryKey(electroId);
		electroCount = electronic.getElectronic_count() - 1;
		electronic.setIs_archive(!electronic.getIs_present() && electroCount == 0);
		electronic.setElectronic_count(electroCount);
		electronicPersistence.update(electronic);
		purchasePersistence.update(purchase);
	}
	
	public void addPurchaseFromZip(String purchaseString, String delimeter) {
		long id, electro_id, employee_id, purchaseType_id;
		Date purchase_date;
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy HH:mm");
		try(Scanner scanner = new Scanner(purchaseString)) {
			scanner.useDelimiter(delimeter);
			id = scanner.nextLong();
			if(purchasePersistence.fetchByPrimaryKey(id) != null) {
				System.out.println("Уже есть такая покупка");
				return;
			}
			electro_id = scanner.nextLong();
			employee_id = scanner.nextLong();
			purchase_date = formatter.parse(scanner.next());
			purchaseType_id = scanner.nextLong();
		}
		catch(Exception exception) {
			System.out.println("Ошибка при чтении покупки из файла");
			return;
		}		
		Purchase purchase = purchasePersistence.create(id);
		purchase.setElectronic_id(electro_id);
		purchase.setPurchase_date(purchase_date);
		purchase.setPurchasetype_id(purchaseType_id);
		purchase.setEmployee_id(employee_id);
		purchasePersistence.update(purchase);
	}
}