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

import electrostore.db.exception.NoSuchPositionException;
import electrostore.db.model.Position;
import electrostore.db.service.PositionLocalServiceUtil;
import electrostore.db.service.persistence.PositionPersistence;
import electrostore.db.service.persistence.PositionUtil;

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
public class PositionPersistenceTest {

	@ClassRule
	@Rule
	public static final AggregateTestRule aggregateTestRule =
		new AggregateTestRule(
			new LiferayIntegrationTestRule(), PersistenceTestRule.INSTANCE,
			new TransactionalTestRule(
				Propagation.REQUIRED, "electrostore.db.service"));

	@Before
	public void setUp() {
		_persistence = PositionUtil.getPersistence();

		Class<?> clazz = _persistence.getClass();

		_dynamicQueryClassLoader = clazz.getClassLoader();
	}

	@After
	public void tearDown() throws Exception {
		Iterator<Position> iterator = _positions.iterator();

		while (iterator.hasNext()) {
			_persistence.remove(iterator.next());

			iterator.remove();
		}
	}

	@Test
	public void testCreate() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Position position = _persistence.create(pk);

		Assert.assertNotNull(position);

		Assert.assertEquals(position.getPrimaryKey(), pk);
	}

	@Test
	public void testRemove() throws Exception {
		Position newPosition = addPosition();

		_persistence.remove(newPosition);

		Position existingPosition = _persistence.fetchByPrimaryKey(
			newPosition.getPrimaryKey());

		Assert.assertNull(existingPosition);
	}

	@Test
	public void testUpdateNew() throws Exception {
		addPosition();
	}

	@Test
	public void testUpdateExisting() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Position newPosition = _persistence.create(pk);

		newPosition.setName(RandomTestUtil.randomString());

		_positions.add(_persistence.update(newPosition));

		Position existingPosition = _persistence.findByPrimaryKey(
			newPosition.getPrimaryKey());

		Assert.assertEquals(
			existingPosition.getPosition_id(), newPosition.getPosition_id());
		Assert.assertEquals(existingPosition.getName(), newPosition.getName());
	}

	@Test
	public void testFindByPrimaryKeyExisting() throws Exception {
		Position newPosition = addPosition();

		Position existingPosition = _persistence.findByPrimaryKey(
			newPosition.getPrimaryKey());

		Assert.assertEquals(existingPosition, newPosition);
	}

	@Test(expected = NoSuchPositionException.class)
	public void testFindByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		_persistence.findByPrimaryKey(pk);
	}

	@Test
	public void testFindAll() throws Exception {
		_persistence.findAll(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS, getOrderByComparator());
	}

	protected OrderByComparator<Position> getOrderByComparator() {
		return OrderByComparatorFactoryUtil.create(
			"positiontype", "position_id", true, "name", true);
	}

	@Test
	public void testFetchByPrimaryKeyExisting() throws Exception {
		Position newPosition = addPosition();

		Position existingPosition = _persistence.fetchByPrimaryKey(
			newPosition.getPrimaryKey());

		Assert.assertEquals(existingPosition, newPosition);
	}

	@Test
	public void testFetchByPrimaryKeyMissing() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Position missingPosition = _persistence.fetchByPrimaryKey(pk);

		Assert.assertNull(missingPosition);
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereAllPrimaryKeysExist()
		throws Exception {

		Position newPosition1 = addPosition();
		Position newPosition2 = addPosition();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPosition1.getPrimaryKey());
		primaryKeys.add(newPosition2.getPrimaryKey());

		Map<Serializable, Position> positions = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(2, positions.size());
		Assert.assertEquals(
			newPosition1, positions.get(newPosition1.getPrimaryKey()));
		Assert.assertEquals(
			newPosition2, positions.get(newPosition2.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereNoPrimaryKeysExist()
		throws Exception {

		long pk1 = RandomTestUtil.nextLong();

		long pk2 = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(pk1);
		primaryKeys.add(pk2);

		Map<Serializable, Position> positions = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(positions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithMultiplePrimaryKeysWhereSomePrimaryKeysExist()
		throws Exception {

		Position newPosition = addPosition();

		long pk = RandomTestUtil.nextLong();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPosition.getPrimaryKey());
		primaryKeys.add(pk);

		Map<Serializable, Position> positions = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, positions.size());
		Assert.assertEquals(
			newPosition, positions.get(newPosition.getPrimaryKey()));
	}

	@Test
	public void testFetchByPrimaryKeysWithNoPrimaryKeys() throws Exception {
		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		Map<Serializable, Position> positions = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertTrue(positions.isEmpty());
	}

	@Test
	public void testFetchByPrimaryKeysWithOnePrimaryKey() throws Exception {
		Position newPosition = addPosition();

		Set<Serializable> primaryKeys = new HashSet<Serializable>();

		primaryKeys.add(newPosition.getPrimaryKey());

		Map<Serializable, Position> positions = _persistence.fetchByPrimaryKeys(
			primaryKeys);

		Assert.assertEquals(1, positions.size());
		Assert.assertEquals(
			newPosition, positions.get(newPosition.getPrimaryKey()));
	}

	@Test
	public void testActionableDynamicQuery() throws Exception {
		final IntegerWrapper count = new IntegerWrapper();

		ActionableDynamicQuery actionableDynamicQuery =
			PositionLocalServiceUtil.getActionableDynamicQuery();

		actionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Position>() {

				@Override
				public void performAction(Position position) {
					Assert.assertNotNull(position);

					count.increment();
				}

			});

		actionableDynamicQuery.performActions();

		Assert.assertEquals(count.getValue(), _persistence.countAll());
	}

	@Test
	public void testDynamicQueryByPrimaryKeyExisting() throws Exception {
		Position newPosition = addPosition();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Position.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"position_id", newPosition.getPosition_id()));

		List<Position> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Position existingPosition = result.get(0);

		Assert.assertEquals(existingPosition, newPosition);
	}

	@Test
	public void testDynamicQueryByPrimaryKeyMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Position.class, _dynamicQueryClassLoader);

		dynamicQuery.add(
			RestrictionsFactoryUtil.eq(
				"position_id", RandomTestUtil.nextLong()));

		List<Position> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	@Test
	public void testDynamicQueryByProjectionExisting() throws Exception {
		Position newPosition = addPosition();

		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Position.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("position_id"));

		Object newPosition_id = newPosition.getPosition_id();

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"position_id", new Object[] {newPosition_id}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(1, result.size());

		Object existingPosition_id = result.get(0);

		Assert.assertEquals(existingPosition_id, newPosition_id);
	}

	@Test
	public void testDynamicQueryByProjectionMissing() throws Exception {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(
			Position.class, _dynamicQueryClassLoader);

		dynamicQuery.setProjection(
			ProjectionFactoryUtil.property("position_id"));

		dynamicQuery.add(
			RestrictionsFactoryUtil.in(
				"position_id", new Object[] {RandomTestUtil.nextLong()}));

		List<Object> result = _persistence.findWithDynamicQuery(dynamicQuery);

		Assert.assertEquals(0, result.size());
	}

	protected Position addPosition() throws Exception {
		long pk = RandomTestUtil.nextLong();

		Position position = _persistence.create(pk);

		position.setName(RandomTestUtil.randomString());

		_positions.add(_persistence.update(position));

		return position;
	}

	private List<Position> _positions = new ArrayList<Position>();
	private PositionPersistence _persistence;
	private ClassLoader _dynamicQueryClassLoader;

}