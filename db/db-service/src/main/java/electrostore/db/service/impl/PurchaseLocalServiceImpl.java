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

import com.liferay.portal.aop.AopService;

import electrostore.db.model.Purchase;
import electrostore.db.service.base.PurchaseLocalServiceBaseImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=electrostore.db.model.Purchase",
	service = AopService.class
)
public class PurchaseLocalServiceImpl extends PurchaseLocalServiceBaseImpl {
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