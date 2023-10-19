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

import java.util.List;

import javax.portlet.ActionRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.util.ParamUtil;

import electrostore.db.model.Employee;
import electrostore.db.service.base.EmployeeLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=electrostore.db.model.Employee",
	service = AopService.class
)
public class EmployeeLocalServiceImpl extends EmployeeLocalServiceBaseImpl {
	public void addEmployee(ActionRequest request) {
		long id = counterLocalService.increment();
		Employee employee = employeePersistence.create(id);
		employee.setName(ParamUtil.getString(request, "name"));
		employee.setLastname(ParamUtil.getString(request, "lastname"));
		employee.setMidname(ParamUtil.getString(request, "midname"));
		boolean isFemale = ParamUtil.getString(request, "sex") == "Женщина" ? true : false;
		employee.setSex(isFemale);
		employeePersistence.update(employee);
	}
	public List<Employee> getAllEmployees() {
		return employeePersistence.findAll();
	}
}