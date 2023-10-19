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

package electrostore.db.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Electrotype_Employee}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Electrotype_Employee
 * @generated
 */
public class Electrotype_EmployeeWrapper
	extends BaseModelWrapper<Electrotype_Employee>
	implements Electrotype_Employee, ModelWrapper<Electrotype_Employee> {

	public Electrotype_EmployeeWrapper(
		Electrotype_Employee electrotype_Employee) {

		super(electrotype_Employee);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("emp_id", getEmp_id());
		attributes.put("electro_id", getElectro_id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long emp_id = (Long)attributes.get("emp_id");

		if (emp_id != null) {
			setEmp_id(emp_id);
		}

		Long electro_id = (Long)attributes.get("electro_id");

		if (electro_id != null) {
			setElectro_id(electro_id);
		}
	}

	/**
	 * Returns the electro_id of this electrotype_ employee.
	 *
	 * @return the electro_id of this electrotype_ employee
	 */
	@Override
	public long getElectro_id() {
		return model.getElectro_id();
	}

	/**
	 * Returns the emp_id of this electrotype_ employee.
	 *
	 * @return the emp_id of this electrotype_ employee
	 */
	@Override
	public long getEmp_id() {
		return model.getEmp_id();
	}

	/**
	 * Returns the primary key of this electrotype_ employee.
	 *
	 * @return the primary key of this electrotype_ employee
	 */
	@Override
	public electrostore.db.service.persistence.Electrotype_EmployeePK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the electro_id of this electrotype_ employee.
	 *
	 * @param electro_id the electro_id of this electrotype_ employee
	 */
	@Override
	public void setElectro_id(long electro_id) {
		model.setElectro_id(electro_id);
	}

	/**
	 * Sets the emp_id of this electrotype_ employee.
	 *
	 * @param emp_id the emp_id of this electrotype_ employee
	 */
	@Override
	public void setEmp_id(long emp_id) {
		model.setEmp_id(emp_id);
	}

	/**
	 * Sets the primary key of this electrotype_ employee.
	 *
	 * @param primaryKey the primary key of this electrotype_ employee
	 */
	@Override
	public void setPrimaryKey(
		electrostore.db.service.persistence.Electrotype_EmployeePK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected Electrotype_EmployeeWrapper wrap(
		Electrotype_Employee electrotype_Employee) {

		return new Electrotype_EmployeeWrapper(electrotype_Employee);
	}

}