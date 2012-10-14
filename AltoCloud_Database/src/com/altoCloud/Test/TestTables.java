package com.altoCloud.Test;

import java.sql.Date;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.altoCloud.common.HibernateUtil;
import com.altoCloud.domain.level3.NetworkDetails;
import com.altoCloud.domain.level3.ProviderDetails;
import com.altoCloud.domain.level3.StationDetails;
import com.altoCloud.domain.level3.StationDetailsExtra;
import com.altoCloud.domain.level3.StationStatus;
import com.altoCloud.domain.level3.Weather;

/**
 * @author RENISH
 * 
 */
public class TestTables {

	public static void main(String[] args) {
		// Session session = HibernateUtil.getSessionFactory().openSession();
		new TestTables().testAllLevel3Tables();
	}

	public void testAllLevel3Tables() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Transaction transaction = null;
		try {

			transaction = session.beginTransaction();

			StationStatus stationStatus = new StationStatus();
			stationStatus.setStatus("Active");
			// session.save(stationStatus);

			NetworkDetails networkDetails = new NetworkDetails();
			networkDetails.setNetworkId("NET_ID");
			networkDetails.setNetworkName("ABAP Net Name");
			session.save(networkDetails);

			ProviderDetails priProDet = new ProviderDetails();
			priProDet.setProviderId("PRO_1");
			priProDet.setProviderName("Test PRO_1");
			session.save(priProDet);

			ProviderDetails secProDet = new ProviderDetails();
			secProDet.setProviderId("PRO_2");
			secProDet.setProviderName("Test PRO_2");
			session.save(secProDet);

			ProviderDetails terProDet = new ProviderDetails();
			terProDet.setProviderId("PRO_3");
			terProDet.setProviderName("Test PRO_3");
			session.save(terProDet);

			StationDetailsExtra detailsExtra = new StationDetailsExtra();
			detailsExtra.setStnSecId("stnSecId");
			detailsExtra.setNetworkDetails(networkDetails);
			detailsExtra.setPriProDetails(priProDet);
			detailsExtra.setSecProDetails(secProDet);
			detailsExtra.setTerProDetails(terProDet);

			StationDetails stationDetails = new StationDetails();
			stationDetails.setStnCode("AUT546");
			stationDetails.setStnDetailsExtra(detailsExtra);
			stationDetails.setStationStatus(stationStatus);

			session.save(detailsExtra);
			session.save(stationDetails);

			Weather weather = new Weather();
			weather.setTMPF(34.56);
			weather.setStationDetails(stationDetails);
			weather.setALTI(5.6);
			weather.setDate(new Date(43453));
			weather.setDRCT(56.78);
			weather.setDWPF(43.56);
			weather.setGUST(23.76);

			session.save(weather);
			transaction.commit();

		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}

	}

	public void testStationDetailsandExtraDetails() {
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
			// stationDetails1.setCountry("US");
			// stationDetails1.setElev(34.56);
			// stationDetails1.setLat(43.56);
			// stationDetails1.setLon(23.47);
			// stationDetails1.setMnet(8);

			/*
			 * StationDetails stationDetails2 = new StationDetails();
			 * stationDetails2.setStnCode("ABAUT");
			 * stationDetails2.setCountry("US"); stationDetails2.setElev(34.56);
			 * stationDetails2.setLat(43.56); stationDetails2.setLon(23.47);
			 * stationDetails2.setMnet(8);
			 */
			StationDetailsExtra detailsExtra = new StationDetailsExtra();
			// detailsExtra.setNetworkId("network_ID1");
			// detailsExtra.setPriProId("PriProID");
			// detailsExtra.setSecProId("secProId");
			detailsExtra.setStnSecId("stnSecId");
			// detailsExtra.setTerProId("terProId");

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
