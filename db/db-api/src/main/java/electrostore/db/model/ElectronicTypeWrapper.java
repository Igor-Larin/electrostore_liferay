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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ElectronicType}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectronicType
 * @generated
 */
public class ElectronicTypeWrapper
	extends BaseModelWrapper<ElectronicType>
	implements ElectronicType, ModelWrapper<ElectronicType> {

	public ElectronicTypeWrapper(ElectronicType electronicType) {
		super(electronicType);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("electrotype_id", getElectrotype_id());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long electrotype_id = (Long)attributes.get("electrotype_id");

		if (electrotype_id != null) {
			setElectrotype_id(electrotype_id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	 * Returns the electrotype_id of this electronic type.
	 *
	 * @return the electrotype_id of this electronic type
	 */
	@Override
	public long getElectrotype_id() {
		return model.getElectrotype_id();
	}

	/**
	 * Returns the name of this electronic type.
	 *
	 * @return the name of this electronic type
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the primary key of this electronic type.
	 *
	 * @return the primary key of this electronic type
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the electrotype_id of this electronic type.
	 *
	 * @param electrotype_id the electrotype_id of this electronic type
	 */
	@Override
	public void setElectrotype_id(long electrotype_id) {
		model.setElectrotype_id(electrotype_id);
	}

	/**
	 * Sets the name of this electronic type.
	 *
	 * @param name the name of this electronic type
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the primary key of this electronic type.
	 *
	 * @param primaryKey the primary key of this electronic type
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected ElectronicTypeWrapper wrap(ElectronicType electronicType) {
		return new ElectronicTypeWrapper(electronicType);
	}

}