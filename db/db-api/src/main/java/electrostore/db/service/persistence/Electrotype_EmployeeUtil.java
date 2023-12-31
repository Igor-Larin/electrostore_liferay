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

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import electrostore.db.model.Electrotype_Employee;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the electrotype_ employee service. This utility wraps <code>electrostore.db.service.persistence.impl.Electrotype_EmployeePersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Electrotype_EmployeePersistence
 * @generated
 */
public class Electrotype_EmployeeUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Electrotype_Employee electrotype_Employee) {
		getPersistence().clearCache(electrotype_Employee);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, Electrotype_Employee> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Electrotype_Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Electrotype_Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Electrotype_Employee> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Electrotype_Employee> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Electrotype_Employee update(
		Electrotype_Employee electrotype_Employee) {

		return getPersistence().update(electrotype_Employee);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Electrotype_Employee update(
		Electrotype_Employee electrotype_Employee,
		ServiceContext serviceContext) {

		return getPersistence().update(electrotype_Employee, serviceContext);
	}

	/**
	 * Returns all the electrotype_ employees where emp_id = &#63;.
	 *
	 * @param emp_id the emp_id
	 * @return the matching electrotype_ employees
	 */
	public static List<Electrotype_Employee> findByEmployeeId(long emp_id) {
		return getPersistence().findByEmployeeId(emp_id);
	}

	/**
	 * Returns a range of all the electrotype_ employees where emp_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Electrotype_EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param emp_id the emp_id
	 * @param start the lower bound of the range of electrotype_ employees
	 * @param end the upper bound of the range of electrotype_ employees (not inclusive)
	 * @return the range of matching electrotype_ employees
	 */
	public static List<Electrotype_Employee> findByEmployeeId(
		long emp_id, int start, int end) {

		return getPersistence().findByEmployeeId(emp_id, start, end);
	}

	/**
	 * Returns an ordered range of all the electrotype_ employees where emp_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Electrotype_EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param emp_id the emp_id
	 * @param start the lower bound of the range of electrotype_ employees
	 * @param end the upper bound of the range of electrotype_ employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching electrotype_ employees
	 */
	public static List<Electrotype_Employee> findByEmployeeId(
		long emp_id, int start, int end,
		OrderByComparator<Electrotype_Employee> orderByComparator) {

		return getPersistence().findByEmployeeId(
			emp_id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the electrotype_ employees where emp_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Electrotype_EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param emp_id the emp_id
	 * @param start the lower bound of the range of electrotype_ employees
	 * @param end the upper bound of the range of electrotype_ employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching electrotype_ employees
	 */
	public static List<Electrotype_Employee> findByEmployeeId(
		long emp_id, int start, int end,
		OrderByComparator<Electrotype_Employee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByEmployeeId(
			emp_id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first electrotype_ employee in the ordered set where emp_id = &#63;.
	 *
	 * @param emp_id the emp_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electrotype_ employee
	 * @throws NoSuchElectrotype_EmployeeException if a matching electrotype_ employee could not be found
	 */
	public static Electrotype_Employee findByEmployeeId_First(
			long emp_id,
			OrderByComparator<Electrotype_Employee> orderByComparator)
		throws electrostore.db.exception.NoSuchElectrotype_EmployeeException {

		return getPersistence().findByEmployeeId_First(
			emp_id, orderByComparator);
	}

	/**
	 * Returns the first electrotype_ employee in the ordered set where emp_id = &#63;.
	 *
	 * @param emp_id the emp_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electrotype_ employee, or <code>null</code> if a matching electrotype_ employee could not be found
	 */
	public static Electrotype_Employee fetchByEmployeeId_First(
		long emp_id,
		OrderByComparator<Electrotype_Employee> orderByComparator) {

		return getPersistence().fetchByEmployeeId_First(
			emp_id, orderByComparator);
	}

	/**
	 * Returns the last electrotype_ employee in the ordered set where emp_id = &#63;.
	 *
	 * @param emp_id the emp_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electrotype_ employee
	 * @throws NoSuchElectrotype_EmployeeException if a matching electrotype_ employee could not be found
	 */
	public static Electrotype_Employee findByEmployeeId_Last(
			long emp_id,
			OrderByComparator<Electrotype_Employee> orderByComparator)
		throws electrostore.db.exception.NoSuchElectrotype_EmployeeException {

		return getPersistence().findByEmployeeId_Last(
			emp_id, orderByComparator);
	}

	/**
	 * Returns the last electrotype_ employee in the ordered set where emp_id = &#63;.
	 *
	 * @param emp_id the emp_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electrotype_ employee, or <code>null</code> if a matching electrotype_ employee could not be found
	 */
	public static Electrotype_Employee fetchByEmployeeId_Last(
		long emp_id,
		OrderByComparator<Electrotype_Employee> orderByComparator) {

		return getPersistence().fetchByEmployeeId_Last(
			emp_id, orderByComparator);
	}

	/**
	 * Returns the electrotype_ employees before and after the current electrotype_ employee in the ordered set where emp_id = &#63;.
	 *
	 * @param electrotype_EmployeePK the primary key of the current electrotype_ employee
	 * @param emp_id the emp_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next electrotype_ employee
	 * @throws NoSuchElectrotype_EmployeeException if a electrotype_ employee with the primary key could not be found
	 */
	public static Electrotype_Employee[] findByEmployeeId_PrevAndNext(
			electrostore.db.service.persistence.Electrotype_EmployeePK
				electrotype_EmployeePK,
			long emp_id,
			OrderByComparator<Electrotype_Employee> orderByComparator)
		throws electrostore.db.exception.NoSuchElectrotype_EmployeeException {

		return getPersistence().findByEmployeeId_PrevAndNext(
			electrotype_EmployeePK, emp_id, orderByComparator);
	}

	/**
	 * Removes all the electrotype_ employees where emp_id = &#63; from the database.
	 *
	 * @param emp_id the emp_id
	 */
	public static void removeByEmployeeId(long emp_id) {
		getPersistence().removeByEmployeeId(emp_id);
	}

	/**
	 * Returns the number of electrotype_ employees where emp_id = &#63;.
	 *
	 * @param emp_id the emp_id
	 * @return the number of matching electrotype_ employees
	 */
	public static int countByEmployeeId(long emp_id) {
		return getPersistence().countByEmployeeId(emp_id);
	}

	/**
	 * Returns all the electrotype_ employees where electro_id = &#63;.
	 *
	 * @param electro_id the electro_id
	 * @return the matching electrotype_ employees
	 */
	public static List<Electrotype_Employee> findByElectronicType(
		long electro_id) {

		return getPersistence().findByElectronicType(electro_id);
	}

	/**
	 * Returns a range of all the electrotype_ employees where electro_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Electrotype_EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param electro_id the electro_id
	 * @param start the lower bound of the range of electrotype_ employees
	 * @param end the upper bound of the range of electrotype_ employees (not inclusive)
	 * @return the range of matching electrotype_ employees
	 */
	public static List<Electrotype_Employee> findByElectronicType(
		long electro_id, int start, int end) {

		return getPersistence().findByElectronicType(electro_id, start, end);
	}

	/**
	 * Returns an ordered range of all the electrotype_ employees where electro_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Electrotype_EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param electro_id the electro_id
	 * @param start the lower bound of the range of electrotype_ employees
	 * @param end the upper bound of the range of electrotype_ employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching electrotype_ employees
	 */
	public static List<Electrotype_Employee> findByElectronicType(
		long electro_id, int start, int end,
		OrderByComparator<Electrotype_Employee> orderByComparator) {

		return getPersistence().findByElectronicType(
			electro_id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the electrotype_ employees where electro_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>Electrotype_EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param electro_id the electro_id
	 * @param start the lower bound of the range of electrotype_ employees
	 * @param end the upper bound of the range of electrotype_ employees (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching electrotype_ employees
	 */
	public static List<Electrotype_Employee> findByElectronicType(
		long electro_id, int start, int end,
		OrderByComparator<Electrotype_Employee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByElectronicType(
			electro_id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first electrotype_ employee in the ordered set where electro_id = &#63;.
	 *
	 * @param electro_id the electro_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electrotype_ employee
	 * @throws NoSuchElectrotype_EmployeeException if a matching electrotype_ employee could not be found
	 */
	public static Electrotype_Employee findByElectronicType_First(
			long electro_id,
			OrderByComparator<Electrotype_Employee> orderByComparator)
		throws electrostore.db.exception.NoSuchElectrotype_EmployeeException {

		return getPersistence().findByElectronicType_First(
			electro_id, orderByComparator);
	}

	/**
	 * Returns the first electrotype_ employee in the ordered set where electro_id = &#63;.
	 *
	 * @param electro_id the electro_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electrotype_ employee, or <code>null</code> if a matching electrotype_ employee could not be found
	 */
	public static Electrotype_Employee fetchByElectronicType_First(
		long electro_id,
		OrderByComparator<Electrotype_Employee> orderByComparator) {

		return getPersistence().fetchByElectronicType_First(
			electro_id, orderByComparator);
	}

	/**
	 * Returns the last electrotype_ employee in the ordered set where electro_id = &#63;.
	 *
	 * @param electro_id the electro_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electrotype_ employee
	 * @throws NoSuchElectrotype_EmployeeException if a matching electrotype_ employee could not be found
	 */
	public static Electrotype_Employee findByElectronicType_Last(
			long electro_id,
			OrderByComparator<Electrotype_Employee> orderByComparator)
		throws electrostore.db.exception.NoSuchElectrotype_EmployeeException {

		return getPersistence().findByElectronicType_Last(
			electro_id, orderByComparator);
	}

	/**
	 * Returns the last electrotype_ employee in the ordered set where electro_id = &#63;.
	 *
	 * @param electro_id the electro_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electrotype_ employee, or <code>null</code> if a matching electrotype_ employee could not be found
	 */
	public static Electrotype_Employee fetchByElectronicType_Last(
		long electro_id,
		OrderByComparator<Electrotype_Employee> orderByComparator) {

		return getPersistence().fetchByElectronicType_Last(
			electro_id, orderByComparator);
	}

	/**
	 * Returns the electrotype_ employees before and after the current electrotype_ employee in the ordered set where electro_id = &#63;.
	 *
	 * @param electrotype_EmployeePK the primary key of the current electrotype_ employee
	 * @param electro_id the electro_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next electrotype_ employee
	 * @throws NoSuchElectrotype_EmployeeException if a electrotype_ employee with the primary key could not be found
	 */
	public static Electrotype_Employee[] findByElectronicType_PrevAndNext(
			electrostore.db.service.persistence.Electrotype_EmployeePK
				electrotype_EmployeePK,
			long electro_id,
			OrderByComparator<Electrotype_Employee> orderByComparator)
		throws electrostore.db.exception.NoSuchElectrotype_EmployeeException {

		return getPersistence().findByElectronicType_PrevAndNext(
			electrotype_EmployeePK, electro_id, orderByComparator);
	}

	/**
	 * Removes all the electrotype_ employees where electro_id = &#63; from the database.
	 *
	 * @param electro_id the electro_id
	 */
	public static void removeByElectronicType(long electro_id) {
		getPersistence().removeByElectronicType(electro_id);
	}

	/**
	 * Returns the number of electrotype_ employees where electro_id = &#63;.
	 *
	 * @param electro_id the electro_id
	 * @return the number of matching electrotype_ employees
	 */
	public static int countByElectronicType(long electro_id) {
		return getPersistence().countByElectronicType(electro_id);
	}

	/**
	 * Caches the electrotype_ employee in the entity cache if it is enabled.
	 *
	 * @param electrotype_Employee the electrotype_ employee
	 */
	public static void cacheResult(Electrotype_Employee electrotype_Employee) {
		getPersistence().cacheResult(electrotype_Employee);
	}

	/**
	 * Caches the electrotype_ employees in the entity cache if it is enabled.
	 *
	 * @param electrotype_Employees the electrotype_ employees
	 */
	public static void cacheResult(
		List<Electrotype_Employee> electrotype_Employees) {

		getPersistence().cacheResult(electrotype_Employees);
	}

	/**
	 * Creates a new electrotype_ employee with the primary key. Does not add the electrotype_ employee to the database.
	 *
	 * @param electrotype_EmployeePK the primary key for the new electrotype_ employee
	 * @return the new electrotype_ employee
	 */
	public static Electrotype_Employee create(
		electrostore.db.service.persistence.Electrotype_EmployeePK
			electrotype_EmployeePK) {

		return getPersistence().create(electrotype_EmployeePK);
	}

	/**
	 * Removes the electrotype_ employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param electrotype_EmployeePK the primary key of the electrotype_ employee
	 * @return the electrotype_ employee that was removed
	 * @throws NoSuchElectrotype_EmployeeException if a electrotype_ employee with the primary key could not be found
	 */
	public static Electrotype_Employee remove(
			electrostore.db.service.persistence.Electrotype_EmployeePK
				electrotype_EmployeePK)
		throws electrostore.db.exception.NoSuchElectrotype_EmployeeException {

		return getPersistence().remove(electrotype_EmployeePK);
	}

	public static Electrotype_Employee updateImpl(
		Electrotype_Employee electrotype_Employee) {

		return getPersistence().updateImpl(electrotype_Employee);
	}

	/**
	 * Returns the electrotype_ employee with the primary key or throws a <code>NoSuchElectrotype_EmployeeException</code> if it could not be found.
	 *
	 * @param electrotype_EmployeePK the primary key of the electrotype_ employee
	 * @return the electrotype_ employee
	 * @throws NoSuchElectrotype_EmployeeException if a electrotype_ employee with the primary key could not be found
	 */
	public static Electrotype_Employee findByPrimaryKey(
			electrostore.db.service.persistence.Electrotype_EmployeePK
				electrotype_EmployeePK)
		throws electrostore.db.exception.NoSuchElectrotype_EmployeeException {

		return getPersistence().findByPrimaryKey(electrotype_EmployeePK);
	}

	/**
	 * Returns the electrotype_ employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param electrotype_EmployeePK the primary key of the electrotype_ employee
	 * @return the electrotype_ employee, or <code>null</code> if a electrotype_ employee with the primary key could not be found
	 */
	public static Electrotype_Employee fetchByPrimaryKey(
		electrostore.db.service.persistence.Electrotype_EmployeePK
			electrotype_EmployeePK) {

		return getPersistence().fetchByPrimaryKey(electrotype_EmployeePK);
	}

	/**
	 * Returns all the electrotype_ employees.
	 *
	 * @return the electrotype_ employees
	 */
	public static List<Electrotype_Employee> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<Electrotype_Employee> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<Electrotype_Employee> findAll(
		int start, int end,
		OrderByComparator<Electrotype_Employee> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<Electrotype_Employee> findAll(
		int start, int end,
		OrderByComparator<Electrotype_Employee> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the electrotype_ employees from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of electrotype_ employees.
	 *
	 * @return the number of electrotype_ employees
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static Electrotype_EmployeePersistence getPersistence() {
		return _persistence;
	}

	private static volatile Electrotype_EmployeePersistence _persistence;

}