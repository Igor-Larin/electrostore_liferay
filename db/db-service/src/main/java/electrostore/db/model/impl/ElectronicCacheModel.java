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

import electrostore.db.model.Electronic;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Electronic in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ElectronicCacheModel
	implements CacheModel<Electronic>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ElectronicCacheModel)) {
			return false;
		}

		ElectronicCacheModel electronicCacheModel =
			(ElectronicCacheModel)object;

		if (electronic_id == electronicCacheModel.electronic_id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, electronic_id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{electronic_id=");
		sb.append(electronic_id);
		sb.append(", name=");
		sb.append(name);
		sb.append(", price=");
		sb.append(price);
		sb.append(", electronic_count=");
		sb.append(electronic_count);
		sb.append(", is_present=");
		sb.append(is_present);
		sb.append(", is_archive=");
		sb.append(is_archive);
		sb.append(", description=");
		sb.append(description);
		sb.append(", electrotype_id=");
		sb.append(electrotype_id);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Electronic toEntityModel() {
		ElectronicImpl electronicImpl = new ElectronicImpl();

		electronicImpl.setElectronic_id(electronic_id);

		if (name == null) {
			electronicImpl.setName("");
		}
		else {
			electronicImpl.setName(name);
		}

		electronicImpl.setPrice(price);
		electronicImpl.setElectronic_count(electronic_count);
		electronicImpl.setIs_present(is_present);
		electronicImpl.setIs_archive(is_archive);

		if (description == null) {
			electronicImpl.setDescription("");
		}
		else {
			electronicImpl.setDescription(description);
		}

		electronicImpl.setElectrotype_id(electrotype_id);

		electronicImpl.resetOriginalValues();

		return electronicImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		electronic_id = objectInput.readLong();
		name = objectInput.readUTF();

		price = objectInput.readInt();

		electronic_count = objectInput.readInt();

		is_present = objectInput.readBoolean();

		is_archive = objectInput.readBoolean();
		description = objectInput.readUTF();

		electrotype_id = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(electronic_id);

		if (name == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeInt(price);

		objectOutput.writeInt(electronic_count);

		objectOutput.writeBoolean(is_present);

		objectOutput.writeBoolean(is_archive);

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(electrotype_id);
	}

	public long electronic_id;
	public String name;
	public int price;
	public int electronic_count;
	public boolean is_present;
	public boolean is_archive;
	public String description;
	public long electrotype_id;

}