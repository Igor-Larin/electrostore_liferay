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
public class ElectronicTypeSoap implements Serializable {

	public static ElectronicTypeSoap toSoapModel(ElectronicType model) {
		ElectronicTypeSoap soapModel = new ElectronicTypeSoap();

		soapModel.setElectrotype_id(model.getElectrotype_id());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static ElectronicTypeSoap[] toSoapModels(ElectronicType[] models) {
		ElectronicTypeSoap[] soapModels = new ElectronicTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ElectronicTypeSoap[][] toSoapModels(
		ElectronicType[][] models) {

		ElectronicTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ElectronicTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ElectronicTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ElectronicTypeSoap[] toSoapModels(
		List<ElectronicType> models) {

		List<ElectronicTypeSoap> soapModels = new ArrayList<ElectronicTypeSoap>(
			models.size());

		for (ElectronicType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ElectronicTypeSoap[soapModels.size()]);
	}

	public ElectronicTypeSoap() {
	}

	public long getPrimaryKey() {
		return _electrotype_id;
	}

	public void setPrimaryKey(long pk) {
		setElectrotype_id(pk);
	}

	public long getElectrotype_id() {
		return _electrotype_id;
	}

	public void setElectrotype_id(long electrotype_id) {
		_electrotype_id = electrotype_id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _electrotype_id;
	private String _name;

}