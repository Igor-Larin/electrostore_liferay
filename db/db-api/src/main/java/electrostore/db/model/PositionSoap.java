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
public class PositionSoap implements Serializable {

	public static PositionSoap toSoapModel(Position model) {
		PositionSoap soapModel = new PositionSoap();

		soapModel.setPosition_id(model.getPosition_id());
		soapModel.setName(model.getName());

		return soapModel;
	}

	public static PositionSoap[] toSoapModels(Position[] models) {
		PositionSoap[] soapModels = new PositionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PositionSoap[][] toSoapModels(Position[][] models) {
		PositionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PositionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PositionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PositionSoap[] toSoapModels(List<Position> models) {
		List<PositionSoap> soapModels = new ArrayList<PositionSoap>(
			models.size());

		for (Position model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PositionSoap[soapModels.size()]);
	}

	public PositionSoap() {
	}

	public long getPrimaryKey() {
		return _position_id;
	}

	public void setPrimaryKey(long pk) {
		setPosition_id(pk);
	}

	public long getPosition_id() {
		return _position_id;
	}

	public void setPosition_id(long position_id) {
		_position_id = position_id;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	private long _position_id;
	private String _name;

}