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

import electrostore.db.model.PurchaseType;
import electrostore.db.service.base.PurchaseTypeLocalServiceBaseImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=electrostore.db.model.PurchaseType",
	service = AopService.class
)
public class PurchaseTypeLocalServiceImpl
	extends PurchaseTypeLocalServiceBaseImpl {
	public void addPurchaseTypeFromZip(String purchaseTypeString, String delimeter) {
		long id;
		String name;
		try(Scanner scanner = new Scanner(purchaseTypeString)) {
			scanner.useDelimiter(delimeter);
			id = scanner.nextLong();
			if(purchaseTypePersistence.fetchByPrimaryKey(id) != null) {
				System.out.println("Уже есть такой тип покупки id " + id);
				return;
			}
			name = scanner.next();
		}
		catch(Exception exception) {
			System.out.println("Ошибка при чтении типа покупки из файла");
			return;
		}		
		PurchaseType purchaseType = purchaseTypePersistence.create(id);
		purchaseType.setName(name);
		purchaseTypePersistence.update(purchaseType);
	}
}