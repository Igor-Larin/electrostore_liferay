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

package electrostore.db.service.persistence.test;

import com.liferay.arquillian.extension.junit.bridge.junit.Arquillian;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.OrderByComparatorFactoryUtil;
import com.liferay.portal.kernel.util.Time;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import electrostore.db.exception.NoSuchEmployeeException;
import electrostore.db.model.Employee;
import electrostore.db.service.EmployeeLocalServiceUtil;
import electrostore.db.service.persistence.EmployeePersistence;
import electrostore.db.service.persistence.EmployeeUtil;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @generated
 */
@RunWith(Arquillian.class)
public class EmployeePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "electrostore.db.service"));

	@Before
	public void setUp() {
		_persistence = EmployeeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Employee> iterator = _employees.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Employee employee = _persistence.create(pk);

		Assert.assertNotNull(employee);

		Assert.assertEquals(employee.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Employee newEmployee = addEmployee();

		_persistence.remove(newEmployee);

		Employee existingEmployee = _persistence.fetchByPrimaryKey(
			newEmployee.getPrimaryKey());

		Assert.assertNull(existingEmployee);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addEmployee();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Employee newEmployee = _persistence.create(pk);

		newEmployee.setName(RandomTestUtil.randomString());

		newEmployee.setLastname(RandomTestUtil.randomString());

		newEmployee.setMidname(RandomTestUtil.randomString());

		newEmployee.setBirthdate(RandomTestUtil.nextDate());

		newEmployee.setSex(RandomTestUtil.randomBoolean());

		newEmployee.setPosition_id(RandomTestUtil.nextLong());

		_employees.add(_persistence.update(newEmployee));

		Employee existingEmployee = _persistence.findByPrimaryKey(
			newEmployee.getPrimaryKey());

		Assert.assertEquals(
			existingEmployee.getEmployee_id(), newEmployee.getEmployee_id());
		Assert.assertEquals(existingEmployee.getName(), newEmployee.getName());
		Assert.assertEquals(
			existingEmployee.getLastname(), newEmployee.getLastname());
		Assert.assertEquals(
			existingEmployee.getMidname(), newEmployee.getMidname());
		Assert.assertEquals(
			Time.getShortTimestamp(existingEmployee.getBirthdate()),
			Time.getShortTimestamp(newEmployee.getBirthdate()));
		Assert.assertEquals(existingEmployee.isSex(), newEmployee.isSex());
		Assert.assertEquals(
			existingEmployee.getPosition_id(), newEmployee.getPosition_id());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Employee newEmployee = addEmployee();

		Employee existingEmployee = _persistence.findByPrimaryKey(
			newEmployee.getPrimaryKey());

		Assert.assertEquals(existingEmployee, newEmployee);
	}

	@Test(expected = NoSuchEmployeeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Employee> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"employees", "employee_id", true, "name", true, "lastname", true,
			"midname", true, "birthdate", true, "sex", true, "position_id",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Employee newEmployee = addEmployee();

		Employee existingEmployee = _persistence.fetchByPrimaryKey(
			newEmployee.getPrimaryKey());

		Assert.assertEquals(existingEmployee, newEmployee);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Employee missingEmployee = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingEmployee);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Employee newEmployee1 = addEmployee();
		Employee newEmployee2 = addEmployee();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployee1.getPrimaryKey());
		primaryKeys.add(newEmployee2.getPrimaryKey());

		Map<Serializable, Employee> employees = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, employees.size());
		Assert.assertEquals(
			newEmployee1, employees.get(newEmployee1.getPrimaryKey()));
		Assert.assertEquals(
			newEmployee2, employees.get(newEmployee2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Employee> employees = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(employees.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Employee newEmployee = addEmployee();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployee.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Employee> employees = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, employees.size());
		Assert.assertEquals(
			newEmployee, employees.get(newEmployee.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Employee> employees = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(employees.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Employee newEmployee = addEmployee();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newEmployee.getPrimaryKey());

		Map<Serializable, Employee> employees = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, employees.size());
		Assert.assertEquals(
			newEmployee, employees.get(newEmployee.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			EmployeeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Employee>() {

				@Override
				public void performAction(Employee employee) {
					Assert.assertNotNull(employee);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Employee newEmployee = addEmployee();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Employee.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"employee_id", newEmployee.getEmployee_id()));

		List<Employee> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Employee existingEmployee = result.get(0);

		Assert.assertEquals(existingEmployee, newEmployee);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Employee.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"employee_id", RandomTestUtil.nextLong()));

		List<Employee> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Employee newEmployee = addEmployee();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Employee.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("employee_id"));

		Object newEmployee_id = newEmployee.getEmployee_id();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"employee_id", new Object[] {newEmployee_id}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingEmployee_id = result.get(0);

		Assert.assertEquals(existingEmployee_id, newEmployee_id);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Employee.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("employee_id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"employee_id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Employee addEmployee() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Employee employee = _persistence.create(pk);

		employee.setName(RandomTestUtil.randomString());

		employee.setLastname(RandomTestUtil.randomString());

		employee.setMidname(RandomTestUtil.randomString());

		employee.setBirthdate(RandomTestUtil.nextDate());

		employee.setSex(RandomTestUtil.randomBoolean());

		employee.setPosition_id(RandomTestUtil.nextLong());

		_employees.add(_persistence.update(employee));

		return employee;
	}

	private List<Employee> _employees = new ArrayList<Employee>();
	private EmployeePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}