package com.altoCloud.dbOpration;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.altoCloud.common.HibernateUtil;
import com.altoCloud.domain.StationDetails;
import com.altoCloud.domain.Station_Details;
import com.altoCloud.domain.Station_Details_extra;
import com.altoCloud.domain.Weather;



public class Create_Db {
	
	public static void main(String[] args) {
		System.out.println("Loading data to pplhib");
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		com.altoCloud.domain.Weather weather= new Weather();
		Weather wr= new Weather();
		StationDetails station_Details1= new StationDetails();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			
			station_Details1.setStn("kaya");
			station_Details1.setStn_name("kaya");
			station_Details1.setCountry("us");
			station_Details1.setElev(1234);
			station_Details1.setLat(23.34);
			station_Details1.setLon(12.89);
			station_Details1.setMnet(8);
			station_Details1.setOther_id(6357);
			station_Details1.setState("tx");
			
			Station_Details_extra extra= new Station_Details_extra();
			extra.setNetwork_name("dhg");
			extra.setPrimary_provider("fsg");
			extra.setPrimary_provider_id(1);
			
			
			weather.setStnDetails(station_Details1);
			extra.setStn_details(station_Details1);
			
			session.save(station_Details1);
			session.save(extra);
			//session.delete(station_Details1);
			wr.setStn_id(station_Details1);
			
			transaction.commit();
		} catch (HibernateException e) {
			transaction.rollback();
			e.printStackTrace();
		} 
		
		WeatherQuery qr= new WeatherQuery();
		qr.add(weather);
		qr.findById(1);
		qr.getAllByStationId(wr);
		//qr.getAllByMnetId(8);
		qr.getAllByState("tx");
		qr.findAverageTempByState("tx", 8);
		Weather obj= new Weather();
		obj.setStn_id(station_Details1);
		qr.add(obj);
		
		qr.getAllByMnetId(8);
		
		StationDetailsExtraQuery ex= new StationDetailsExtraQuery();
		ex.getAllByMnetId("kaya");
		
	}


}
