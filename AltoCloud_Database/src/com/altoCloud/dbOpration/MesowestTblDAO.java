package com.altoCloud.dbOpration;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.altoCloud.common.HibernateUtil;
import com.altoCloud.domain.MesowestTblStationInfo;

public class MesowestTblDAO {

	public static void main(String[] args) {
		new MesowestTblDAO().saveStationDetails("");
	}
	
	
	public Long saveStationDetails(String cityName) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = null;
		Long stationPrimaryId = null;
		try {
			transaction = session.beginTransaction();

			MesowestTblStationInfo stationInfo = new MesowestTblStationInfo();
			stationInfo.setCountry("US");
			// city.setName(cityName);
			stationPrimaryId = (Long) session.save(stationInfo);
			transaction.commit();
			System.out.println("Station ID:" + stationPrimaryId);
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return stationPrimaryId;
	}

	// @SuppressWarnings("unchecked")
	// public void listCities() {
	// Session session = HibernateUtil.getSessionFactory().openSession();
	// Transaction transaction = null;
	// try {
	// transaction = session.beginTransaction();
	// List<City> cities = session.createQuery("from City").list();
	//
	// for (City city : cities) {
	// System.out.println(city.getName());
	// }
	//
	// transaction.commit();
	// } catch (HibernateException e) {
	// transaction.rollback();
	// e.printStackTrace();
	// } finally {
	// session.close();
	// }
	// }
	//
	// public void updateCity(Long cityId, String cityName) {
	// Session session = HibernateUtil.getSessionFactory().openSession();
	// Transaction transaction = null;
	// try {
	// transaction = session.beginTransaction();
	// City city = (City) session.get(City.class, cityId);
	// city.setName(cityName);
	// transaction.commit();
	// } catch (HibernateException e) {
	// transaction.rollback();
	// e.printStackTrace();
	// } finally {
	// session.close();
	// }
	// }
	//
	// public void deleteCity(Long cityId) {
	// Session session = HibernateUtil.getSessionFactory().openSession();
	// Transaction transaction = null;
	// try {
	// transaction = session.beginTransaction();
	// City city = (City) session.get(City.class, cityId);
	// session.delete(city);
	// transaction.commit();
	// } catch (HibernateException e) {
	// transaction.rollback();
	// e.printStackTrace();
	// } finally {
	// session.close();
	// }
	// }
}