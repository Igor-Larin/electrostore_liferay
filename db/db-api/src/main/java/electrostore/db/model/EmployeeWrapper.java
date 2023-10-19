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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Employee}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Employee
 * @generated
 */
public class EmployeeWrapper
	extends BaseModelWrapper<Employee>
	implements Employee, ModelWrapper<Employee> {

	public EmployeeWrapper(Employee employee) {
		super(employee);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("employee_id", getEmployee_id());
		attributes.put("name", getName());
		attributes.put("lastname", getLastname());
		attributes.put("midname", getMidname());
		attributes.put("birthdate", getBirthdate());
		attributes.put("sex", isSex());
		attributes.put("position_id", getPosition_id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long employee_id = (Long)attributes.get("employee_id");

		if (employee_id != null) {
			setEmployee_id(employee_id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String lastname = (String)attributes.get("lastname");

		if (lastname != null) {
			setLastname(lastname);
		}

		String midname = (String)attributes.get("midname");

		if (midname != null) {
			setMidname(midname);
		}

		Date birthdate = (Date)attributes.get("birthdate");

		if (birthdate != null) {
			setBirthdate(birthdate);
		}

		Boolean sex = (Boolean)attributes.get("sex");

		if (sex != null) {
			setSex(sex);
		}

		Long position_id = (Long)attributes.get("position_id");

		if (position_id != null) {
			setPosition_id(position_id);
		}
	}

	/**
	 * Returns the birthdate of this employee.
	 *
	 * @return the birthdate of this employee
	 */
	@Override
	public Date getBirthdate() {
		return model.getBirthdate();
	}

	/**
	 * Returns the employee_id of this employee.
	 *
	 * @return the employee_id of this employee
	 */
	@Override
	public long getEmployee_id() {
		return model.getEmployee_id();
	}

	/**
	 * Returns the lastname of this employee.
	 *
	 * @return the lastname of this employee
	 */
	@Override
	public String getLastname() {
		return model.getLastname();
	}

	/**
	 * Returns the midname of this employee.
	 *
	 * @return the midname of this employee
	 */
	@Override
	public String getMidname() {
		return model.getMidname();
	}

	/**
	 * Returns the name of this employee.
	 *
	 * @return the name of this employee
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the position_id of this employee.
	 *
	 * @return the position_id of this employee
	 */
	@Override
	public long getPosition_id() {
		return model.getPosition_id();
	}

	/**
	 * Returns the primary key of this employee.
	 *
	 * @return the primary key of this employee
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the sex of this employee.
	 *
	 * @return the sex of this employee
	 */
	@Override
	public boolean getSex() {
		return model.getSex();
	}

	/**
	 * Returns <code>true</code> if this employee is sex.
	 *
	 * @return <code>true</code> if this employee is sex; <code>false</code> otherwise
	 */
	@Override
	public boolean isSex() {
		return model.isSex();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the birthdate of this employee.
	 *
	 * @param birthdate the birthdate of this employee
	 */
	@Override
	public void setBirthdate(Date birthdate) {
		model.setBirthdate(birthdate);
	}

	/**
	 * Sets the employee_id of this employee.
	 *
	 * @param employee_id the employee_id of this employee
	 */
	@Override
	public void setEmployee_id(long employee_id) {
		model.setEmployee_id(employee_id);
	}

	/**
	 * Sets the lastname of this employee.
	 *
	 * @param lastname the lastname of this employee
	 */
	@Override
	public void setLastname(String lastname) {
		model.setLastname(lastname);
	}

	/**
	 * Sets the midname of this employee.
	 *
	 * @param midname the midname of this employee
	 */
	@Override
	public void setMidname(String midname) {
		model.setMidname(midname);
	}

	/**
	 * Sets the name of this employee.
	 *
	 * @param name the name of this employee
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the position_id of this employee.
	 *
	 * @param position_id the position_id of this employee
	 */
	@Override
	public void setPosition_id(long position_id) {
		model.setPosition_id(position_id);
	}

	/**
	 * Sets the primary key of this employee.
	 *
	 * @param primaryKey the primary key of this employee
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets whether this employee is sex.
	 *
	 * @param sex the sex of this employee
	 */
	@Override
	public void setSex(boolean sex) {
		model.setSex(sex);
	}

	@Override
	protected EmployeeWrapper wrap(Employee employee) {
		return new EmployeeWrapper(employee);
	}

}