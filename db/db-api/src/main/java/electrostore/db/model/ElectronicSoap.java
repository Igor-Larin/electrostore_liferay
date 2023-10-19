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
public class ElectronicSoap implements Serializable {

	public static ElectronicSoap toSoapModel(Electronic model) {
		ElectronicSoap soapModel = new ElectronicSoap();

		soapModel.setElectronic_id(model.getElectronic_id());
		soapModel.setName(model.getName());
		soapModel.setPrice(model.getPrice());
		soapModel.setElectronic_count(model.getElectronic_count());
		soapModel.setIs_present(model.isIs_present());
		soapModel.setIs_archive(model.isIs_archive());
		soapModel.setDescription(model.getDescription());
		soapModel.setElectrotype_id(model.getElectrotype_id());

		return soapModel;
	}

	public static ElectronicSoap[] toSoapModels(Electronic[] models) {
		ElectronicSoap[] soapModels = new ElectronicSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ElectronicSoap[][] toSoapModels(Electronic[][] models) {
		ElectronicSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ElectronicSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ElectronicSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ElectronicSoap[] toSoapModels(List<Electronic> models) {
		List<ElectronicSoap> soapModels = new ArrayList<ElectronicSoap>(
			models.size());

		for (Electronic model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ElectronicSoap[soapModels.size()]);
	}

	public ElectronicSoap() {
	}

	public long getPrimaryKey() {
		return _electronic_id;
	}

	public void setPrimaryKey(long pk) {
		setElectronic_id(pk);
	}

	public long getElectronic_id() {
		return _electronic_id;
	}

	public void setElectronic_id(long electronic_id) {
		_electronic_id = electronic_id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public int getPrice() {
		return _price;
	}

	public void setPrice(int price) {
		_price = price;
	}

	public int getElectronic_count() {
		return _electronic_count;
	}

	public void setElectronic_count(int electronic_count) {
		_electronic_count = electronic_count;
	}

	public boolean getIs_present() {
		return _is_present;
	}

	public boolean isIs_present() {
		return _is_present;
	}

	public void setIs_present(boolean is_present) {
		_is_present = is_present;
	}

	public boolean getIs_archive() {
		return _is_archive;
	}

	public boolean isIs_archive() {
		return _is_archive;
	}

	public void setIs_archive(boolean is_archive) {
		_is_archive = is_archive;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getElectrotype_id() {
		return _electrotype_id;
	}

	public void setElectrotype_id(long electrotype_id) {
		_electrotype_id = electrotype_id;
	}

	private long _electronic_id;
	private String _name;
	private int _price;
	private int _electronic_count;
	private boolean _is_present;
	private boolean _is_archive;
	private String _description;
	private long _electrotype_id;

}