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
public class PurchaseTypeSoap implements Serializable {

	public static PurchaseTypeSoap toSoapModel(PurchaseType model) {
		PurchaseTypeSoap soapModel = new PurchaseTypeSoap();

		soapModel.setPurchasetype_id(model.getPurchasetype_id());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static PurchaseTypeSoap[] toSoapModels(PurchaseType[] models) {
		PurchaseTypeSoap[] soapModels = new PurchaseTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PurchaseTypeSoap[][] toSoapModels(PurchaseType[][] models) {
		PurchaseTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PurchaseTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PurchaseTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PurchaseTypeSoap[] toSoapModels(List<PurchaseType> models) {
		List<PurchaseTypeSoap> soapModels = new ArrayList<PurchaseTypeSoap>(
			models.size());

		for (PurchaseType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PurchaseTypeSoap[soapModels.size()]);
	}

	public PurchaseTypeSoap() {
	}

	public long getPrimaryKey() {
		return _purchasetype_id;
	}

	public void setPrimaryKey(long pk) {
		setPurchasetype_id(pk);
	}

	public long getPurchasetype_id() {
		return _purchasetype_id;
	}

	public void setPurchasetype_id(long purchasetype_id) {
		_purchasetype_id = purchasetype_id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _purchasetype_id;
	private String _name;

}