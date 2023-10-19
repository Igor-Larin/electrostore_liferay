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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Purchase}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Purchase
 * @generated
 */
public class PurchaseWrapper
	extends BaseModelWrapper<Purchase>
	implements ModelWrapper<Purchase>, Purchase {

	public PurchaseWrapper(Purchase purchase) {
		super(purchase);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("purchase_id", getPurchase_id());
		attributes.put("purchase_date", getPurchase_date());
		attributes.put("electronic_id", getElectronic_id());
		attributes.put("purchasetype_id", getPurchasetype_id());
		attributes.put("employee_id", getEmployee_id());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long purchase_id = (Long)attributes.get("purchase_id");

		if (purchase_id != null) {
			setPurchase_id(purchase_id);
		}

		Date purchase_date = (Date)attributes.get("purchase_date");

		if (purchase_date != null) {
			setPurchase_date(purchase_date);
		}

		Long electronic_id = (Long)attributes.get("electronic_id");

		if (electronic_id != null) {
			setElectronic_id(electronic_id);
		}

		Long purchasetype_id = (Long)attributes.get("purchasetype_id");

		if (purchasetype_id != null) {
			setPurchasetype_id(purchasetype_id);
		}

		Long employee_id = (Long)attributes.get("employee_id");

		if (employee_id != null) {
			setEmployee_id(employee_id);
		}
	}

	/**
	 * Returns the electronic_id of this purchase.
	 *
	 * @return the electronic_id of this purchase
	 */
	@Override
	public long getElectronic_id() {
		return model.getElectronic_id();
	}

	/**
	 * Returns the employee_id of this purchase.
	 *
	 * @return the employee_id of this purchase
	 */
	@Override
	public long getEmployee_id() {
		return model.getEmployee_id();
	}

	/**
	 * Returns the primary key of this purchase.
	 *
	 * @return the primary key of this purchase
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the purchase_date of this purchase.
	 *
	 * @return the purchase_date of this purchase
	 */
	@Override
	public Date getPurchase_date() {
		return model.getPurchase_date();
	}

	/**
	 * Returns the purchase_id of this purchase.
	 *
	 * @return the purchase_id of this purchase
	 */
	@Override
	public long getPurchase_id() {
		return model.getPurchase_id();
	}

	/**
	 * Returns the purchasetype_id of this purchase.
	 *
	 * @return the purchasetype_id of this purchase
	 */
	@Override
	public long getPurchasetype_id() {
		return model.getPurchasetype_id();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the electronic_id of this purchase.
	 *
	 * @param electronic_id the electronic_id of this purchase
	 */
	@Override
	public void setElectronic_id(long electronic_id) {
		model.setElectronic_id(electronic_id);
	}

	/**
	 * Sets the employee_id of this purchase.
	 *
	 * @param employee_id the employee_id of this purchase
	 */
	@Override
	public void setEmployee_id(long employee_id) {
		model.setEmployee_id(employee_id);
	}

	/**
	 * Sets the primary key of this purchase.
	 *
	 * @param primaryKey the primary key of this purchase
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the purchase_date of this purchase.
	 *
	 * @param purchase_date the purchase_date of this purchase
	 */
	@Override
	public void setPurchase_date(Date purchase_date) {
		model.setPurchase_date(purchase_date);
	}

	/**
	 * Sets the purchase_id of this purchase.
	 *
	 * @param purchase_id the purchase_id of this purchase
	 */
	@Override
	public void setPurchase_id(long purchase_id) {
		model.setPurchase_id(purchase_id);
	}

	/**
	 * Sets the purchasetype_id of this purchase.
	 *
	 * @param purchasetype_id the purchasetype_id of this purchase
	 */
	@Override
	public void setPurchasetype_id(long purchasetype_id) {
		model.setPurchasetype_id(purchasetype_id);
	}

	@Override
	protected PurchaseWrapper wrap(Purchase purchase) {
		return new PurchaseWrapper(purchase);
	}

}