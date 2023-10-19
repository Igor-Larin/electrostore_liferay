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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the Electrotype_Employee service. Represents a row in the &quot;electrotype_employee&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see Electrotype_EmployeeModel
 * @generated
 */
@ImplementationClassName("electrostore.db.model.impl.Electrotype_EmployeeImpl")
@ProviderType
public interface Electrotype_Employee
	extends Electrotype_EmployeeModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>electrostore.db.model.impl.Electrotype_EmployeeImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Electrotype_Employee, Long> EMP_ID_ACCESSOR =
		new Accessor<Electrotype_Employee, Long>() {

			@Override
			public Long get(Electrotype_Employee electrotype_Employee) {
				return electrotype_Employee.getEmp_id();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Electrotype_Employee> getTypeClass() {
				return Electrotype_Employee.class;
			}

		};
	public static final Accessor<Electrotype_Employee, Long>
		ELECTRO_ID_ACCESSOR = new Accessor<Electrotype_Employee, Long>() {

			@Override
			public Long get(Electrotype_Employee electrotype_Employee) {
				return electrotype_Employee.getElectro_id();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Electrotype_Employee> getTypeClass() {
				return Electrotype_Employee.class;
			}

		};

}