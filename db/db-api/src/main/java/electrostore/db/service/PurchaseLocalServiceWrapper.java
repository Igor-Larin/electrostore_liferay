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
 * Provides a wrapper for {@link PurchaseLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PurchaseLocalService
 * @generated
 */
public class PurchaseLocalServiceWrapper
	implements PurchaseLocalService, ServiceWrapper<PurchaseLocalService> {

	public PurchaseLocalServiceWrapper(
		PurchaseLocalService purchaseLocalService) {

		_purchaseLocalService = purchaseLocalService;
	}

	@Override
	public void addPurchase(javax.portlet.ActionRequest request)
		throws com.liferay.portal.kernel.exception.PortalException {

		_purchaseLocalService.addPurchase(request);
	}

	/**
	 * Adds the purchase to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PurchaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purchase the purchase
	 * @return the purchase that was added
	 */
	@Override
	public electrostore.db.model.Purchase addPurchase(
		electrostore.db.model.Purchase purchase) {

		return _purchaseLocalService.addPurchase(purchase);
	}

	@Override
	public void addPurchaseFromZip(String purchaseString, String delimeter) {
		_purchaseLocalService.addPurchaseFromZip(purchaseString, delimeter);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new purchase with the primary key. Does not add the purchase to the database.
	 *
	 * @param purchase_id the primary key for the new purchase
	 * @return the new purchase
	 */
	@Override
	public electrostore.db.model.Purchase createPurchase(long purchase_id) {
		return _purchaseLocalService.createPurchase(purchase_id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public void deletePurchase(javax.portlet.ActionRequest request)
		throws com.liferay.portal.kernel.exception.PortalException {

		_purchaseLocalService.deletePurchase(request);
	}

	/**
	 * Deletes the purchase with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PurchaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purchase_id the primary key of the purchase
	 * @return the purchase that was removed
	 * @throws PortalException if a purchase with the primary key could not be found
	 */
	@Override
	public electrostore.db.model.Purchase deletePurchase(long purchase_id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseLocalService.deletePurchase(purchase_id);
	}

	/**
	 * Deletes the purchase from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PurchaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purchase the purchase
	 * @return the purchase that was removed
	 */
	@Override
	public electrostore.db.model.Purchase deletePurchase(
		electrostore.db.model.Purchase purchase) {

		return _purchaseLocalService.deletePurchase(purchase);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _purchaseLocalService.dynamicQuery();
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

		return _purchaseLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>electrostore.db.model.impl.PurchaseModelImpl</code>.
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

		return _purchaseLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>electrostore.db.model.impl.PurchaseModelImpl</code>.
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

		return _purchaseLocalService.dynamicQuery(
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

		return _purchaseLocalService.dynamicQueryCount(dynamicQuery);
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

		return _purchaseLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public electrostore.db.model.Purchase fetchPurchase(long purchase_id) {
		return _purchaseLocalService.fetchPurchase(purchase_id);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _purchaseLocalService.getActionableDynamicQuery();
	}

	@Override
	public String getElectrotechPurchasesCount() {
		return _purchaseLocalService.getElectrotechPurchasesCount();
	}

	@Override
	public String getGainByCash() {
		return _purchaseLocalService.getGainByCash();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _purchaseLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _purchaseLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the purchase with the primary key.
	 *
	 * @param purchase_id the primary key of the purchase
	 * @return the purchase
	 * @throws PortalException if a purchase with the primary key could not be found
	 */
	@Override
	public electrostore.db.model.Purchase getPurchase(long purchase_id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _purchaseLocalService.getPurchase(purchase_id);
	}

	/**
	 * Returns a range of all the purchases.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>electrostore.db.model.impl.PurchaseModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of purchases
	 * @param end the upper bound of the range of purchases (not inclusive)
	 * @return the range of purchases
	 */
	@Override
	public java.util.List<electrostore.db.model.Purchase> getPurchases(
		int start, int end) {

		return _purchaseLocalService.getPurchases(start, end);
	}

	@Override
	public java.util.List<electrostore.db.model.Purchase> getPurchasesByOrder(
		int start, int end, String order) {

		return _purchaseLocalService.getPurchasesByOrder(start, end, order);
	}

	/**
	 * Returns the number of purchases.
	 *
	 * @return the number of purchases
	 */
	@Override
	public int getPurchasesCount() {
		return _purchaseLocalService.getPurchasesCount();
	}

	/**
	 * Updates the purchase in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PurchaseLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param purchase the purchase
	 * @return the purchase that was updated
	 */
	@Override
	public electrostore.db.model.Purchase updatePurchase(
		electrostore.db.model.Purchase purchase) {

		return _purchaseLocalService.updatePurchase(purchase);
	}

	@Override
	public PurchaseLocalService getWrappedService() {
		return _purchaseLocalService;
	}

	@Override
	public void setWrappedService(PurchaseLocalService purchaseLocalService) {
		_purchaseLocalService = purchaseLocalService;
	}

	private PurchaseLocalService _purchaseLocalService;

}