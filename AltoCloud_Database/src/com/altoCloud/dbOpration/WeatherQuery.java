package com.altoCloud.dbOpration;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.altoCloud.common.HibernateUtil;
import com.altoCloud.domain.Weather;

public class WeatherQuery {

	
	public void add(Weather weather) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(weather);
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		}

	}


	public void remove(Weather item) {
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

	
	public List<Weather> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Weather> getAllByStationId(Weather template) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ArrayList<Weather> r = new ArrayList<Weather>();
		try {
			session.beginTransaction();
			org.hibernate.Criteria c = session.createCriteria(Weather.class);
			if (template.getStn_id() != null) {
				c.add(Restrictions.eq("stn_id", template.getStn_id()));
			}
			r = (ArrayList<Weather>) c.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		System.out.println("find by stn id"
				+ r.get(0).getStn_id().getStn_name());
		return r;
	}

	public List<Weather> getAllByMnetId(int mnet) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		List<Weather> r = new ArrayList<Weather>();
		try {
			session.beginTransaction();
			Query query = session
					.createQuery("FROM Weather as w join  fetch w.stn_id as s  WHERE s.mnet=:type");
			query.setInteger("type", mnet);

			r = (List<Weather>) query.list();
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

		return r;
	}

	public List<Weather> getAllByState(String state) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ArrayList<Weather> r = new ArrayList<Weather>();
		try {
			session.beginTransaction();
			Query query = session
					.createQuery("FROM Weather as w join fetch w.stn_id as s  WHERE s.state=:type");
			query.setString("type", state);

			r = (ArrayList<Weather>) query.list();
			System.out.println(r.get(0).getId());
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}
		return r;
	}

	public double findAverageTempByState(String state, int month) {
		ArrayList<Weather> weather = new ArrayList<Weather>();
		weather = (ArrayList<Weather>) getAllByState(state);
		int size = weather.size();
		double avg = 0;
		for (int i = 0; i < size; i++) {
			Weather obj = weather.get(i);
			if (obj.getDate() != null) {
				if (obj.getDate().getMonth() == month) {
					avg += weather.get(i).getTMPF();
				}

			}
		}
		return avg / size;

	}

	public Weather findById(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Weather r = null;
		try {
			session.beginTransaction();
			r = (Weather) session.load(Weather.class, id);

			System.out.println(r.getStn_id().getStn_name());
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.printStackTrace();
		}

		return r;
	}

	protected boolean validate(Weather p) {
		if (p == null)
			return false;

		// TODO validate values
		return true;
	}

	public void updateTable(Weather weather) {
		if (!validate(weather) || weather.getId() == -1)
			throw new RuntimeException("Invalid person");

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.saveOrUpdate(weather);
			session.getTransaction().commit();
		} catch (RuntimeException e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

}
