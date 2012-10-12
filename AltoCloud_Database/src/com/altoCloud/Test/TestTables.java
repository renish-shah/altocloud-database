/**
 * 
 */
package com.altoCloud.Test;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.altoCloud.common.HibernateUtil;
import com.altoCloud.domain.level3.StationDetails;
import com.altoCloud.domain.level3.StationDetailsExtra;

/**
 * @author RENISH
 * 
 */
public class TestTables {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Session session = HibernateUtil.getSessionFactory().openSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction transaction = null;
		try {
			transaction = session.beginTransaction();

			/*
			 * Query query = session
			 * .createQuery("insert into Station_Details(stn_code, country, elev)"
			 * ); query.setParameter("stn_code", "STN_1");
			 * query.setParameter("country", "US"); query.setParameter("elev",
			 * "45.65");
			 * 
			 * int result = query.executeUpdate();
			 */
			StationDetails stationDetails1 = new StationDetails();
			stationDetails1.setStnCode("ABAUT");
			stationDetails1.setCountry("US");
			stationDetails1.setElev(34.56);
			stationDetails1.setLat(43.56);
			stationDetails1.setLon(23.47);
			stationDetails1.setMnet(8);

			/*
			 * StationDetails stationDetails2 = new StationDetails();
			 * stationDetails2.setStnCode("ABAUT");
			 * stationDetails2.setCountry("US"); stationDetails2.setElev(34.56);
			 * stationDetails2.setLat(43.56); stationDetails2.setLon(23.47);
			 * stationDetails2.setMnet(8);
			 */
			StationDetailsExtra detailsExtra = new StationDetailsExtra();
			detailsExtra.setNetworkId("network_ID1");
			detailsExtra.setPriProId("PriProID");
			detailsExtra.setSecProId("secProId");
			detailsExtra.setStnSecId("stnSecId");
			detailsExtra.setTerProId("terProId");

			stationDetails1.setStnDetailsExtra(detailsExtra);
			/*
			 * stationDetails2.setStnDetailsExtra(detailsExtra);
			 */
			// Address address1 = new Address("OMR Road", "Chennai", "TN",
			// "600097");
			// Address address2 = new Address("Ring Road", "Banglore",
			// "Karnataka", "560000");
			// Student student1 = new Student("Eswar", address1);
			// Student student2 = new Student("Joe", address2);
			// session.save(student1);

			session.save(stationDetails1);
			transaction.commit();
			System.out.println("ONe completed");
			/*
			 * session.save(stationDetails2);
			 */
			// transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}
}
