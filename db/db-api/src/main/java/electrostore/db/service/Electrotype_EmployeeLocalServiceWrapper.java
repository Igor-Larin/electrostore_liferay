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

package electrostore.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link Electrotype_EmployeeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see Electrotype_EmployeeLocalService
 * @generated
 */
public class Electrotype_EmployeeLocalServiceWrapper
	implements Electrotype_EmployeeLocalService,
			   ServiceWrapper<Electrotype_EmployeeLocalService> {

	public Electrotype_EmployeeLocalServiceWrapper(
		Electrotype_EmployeeLocalService electrotype_EmployeeLocalService) {

		_electrotype_EmployeeLocalService = electrotype_EmployeeLocalService;
	}

	/**
	 * Adds the electrotype_ employee to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Electrotype_EmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param electrotype_Employee the electrotype_ employee
	 * @return the electrotype_ employee that was added
	 */
	@Override
	public electrostore.db.model.Electrotype_Employee addElectrotype_Employee(
		electrostore.db.model.Electrotype_Employee electrotype_Employee) {

		return _electrotype_EmployeeLocalService.addElectrotype_Employee(
			electrotype_Employee);
	}

	@Override
	public void addElectrotype_EmployeeFromZip(
		String entityString, String delimeter) {

		_electrotype_EmployeeLocalService.addElectrotype_EmployeeFromZip(
			entityString, delimeter);
	}

	/**
	 * Creates a new electrotype_ employee with the primary key. Does not add the electrotype_ employee to the database.
	 *
	 * @param electrotype_EmployeePK the primary key for the new electrotype_ employee
	 * @return the new electrotype_ employee
	 */
	@Override
	public electrostore.db.model.Electrotype_Employee
		createElectrotype_Employee(
			electrostore.db.service.persistence.Electrotype_EmployeePK
				electrotype_EmployeePK) {

		return _electrotype_EmployeeLocalService.createElectrotype_Employee(
			electrotype_EmployeePK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _electrotype_EmployeeLocalService.createPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Deletes the electrotype_ employee from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Electrotype_EmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param electrotype_Employee the electrotype_ employee
	 * @return the electrotype_ employee that was removed
	 */
	@Override
	public electrostore.db.model.Electrotype_Employee
		deleteElectrotype_Employee(
			electrostore.db.model.Electrotype_Employee electrotype_Employee) {

		return _electrotype_EmployeeLocalService.deleteElectrotype_Employee(
			electrotype_Employee);
	}

	/**
	 * Deletes the electrotype_ employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Electrotype_EmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param electrotype_EmployeePK the primary key of the electrotype_ employee
	 * @return the electrotype_ employee that was removed
	 * @throws PortalException if a electrotype_ employee with the primary key could not be found
	 */
	@Override
	public electrostore.db.model.Electrotype_Employee
			deleteElectrotype_Employee(
				electrostore.db.service.persistence.Electrotype_EmployeePK
					electrotype_EmployeePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _electrotype_EmployeeLocalService.deleteElectrotype_Employee(
			electrotype_EmployeePK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _electrotype_EmployeeLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _electrotype_EmployeeLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _electrotype_EmployeeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>electrostore.db.model.impl.Electrotype_EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _electrotype_EmployeeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>electrostore.db.model.impl.Electrotype_EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _electrotype_EmployeeLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _electrotype_EmployeeLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _electrotype_EmployeeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public electrostore.db.model.Electrotype_Employee fetchElectrotype_Employee(
		electrostore.db.service.persistence.Electrotype_EmployeePK
			electrotype_EmployeePK) {

		return _electrotype_EmployeeLocalService.fetchElectrotype_Employee(
			electrotype_EmployeePK);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _electrotype_EmployeeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the electrotype_ employee with the primary key.
	 *
	 * @param electrotype_EmployeePK the primary key of the electrotype_ employee
	 * @return the electrotype_ employee
	 * @throws PortalException if a electrotype_ employee with the primary key could not be found
	 */
	@Override
	public electrostore.db.model.Electrotype_Employee getElectrotype_Employee(
			electrostore.db.service.persistence.Electrotype_EmployeePK
				electrotype_EmployeePK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _electrotype_EmployeeLocalService.getElectrotype_Employee(
			electrotype_EmployeePK);
	}

	/**
	 * Returns a range of all the electrotype_ employees.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>electrostore.db.model.impl.Electrotype_EmployeeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electrotype_ employees
	 * @param end the upper bound of the range of electrotype_ employees (not inclusive)
	 * @return the range of electrotype_ employees
	 */
	@Override
	public java.util.List<electrostore.db.model.Electrotype_Employee>
		getElectrotype_Employees(int start, int end) {

		return _electrotype_EmployeeLocalService.getElectrotype_Employees(
			start, end);
	}

	/**
	 * Returns the number of electrotype_ employees.
	 *
	 * @return the number of electrotype_ employees
	 */
	@Override
	public int getElectrotype_EmployeesCount() {
		return _electrotype_EmployeeLocalService.
			getElectrotype_EmployeesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _electrotype_EmployeeLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _electrotype_EmployeeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _electrotype_EmployeeLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Updates the electrotype_ employee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect Electrotype_EmployeeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param electrotype_Employee the electrotype_ employee
	 * @return the electrotype_ employee that was updated
	 */
	@Override
	public electrostore.db.model.Electrotype_Employee
		updateElectrotype_Employee(
			electrostore.db.model.Electrotype_Employee electrotype_Employee) {

		return _electrotype_EmployeeLocalService.updateElectrotype_Employee(
			electrotype_Employee);
	}

	@Override
	public Electrotype_EmployeeLocalService getWrappedService() {
		return _electrotype_EmployeeLocalService;
	}

	@Override
	public void setWrappedService(
		Electrotype_EmployeeLocalService electrotype_EmployeeLocalService) {

		_electrotype_EmployeeLocalService = electrotype_EmployeeLocalService;
	}

	private Electrotype_EmployeeLocalService _electrotype_EmployeeLocalService;

}