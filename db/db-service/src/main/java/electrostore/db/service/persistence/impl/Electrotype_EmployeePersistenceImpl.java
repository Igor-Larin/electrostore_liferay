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
import com.liferay.portal.kernel.util.SetUtil;

import electrostore.db.exception.NoSuchElectrotype_EmployeeException;
import electrostore.db.model.Electrotype_Employee;
import electrostore.db.model.impl.Electrotype_EmployeeImpl;
import electrostore.db.model.impl.Electrotype_EmployeeModelImpl;
import electrostore.db.service.persistence.Electrotype_EmployeePK;
import electrostore.db.service.persistence.Electrotype_EmployeePersistence;
import electrostore.db.service.persistence.Electrotype_EmployeeUtil;
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
 * The persistence implementation for the electrotype_ employee service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = Electrotype_EmployeePersistence.class)
public class Electrotype_EmployeePersistenceImpl
	extends BasePersistenceImpl<Electrotype_Employee>
	implements Electrotype_EmployeePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>Electrotype_EmployeeUtil</code> to access the electrotype_ employee persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		Electrotype_EmployeeImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public Electrotype_EmployeePersistenceImpl() {
		setModelClass(Electrotype_Employee.class);

		setModelImplClass(Electrotype_EmployeeImpl.class);
		setModelPKClass(Electrotype_EmployeePK.class);
	}

	/**
	 * Caches the electrotype_ employee in the entity cache if it is enabled.
	 *
	 * @param electrotype_Employee the electrotype_ employee
	 */
	@Override
	public void cacheResult(Electrotype_Employee electrotype_Employee) {
		entityCache.putResult(
			Electrotype_EmployeeImpl.class,
			electrotype_Employee.getPrimaryKey(), electrotype_Employee);
	}

	private int _valueObjectFinderCacheListThreshold;

	/**
	 * Caches the electrotype_ employees in the entity cache if it is enabled.
	 *
	 * @param electrotype_Employees the electrotype_ employees
	 */
	@Override
	public void cacheResult(List<Electrotype_Employee> electrotype_Employees) {
		if ((_valueObjectFinderCacheListThreshold == 0) ||
			((_valueObjectFinderCacheListThreshold > 0) &&
			 (electrotype_Employees.size() >
				 _valueObjectFinderCacheListThreshold))) {

			return;
		}

		for (Electrotype_Employee electrotype_Employee :
				electrotype_Employees) {

			if (entityCache.getResult(
					Electrotype_EmployeeImpl.class,
					electrotype_Employee.getPrimaryKey()) == null) {

				cacheResult(electrotype_Employee);
			}
		}
	}

	/**
	 * Clears the cache for all electrotype_ employees.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Electrotype_EmployeeImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the electrotype_ employee.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Electrotype_Employee electrotype_Employee) {
		entityCache.removeResult(
			Electrotype_EmployeeImpl.class, electrotype_Employee);
	}

	@Override
	public void clearCache(List<Electrotype_Employee> electrotype_Employees) {
		for (Electrotype_Employee electrotype_Employee :
				electrotype_Employees) {

			entityCache.removeResult(
				Electrotype_EmployeeImpl.class, electrotype_Employee);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				Electrotype_EmployeeImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new electrotype_ employee with the primary key. Does not add the electrotype_ employee to the database.
	 *
	 * @param electrotype_EmployeePK the primary key for the new electrotype_ employee
	 * @return the new electrotype_ employee
	 */
	@Override
	public Electrotype_Employee create(
		Electrotype_EmployeePK electrotype_EmployeePK) {

		Electrotype_Employee electrotype_Employee =
			new Electrotype_EmployeeImpl();

		electrotype_Employee.setNew(true);
		electrotype_Employee.setPrimaryKey(electrotype_EmployeePK);

		return electrotype_Employee;
	}

	/**
	 * Removes the electrotype_ employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param electrotype_EmployeePK the primary key of the electrotype_ employee
	 * @return the electrotype_ employee that was removed
	 * @throws NoSuchElectrotype_EmployeeException if a electrotype_ employee with the primary key could not be found
	 */
	@Override
	public Electrotype_Employee remove(
			Electrotype_EmployeePK electrotype_EmployeePK)
		throws NoSuchElectrotype_EmployeeException {

		return remove((Serializable)electrotype_EmployeePK);
	}

	/**
	 * Removes the electrotype_ employee with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the electrotype_ employee
	 * @return the electrotype_ employee that was removed
	 * @throws NoSuchElectrotype_EmployeeException if a electrotype_ employee with the primary key could not be found
	 */
	@Override
	public Electrotype_Employee remove(Serializable primaryKey)
		throws NoSuchElectrotype_EmployeeException {

		Session session = null;

		try {
			session = openSession();

			Electrotype_Employee electrotype_Employee =
				(Electrotype_Employee)session.get(
					Electrotype_EmployeeImpl.class, primaryKey);

			if (electrotype_Employee == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchElectrotype_EmployeeException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(electrotype_Employee);
		}
		catch (NoSuchElectrotype_EmployeeException noSuchEntityException) {
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
	protected Electrotype_Employee removeImpl(
		Electrotype_Employee electrotype_Employee) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(electrotype_Employee)) {
				electrotype_Employee = (Electrotype_Employee)session.get(
					Electrotype_EmployeeImpl.class,
					electrotype_Employee.getPrimaryKeyObj());
			}

			if (electrotype_Employee != null) {
				session.delete(electrotype_Employee);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (electrotype_Employee != null) {
			clearCache(electrotype_Employee);
		}

		return electrotype_Employee;
	}

	@Override
	public Electrotype_Employee updateImpl(
		Electrotype_Employee electrotype_Employee) {

		boolean isNew = electrotype_Employee.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(electrotype_Employee);
			}
			else {
				electrotype_Employee = (Electrotype_Employee)session.merge(
					electrotype_Employee);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			Electrotype_EmployeeImpl.class, electrotype_Employee, false, true);

		if (isNew) {
			electrotype_Employee.setNew(false);
		}

		electrotype_Employee.resetOriginalValues();

		return electrotype_Employee;
	}

	/**
	 * Returns the electrotype_ employee with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the electrotype_ employee
	 * @return the electrotype_ employee
	 * @throws NoSuchElectrotype_EmployeeException if a electrotype_ employee with the primary key could not be found
	 */
	@Override
	public Electrotype_Employee findByPrimaryKey(Serializable primaryKey)
		throws NoSuchElectrotype_EmployeeException {

		Electrotype_Employee electrotype_Employee = fetchByPrimaryKey(
			primaryKey);

		if (electrotype_Employee == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchElectrotype_EmployeeException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return electrotype_Employee;
	}

	/**
	 * Returns the electrotype_ employee with the primary key or throws a <code>NoSuchElectrotype_EmployeeException</code> if it could not be found.
	 *
	 * @param electrotype_EmployeePK the primary key of the electrotype_ employee
	 * @return the electrotype_ employee
	 * @throws NoSuchElectrotype_EmployeeException if a electrotype_ employee with the primary key could not be found
	 */
	@Override
	public Electrotype_Employee findByPrimaryKey(
			Electrotype_EmployeePK electrotype_EmployeePK)
		throws NoSuchElectrotype_EmployeeException {

		return findByPrimaryKey((Serializable)electrotype_EmployeePK);
	}

	/**
	 * Returns the electrotype_ employee with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param electrotype_EmployeePK the primary key of the electrotype_ employee
	 * @return the electrotype_ employee, or <code>null</code> if a electrotype_ employee with the primary key could not be found
	 */
	@Override
	public Electrotype_Employee fetchByPrimaryKey(
		Electrotype_EmployeePK electrotype_EmployeePK) {

		return fetchByPrimaryKey((Serializable)electrotype_EmployeePK);
	}

	/**
	 * Returns all the electrotype_ employees.
	 *
	 * @return the electrotype_ employees
	 */
	@Override
	public List<Electrotype_Employee> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Electrotype_Employee> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<Electrotype_Employee> findAll(
		int start, int end,
		OrderByComparator<Electrotype_Employee> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<Electrotype_Employee> findAll(
		int start, int end,
		OrderByComparator<Electrotype_Employee> orderByComparator,
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

		List<Electrotype_Employee> list = null;

		if (useFinderCache) {
			list = (List<Electrotype_Employee>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_ELECTROTYPE_EMPLOYEE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_ELECTROTYPE_EMPLOYEE;

				sql = sql.concat(Electrotype_EmployeeModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Electrotype_Employee>)QueryUtil.list(
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
	 * Removes all the electrotype_ employees from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Electrotype_Employee electrotype_Employee : findAll()) {
			remove(electrotype_Employee);
		}
	}

	/**
	 * Returns the number of electrotype_ employees.
	 *
	 * @return the number of electrotype_ employees
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_ELECTROTYPE_EMPLOYEE);

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
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "electrotype_EmployeePK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_ELECTROTYPE_EMPLOYEE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return Electrotype_EmployeeModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the electrotype_ employee persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new Electrotype_EmployeeModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", Electrotype_Employee.class.getName()));

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

		_setElectrotype_EmployeeUtilPersistence(this);
	}

	@Deactivate
	public void deactivate() {
		_setElectrotype_EmployeeUtilPersistence(null);

		entityCache.removeCache(Electrotype_EmployeeImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	private void _setElectrotype_EmployeeUtilPersistence(
		Electrotype_EmployeePersistence electrotype_EmployeePersistence) {

		try {
			Field field = Electrotype_EmployeeUtil.class.getDeclaredField(
				"_persistence");

			field.setAccessible(true);

			field.set(null, electrotype_EmployeePersistence);
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

	private static final String _SQL_SELECT_ELECTROTYPE_EMPLOYEE =
		"SELECT electrotype_Employee FROM Electrotype_Employee electrotype_Employee";

	private static final String _SQL_COUNT_ELECTROTYPE_EMPLOYEE =
		"SELECT COUNT(electrotype_Employee) FROM Electrotype_Employee electrotype_Employee";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"electrotype_Employee.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Electrotype_Employee exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		Electrotype_EmployeePersistenceImpl.class);

	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"emp_id", "electro_id"});

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

	private static class Electrotype_EmployeeModelArgumentsResolver
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

			Electrotype_EmployeeModelImpl electrotype_EmployeeModelImpl =
				(Electrotype_EmployeeModelImpl)baseModel;

			long columnBitmask =
				electrotype_EmployeeModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					electrotype_EmployeeModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						electrotype_EmployeeModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					electrotype_EmployeeModelImpl, columnNames, original);
			}

			return null;
		}

		private static Object[] _getValue(
			Electrotype_EmployeeModelImpl electrotype_EmployeeModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						electrotype_EmployeeModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = electrotype_EmployeeModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static final Map<FinderPath, Long>
			_finderPathColumnBitmasksCache = new ConcurrentHashMap<>();

	}

}