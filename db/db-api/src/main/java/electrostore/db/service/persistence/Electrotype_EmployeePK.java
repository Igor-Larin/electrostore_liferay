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

package electrostore.db.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class Electrotype_EmployeePK
	implements Comparable<Electrotype_EmployeePK>, Serializable {

	public long emp_id;
	public long electro_id;

	public Electrotype_EmployeePK() {
	}

	public Electrotype_EmployeePK(long emp_id, long electro_id) {
		this.emp_id = emp_id;
		this.electro_id = electro_id;
	}

	public long getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(long emp_id) {
		this.emp_id = emp_id;
	}

	public long getElectro_id() {
		return electro_id;
	}

	public void setElectro_id(long electro_id) {
		this.electro_id = electro_id;
	}

	@Override
	public int compareTo(Electrotype_EmployeePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (emp_id < pk.emp_id) {
			value = -1;
		}
		else if (emp_id > pk.emp_id) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (electro_id < pk.electro_id) {
			value = -1;
		}
		else if (electro_id > pk.electro_id) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof Electrotype_EmployeePK)) {
			return false;
		}

		Electrotype_EmployeePK pk = (Electrotype_EmployeePK)object;

		if ((emp_id == pk.emp_id) && (electro_id == pk.electro_id)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, emp_id);
		hashCode = HashUtil.hash(hashCode, electro_id);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(6);

		sb.append("{");

		sb.append("emp_id=");

		sb.append(emp_id);
		sb.append(", electro_id=");

		sb.append(electro_id);

		sb.append("}");

		return sb.toString();
	}

}