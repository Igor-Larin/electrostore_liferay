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

package electrostore.db.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import electrostore.db.model.Employee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Employee in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class EmployeeCacheModel
	implements CacheModel<Employee>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof EmployeeCacheModel)) {
			return false;
		}

		EmployeeCacheModel employeeCacheModel = (EmployeeCacheModel)object;

		if (employee_id == employeeCacheModel.employee_id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, employee_id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{employee_id=");
		sb.append(employee_id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", lastname=");
		sb.append(lastname);
		sb.append(", midname=");
		sb.append(midname);
		sb.append(", birthdate=");
		sb.append(birthdate);
		sb.append(", sex=");
		sb.append(sex);
		sb.append(", position_id=");
		sb.append(position_id);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Employee toEntityModel() {
		EmployeeImpl employeeImpl = new EmployeeImpl();

		employeeImpl.setEmployee_id(employee_id);

		if (name == null) {
			employeeImpl.setName("");
		}
		else {
			employeeImpl.setName(name);
		}

		if (lastname == null) {
			employeeImpl.setLastname("");
		}
		else {
			employeeImpl.setLastname(lastname);
		}

		if (midname == null) {
			employeeImpl.setMidname("");
		}
		else {
			employeeImpl.setMidname(midname);
		}

		if (birthdate == Long.MIN_VALUE) {
			employeeImpl.setBirthdate(null);
		}
		else {
			employeeImpl.setBirthdate(new Date(birthdate));
		}

		employeeImpl.setSex(sex);
		employeeImpl.setPosition_id(position_id);

		employeeImpl.resetOriginalValues();

		return employeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		employee_id = objectInput.readLong();
		name = objectInput.readUTF();
		lastname = objectInput.readUTF();
		midname = objectInput.readUTF();
		birthdate = objectInput.readLong();

		sex = objectInput.readBoolean();

		position_id = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(employee_id);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (lastname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(lastname);
		}

		if (midname == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(midname);
		}

		objectOutput.writeLong(birthdate);

		objectOutput.writeBoolean(sex);

		objectOutput.writeLong(position_id);
	}

	public long employee_id;
	public String name;
	public String lastname;
	public String midname;
	public long birthdate;
	public boolean sex;
	public long position_id;

}