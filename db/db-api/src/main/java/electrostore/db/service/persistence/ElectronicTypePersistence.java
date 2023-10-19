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

import electrostore.db.exception.NoSuchElectronicTypeException;
import electrostore.db.model.ElectronicType;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the electronic type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ElectronicTypeUtil
 * @generated
 */
@ProviderType
public interface ElectronicTypePersistence
	extends BasePersistence<ElectronicType> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ElectronicTypeUtil} to access the electronic type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the electronic type in the entity cache if it is enabled.
	 *
	 * @param electronicType the electronic type
	 */
	public void cacheResult(ElectronicType electronicType);

	/**
	 * Caches the electronic types in the entity cache if it is enabled.
	 *
	 * @param electronicTypes the electronic types
	 */
	public void cacheResult(java.util.List<ElectronicType> electronicTypes);

	/**
	 * Creates a new electronic type with the primary key. Does not add the electronic type to the database.
	 *
	 * @param electrotype_id the primary key for the new electronic type
	 * @return the new electronic type
	 */
	public ElectronicType create(long electrotype_id);

	/**
	 * Removes the electronic type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param electrotype_id the primary key of the electronic type
	 * @return the electronic type that was removed
	 * @throws NoSuchElectronicTypeException if a electronic type with the primary key could not be found
	 */
	public ElectronicType remove(long electrotype_id)
		throws NoSuchElectronicTypeException;

	public ElectronicType updateImpl(ElectronicType electronicType);

	/**
	 * Returns the electronic type with the primary key or throws a <code>NoSuchElectronicTypeException</code> if it could not be found.
	 *
	 * @param electrotype_id the primary key of the electronic type
	 * @return the electronic type
	 * @throws NoSuchElectronicTypeException if a electronic type with the primary key could not be found
	 */
	public ElectronicType findByPrimaryKey(long electrotype_id)
		throws NoSuchElectronicTypeException;

	/**
	 * Returns the electronic type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param electrotype_id the primary key of the electronic type
	 * @return the electronic type, or <code>null</code> if a electronic type with the primary key could not be found
	 */
	public ElectronicType fetchByPrimaryKey(long electrotype_id);

	/**
	 * Returns all the electronic types.
	 *
	 * @return the electronic types
	 */
	public java.util.List<ElectronicType> findAll();

	/**
	 * Returns a range of all the electronic types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronic types
	 * @param end the upper bound of the range of electronic types (not inclusive)
	 * @return the range of electronic types
	 */
	public java.util.List<ElectronicType> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the electronic types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronic types
	 * @param end the upper bound of the range of electronic types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of electronic types
	 */
	public java.util.List<ElectronicType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectronicType>
			orderByComparator);

	/**
	 * Returns an ordered range of all the electronic types.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ElectronicTypeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of electronic types
	 * @param end the upper bound of the range of electronic types (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of electronic types
	 */
	public java.util.List<ElectronicType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ElectronicType>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the electronic types from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of electronic types.
	 *
	 * @return the number of electronic types
	 */
	public int countAll();

}