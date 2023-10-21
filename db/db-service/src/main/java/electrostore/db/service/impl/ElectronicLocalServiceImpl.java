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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.ParamUtil;

import electrostore.db.model.Electronic;
import electrostore.db.service.base.ElectronicLocalServiceBaseImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Brian Wing Shun Chan
 */
@Component(
	property = "model.class.name=electrostore.db.model.Electronic",
	service = AopService.class
)
public class ElectronicLocalServiceImpl extends ElectronicLocalServiceBaseImpl {
	
	public void addElectronic(ActionRequest request) {
		long id = counterLocalService.increment();
		Electronic electronic = electronicLocalService.createElectronic(id);
		electronic.setName(ParamUtil.getString(request, "name"));
		electronic.setDescription(ParamUtil.getString(request, "description"));
		electronic.setPrice(ParamUtil.getInteger(request, "price"));
		electronic.setElectronic_count(ParamUtil.getInteger(request, "count"));
		electronic.setElectrotype_id(ParamUtil.getLong(request, "electrotype"));
		electronic.setIs_archive(ParamUtil.getBoolean(request, "is_archive"));
		electronic.setIs_present(ParamUtil.getBoolean(request, "is_present"));
		electronicPersistence.update(electronic);
	}
	
	public void updateElectronic(ActionRequest request) throws PortalException {
		long id = ParamUtil.getLong(request, "electronicId");
		Electronic electronic = electronicLocalService.getElectronic(id);
		electronic.setName(ParamUtil.getString(request, "name"));
		electronic.setDescription(ParamUtil.getString(request, "description"));
		electronic.setPrice(ParamUtil.getInteger(request, "price"));
		electronic.setElectronic_count(ParamUtil.getInteger(request, "count"));
		electronic.setElectrotype_id(ParamUtil.getLong(request, "electrotype"));
		electronic.setIs_archive(ParamUtil.getBoolean(request, "is_archive"));
		electronic.setIs_present(ParamUtil.getBoolean(request, "is_present"));
		electronicPersistence.update(electronic);
	}
	
	public void addElectronicFromZip(String electronicString, String delimeter) {
		long id, electrotype_id;
		int price, count;
		String description, name;
		boolean isPresent, isArchive;
		try(Scanner scanner = new Scanner(electronicString)) {
			scanner.useDelimiter(delimeter);
			id = scanner.nextLong();
			if(electronicPersistence.fetchByPrimaryKey(id) != null) {
				System.out.println("Уже есть такой товар");
				return;
			}
			name = scanner.next();
			electrotype_id = scanner.nextLong();
			price = scanner.nextInt();
			count = scanner.nextInt();
			isPresent = scanner.nextByte() == 1 ? true : false;
			isArchive = scanner.nextByte() == 1 ? true : false;
			description = scanner.next();
		}
		catch(Exception exception) {
			System.out.println("Ошибка при чтении товара из файла");
			return;
		}		
		Electronic electronic = electronicPersistence.create(id);
		electronic.setName(name);
		electronic.setElectrotype_id(electrotype_id);
		electronic.setPrice(price);
		electronic.setElectronic_count(count);
		electronic.setIs_archive(isArchive);
		electronic.setIs_present(isPresent);
		electronic.setDescription(description);
		electronicPersistence.update(electronic);
	}
}