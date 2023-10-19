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
 * Provides a wrapper for {@link ElectronicTypeLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ElectronicTypeLocalService
 * @generated
 */
public class ElectronicTypeLocalServiceWrapper
	implements ElectronicTypeLocalService,
			   ServiceWrapper<ElectronicTypeLocalService> {

	public ElectronicTypeLocalServiceWrapper(
		ElectronicTypeLocalService electronicTypeLocalService) {

		_electronicTypeLocalService = electronicTypeLocalService;
	}

	/**
	 * Adds the electronic type to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElectronicTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param electronicType the electronic type
	 * @return the electronic type that was added
	 */
	@Override
	public electrostore.db.model.ElectronicType addElectronicType(
		electrostore.db.model.ElectronicType electronicType) {

		return _electronicTypeLocalService.addElectronicType(electronicType);
	}

	/**
	 * Creates a new electronic type with the primary key. Does not add the electronic type to the database.
	 *
	 * @param electrotype_id the primary key for the new electronic type
	 * @return the new electronic type
	 */
	@Override
	public electrostore.db.model.ElectronicType createElectronicType(
		long electrotype_id) {

		return _electronicTypeLocalService.createElectronicType(electrotype_id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _electronicTypeLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the electronic type from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElectronicTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param electronicType the electronic type
	 * @return the electronic type that was removed
	 */
	@Override
	public electrostore.db.model.ElectronicType deleteElectronicType(
		electrostore.db.model.ElectronicType electronicType) {

		return _electronicTypeLocalService.deleteElectronicType(electronicType);
	}

	/**
	 * Deletes the electronic type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElectronicTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param electrotype_id the primary key of the electronic type
	 * @return the electronic type that was removed
	 * @throws PortalException if a electronic type with the primary key could not be found
	 */
	@Override
	public electrostore.db.model.ElectronicType deleteElectronicType(
			long electrotype_id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _electronicTypeLocalService.deleteElectronicType(electrotype_id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _electronicTypeLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _electronicTypeLocalService.dynamicQuery();
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

		return _electronicTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>electrostore.db.model.impl.ElectronicTypeModelImpl</code>.
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

		return _electronicTypeLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>electrostore.db.model.impl.ElectronicTypeModelImpl</code>.
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

		return _electronicTypeLocalService.dynamicQuery(
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

		return _electronicTypeLocalService.dynamicQueryCount(dynamicQuery);
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

		return _electronicTypeLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public electrostore.db.model.ElectronicType fetchElectronicType(
		long electrotype_id) {

		return _electronicTypeLocalService.fetchElectronicType(electrotype_id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _electronicTypeLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the electronic type with the primary key.
	 *
	 * @param electrotype_id the primary key of the electronic type
	 * @return the electronic type
	 * @throws PortalException if a electronic type with the primary key could not be found
	 */
	@Override
	public electrostore.db.model.ElectronicType getElectronicType(
			long electrotype_id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _electronicTypeLocalService.getElectronicType(electrotype_id);
	}

	/**
	 * Returns a range of all the electronic types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>electrostore.db.model.impl.ElectronicTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronic types
	 * @param end the upper bound of the range of electronic types (not inclusive)
	 * @return the range of electronic types
	 */
	@Override
	public java.util.List<electrostore.db.model.ElectronicType>
		getElectronicTypes(int start, int end) {

		return _electronicTypeLocalService.getElectronicTypes(start, end);
	}

	/**
	 * Returns the number of electronic types.
	 *
	 * @return the number of electronic types
	 */
	@Override
	public int getElectronicTypesCount() {
		return _electronicTypeLocalService.getElectronicTypesCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _electronicTypeLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _electronicTypeLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _electronicTypeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the electronic type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ElectronicTypeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param electronicType the electronic type
	 * @return the electronic type that was updated
	 */
	@Override
	public electrostore.db.model.ElectronicType updateElectronicType(
		electrostore.db.model.ElectronicType electronicType) {

		return _electronicTypeLocalService.updateElectronicType(electronicType);
	}

	@Override
	public ElectronicTypeLocalService getWrappedService() {
		return _electronicTypeLocalService;
	}

	@Override
	public void setWrappedService(
		ElectronicTypeLocalService electronicTypeLocalService) {

		_electronicTypeLocalService = electronicTypeLocalService;
	}

	private ElectronicTypeLocalService _electronicTypeLocalService;

}