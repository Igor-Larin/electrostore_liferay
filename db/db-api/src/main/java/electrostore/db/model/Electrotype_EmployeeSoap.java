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

import electrostore.db.service.persistence.Electrotype_EmployeePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class Electrotype_EmployeeSoap implements Serializable {

	public static Electrotype_EmployeeSoap toSoapModel(
		Electrotype_Employee model) {

		Electrotype_EmployeeSoap soapModel = new Electrotype_EmployeeSoap();

		soapModel.setEmp_id(model.getEmp_id());
		soapModel.setElectro_id(model.getElectro_id());

		return soapModel;
	}

	public static Electrotype_EmployeeSoap[] toSoapModels(
		Electrotype_Employee[] models) {

		Electrotype_EmployeeSoap[] soapModels =
			new Electrotype_EmployeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Electrotype_EmployeeSoap[][] toSoapModels(
		Electrotype_Employee[][] models) {

		Electrotype_EmployeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new Electrotype_EmployeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Electrotype_EmployeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Electrotype_EmployeeSoap[] toSoapModels(
		List<Electrotype_Employee> models) {

		List<Electrotype_EmployeeSoap> soapModels =
			new ArrayList<Electrotype_EmployeeSoap>(models.size());

		for (Electrotype_Employee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new Electrotype_EmployeeSoap[soapModels.size()]);
	}

	public Electrotype_EmployeeSoap() {
	}

	public Electrotype_EmployeePK getPrimaryKey() {
		return new Electrotype_EmployeePK(_emp_id, _electro_id);
	}

	public void setPrimaryKey(Electrotype_EmployeePK pk) {
		setEmp_id(pk.emp_id);
		setElectro_id(pk.electro_id);
	}

	public long getEmp_id() {
		return _emp_id;
	}

	public void setEmp_id(long emp_id) {
		_emp_id = emp_id;
	}

	public long getElectro_id() {
		return _electro_id;
	}

	public void setElectro_id(long electro_id) {
		_electro_id = electro_id;
	}

	private long _emp_id;
	private long _electro_id;

}