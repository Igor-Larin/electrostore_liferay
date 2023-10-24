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

import electrostore.db.model.Electrotype_Employee;
import electrostore.db.service.base.Electrotype_EmployeeLocalServiceBaseImpl;
import electrostore.db.service.persistence.Electrotype_EmployeePK;

import java.util.Scanner;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=electrostore.db.model.Electrotype_Employee",
	service = AopService.class
)
public class Electrotype_EmployeeLocalServiceImpl
	extends Electrotype_EmployeeLocalServiceBaseImpl {
	
	public void addElectrotype_EmployeeFromZip(String entityString, String delimeter) {
		long employee_id, electrotype_id;
		try(Scanner scanner = new Scanner(entityString)) {
			scanner.useDelimiter(delimeter);
			employee_id = scanner.nextLong();
			electrotype_id = scanner.nextLong();
		}
		catch(Exception exception) {
			System.out.println("Ошибка при чтении связующей таблицы из файла");
			return;
		}
		if(electrotype_EmployeePersistence.fetchByPrimaryKey(new Electrotype_EmployeePK(employee_id, electrotype_id)) == null) {
			Electrotype_Employee electrotype_Employee = electrotype_EmployeePersistence.create(new Electrotype_EmployeePK(employee_id, electrotype_id));
			electrotype_EmployeePersistence.update(electrotype_Employee);
		}
		else {
			System.out.println("Такая строка уже есть в связующей таблице + " + employee_id + " " + electrotype_id);
		}
	}
}