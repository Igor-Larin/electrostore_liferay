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
import com.liferay.portal.test.rule.LiferayIntegrationTestRule;
import com.liferay.portal.test.rule.PersistenceTestRule;
import com.liferay.portal.test.rule.TransactionalTestRule;

import electrostore.db.exception.NoSuchElectronicTypeException;
import electrostore.db.model.ElectronicType;
import electrostore.db.service.ElectronicTypeLocalServiceUtil;
import electrostore.db.service.persistence.ElectronicTypePersistence;
import electrostore.db.service.persistence.ElectronicTypeUtil;

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
public class ElectronicTypePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "electrostore.db.service"));

	@Before
	public void setUp() {
		_persistence = ElectronicTypeUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<ElectronicType> iterator = _electronicTypes.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ElectronicType electronicType = _persistence.create(pk);

		Assert.assertNotNull(electronicType);

		Assert.assertEquals(electronicType.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		ElectronicType newElectronicType = addElectronicType();

		_persistence.remove(newElectronicType);

		ElectronicType existingElectronicType = _persistence.fetchByPrimaryKey(
			newElectronicType.getPrimaryKey());

		Assert.assertNull(existingElectronicType);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addElectronicType();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ElectronicType newElectronicType = _persistence.create(pk);

		newElectronicType.setName(RandomTestUtil.randomString());

		_electronicTypes.add(_persistence.update(newElectronicType));

		ElectronicType existingElectronicType = _persistence.findByPrimaryKey(
			newElectronicType.getPrimaryKey());

		Assert.assertEquals(
			existingElectronicType.getElectrotype_id(),
			newElectronicType.getElectrotype_id());
		Assert.assertEquals(
			existingElectronicType.getName(), newElectronicType.getName());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		ElectronicType newElectronicType = addElectronicType();

		ElectronicType existingElectronicType = _persistence.findByPrimaryKey(
			newElectronicType.getPrimaryKey());

		Assert.assertEquals(existingElectronicType, newElectronicType);
	}

	@Test(expected = NoSuchElectronicTypeException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<ElectronicType> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"electrotype", "electrotype_id", true, "name", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		ElectronicType newElectronicType = addElectronicType();

		ElectronicType existingElectronicType = _persistence.fetchByPrimaryKey(
			newElectronicType.getPrimaryKey());

		Assert.assertEquals(existingElectronicType, newElectronicType);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ElectronicType missingElectronicType = _persistence.fetchByPrimaryKey(
			pk);

		Assert.assertNull(missingElectronicType);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		ElectronicType newElectronicType1 = addElectronicType();
		ElectronicType newElectronicType2 = addElectronicType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectronicType1.getPrimaryKey());
		primaryKeys.add(newElectronicType2.getPrimaryKey());

		Map<Serializable, ElectronicType> electronicTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, electronicTypes.size());
		Assert.assertEquals(
			newElectronicType1,
			electronicTypes.get(newElectronicType1.getPrimaryKey()));
		Assert.assertEquals(
			newElectronicType2,
			electronicTypes.get(newElectronicType2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, ElectronicType> electronicTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(electronicTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		ElectronicType newElectronicType = addElectronicType();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectronicType.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, ElectronicType> electronicTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, electronicTypes.size());
		Assert.assertEquals(
			newElectronicType,
			electronicTypes.get(newElectronicType.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, ElectronicType> electronicTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(electronicTypes.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		ElectronicType newElectronicType = addElectronicType();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectronicType.getPrimaryKey());

		Map<Serializable, ElectronicType> electronicTypes =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, electronicTypes.size());
		Assert.assertEquals(
			newElectronicType,
			electronicTypes.get(newElectronicType.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ElectronicTypeLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<ElectronicType>() {

				@Override
				public void performAction(ElectronicType electronicType) {
					Assert.assertNotNull(electronicType);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		ElectronicType newElectronicType = addElectronicType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ElectronicType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"electrotype_id", newElectronicType.getElectrotype_id()));

		List<ElectronicType> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		ElectronicType existingElectronicType = result.get(0);

		Assert.assertEquals(existingElectronicType, newElectronicType);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ElectronicType.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"electrotype_id", RandomTestUtil.nextLong()));

		List<ElectronicType> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		ElectronicType newElectronicType = addElectronicType();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ElectronicType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("electrotype_id"));

		Object newElectrotype_id = newElectronicType.getElectrotype_id();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"electrotype_id", new Object[] {newElectrotype_id}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingElectrotype_id = result.get(0);

		Assert.assertEquals(existingElectrotype_id, newElectrotype_id);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			ElectronicType.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("electrotype_id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"electrotype_id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected ElectronicType addElectronicType() throws Exception {
		long pk = RandomTestUtil.nextLong();

		ElectronicType electronicType = _persistence.create(pk);

		electronicType.setName(RandomTestUtil.randomString());

		_electronicTypes.add(_persistence.update(electronicType));

		return electronicType;
	}

	private List<ElectronicType> _electronicTypes =
		new ArrayList<ElectronicType>();
	private ElectronicTypePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}