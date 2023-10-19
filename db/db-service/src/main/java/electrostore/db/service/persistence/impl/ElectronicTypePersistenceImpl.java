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

import electrostore.db.exception.NoSuchElectronicTypeException;
import electrostore.db.model.ElectronicType;
import electrostore.db.model.impl.ElectronicTypeImpl;
import electrostore.db.model.impl.ElectronicTypeModelImpl;
import electrostore.db.service.persistence.ElectronicTypePersistence;
import electrostore.db.service.persistence.ElectronicTypeUtil;
import electrostore.db.service.persistence.impl.constants.electrostorePersistenceConstants;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
 * The persistence implementation for the electronic type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ElectronicTypePersistence.class)
public class ElectronicTypePersistenceImpl
	extends BasePersistenceImpl<ElectronicType>
	implements ElectronicTypePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ElectronicTypeUtil</code> to access the electronic type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ElectronicTypeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ElectronicTypePersistenceImpl() {
		setModelClass(ElectronicType.class);

		setModelImplClass(ElectronicTypeImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the electronic type in the entity cache if it is enabled.
	 *
	 * @param electronicType the electronic type
	 */
	@Override
	public void cacheResult(ElectronicType electronicType) {
		entityCache.putResult(
			ElectronicTypeImpl.class, electronicType.getPrimaryKey(),
			electronicType);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the electronic types in the entity cache if it is enabled.
	 *
	 * @param electronicTypes the electronic types
	 */
	@Override
	public void cacheResult(List<ElectronicType> electronicTypes) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (electronicTypes.size() > _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (ElectronicType electronicType : electronicTypes) {
			if (entityCache.getResult(
					ElectronicTypeImpl.class, electronicType.getPrimaryKey()) ==
						null) {

				cacheResult(electronicType);
			}
		}
	}

	/**
	 * Clears the cache for all electronic types.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ElectronicTypeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the electronic type.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ElectronicType electronicType) {
		entityCache.removeResult(ElectronicTypeImpl.class, electronicType);
	}

	@Override
	public void clearCache(List<ElectronicType> electronicTypes) {
		for (ElectronicType electronicType : electronicTypes) {
			entityCache.removeResult(ElectronicTypeImpl.class, electronicType);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ElectronicTypeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new electronic type with the primary key. Does not add the electronic type to the database.
	 *
	 * @param electrotype_id the primary key for the new electronic type
	 * @return the new electronic type
	 */
	@Override
	public ElectronicType create(long electrotype_id) {
		ElectronicType electronicType = new ElectronicTypeImpl();

		electronicType.setNew(true);
		electronicType.setPrimaryKey(electrotype_id);

		return electronicType;
	}

	/**
	 * Removes the electronic type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param electrotype_id the primary key of the electronic type
	 * @return the electronic type that was removed
	 * @throws NoSuchElectronicTypeException if a electronic type with the primary key could not be found
	 */
	@Override
	public ElectronicType remove(long electrotype_id)
		throws NoSuchElectronicTypeException {

		return remove((Serializable)electrotype_id);
	}

	/**
	 * Removes the electronic type with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the electronic type
	 * @return the electronic type that was removed
	 * @throws NoSuchElectronicTypeException if a electronic type with the primary key could not be found
	 */
	@Override
	public ElectronicType remove(Serializable primaryKey)
		throws NoSuchElectronicTypeException {

		Session session = null;

		try {
			session = openSession();

			ElectronicType electronicType = (ElectronicType)session.get(
				ElectronicTypeImpl.class, primaryKey);

			if (electronicType == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchElectronicTypeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(electronicType);
		}
		catch (NoSuchElectronicTypeException noSuchEntityException) {
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
	protected ElectronicType removeImpl(ElectronicType electronicType) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(electronicType)) {
				electronicType = (ElectronicType)session.get(
					ElectronicTypeImpl.class,
					electronicType.getPrimaryKeyObj());
			}

			if (electronicType != null) {
				session.delete(electronicType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (electronicType != null) {
			clearCache(electronicType);
		}

		return electronicType;
	}

	@Override
	public ElectronicType updateImpl(ElectronicType electronicType) {
		boolean isNew = electronicType.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(electronicType);
			}
			else {
				electronicType = (ElectronicType)session.merge(electronicType);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ElectronicTypeImpl.class, electronicType, false, true);

		if (isNew) {
			electronicType.setNew(false);
		}

		electronicType.resetOriginalValues();

		return electronicType;
	}

	/**
	 * Returns the electronic type with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the electronic type
	 * @return the electronic type
	 * @throws NoSuchElectronicTypeException if a electronic type with the primary key could not be found
	 */
	@Override
	public ElectronicType findByPrimaryKey(Serializable primaryKey)
		throws NoSuchElectronicTypeException {

		ElectronicType electronicType = fetchByPrimaryKey(primaryKey);

		if (electronicType == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchElectronicTypeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return electronicType;
	}

	/**
	 * Returns the electronic type with the primary key or throws a <code>NoSuchElectronicTypeException</code> if it could not be found.
	 *
	 * @param electrotype_id the primary key of the electronic type
	 * @return the electronic type
	 * @throws NoSuchElectronicTypeException if a electronic type with the primary key could not be found
	 */
	@Override
	public ElectronicType findByPrimaryKey(long electrotype_id)
		throws NoSuchElectronicTypeException {

		return findByPrimaryKey((Serializable)electrotype_id);
	}

	/**
	 * Returns the electronic type with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param electrotype_id the primary key of the electronic type
	 * @return the electronic type, or <code>null</code> if a electronic type with the primary key could not be found
	 */
	@Override
	public ElectronicType fetchByPrimaryKey(long electrotype_id) {
		return fetchByPrimaryKey((Serializable)electrotype_id);
	}

	/**
	 * Returns all the electronic types.
	 *
	 * @return the electronic types
	 */
	@Override
	public List<ElectronicType> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ElectronicType> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ElectronicType> findAll(
		int start, int end,
		OrderByComparator<ElectronicType> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ElectronicType> findAll(
		int start, int end, OrderByComparator<ElectronicType> orderByComparator,
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

		List<ElectronicType> list = null;

		if (useFinderCache) {
			list = (List<ElectronicType>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ELECTRONICTYPE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ELECTRONICTYPE;

				sql = sql.concat(ElectronicTypeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ElectronicType>)QueryUtil.list(
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
	 * Removes all the electronic types from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ElectronicType electronicType : findAll()) {
			remove(electronicType);
		}
	}

	/**
	 * Returns the number of electronic types.
	 *
	 * @return the number of electronic types
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_ELECTRONICTYPE);

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
		return "electrotype_id";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ELECTRONICTYPE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ElectronicTypeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the electronic type persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ElectronicTypeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ElectronicType.class.getName()));

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

		_setElectronicTypeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setElectronicTypeUtilPersistence(null);

		entityCache.removeCache(ElectronicTypeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setElectronicTypeUtilPersistence(
		ElectronicTypePersistence electronicTypePersistence) {

		try {
			Field field = ElectronicTypeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, electronicTypePersistence);
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

	private static final String _SQL_SELECT_ELECTRONICTYPE =
		"SELECT electronicType FROM ElectronicType electronicType";

	private static final String _SQL_COUNT_ELECTRONICTYPE =
		"SELECT COUNT(electronicType) FROM ElectronicType electronicType";

	private static final String _ORDER_BY_ENTITY_ALIAS = "electronicType.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ElectronicType exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ElectronicTypePersistenceImpl.class);

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

	private static class ElectronicTypeModelArgumentsResolver
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

			ElectronicTypeModelImpl electronicTypeModelImpl =
				(ElectronicTypeModelImpl)baseModel;

			long columnBitmask = electronicTypeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					electronicTypeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						electronicTypeModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					electronicTypeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			ElectronicTypeModelImpl electronicTypeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						electronicTypeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = electronicTypeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}