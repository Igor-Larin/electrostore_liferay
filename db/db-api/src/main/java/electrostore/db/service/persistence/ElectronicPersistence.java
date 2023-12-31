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

import electrostore.db.exception.NoSuchElectronicException;
import electrostore.db.model.Electronic;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the electronic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectronicUtil
 * @generated
 */
@ProviderType
public interface ElectronicPersistence extends BasePersistence<Electronic> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ElectronicUtil} to access the electronic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the electronics where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @return the matching electronics
	 */
	public java.util.List<Electronic> findByElectronicType(long electrotype_id);

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
	public java.util.List<Electronic> findByElectronicType(
		long electrotype_id, int start, int end);

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
	public java.util.List<Electronic> findByElectronicType(
		long electrotype_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Electronic>
			orderByComparator);

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
	public java.util.List<Electronic> findByElectronicType(
		long electrotype_id, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Electronic>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first electronic in the ordered set where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electronic
	 * @throws NoSuchElectronicException if a matching electronic could not be found
	 */
	public Electronic findByElectronicType_First(
			long electrotype_id,
			com.liferay.portal.kernel.util.OrderByComparator<Electronic>
				orderByComparator)
		throws NoSuchElectronicException;

	/**
	 * Returns the first electronic in the ordered set where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electronic, or <code>null</code> if a matching electronic could not be found
	 */
	public Electronic fetchByElectronicType_First(
		long electrotype_id,
		com.liferay.portal.kernel.util.OrderByComparator<Electronic>
			orderByComparator);

	/**
	 * Returns the last electronic in the ordered set where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electronic
	 * @throws NoSuchElectronicException if a matching electronic could not be found
	 */
	public Electronic findByElectronicType_Last(
			long electrotype_id,
			com.liferay.portal.kernel.util.OrderByComparator<Electronic>
				orderByComparator)
		throws NoSuchElectronicException;

	/**
	 * Returns the last electronic in the ordered set where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electronic, or <code>null</code> if a matching electronic could not be found
	 */
	public Electronic fetchByElectronicType_Last(
		long electrotype_id,
		com.liferay.portal.kernel.util.OrderByComparator<Electronic>
			orderByComparator);

	/**
	 * Returns the electronics before and after the current electronic in the ordered set where electrotype_id = &#63;.
	 *
	 * @param electronic_id the primary key of the current electronic
	 * @param electrotype_id the electrotype_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next electronic
	 * @throws NoSuchElectronicException if a electronic with the primary key could not be found
	 */
	public Electronic[] findByElectronicType_PrevAndNext(
			long electronic_id, long electrotype_id,
			com.liferay.portal.kernel.util.OrderByComparator<Electronic>
				orderByComparator)
		throws NoSuchElectronicException;

	/**
	 * Removes all the electronics where electrotype_id = &#63; from the database.
	 *
	 * @param electrotype_id the electrotype_id
	 */
	public void removeByElectronicType(long electrotype_id);

	/**
	 * Returns the number of electronics where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @return the number of matching electronics
	 */
	public int countByElectronicType(long electrotype_id);

	/**
	 * Returns the electronic where name = &#63; or throws a <code>NoSuchElectronicException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching electronic
	 * @throws NoSuchElectronicException if a matching electronic could not be found
	 */
	public Electronic findByElectronicName(String name)
		throws NoSuchElectronicException;

	/**
	 * Returns the electronic where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching electronic, or <code>null</code> if a matching electronic could not be found
	 */
	public Electronic fetchByElectronicName(String name);

	/**
	 * Returns the electronic where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching electronic, or <code>null</code> if a matching electronic could not be found
	 */
	public Electronic fetchByElectronicName(
		String name, boolean useFinderCache);

	/**
	 * Removes the electronic where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the electronic that was removed
	 */
	public Electronic removeByElectronicName(String name)
		throws NoSuchElectronicException;

	/**
	 * Returns the number of electronics where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching electronics
	 */
	public int countByElectronicName(String name);

	/**
	 * Caches the electronic in the entity cache if it is enabled.
	 *
	 * @param electronic the electronic
	 */
	public void cacheResult(Electronic electronic);

	/**
	 * Caches the electronics in the entity cache if it is enabled.
	 *
	 * @param electronics the electronics
	 */
	public void cacheResult(java.util.List<Electronic> electronics);

	/**
	 * Creates a new electronic with the primary key. Does not add the electronic to the database.
	 *
	 * @param electronic_id the primary key for the new electronic
	 * @return the new electronic
	 */
	public Electronic create(long electronic_id);

	/**
	 * Removes the electronic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param electronic_id the primary key of the electronic
	 * @return the electronic that was removed
	 * @throws NoSuchElectronicException if a electronic with the primary key could not be found
	 */
	public Electronic remove(long electronic_id)
		throws NoSuchElectronicException;

	public Electronic updateImpl(Electronic electronic);

	/**
	 * Returns the electronic with the primary key or throws a <code>NoSuchElectronicException</code> if it could not be found.
	 *
	 * @param electronic_id the primary key of the electronic
	 * @return the electronic
	 * @throws NoSuchElectronicException if a electronic with the primary key could not be found
	 */
	public Electronic findByPrimaryKey(long electronic_id)
		throws NoSuchElectronicException;

	/**
	 * Returns the electronic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param electronic_id the primary key of the electronic
	 * @return the electronic, or <code>null</code> if a electronic with the primary key could not be found
	 */
	public Electronic fetchByPrimaryKey(long electronic_id);

	/**
	 * Returns all the electronics.
	 *
	 * @return the electronics
	 */
	public java.util.List<Electronic> findAll();

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
	public java.util.List<Electronic> findAll(int start, int end);

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
	public java.util.List<Electronic> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Electronic>
			orderByComparator);

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
	public java.util.List<Electronic> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Electronic>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the electronics from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of electronics.
	 *
	 * @return the number of electronics
	 */
	public int countAll();

}