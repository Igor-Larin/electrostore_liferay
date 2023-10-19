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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PurchaseSoap implements Serializable {

	public static PurchaseSoap toSoapModel(Purchase model) {
		PurchaseSoap soapModel = new PurchaseSoap();

		soapModel.setPurchase_id(model.getPurchase_id());
		soapModel.setPurchase_date(model.getPurchase_date());
		soapModel.setElectronic_id(model.getElectronic_id());
		soapModel.setPurchasetype_id(model.getPurchasetype_id());
		soapModel.setEmployee_id(model.getEmployee_id());

		return soapModel;
	}

	public static PurchaseSoap[] toSoapModels(Purchase[] models) {
		PurchaseSoap[] soapModels = new PurchaseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PurchaseSoap[][] toSoapModels(Purchase[][] models) {
		PurchaseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PurchaseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PurchaseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PurchaseSoap[] toSoapModels(List<Purchase> models) {
		List<PurchaseSoap> soapModels = new ArrayList<PurchaseSoap>(
			models.size());

		for (Purchase model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PurchaseSoap[soapModels.size()]);
	}

	public PurchaseSoap() {
	}

	public long getPrimaryKey() {
		return _purchase_id;
	}

	public void setPrimaryKey(long pk) {
		setPurchase_id(pk);
	}

	public long getPurchase_id() {
		return _purchase_id;
	}

	public void setPurchase_id(long purchase_id) {
		_purchase_id = purchase_id;
	}

	public Date getPurchase_date() {
		return _purchase_date;
	}

	public void setPurchase_date(Date purchase_date) {
		_purchase_date = purchase_date;
	}

	public long getElectronic_id() {
		return _electronic_id;
	}

	public void setElectronic_id(long electronic_id) {
		_electronic_id = electronic_id;
	}

	public long getPurchasetype_id() {
		return _purchasetype_id;
	}

	public void setPurchasetype_id(long purchasetype_id) {
		_purchasetype_id = purchasetype_id;
	}

	public long getEmployee_id() {
		return _employee_id;
	}

	public void setEmployee_id(long employee_id) {
		_employee_id = employee_id;
	}

	private long _purchase_id;
	private Date _purchase_date;
	private long _electronic_id;
	private long _purchasetype_id;
	private long _employee_id;

}