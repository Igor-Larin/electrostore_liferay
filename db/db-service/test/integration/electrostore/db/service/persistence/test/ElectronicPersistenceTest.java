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

import electrostore.db.exception.NoSuchElectronicException;
import electrostore.db.model.Electronic;
import electrostore.db.service.ElectronicLocalServiceUtil;
import electrostore.db.service.persistence.ElectronicPersistence;
import electrostore.db.service.persistence.ElectronicUtil;

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
public class ElectronicPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "electrostore.db.service"));

	@Before
	public void setUp() {
		_persistence = ElectronicUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Electronic> iterator = _electronics.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Electronic electronic = _persistence.create(pk);

		Assert.assertNotNull(electronic);

		Assert.assertEquals(electronic.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Electronic newElectronic = addElectronic();

		_persistence.remove(newElectronic);

		Electronic existingElectronic = _persistence.fetchByPrimaryKey(
			newElectronic.getPrimaryKey());

		Assert.assertNull(existingElectronic);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addElectronic();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Electronic newElectronic = _persistence.create(pk);

		newElectronic.setName(RandomTestUtil.randomString());

		newElectronic.setPrice(RandomTestUtil.nextInt());

		newElectronic.setElectronic_count(RandomTestUtil.nextInt());

		newElectronic.setIs_present(RandomTestUtil.randomBoolean());

		newElectronic.setIs_archive(RandomTestUtil.randomBoolean());

		newElectronic.setDescription(RandomTestUtil.randomString());

		newElectronic.setElectrotype_id(RandomTestUtil.nextLong());

		_electronics.add(_persistence.update(newElectronic));

		Electronic existingElectronic = _persistence.findByPrimaryKey(
			newElectronic.getPrimaryKey());

		Assert.assertEquals(
			existingElectronic.getElectronic_id(),
			newElectronic.getElectronic_id());
		Assert.assertEquals(
			existingElectronic.getName(), newElectronic.getName());
		Assert.assertEquals(
			existingElectronic.getPrice(), newElectronic.getPrice());
		Assert.assertEquals(
			existingElectronic.getElectronic_count(),
			newElectronic.getElectronic_count());
		Assert.assertEquals(
			existingElectronic.isIs_present(), newElectronic.isIs_present());
		Assert.assertEquals(
			existingElectronic.isIs_archive(), newElectronic.isIs_archive());
		Assert.assertEquals(
			existingElectronic.getDescription(),
			newElectronic.getDescription());
		Assert.assertEquals(
			existingElectronic.getElectrotype_id(),
			newElectronic.getElectrotype_id());
	}

	@Test
	public void testCountByElectronicType() throws Exception {
		_persistence.countByElectronicType(RandomTestUtil.nextLong());

		_persistence.countByElectronicType(0L);
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Electronic newElectronic = addElectronic();

		Electronic existingElectronic = _persistence.findByPrimaryKey(
			newElectronic.getPrimaryKey());

		Assert.assertEquals(existingElectronic, newElectronic);
	}

	@Test(expected = NoSuchElectronicException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Electronic> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"electronics", "electronic_id", true, "name", true, "price", true,
			"electronic_count", true, "is_present", true, "is_archive", true,
			"description", true, "electrotype_id", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Electronic newElectronic = addElectronic();

		Electronic existingElectronic = _persistence.fetchByPrimaryKey(
			newElectronic.getPrimaryKey());

		Assert.assertEquals(existingElectronic, newElectronic);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Electronic missingElectronic = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingElectronic);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Electronic newElectronic1 = addElectronic();
		Electronic newElectronic2 = addElectronic();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectronic1.getPrimaryKey());
		primaryKeys.add(newElectronic2.getPrimaryKey());

		Map<Serializable, Electronic> electronics =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(2, electronics.size());
		Assert.assertEquals(
			newElectronic1, electronics.get(newElectronic1.getPrimaryKey()));
		Assert.assertEquals(
			newElectronic2, electronics.get(newElectronic2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Electronic> electronics =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(electronics.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Electronic newElectronic = addElectronic();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectronic.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Electronic> electronics =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, electronics.size());
		Assert.assertEquals(
			newElectronic, electronics.get(newElectronic.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Electronic> electronics =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertTrue(electronics.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Electronic newElectronic = addElectronic();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newElectronic.getPrimaryKey());

		Map<Serializable, Electronic> electronics =
			_persistence.fetchByPrimaryKeys(primaryKeys);

		Assert.assertEquals(1, electronics.size());
		Assert.assertEquals(
			newElectronic, electronics.get(newElectronic.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			ElectronicLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Electronic>() {

				@Override
				public void performAction(Electronic electronic) {
					Assert.assertNotNull(electronic);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Electronic newElectronic = addElectronic();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electronic.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"electronic_id", newElectronic.getElectronic_id()));

		List<Electronic> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(1, result.size());

		Electronic existingElectronic = result.get(0);

		Assert.assertEquals(existingElectronic, newElectronic);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electronic.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"electronic_id", RandomTestUtil.nextLong()));

		List<Electronic> result = _persistence.findWithDynamicQuery(
			dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Electronic newElectronic = addElectronic();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electronic.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("electronic_id"));

		Object newElectronic_id = newElectronic.getElectronic_id();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"electronic_id", new Object[] {newElectronic_id}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingElectronic_id = result.get(0);

		Assert.assertEquals(existingElectronic_id, newElectronic_id);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Electronic.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("electronic_id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"electronic_id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Electronic addElectronic() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Electronic electronic = _persistence.create(pk);

		electronic.setName(RandomTestUtil.randomString());

		electronic.setPrice(RandomTestUtil.nextInt());

		electronic.setElectronic_count(RandomTestUtil.nextInt());

		electronic.setIs_present(RandomTestUtil.randomBoolean());

		electronic.setIs_archive(RandomTestUtil.randomBoolean());

		electronic.setDescription(RandomTestUtil.randomString());

		electronic.setElectrotype_id(RandomTestUtil.nextLong());

		_electronics.add(_persistence.update(electronic));

		return electronic;
	}

	private List<Electronic> _electronics = new ArrayList<Electronic>();
	private ElectronicPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}