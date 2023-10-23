package electrostore.db.service.persistence.impl;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import electrostore.db.model.Employee;
import electrostore.db.model.impl.EmployeeImpl;
import electrostore.db.service.persistence.EmployeeFinder;

@Component(service = EmployeeFinder.class)
public class EmployeeFinderImpl extends EmployeeFinderBaseImpl implements EmployeeFinder {
	@Reference
	private CustomSQL customSQL;
	public Employee findBestEmployeeBySmartphonePurchases() {
		Employee employee = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "findBestEmployeeBySmartphonePurchases");		
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Employee Entity", EmployeeImpl.class);
			employee = (Employee)QueryUtil.list(query, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS).get(0);
			
		} catch (Exception e) {
			System.out.println("Ошибка при исполнениии лучшего сотрудника " + e.getMessage());
		}
		finally {
			closeSession(session);
		}
		return employee;
	}
}
