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
 * This class is a wrapper for {@link Position}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Position
 * @generated
 */
public class PositionWrapper
	extends BaseModelWrapper<Position>
	implements ModelWrapper<Position>, Position {

	public PositionWrapper(Position position) {
		super(position);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("position_id", getPosition_id());
		attributes.put("name", getName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long position_id = (Long)attributes.get("position_id");

		if (position_id != null) {
			setPosition_id(position_id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}
	}

	/**
	 * Returns the name of this position.
	 *
	 * @return the name of this position
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the position_id of this position.
	 *
	 * @return the position_id of this position
	 */
	@Override
	public long getPosition_id() {
		return model.getPosition_id();
	}

	/**
	 * Returns the primary key of this position.
	 *
	 * @return the primary key of this position
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
	 * Sets the name of this position.
	 *
	 * @param name the name of this position
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the position_id of this position.
	 *
	 * @param position_id the position_id of this position
	 */
	@Override
	public void setPosition_id(long position_id) {
		model.setPosition_id(position_id);
	}

	/**
	 * Sets the primary key of this position.
	 *
	 * @param primaryKey the primary key of this position
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected PositionWrapper wrap(Position position) {
		return new PositionWrapper(position);
	}

}