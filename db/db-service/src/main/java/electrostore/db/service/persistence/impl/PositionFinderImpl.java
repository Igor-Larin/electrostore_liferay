package electrostore.db.service.persistence.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import electrostore.db.model.Employee;
import electrostore.db.model.impl.EmployeeImpl;
import electrostore.db.service.persistence.PositionFinder;

@Component(service = PositionFinder.class)
public class PositionFinderImpl extends PositionFinderBaseImpl implements PositionFinder{
	@Reference
	private CustomSQL customSQL;
	public Employee findBestEmployeesByPositions(String position) {
		Employee employee = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "findBestEmployeesByPositions");	
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			query.addEntity("Employee Entity", EmployeeImpl.class);
			QueryPos qPos = QueryPos.getInstance(query);
	        qPos.add(position);
			employee = (Employee)QueryUtil.list(query, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS).get(0);
			
		} catch (Exception e) {
			System.out.println("Ошибка при исполнениии лучшего сотрудника по должности" + e.getMessage());
		}
		finally {
			closeSession(session);
		}
		return employee;
	}
}
