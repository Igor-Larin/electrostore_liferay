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

import electrostore.db.exception.NoSuchPurchaseException;
import electrostore.db.model.Purchase;
import electrostore.db.service.PurchaseLocalServiceUtil;
import electrostore.db.service.persistence.PurchasePersistence;
import electrostore.db.service.persistence.PurchaseUtil;

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
public class PurchasePersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "electrostore.db.service"));

	@Before
	public void setUp() {
		_persistence = PurchaseUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Purchase> iterator = _purchases.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Purchase purchase = _persistence.create(pk);

		Assert.assertNotNull(purchase);

		Assert.assertEquals(purchase.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Purchase newPurchase = addPurchase();

		_persistence.remove(newPurchase);

		Purchase existingPurchase = _persistence.fetchByPrimaryKey(
			newPurchase.getPrimaryKey());

		Assert.assertNull(existingPurchase);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPurchase();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Purchase newPurchase = _persistence.create(pk);

		newPurchase.setPurchase_date(RandomTestUtil.nextDate());

		newPurchase.setElectronic_id(RandomTestUtil.nextLong());

		newPurchase.setPurchasetype_id(RandomTestUtil.nextLong());

		newPurchase.setEmployee_id(RandomTestUtil.nextLong());

		_purchases.add(_persistence.update(newPurchase));

		Purchase existingPurchase = _persistence.findByPrimaryKey(
			newPurchase.getPrimaryKey());

		Assert.assertEquals(
			existingPurchase.getPurchase_id(), newPurchase.getPurchase_id());
		Assert.assertEquals(
			Time.getShortTimestamp(existingPurchase.getPurchase_date()),
			Time.getShortTimestamp(newPurchase.getPurchase_date()));
		Assert.assertEquals(
			existingPurchase.getElectronic_id(),
			newPurchase.getElectronic_id());
		Assert.assertEquals(
			existingPurchase.getPurchasetype_id(),
			newPurchase.getPurchasetype_id());
		Assert.assertEquals(
			existingPurchase.getEmployee_id(), newPurchase.getEmployee_id());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Purchase newPurchase = addPurchase();

		Purchase existingPurchase = _persistence.findByPrimaryKey(
			newPurchase.getPrimaryKey());

		Assert.assertEquals(existingPurchase, newPurchase);
	}

	@Test(expected = NoSuchPurchaseException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Purchase> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"purchases", "purchase_id", true, "purchase_date", true,
			"electronic_id", true, "purchasetype_id", true, "employee_id",
			true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Purchase newPurchase = addPurchase();

		Purchase existingPurchase = _persistence.fetchByPrimaryKey(
			newPurchase.getPrimaryKey());

		Assert.assertEquals(existingPurchase, newPurchase);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Purchase missingPurchase = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPurchase);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Purchase newPurchase1 = addPurchase();
		Purchase newPurchase2 = addPurchase();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPurchase1.getPrimaryKey());
		primaryKeys.add(newPurchase2.getPrimaryKey());

		Map<Serializable, Purchase> purchases = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, purchases.size());
		Assert.assertEquals(
			newPurchase1, purchases.get(newPurchase1.getPrimaryKey()));
		Assert.assertEquals(
			newPurchase2, purchases.get(newPurchase2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Purchase> purchases = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(purchases.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Purchase newPurchase = addPurchase();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPurchase.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Purchase> purchases = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, purchases.size());
		Assert.assertEquals(
			newPurchase, purchases.get(newPurchase.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Purchase> purchases = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(purchases.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Purchase newPurchase = addPurchase();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPurchase.getPrimaryKey());

		Map<Serializable, Purchase> purchases = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, purchases.size());
		Assert.assertEquals(
			newPurchase, purchases.get(newPurchase.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PurchaseLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Purchase>() {

				@Override
				public void performAction(Purchase purchase) {
					Assert.assertNotNull(purchase);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Purchase newPurchase = addPurchase();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Purchase.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"purchase_id", newPurchase.getPurchase_id()));

		List<Purchase> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Purchase existingPurchase = result.get(0);

		Assert.assertEquals(existingPurchase, newPurchase);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Purchase.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"purchase_id", RandomTestUtil.nextLong()));

		List<Purchase> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Purchase newPurchase = addPurchase();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Purchase.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("purchase_id"));

		Object newPurchase_id = newPurchase.getPurchase_id();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"purchase_id", new Object[] {newPurchase_id}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingPurchase_id = result.get(0);

		Assert.assertEquals(existingPurchase_id, newPurchase_id);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Purchase.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("purchase_id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"purchase_id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Purchase addPurchase() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Purchase purchase = _persistence.create(pk);

		purchase.setPurchase_date(RandomTestUtil.nextDate());

		purchase.setElectronic_id(RandomTestUtil.nextLong());

		purchase.setPurchasetype_id(RandomTestUtil.nextLong());

		purchase.setEmployee_id(RandomTestUtil.nextLong());

		_purchases.add(_persistence.update(purchase));

		return purchase;
	}

	private List<Purchase> _purchases = new ArrayList<Purchase>();
	private PurchasePersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}