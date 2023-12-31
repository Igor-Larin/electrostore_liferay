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

package electrostore.db.service.persistence.impl;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringUtil;

import electrostore.db.exception.NoSuchElectronicException;
import electrostore.db.model.Electronic;
import electrostore.db.model.impl.ElectronicImpl;
import electrostore.db.model.impl.ElectronicModelImpl;
import electrostore.db.service.persistence.ElectronicPersistence;
import electrostore.db.service.persistence.ElectronicUtil;
import electrostore.db.service.persistence.impl.constants.electrostorePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the electronic service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ElectronicPersistence.class)
public class ElectronicPersistenceImpl
	extends BasePersistenceImpl<Electronic> implements ElectronicPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ElectronicUtil</code> to access the electronic persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ElectronicImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByElectronicType;
	private FinderPath _finderPathWithoutPaginationFindByElectronicType;
	private FinderPath _finderPathCountByElectronicType;

	/**
	 * Returns all the electronics where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @return the matching electronics
	 */
	@Override
	public List<Electronic> findByElectronicType(long electrotype_id) {
		return findByElectronicType(
			electrotype_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Electronic> findByElectronicType(
		long electrotype_id, int start, int end) {

		return findByElectronicType(electrotype_id, start, end, null);
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
	@Override
	public List<Electronic> findByElectronicType(
		long electrotype_id, int start, int end,
		OrderByComparator<Electronic> orderByComparator) {

		return findByElectronicType(
			electrotype_id, start, end, orderByComparator, true);
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
	@Override
	public List<Electronic> findByElectronicType(
		long electrotype_id, int start, int end,
		OrderByComparator<Electronic> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByElectronicType;
				finderArgs = new Object[] {electrotype_id};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByElectronicType;
			finderArgs = new Object[] {
				electrotype_id, start, end, orderByComparator
			};
		}

		List<Electronic> list = null;

		if (useFinderCache) {
			list = (List<Electronic>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Electronic electronic : list) {
					if (electrotype_id != electronic.getElectrotype_id()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_ELECTRONIC_WHERE);

			sb.append(_FINDER_COLUMN_ELECTRONICTYPE_ELECTROTYPE_ID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ElectronicModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(electrotype_id);

				list = (List<Electronic>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first electronic in the ordered set where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electronic
	 * @throws NoSuchElectronicException if a matching electronic could not be found
	 */
	@Override
	public Electronic findByElectronicType_First(
			long electrotype_id,
			OrderByComparator<Electronic> orderByComparator)
		throws NoSuchElectronicException {

		Electronic electronic = fetchByElectronicType_First(
			electrotype_id, orderByComparator);

		if (electronic != null) {
			return electronic;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("electrotype_id=");
		sb.append(electrotype_id);

		sb.append("}");

		throw new NoSuchElectronicException(sb.toString());
	}

	/**
	 * Returns the first electronic in the ordered set where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching electronic, or <code>null</code> if a matching electronic could not be found
	 */
	@Override
	public Electronic fetchByElectronicType_First(
		long electrotype_id, OrderByComparator<Electronic> orderByComparator) {

		List<Electronic> list = findByElectronicType(
			electrotype_id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last electronic in the ordered set where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electronic
	 * @throws NoSuchElectronicException if a matching electronic could not be found
	 */
	@Override
	public Electronic findByElectronicType_Last(
			long electrotype_id,
			OrderByComparator<Electronic> orderByComparator)
		throws NoSuchElectronicException {

		Electronic electronic = fetchByElectronicType_Last(
			electrotype_id, orderByComparator);

		if (electronic != null) {
			return electronic;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("electrotype_id=");
		sb.append(electrotype_id);

		sb.append("}");

		throw new NoSuchElectronicException(sb.toString());
	}

	/**
	 * Returns the last electronic in the ordered set where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching electronic, or <code>null</code> if a matching electronic could not be found
	 */
	@Override
	public Electronic fetchByElectronicType_Last(
		long electrotype_id, OrderByComparator<Electronic> orderByComparator) {

		int count = countByElectronicType(electrotype_id);

		if (count == 0) {
			return null;
		}

		List<Electronic> list = findByElectronicType(
			electrotype_id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Electronic[] findByElectronicType_PrevAndNext(
			long electronic_id, long electrotype_id,
			OrderByComparator<Electronic> orderByComparator)
		throws NoSuchElectronicException {

		Electronic electronic = findByPrimaryKey(electronic_id);

		Session session = null;

		try {
			session = openSession();

			Electronic[] array = new ElectronicImpl[3];

			array[0] = getByElectronicType_PrevAndNext(
				session, electronic, electrotype_id, orderByComparator, true);

			array[1] = electronic;

			array[2] = getByElectronicType_PrevAndNext(
				session, electronic, electrotype_id, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Electronic getByElectronicType_PrevAndNext(
		Session session, Electronic electronic, long electrotype_id,
		OrderByComparator<Electronic> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_ELECTRONIC_WHERE);

		sb.append(_FINDER_COLUMN_ELECTRONICTYPE_ELECTROTYPE_ID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ElectronicModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(electrotype_id);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(electronic)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Electronic> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the electronics where electrotype_id = &#63; from the database.
	 *
	 * @param electrotype_id the electrotype_id
	 */
	@Override
	public void removeByElectronicType(long electrotype_id) {
		for (Electronic electronic :
				findByElectronicType(
					electrotype_id, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(electronic);
		}
	}

	/**
	 * Returns the number of electronics where electrotype_id = &#63;.
	 *
	 * @param electrotype_id the electrotype_id
	 * @return the number of matching electronics
	 */
	@Override
	public int countByElectronicType(long electrotype_id) {
		FinderPath finderPath = _finderPathCountByElectronicType;

		Object[] finderArgs = new Object[] {electrotype_id};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELECTRONIC_WHERE);

			sb.append(_FINDER_COLUMN_ELECTRONICTYPE_ELECTROTYPE_ID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(electrotype_id);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ELECTRONICTYPE_ELECTROTYPE_ID_2 =
		"electronic.electrotype_id = ?";

	private FinderPath _finderPathFetchByElectronicName;
	private FinderPath _finderPathCountByElectronicName;

	/**
	 * Returns the electronic where name = &#63; or throws a <code>NoSuchElectronicException</code> if it could not be found.
	 *
	 * @param name the name
	 * @return the matching electronic
	 * @throws NoSuchElectronicException if a matching electronic could not be found
	 */
	@Override
	public Electronic findByElectronicName(String name)
		throws NoSuchElectronicException {

		Electronic electronic = fetchByElectronicName(name);

		if (electronic == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("name=");
			sb.append(name);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchElectronicException(sb.toString());
		}

		return electronic;
	}

	/**
	 * Returns the electronic where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching electronic, or <code>null</code> if a matching electronic could not be found
	 */
	@Override
	public Electronic fetchByElectronicName(String name) {
		return fetchByElectronicName(name, true);
	}

	/**
	 * Returns the electronic where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching electronic, or <code>null</code> if a matching electronic could not be found
	 */
	@Override
	public Electronic fetchByElectronicName(
		String name, boolean useFinderCache) {

		name = Objects.toString(name, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {name};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByElectronicName, finderArgs, this);
		}

		if (result instanceof Electronic) {
			Electronic electronic = (Electronic)result;

			if (!Objects.equals(name, electronic.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_ELECTRONIC_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_ELECTRONICNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_ELECTRONICNAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				List<Electronic> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByElectronicName, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {name};
							}

							_log.warn(
								"ElectronicPersistenceImpl.fetchByElectronicName(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Electronic electronic = list.get(0);

					result = electronic;

					cacheResult(electronic);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Electronic)result;
		}
	}

	/**
	 * Removes the electronic where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the electronic that was removed
	 */
	@Override
	public Electronic removeByElectronicName(String name)
		throws NoSuchElectronicException {

		Electronic electronic = findByElectronicName(name);

		return remove(electronic);
	}

	/**
	 * Returns the number of electronics where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching electronics
	 */
	@Override
	public int countByElectronicName(String name) {
		name = Objects.toString(name, "");

		FinderPath finderPath = _finderPathCountByElectronicName;

		Object[] finderArgs = new Object[] {name};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_ELECTRONIC_WHERE);

			boolean bindName = false;

			if (name.isEmpty()) {
				sb.append(_FINDER_COLUMN_ELECTRONICNAME_NAME_3);
			}
			else {
				bindName = true;

				sb.append(_FINDER_COLUMN_ELECTRONICNAME_NAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindName) {
					queryPos.add(name);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_ELECTRONICNAME_NAME_2 =
		"electronic.name = ?";

	private static final String _FINDER_COLUMN_ELECTRONICNAME_NAME_3 =
		"(electronic.name IS NULL OR electronic.name = '')";

	public ElectronicPersistenceImpl() {
		setModelClass(Electronic.class);

		setModelImplClass(ElectronicImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the electronic in the entity cache if it is enabled.
	 *
	 * @param electronic the electronic
	 */
	@Override
	public void cacheResult(Electronic electronic) {
		entityCache.putResult(
			ElectronicImpl.class, electronic.getPrimaryKey(), electronic);

		finderCache.putResult(
			_finderPathFetchByElectronicName,
			new Object[] {electronic.getName()}, electronic);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the electronics in the entity cache if it is enabled.
	 *
	 * @param electronics the electronics
	 */
	@Override
	public void cacheResult(List<Electronic> electronics) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (electronics.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Electronic electronic : electronics) {
			if (entityCache.getResult(
					ElectronicImpl.class, electronic.getPrimaryKey()) == null) {

				cacheResult(electronic);
			}
		}
	}

	/**
	 * Clears the cache for all electronics.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ElectronicImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the electronic.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Electronic electronic) {
		entityCache.removeResult(ElectronicImpl.class, electronic);
	}

	@Override
	public void clearCache(List<Electronic> electronics) {
		for (Electronic electronic : electronics) {
			entityCache.removeResult(ElectronicImpl.class, electronic);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ElectronicImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ElectronicModelImpl electronicModelImpl) {

		Object[] args = new Object[] {electronicModelImpl.getName()};

		finderCache.putResult(
			_finderPathCountByElectronicName, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByElectronicName, args, electronicModelImpl, false);
	}

	/**
	 * Creates a new electronic with the primary key. Does not add the electronic to the database.
	 *
	 * @param electronic_id the primary key for the new electronic
	 * @return the new electronic
	 */
	@Override
	public Electronic create(long electronic_id) {
		Electronic electronic = new ElectronicImpl();

		electronic.setNew(true);
		electronic.setPrimaryKey(electronic_id);

		return electronic;
	}

	/**
	 * Removes the electronic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param electronic_id the primary key of the electronic
	 * @return the electronic that was removed
	 * @throws NoSuchElectronicException if a electronic with the primary key could not be found
	 */
	@Override
	public Electronic remove(long electronic_id)
		throws NoSuchElectronicException {

		return remove((Serializable)electronic_id);
	}

	/**
	 * Removes the electronic with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the electronic
	 * @return the electronic that was removed
	 * @throws NoSuchElectronicException if a electronic with the primary key could not be found
	 */
	@Override
	public Electronic remove(Serializable primaryKey)
		throws NoSuchElectronicException {

		Session session = null;

		try {
			session = openSession();

			Electronic electronic = (Electronic)session.get(
				ElectronicImpl.class, primaryKey);

			if (electronic == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchElectronicException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(electronic);
		}
		catch (NoSuchElectronicException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Electronic removeImpl(Electronic electronic) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(electronic)) {
				electronic = (Electronic)session.get(
					ElectronicImpl.class, electronic.getPrimaryKeyObj());
			}

			if (electronic != null) {
				session.delete(electronic);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (electronic != null) {
			clearCache(electronic);
		}

		return electronic;
	}

	@Override
	public Electronic updateImpl(Electronic electronic) {
		boolean isNew = electronic.isNew();

		if (!(electronic instanceof ElectronicModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(electronic.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(electronic);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in electronic proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Electronic implementation " +
					electronic.getClass());
		}

		ElectronicModelImpl electronicModelImpl =
			(ElectronicModelImpl)electronic;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(electronic);
			}
			else {
				electronic = (Electronic)session.merge(electronic);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ElectronicImpl.class, electronicModelImpl, false, true);

		cacheUniqueFindersCache(electronicModelImpl);

		if (isNew) {
			electronic.setNew(false);
		}

		electronic.resetOriginalValues();

		return electronic;
	}

	/**
	 * Returns the electronic with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the electronic
	 * @return the electronic
	 * @throws NoSuchElectronicException if a electronic with the primary key could not be found
	 */
	@Override
	public Electronic findByPrimaryKey(Serializable primaryKey)
		throws NoSuchElectronicException {

		Electronic electronic = fetchByPrimaryKey(primaryKey);

		if (electronic == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchElectronicException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return electronic;
	}

	/**
	 * Returns the electronic with the primary key or throws a <code>NoSuchElectronicException</code> if it could not be found.
	 *
	 * @param electronic_id the primary key of the electronic
	 * @return the electronic
	 * @throws NoSuchElectronicException if a electronic with the primary key could not be found
	 */
	@Override
	public Electronic findByPrimaryKey(long electronic_id)
		throws NoSuchElectronicException {

		return findByPrimaryKey((Serializable)electronic_id);
	}

	/**
	 * Returns the electronic with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param electronic_id the primary key of the electronic
	 * @return the electronic, or <code>null</code> if a electronic with the primary key could not be found
	 */
	@Override
	public Electronic fetchByPrimaryKey(long electronic_id) {
		return fetchByPrimaryKey((Serializable)electronic_id);
	}

	/**
	 * Returns all the electronics.
	 *
	 * @return the electronics
	 */
	@Override
	public List<Electronic> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Electronic> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Electronic> findAll(
		int start, int end, OrderByComparator<Electronic> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Electronic> findAll(
		int start, int end, OrderByComparator<Electronic> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Electronic> list = null;

		if (useFinderCache) {
			list = (List<Electronic>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ELECTRONIC);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ELECTRONIC;

				sql = sql.concat(ElectronicModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Electronic>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the electronics from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Electronic electronic : findAll()) {
			remove(electronic);
		}
	}

	/**
	 * Returns the number of electronics.
	 *
	 * @return the number of electronics
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ELECTRONIC);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "electronic_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ELECTRONIC;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ElectronicModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the electronic persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ElectronicModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Electronic.class.getName()));

		_valueObjectFinderCacheListThreshold = GetterUtil.getInteger(
			PropsUtil.get(PropsKeys.VALUE_OBJECT_FINDER_CACHE_LIST_THRESHOLD));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByElectronicType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByElectronicType",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"electrotype_id"}, true);

		_finderPathWithoutPaginationFindByElectronicType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByElectronicType",
			new String[] {Long.class.getName()},
			new String[] {"electrotype_id"}, true);

		_finderPathCountByElectronicType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByElectronicType",
			new String[] {Long.class.getName()},
			new String[] {"electrotype_id"}, false);

		_finderPathFetchByElectronicName = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByElectronicName",
			new String[] {String.class.getName()}, new String[] {"name"}, true);

		_finderPathCountByElectronicName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByElectronicName",
			new String[] {String.class.getName()}, new String[] {"name"},
			false);

		_setElectronicUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setElectronicUtilPersistence(null);

		entityCache.removeCache(ElectronicImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setElectronicUtilPersistence(
		ElectronicPersistence electronicPersistence) {

		try {
			Field field = ElectronicUtil.class.getDeclaredField("_persistence");

			field.setAccessible(true);

			field.set(null, electronicPersistence);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Override
	@Reference(
		target = electrostorePersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = electrostorePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = electrostorePersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_ELECTRONIC =
		"SELECT electronic FROM Electronic electronic";

	private static final String _SQL_SELECT_ELECTRONIC_WHERE =
		"SELECT electronic FROM Electronic electronic WHERE ";

	private static final String _SQL_COUNT_ELECTRONIC =
		"SELECT COUNT(electronic) FROM Electronic electronic";

	private static final String _SQL_COUNT_ELECTRONIC_WHERE =
		"SELECT COUNT(electronic) FROM Electronic electronic WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "electronic.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Electronic exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Electronic exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ElectronicPersistenceImpl.class);

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class ElectronicModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return new Object[0];
				}

				return null;
			}

			ElectronicModelImpl electronicModelImpl =
				(ElectronicModelImpl)baseModel;

			long columnBitmask = electronicModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(electronicModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						electronicModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(electronicModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ElectronicModelImpl electronicModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = electronicModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = electronicModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}