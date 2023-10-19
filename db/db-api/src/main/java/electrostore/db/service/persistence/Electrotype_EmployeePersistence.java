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

package electrostore.db.service.persistence;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import electrostore.db.exception.NoSuchElectrotype_EmployeeException;
import electrostore.db.model.Electrotype_Employee;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the electrotype_ employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Electrotype_EmployeeUtil
 * @generated
 */
@ProviderType
public interface Electrotype_EmployeePersistence
	extends BasePersistence<Electrotype_Employee> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Electrotype_EmployeeUtil} to access the electrotype_ employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the electrotype_ employee in the entity cache if it is enabled.
	 *
	 * @param electrotype_Employee the electrotype_ employee
	 */
	public void cacheResult(Electrotype_Employee electrotype_Employee);

	/**
	 * Caches the electrotype_ employees in the entity cache if it is enabled.
	 *
	 * @param electrotype_Employees the electrotype_ employees
	 */
	public void cacheResult(
		java.util.List<Electrotype_Employee> electrotype_Employees);

	/**
	 * Creates a new electrotype_ employee with the primary key. Does not add the electrotype_ employee to the database.
	 *
	 * @param electrotype_EmployeePK the primary key for the new electrotype_ employee
	 * @return the new electrotype_ employee
	 */
	public Electrotype_Employee create(
		electrostore.db.service.persistence.Electrotype_EmployeePK
			electrotype_EmployeePK);

	/**
	 * Removes the electrotype_ employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param electrotype_EmployeePK the primary key of the electrotype_ employee
	 * @return the electrotype_ employee that was removed
	 * @throws NoSuchElectrotype_EmployeeException if a electrotype_ employee with the primary key could not be found
	 */
	public Electrotype_Employee remove(
			electrostore.db.service.persistence.Electrotype_EmployeePK
				electrotype_EmployeePK)
		throws NoSuchElectrotype_EmployeeException;

	public Electrotype_Employee updateImpl(
		Electrotype_Employee electrotype_Employee);

	/**
	 * Returns the electrotype_ employee with the primary key or throws a <code>NoSuchElectrotype_EmployeeException</code> if it could not be found.
	 *
	 * @param electrotype_EmployeePK the primary key of the electrotype_ employee
	 * @return the electrotype_ employee
	 * @throws NoSuchElectrotype_EmployeeException if a electrotype_ employee with the primary key could not be found
	 */
	public Electrotype_Employee findByPrimaryKey(
			electrostore.db.service.persistence.Electrotype_EmployeePK
				electrotype_EmployeePK)
		throws NoSuchElectrotype_EmployeeException;

	/**
	 * Returns the electrotype_ employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param electrotype_EmployeePK the primary key of the electrotype_ employee
	 * @return the electrotype_ employee, or <code>null</code> if a electrotype_ employee with the primary key could not be found
	 */
	public Electrotype_Employee fetchByPrimaryKey(
		electrostore.db.service.persistence.Electrotype_EmployeePK
			electrotype_EmployeePK);

	/**
	 * Returns all the electrotype_ employees.
	 *
	 * @return the electrotype_ employees
	 */
	public java.util.List<Electrotype_Employee> findAll();

	/**
	 * Returns a range of all the electrotype_ employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Electrotype_EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electrotype_ employees
	 * @param end the upper bound of the range of electrotype_ employees (not inclusive)
	 * @return the range of electrotype_ employees
	 */
	public java.util.List<Electrotype_Employee> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the electrotype_ employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Electrotype_EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electrotype_ employees
	 * @param end the upper bound of the range of electrotype_ employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of electrotype_ employees
	 */
	public java.util.List<Electrotype_Employee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Electrotype_Employee>
			orderByComparator);

	/**
	 * Returns an ordered range of all the electrotype_ employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Electrotype_EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electrotype_ employees
	 * @param end the upper bound of the range of electrotype_ employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of electrotype_ employees
	 */
	public java.util.List<Electrotype_Employee> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Electrotype_Employee>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the electrotype_ employees from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of electrotype_ employees.
	 *
	 * @return the number of electrotype_ employees
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}