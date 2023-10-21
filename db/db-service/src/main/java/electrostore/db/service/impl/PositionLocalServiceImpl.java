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

package electrostore.db.service.impl;

import java.util.List;
import java.util.Scanner;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.aop.AopService;

import electrostore.db.model.Position;
import electrostore.db.model.PurchaseType;
import electrostore.db.service.base.PositionLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=electrostore.db.model.Position",
	service = AopService.class
)
public class PositionLocalServiceImpl extends PositionLocalServiceBaseImpl {
	public List<Position> getAllPositions() {
		return positionPersistence.findAll();
	}
	
	public void addPositionFromZip(String positionString, String delimeter) {
		long id;
		String name;
		try(Scanner scanner = new Scanner(positionString)) {
			scanner.useDelimiter(delimeter);
			id = scanner.nextLong();
			if(positionPersistence.fetchByPrimaryKey(id) != null) {
				System.out.println("Уже есть такая профессия");
				return;
			}
			name = scanner.next();
		}
		catch(Exception exception) {
			System.out.println("Ошибка при чтении профессии из файла");
			return;
		}		
		Position position = positionPersistence.create(id);
		position.setName(name);
		positionPersistence.update(position);
	}
}