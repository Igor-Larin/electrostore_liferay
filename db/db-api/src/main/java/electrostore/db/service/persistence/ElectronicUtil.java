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

import electrostore.db.model.Electronic;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence utility for the electronic service. This utility wraps <code>electrostore.db.service.persistence.impl.ElectronicPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectronicPersistence
 * @generated
 */
public class ElectronicUtil {

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
	public static void clearCache(Electronic electronic) {
		getPersistence().clearCache(electronic);
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
	public static Map<Serializable, Electronic> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Electronic> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Electronic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Electronic> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Electronic> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Electronic update(Electronic electronic) {
		return getPersistence().update(electronic);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Electronic update(
		Electronic electronic, ServiceContext serviceContext) {

		return getPersistence().update(electronic, serviceContext);
	}

	/**
	 * Returns all the electronics where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @return the matching electronics
	 */
	public static List<Electronic> findByElectronicType(long electrotype_id) {
		return getPersistence().findByElectronicType(electrotype_id);
	}

	/**
	 * Returns a range of all the electronics where electrotype_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicModelImpl</code>.
	 * </p>
	 *
	 * @param electrotype_id the electrotype_id
	 * @param start the lower bound of the range of electronics
	 * @param end the upper bound of the range of electronics (not inclusive)
	 * @return the range of matching electronics
	 */
	public static List<Electronic> findByElectronicType(
		long electrotype_id, int start, int end) {

		return getPersistence().findByElectronicType(
			electrotype_id, start, end);
	}

	/**
	 * Returns an ordered range of all the electronics where electrotype_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicModelImpl</code>.
	 * </p>
	 *
	 * @param electrotype_id the electrotype_id
	 * @param start the lower bound of the range of electronics
	 * @param end the upper bound of the range of electronics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching electronics
	 */
	public static List<Electronic> findByElectronicType(
		long electrotype_id, int start, int end,
		OrderByComparator<Electronic> orderByComparator) {

		return getPersistence().findByElectronicType(
			electrotype_id, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the electronics where electrotype_id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicModelImpl</code>.
	 * </p>
	 *
	 * @param electrotype_id the electrotype_id
	 * @param start the lower bound of the range of electronics
	 * @param end the upper bound of the range of electronics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching electronics
	 */
	public static List<Electronic> findByElectronicType(
		long electrotype_id, int start, int end,
		OrderByComparator<Electronic> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByElectronicType(
			electrotype_id, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first electronic in the ordered set where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electronic
	 * @throws NoSuchElectronicException if a matching electronic could not be found
	 */
	public static Electronic findByElectronicType_First(
			long electrotype_id,
			OrderByComparator<Electronic> orderByComparator)
		throws electrostore.db.exception.NoSuchElectronicException {

		return getPersistence().findByElectronicType_First(
			electrotype_id, orderByComparator);
	}

	/**
	 * Returns the first electronic in the ordered set where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electronic, or <code>null</code> if a matching electronic could not be found
	 */
	public static Electronic fetchByElectronicType_First(
		long electrotype_id, OrderByComparator<Electronic> orderByComparator) {

		return getPersistence().fetchByElectronicType_First(
			electrotype_id, orderByComparator);
	}

	/**
	 * Returns the last electronic in the ordered set where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electronic
	 * @throws NoSuchElectronicException if a matching electronic could not be found
	 */
	public static Electronic findByElectronicType_Last(
			long electrotype_id,
			OrderByComparator<Electronic> orderByComparator)
		throws electrostore.db.exception.NoSuchElectronicException {

		return getPersistence().findByElectronicType_Last(
			electrotype_id, orderByComparator);
	}

	/**
	 * Returns the last electronic in the ordered set where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electronic, or <code>null</code> if a matching electronic could not be found
	 */
	public static Electronic fetchByElectronicType_Last(
		long electrotype_id, OrderByComparator<Electronic> orderByComparator) {

		return getPersistence().fetchByElectronicType_Last(
			electrotype_id, orderByComparator);
	}

	/**
	 * Returns the electronics before and after the current electronic in the ordered set where electrotype_id = &#63;.
	 *
	 * @param electronic_id the primary key of the current electronic
	 * @param electrotype_id the electrotype_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next electronic
	 * @throws NoSuchElectronicException if a electronic with the primary key could not be found
	 */
	public static Electronic[] findByElectronicType_PrevAndNext(
			long electronic_id, long electrotype_id,
			OrderByComparator<Electronic> orderByComparator)
		throws electrostore.db.exception.NoSuchElectronicException {

		return getPersistence().findByElectronicType_PrevAndNext(
			electronic_id, electrotype_id, orderByComparator);
	}

	/**
	 * Removes all the electronics where electrotype_id = &#63; from the database.
	 *
	 * @param electrotype_id the electrotype_id
	 */
	public static void removeByElectronicType(long electrotype_id) {
		getPersistence().removeByElectronicType(electrotype_id);
	}

	/**
	 * Returns the number of electronics where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @return the number of matching electronics
	 */
	public static int countByElectronicType(long electrotype_id) {
		return getPersistence().countByElectronicType(electrotype_id);
	}

	/**
	 * Returns the electronic where name = &#63; or throws a <code>NoSuchElectronicException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching electronic
	 * @throws NoSuchElectronicException if a matching electronic could not be found
	 */
	public static Electronic findByElectronicName(String name)
		throws electrostore.db.exception.NoSuchElectronicException {

		return getPersistence().findByElectronicName(name);
	}

	/**
	 * Returns the electronic where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching electronic, or <code>null</code> if a matching electronic could not be found
	 */
	public static Electronic fetchByElectronicName(String name) {
		return getPersistence().fetchByElectronicName(name);
	}

	/**
	 * Returns the electronic where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching electronic, or <code>null</code> if a matching electronic could not be found
	 */
	public static Electronic fetchByElectronicName(
		String name, boolean useFinderCache) {

		return getPersistence().fetchByElectronicName(name, useFinderCache);
	}

	/**
	 * Removes the electronic where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the electronic that was removed
	 */
	public static Electronic removeByElectronicName(String name)
		throws electrostore.db.exception.NoSuchElectronicException {

		return getPersistence().removeByElectronicName(name);
	}

	/**
	 * Returns the number of electronics where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching electronics
	 */
	public static int countByElectronicName(String name) {
		return getPersistence().countByElectronicName(name);
	}

	/**
	 * Caches the electronic in the entity cache if it is enabled.
	 *
	 * @param electronic the electronic
	 */
	public static void cacheResult(Electronic electronic) {
		getPersistence().cacheResult(electronic);
	}

	/**
	 * Caches the electronics in the entity cache if it is enabled.
	 *
	 * @param electronics the electronics
	 */
	public static void cacheResult(List<Electronic> electronics) {
		getPersistence().cacheResult(electronics);
	}

	/**
	 * Creates a new electronic with the primary key. Does not add the electronic to the database.
	 *
	 * @param electronic_id the primary key for the new electronic
	 * @return the new electronic
	 */
	public static Electronic create(long electronic_id) {
		return getPersistence().create(electronic_id);
	}

	/**
	 * Removes the electronic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param electronic_id the primary key of the electronic
	 * @return the electronic that was removed
	 * @throws NoSuchElectronicException if a electronic with the primary key could not be found
	 */
	public static Electronic remove(long electronic_id)
		throws electrostore.db.exception.NoSuchElectronicException {

		return getPersistence().remove(electronic_id);
	}

	public static Electronic updateImpl(Electronic electronic) {
		return getPersistence().updateImpl(electronic);
	}

	/**
	 * Returns the electronic with the primary key or throws a <code>NoSuchElectronicException</code> if it could not be found.
	 *
	 * @param electronic_id the primary key of the electronic
	 * @return the electronic
	 * @throws NoSuchElectronicException if a electronic with the primary key could not be found
	 */
	public static Electronic findByPrimaryKey(long electronic_id)
		throws electrostore.db.exception.NoSuchElectronicException {

		return getPersistence().findByPrimaryKey(electronic_id);
	}

	/**
	 * Returns the electronic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param electronic_id the primary key of the electronic
	 * @return the electronic, or <code>null</code> if a electronic with the primary key could not be found
	 */
	public static Electronic fetchByPrimaryKey(long electronic_id) {
		return getPersistence().fetchByPrimaryKey(electronic_id);
	}

	/**
	 * Returns all the electronics.
	 *
	 * @return the electronics
	 */
	public static List<Electronic> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the electronics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronics
	 * @param end the upper bound of the range of electronics (not inclusive)
	 * @return the range of electronics
	 */
	public static List<Electronic> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the electronics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronics
	 * @param end the upper bound of the range of electronics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of electronics
	 */
	public static List<Electronic> findAll(
		int start, int end, OrderByComparator<Electronic> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the electronics.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronics
	 * @param end the upper bound of the range of electronics (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of electronics
	 */
	public static List<Electronic> findAll(
		int start, int end, OrderByComparator<Electronic> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the electronics from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of electronics.
	 *
	 * @return the number of electronics
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ElectronicPersistence getPersistence() {
		return _persistence;
	}

	private static volatile ElectronicPersistence _persistence;

}