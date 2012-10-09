package com.altoCloud.dbOpration;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.altoCloud.common.HibernateUtil;
import com.altoCloud.domain.Station_Details_extra;

public class StationDetailsExtraQuery {
	public void add(Station_Details_extra s_details) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(s_details);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}

	public void remove(Station_Details_extra item) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.delete(item);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}

	public Station_Details_extra findById(String id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Station_Details_extra r = null;
		try {
			session.beginTransaction();
			r = (Station_Details_extra) session.load(
					Station_Details_extra.class, id);

			// System.out.println(r.getStn_id().getStn_name());
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

		return r;
	}

	public List<Station_Details_extra> getAllByMnetId(String id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Station_Details_extra> r = new ArrayList<Station_Details_extra>();
		try {
			session.beginTransaction();
			Query query = session
					.createQuery("FROM Station_Details_extra as sd join  fetch sd.stn_details as s  WHERE s.stn=:type");
			query.setString("type", id);

			r = (List<Station_Details_extra>) query.list();
			System.out.println(r.get(0).getStn_details().getState());
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

		return r;
	}

	protected boolean validate(Station_Details_extra p) {
		if (p == null)
			return false;

		// TODO validate values
		return true;
	}

	public void updateTable(Station_Details_extra s_details) {
		if (!validate(s_details) || s_details.getStn_details() == null)
			throw new RuntimeException("Invalid person");

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(s_details);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

}
