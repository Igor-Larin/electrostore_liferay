package electrostore.db.service.persistence.impl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;

import electrostore.db.service.persistence.PurchaseFinder;

@Component(service = PurchaseFinder.class)
public class PurchaseFinderImpl extends PurchaseFinderBaseImpl implements PurchaseFinder {
	
	@Reference
	private CustomSQL customSQL;
	
	public String findTheGreatestGainByCash() {
		String res = "error";
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "findCashGain");
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			res = QueryUtil.list(query, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS).get(0).toString();
			
		} catch (Exception e) {
			System.out.println("Ошибка при исполнениии запроса покупок " + e.getMessage());
		}
		finally {
			closeSession(session);
		}
		return res;
	}
	
	public String findElectrotechPurchasesCount() {
		String res = "error";
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "findElectrotechPurchasesCount");
			SQLQuery query = session.createSQLQuery(sql);
			query.setCacheable(false);
			res = QueryUtil.list(query, getDialect(), QueryUtil.ALL_POS, QueryUtil.ALL_POS).get(0).toString();
			
		} catch (Exception e) {
			System.out.println("Ошибка при исполнениии запроса наличных " + e.getMessage());
		}
		finally {
			closeSession(session);
		}
		return res;
	}
}
