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

package electrostore.db.model.impl;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import electrostore.db.model.Purchase;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Purchase in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class PurchaseCacheModel
	implements CacheModel<Purchase>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof PurchaseCacheModel)) {
			return false;
		}

		PurchaseCacheModel purchaseCacheModel = (PurchaseCacheModel)object;

		if (purchase_id == purchaseCacheModel.purchase_id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, purchase_id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{purchase_id=");
		sb.append(purchase_id);
		sb.append(", purchase_date=");
		sb.append(purchase_date);
		sb.append(", electronic_id=");
		sb.append(electronic_id);
		sb.append(", purchasetype_id=");
		sb.append(purchasetype_id);
		sb.append(", employee_id=");
		sb.append(employee_id);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Purchase toEntityModel() {
		PurchaseImpl purchaseImpl = new PurchaseImpl();

		purchaseImpl.setPurchase_id(purchase_id);

		if (purchase_date == Long.MIN_VALUE) {
			purchaseImpl.setPurchase_date(null);
		}
		else {
			purchaseImpl.setPurchase_date(new Date(purchase_date));
		}

		purchaseImpl.setElectronic_id(electronic_id);
		purchaseImpl.setPurchasetype_id(purchasetype_id);
		purchaseImpl.setEmployee_id(employee_id);

		purchaseImpl.resetOriginalValues();

		return purchaseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		purchase_id = objectInput.readLong();
		purchase_date = objectInput.readLong();

		electronic_id = objectInput.readLong();

		purchasetype_id = objectInput.readLong();

		employee_id = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(purchase_id);
		objectOutput.writeLong(purchase_date);

		objectOutput.writeLong(electronic_id);

		objectOutput.writeLong(purchasetype_id);

		objectOutput.writeLong(employee_id);
	}

	public long purchase_id;
	public long purchase_date;
	public long electronic_id;
	public long purchasetype_id;
	public long employee_id;

}