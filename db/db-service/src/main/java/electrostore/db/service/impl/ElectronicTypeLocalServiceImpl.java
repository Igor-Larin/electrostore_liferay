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

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;

import electrostore.db.model.ElectronicType;
import electrostore.db.model.Electrotype_Employee;
import electrostore.db.service.base.ElectronicTypeLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=electrostore.db.model.ElectronicType",
	service = AopService.class
)
public class ElectronicTypeLocalServiceImpl
	extends ElectronicTypeLocalServiceBaseImpl {
	
	public List<Long> getEmployeesElectronicTypes(long employeeId) {
		
		List<Electrotype_Employee> ees = electrotype_EmployeePersistence.findByEmployeeId(employeeId);
		List<Long> etype_ids = new ArrayList<>();
		try {
			for(Electrotype_Employee ee : ees)
				etype_ids.add(ee.getElectro_id());
		} catch (Exception e) {
			System.out.println("Ошибка при поиске типов электротовара + " + e.getMessage());
		}
		return etype_ids;
	}
	
	public void addElectronicTypeFromZip(String electroTypeString, String delimeter) {
		long id;
		String name;
		try(Scanner scanner = new Scanner(electroTypeString)) {
			scanner.useDelimiter(delimeter);
			id = scanner.nextLong();
			if(electronicTypePersistence.fetchByPrimaryKey(id) != null) {
				System.out.println("Уже есть такой тип товара id "  + id);
				return;
			}
			name = scanner.next();			
		}
		catch(Exception exception) {
			System.out.println("Ошибка при чтении типа товара из файла");
			return;
		}		
		ElectronicType electronicType = electronicTypePersistence.create(id);
		electronicType.setName(name);
		electronicTypePersistence.update(electronicType);
	}
}