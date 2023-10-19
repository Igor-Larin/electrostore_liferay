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
 * This class is a wrapper for {@link Electronic}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Electronic
 * @generated
 */
public class ElectronicWrapper
	extends BaseModelWrapper<Electronic>
	implements Electronic, ModelWrapper<Electronic> {

	public ElectronicWrapper(Electronic electronic) {
		super(electronic);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("electronic_id", getElectronic_id());
		attributes.put("name", getName());
		attributes.put("price", getPrice());
		attributes.put("electronic_count", getElectronic_count());
		attributes.put("is_present", isIs_present());
		attributes.put("is_archive", isIs_archive());
		attributes.put("description", getDescription());
		attributes.put("electrotype_id", getElectrotype_id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long electronic_id = (Long)attributes.get("electronic_id");

		if (electronic_id != null) {
			setElectronic_id(electronic_id);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Integer price = (Integer)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Integer electronic_count = (Integer)attributes.get("electronic_count");

		if (electronic_count != null) {
			setElectronic_count(electronic_count);
		}

		Boolean is_present = (Boolean)attributes.get("is_present");

		if (is_present != null) {
			setIs_present(is_present);
		}

		Boolean is_archive = (Boolean)attributes.get("is_archive");

		if (is_archive != null) {
			setIs_archive(is_archive);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long electrotype_id = (Long)attributes.get("electrotype_id");

		if (electrotype_id != null) {
			setElectrotype_id(electrotype_id);
		}
	}

	/**
	 * Returns the description of this electronic.
	 *
	 * @return the description of this electronic
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the electronic_count of this electronic.
	 *
	 * @return the electronic_count of this electronic
	 */
	@Override
	public int getElectronic_count() {
		return model.getElectronic_count();
	}

	/**
	 * Returns the electronic_id of this electronic.
	 *
	 * @return the electronic_id of this electronic
	 */
	@Override
	public long getElectronic_id() {
		return model.getElectronic_id();
	}

	/**
	 * Returns the electrotype_id of this electronic.
	 *
	 * @return the electrotype_id of this electronic
	 */
	@Override
	public long getElectrotype_id() {
		return model.getElectrotype_id();
	}

	/**
	 * Returns the is_archive of this electronic.
	 *
	 * @return the is_archive of this electronic
	 */
	@Override
	public boolean getIs_archive() {
		return model.getIs_archive();
	}

	/**
	 * Returns the is_present of this electronic.
	 *
	 * @return the is_present of this electronic
	 */
	@Override
	public boolean getIs_present() {
		return model.getIs_present();
	}

	/**
	 * Returns the name of this electronic.
	 *
	 * @return the name of this electronic
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the price of this electronic.
	 *
	 * @return the price of this electronic
	 */
	@Override
	public int getPrice() {
		return model.getPrice();
	}

	/**
	 * Returns the primary key of this electronic.
	 *
	 * @return the primary key of this electronic
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns <code>true</code> if this electronic is is_archive.
	 *
	 * @return <code>true</code> if this electronic is is_archive; <code>false</code> otherwise
	 */
	@Override
	public boolean isIs_archive() {
		return model.isIs_archive();
	}

	/**
	 * Returns <code>true</code> if this electronic is is_present.
	 *
	 * @return <code>true</code> if this electronic is is_present; <code>false</code> otherwise
	 */
	@Override
	public boolean isIs_present() {
		return model.isIs_present();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the description of this electronic.
	 *
	 * @param description the description of this electronic
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the electronic_count of this electronic.
	 *
	 * @param electronic_count the electronic_count of this electronic
	 */
	@Override
	public void setElectronic_count(int electronic_count) {
		model.setElectronic_count(electronic_count);
	}

	/**
	 * Sets the electronic_id of this electronic.
	 *
	 * @param electronic_id the electronic_id of this electronic
	 */
	@Override
	public void setElectronic_id(long electronic_id) {
		model.setElectronic_id(electronic_id);
	}

	/**
	 * Sets the electrotype_id of this electronic.
	 *
	 * @param electrotype_id the electrotype_id of this electronic
	 */
	@Override
	public void setElectrotype_id(long electrotype_id) {
		model.setElectrotype_id(electrotype_id);
	}

	/**
	 * Sets whether this electronic is is_archive.
	 *
	 * @param is_archive the is_archive of this electronic
	 */
	@Override
	public void setIs_archive(boolean is_archive) {
		model.setIs_archive(is_archive);
	}

	/**
	 * Sets whether this electronic is is_present.
	 *
	 * @param is_present the is_present of this electronic
	 */
	@Override
	public void setIs_present(boolean is_present) {
		model.setIs_present(is_present);
	}

	/**
	 * Sets the name of this electronic.
	 *
	 * @param name the name of this electronic
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the price of this electronic.
	 *
	 * @param price the price of this electronic
	 */
	@Override
	public void setPrice(int price) {
		model.setPrice(price);
	}

	/**
	 * Sets the primary key of this electronic.
	 *
	 * @param primaryKey the primary key of this electronic
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected ElectronicWrapper wrap(Electronic electronic) {
		return new ElectronicWrapper(electronic);
	}

}