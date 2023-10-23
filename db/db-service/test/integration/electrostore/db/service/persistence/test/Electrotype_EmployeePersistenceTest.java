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
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.test.rule.AggregateTestRule;
import com.liferay.portal.kernel.test.util.RandomTestUtil;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.util.IntegerWrapper;
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import electrostore.db.exception.NoSuchElectrotype_EmployeeException;
import electrostore.db.model.Electrotype_Employee;
import electrostore.db.service.Electrotype_EmployeeLocalServiceUtil;
import electrostore.db.service.persistence.Electrotype_EmployeePK;
import electrostore.db.service.persistence.Electrotype_EmployeePersistence;
import electrostore.db.service.persistence.Electrotype_EmployeeUtil;

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
public class Electrotype_EmployeePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "electrostore.db.service"));

	@Before
	public void setUp() {
		_persistence = Electrotype_EmployeeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Electrotype_Employee> iterator =
			_electrotype_Employees.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		Electrotype_EmployeePK pk = new Electrotype_EmployeePK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Electrotype_Employee electrotype_Employee = _persistence.create(pk);

		Assert.assertNotNull(electrotype_Employee);

		Assert.assertEquals(electrotype_Employee.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Electrotype_Employee newElectrotype_Employee =
			addElectrotype_Employee();

		_persistence.remove(newElectrotype_Employee);

		Electrotype_Employee existingElectrotype_Employee =
			_persistence.fetchByPrimaryKey(
				newElectrotype_Employee.getPrimaryKey());

		Assert.assertNull(existingElectrotype_Employee);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addElectrotype_Employee();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		Electrotype_EmployeePK pk = new Electrotype_EmployeePK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Electrotype_Employee newElectrotype_Employee = _persistence.create(pk);

		_electrotype_Employees.add(
			_persistence.update(newElectrotype_Employee));

		Electrotype_Employee existingElectrotype_Employee =
			_persistence.findByPrimaryKey(
				newElectrotype_Employee.getPrimaryKey());

		Assert.assertEquals(
			existingElectrotype_Employee.getEmp_id(),
			newElectrotype_Employee.getEmp_id());
		Assert.assertEquals(
			existingElectrotype_Employee.getElectro_id(),
			newElectrotype_Employee.getElectro_id());
	}

	@Test
	public void testCountByEmployeeId() throws Exception {
		_persistence.countByEmployeeId(RandomTestUtil.nextLong());

		_persistence.countByEmployeeId(0L);
	}

	@Test
	public void testCountByElectronicType() throws Exception {
		_persistence.countByElectronicType(RandomTestUtil.nextLong());

		_persistence.countByElectronicType(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Electrotype_Employee newElectrotype_Employee =
			addElectrotype_Employee();

		Electrotype_Employee existingElectrotype_Employee =
			_persistence.findByPrimaryKey(
				newElectrotype_Employee.getPrimaryKey());

		Assert.assertEquals(
			existingElectrotype_Employee, newElectrotype_Employee);
	}

	@Test(expected = NoSuchElectrotype_EmployeeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		Electrotype_EmployeePK pk = new Electrotype_EmployeePK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Electrotype_Employee newElectrotype_Employee =
			addElectrotype_Employee();

		Electrotype_Employee existingElectrotype_Employee =
			_persistence.fetchByPrimaryKey(
				newElectrotype_Employee.getPrimaryKey());

		Assert.assertEquals(
			existingElectrotype_Employee, newElectrotype_Employee);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		Electrotype_EmployeePK pk = new Electrotype_EmployeePK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Electrotype_Employee missingElectrotype_Employee =
			_persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingElectrotype_Employee);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Electrotype_Employee newElectrotype_Employee1 =
			addElectrotype_Employee();
		Electrotype_Employee newElectrotype_Employee2 =
			addElectrotype_Employee();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectrotype_Employee1.getPrimaryKey());
		primaryKeys.add(newElectrotype_Employee2.getPrimaryKey());

		Map<Serializable, Electrotype_Employee> electrotype_Employees =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, electrotype_Employees.size());
		Assert.assertEquals(
			newElectrotype_Employee1,
			electrotype_Employees.get(
				newElectrotype_Employee1.getPrimaryKey()));
		Assert.assertEquals(
			newElectrotype_Employee2,
			electrotype_Employees.get(
				newElectrotype_Employee2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		Electrotype_EmployeePK pk1 = new Electrotype_EmployeePK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Electrotype_EmployeePK pk2 = new Electrotype_EmployeePK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Electrotype_Employee> electrotype_Employees =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(electrotype_Employees.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Electrotype_Employee newElectrotype_Employee =
			addElectrotype_Employee();

		Electrotype_EmployeePK pk = new Electrotype_EmployeePK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectrotype_Employee.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Electrotype_Employee> electrotype_Employees =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, electrotype_Employees.size());
		Assert.assertEquals(
			newElectrotype_Employee,
			electrotype_Employees.get(newElectrotype_Employee.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Electrotype_Employee> electrotype_Employees =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(electrotype_Employees.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Electrotype_Employee newElectrotype_Employee =
			addElectrotype_Employee();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectrotype_Employee.getPrimaryKey());

		Map<Serializable, Electrotype_Employee> electrotype_Employees =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, electrotype_Employees.size());
		Assert.assertEquals(
			newElectrotype_Employee,
			electrotype_Employees.get(newElectrotype_Employee.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			Electrotype_EmployeeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod
				<Electrotype_Employee>() {

				@Override
				public void performAction(
					Electrotype_Employee electrotype_Employee) {

					Assert.assertNotNull(electrotype_Employee);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Electrotype_Employee newElectrotype_Employee =
			addElectrotype_Employee();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electrotype_Employee.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.emp_id", newElectrotype_Employee.getEmp_id()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.electro_id", newElectrotype_Employee.getElectro_id()));

		List<Electrotype_Employee> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Electrotype_Employee existingElectrotype_Employee = result.get(0);

		Assert.assertEquals(
			existingElectrotype_Employee, newElectrotype_Employee);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electrotype_Employee.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq("id.emp_id", RandomTestUtil.nextLong()));
		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"id.electro_id", RandomTestUtil.nextLong()));

		List<Electrotype_Employee> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Electrotype_Employee newElectrotype_Employee =
			addElectrotype_Employee();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electrotype_Employee.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id.emp_id"));

		Object newEmp_id = newElectrotype_Employee.getEmp_id();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in("id.emp_id", new Object[] {newEmp_id}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingEmp_id = result.get(0);

		Assert.assertEquals(existingEmp_id, newEmp_id);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electrotype_Employee.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(ProjectionFactoryUtil.property("id.emp_id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"id.emp_id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Electrotype_Employee addElectrotype_Employee() throws Exception {
		Electrotype_EmployeePK pk = new Electrotype_EmployeePK(
			RandomTestUtil.nextLong(), RandomTestUtil.nextLong());

		Electrotype_Employee electrotype_Employee = _persistence.create(pk);

		_electrotype_Employees.add(_persistence.update(electrotype_Employee));

		return electrotype_Employee;
	}

	private List<Electrotype_Employee> _electrotype_Employees =
		new ArrayList<Electrotype_Employee>();
	private Electrotype_EmployeePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}