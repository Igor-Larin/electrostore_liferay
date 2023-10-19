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

import electrostore.db.model.Electrotype_Employee;
import electrostore.db.service.persistence.Electrotype_EmployeePK;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Electrotype_Employee in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class Electrotype_EmployeeCacheModel
	implements CacheModel<Electrotype_Employee>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Electrotype_EmployeeCacheModel)) {
			return false;
		}

		Electrotype_EmployeeCacheModel electrotype_EmployeeCacheModel =
			(Electrotype_EmployeeCacheModel)object;

		if (electrotype_EmployeePK.equals(
				electrotype_EmployeeCacheModel.electrotype_EmployeePK)) {

			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, electrotype_EmployeePK);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(5);

		sb.append("{emp_id=");
		sb.append(emp_id);
		sb.append(", electro_id=");
		sb.append(electro_id);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Electrotype_Employee toEntityModel() {
		Electrotype_EmployeeImpl electrotype_EmployeeImpl =
			new Electrotype_EmployeeImpl();

		electrotype_EmployeeImpl.setEmp_id(emp_id);
		electrotype_EmployeeImpl.setElectro_id(electro_id);

		electrotype_EmployeeImpl.resetOriginalValues();

		return electrotype_EmployeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		emp_id = objectInput.readLong();

		electro_id = objectInput.readLong();

		electrotype_EmployeePK = new Electrotype_EmployeePK(emp_id, electro_id);
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(emp_id);

		objectOutput.writeLong(electro_id);
	}

	public long emp_id;
	public long electro_id;
	public transient Electrotype_EmployeePK electrotype_EmployeePK;

}