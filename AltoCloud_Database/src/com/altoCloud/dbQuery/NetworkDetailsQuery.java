package com.altoCloud.dbQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.altoCloud.common.HibernateUtil;
import com.altoCloud.domain.level3.NetworkDetails;
import com.altoCloud.domain.level3.StationDetails;

public class NetworkDetailsQuery {

	public void add(NetworkDetails networkDetails, Session session) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		Transaction transaction = null;
		try {
//			transaction = session.beginTransaction();
			session.save(networkDetails);
//			transaction.commit();
		} catch (Exception e) {
			// transaction.rollback();
			System.out.println("NetworkDetailsQuery Exception:" + e);
			e.printStackTrace();
		}

	}

	// public void remove(Station_Details item) {
	// Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	// Transaction transaction = null;
	// try {
	// transaction = session.beginTransaction();
	// session.delete(item);
	// transaction.commit();
	// } catch (HibernateException e) {
	// transaction.rollback();
	// e.printStackTrace();
	// }
	//
	// }
	//
	public StationDetails findById(String id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		StationDetails r = null;
		try {
			session.beginTransaction();
			r = (StationDetails) session.load(StationDetails.class, id);

			// System.out.println(r.getStn_id().getStn_name());
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

		return r;
	}
	//
	// protected boolean validate(Station_Details p) {
	// if (p == null)
	// return false;
	//
	// // TODO validate values
	// return true;
	// }
	//
	// public void updateTable(Station_Details s_details) {
	// if (!validate(s_details) || s_details.getStn() == null)
	// throw new RuntimeException("Invalid person");
	//
	// Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	// try {
	// session.beginTransaction();
	// session.saveOrUpdate(s_details);
	// session.getTransaction().commit();
	// } catch (RuntimeException e) {
	// session.getTransaction().rollback();
	// throw e;
	// }
	// }

}
