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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ParamUtil;

import electrostore.db.model.Electrotype_Employee;
import electrostore.db.model.Employee;
import electrostore.db.service.base.EmployeeLocalServiceBaseImpl;
import electrostore.db.service.persistence.Electrotype_EmployeePK;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=electrostore.db.model.Employee",
	service = AopService.class
)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
	
	public Employee getBestEmployeeBySmartphonesPurchases() {
		return employeeFinder.findBestEmployeeBySmartphonePurchases();
	}
	
	public List<Employee> getEmployeesByElectroType(long electroType) {
		List<Electrotype_Employee> employeesTypes = electrotype_EmployeePersistence.findByElectronicType(electroType);
		List<Employee> employees = new ArrayList<>();
		for (Electrotype_Employee emplType : employeesTypes) {
			employees.add(employeePersistence.fetchByPrimaryKey(emplType.getEmp_id()));
		}
		return employees;	
	}
	
	public void deleteEmployee(ActionRequest request) throws PortalException {
		long id = ParamUtil.getLong(request, "employeeId");
		List<Electrotype_Employee> ee = electrotype_EmployeePersistence.findByEmployeeId(id);
		for(Electrotype_Employee el_em : ee)
			electrotype_EmployeePersistence.remove(el_em);
		deleteEmployee(id);
	}
	
	public void addEmployee(ActionRequest request) {
		long id = counterLocalService.increment();
		boolean isFemale = ParamUtil.getBoolean(request, "sex");
		String datePattern = "yyyy-MM-dd";
		Employee employee = employeePersistence.create(id);
		employee.setName(ParamUtil.getString(request, "name"));
		employee.setLastname(ParamUtil.getString(request, "lastname"));
		employee.setMidname(ParamUtil.getString(request, "midname"));		
		employee.setSex(isFemale);
		employee.setBirthdate(ParamUtil.getDate(request, "birthdate", new SimpleDateFormat(datePattern)));
		long[] electrotypes = ParamUtil.getLongValues(request, "electrotypes");
		for(long electrotype : electrotypes) {
			Electrotype_Employee ee = electrotype_EmployeePersistence.create(new Electrotype_EmployeePK(id, electrotype));
			electrotype_EmployeePersistence.update(ee);
		}
		employee.setPosition_id(ParamUtil.getLong(request, "position"));
		employeePersistence.update(employee);
	}
	
	public void addEmployeeFromZip(String employeeString, String delimeter) {
		long id, position_id;
		String lastname, name, midname;
		boolean isFemale;
		Date birthdate;
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
		try(Scanner scanner = new Scanner(employeeString)) {
			scanner.useDelimiter(delimeter);
			id = scanner.nextLong();
			if(employeePersistence.fetchByPrimaryKey(id) != null) {
				System.out.println("Уже есть такой сотрудник id " + id);
				return;
			}
			lastname = scanner.next();
			name = scanner.next();
			midname = scanner.next(); 
			birthdate = formatter.parse(scanner.next());
			position_id = scanner.nextLong();
			isFemale = scanner.nextByte() == 1 ? true : false;
		}
		catch(Exception exception) {
			System.out.println("Ошибка при чтении сотрудника из файла");
			return;
		}		
		Employee employee = employeePersistence.create(id);
		employee.setName(name);
		employee.setLastname(lastname);
		employee.setMidname(midname);		
		employee.setSex(isFemale);
		employee.setBirthdate(birthdate);
		employee.setPosition_id(position_id);
		employeePersistence.update(employee);
	}
	
	public void updateEmployee(ActionRequest request) throws PortalException {
		long id = ParamUtil.getLong(request, "employeeId");
		boolean isFemale = ParamUtil.getBoolean(request, "sex");
		String datePattern = "yyyy-MM-dd";
		Employee employee = employeePersistence.findByPrimaryKey(id);
		employee.setName(ParamUtil.getString(request, "name"));
		employee.setLastname(ParamUtil.getString(request, "lastname"));
		employee.setMidname(ParamUtil.getString(request, "midname"));		
		employee.setSex(isFemale);
		employee.setBirthdate(ParamUtil.getDate(request, "birthdate", new SimpleDateFormat(datePattern)));
		employee.setPosition_id(ParamUtil.getLong(request, "position"));
		long[] electrotypes = ParamUtil.getLongValues(request, "electrotypes");
		
		List<Electrotype_Employee> ees = electrotype_EmployeePersistence.findByEmployeeId(id);
		for(Electrotype_Employee el_em : ees)
			electrotype_EmployeePersistence.remove(el_em);
		
		for(long electrotype : electrotypes) {
			Electrotype_Employee ee = electrotype_EmployeePersistence.create(new Electrotype_EmployeePK(id, electrotype));
			electrotype_EmployeePersistence.update(ee);
		}
		employeePersistence.update(employee);
	}
	
	public List<Employee> getAllEmployees() {
		return employeePersistence.findAll();
	}	
}