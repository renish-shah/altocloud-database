package com.altoCloud.domain;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Station_Details")
public class StationDetails {

	
	private String stn;
	private long other_id;
	//@Column(nullable = false)
	private String stn_name;
	//@Column(nullable = false)
	private String state;
	//@Column(nullable = false)
	private String country;
	//@Column(nullable = false)
	private double lat;
	//@Column(nullable = false)
	private double lon;
	//@Column(nullable = false)
	private double elev;
	//@Column(nullable = false)
	private int mnet;
	private String status;

	@Id
	@Column(name = "stn", updatable = false, nullable = false)
	public String getStn() {
		return stn;
	}

	public void setStn(String stn) {
		this.stn = stn;
	}

	public long getOther_id() {
		return other_id;
	}

	public void setOther_id(long other_id) {
		this.other_id = other_id;
	}

	public String getStn_name() {
		return stn_name;
	}

	public void setStn_name(String stn_name) {
		this.stn_name = stn_name;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	public double getElev() {
		return elev;
	}

	public void setElev(double elev) {
		this.elev = elev;
	}

	public int getMnet() {
		return mnet;
	}

	public void setMnet(int mnet) {
		this.mnet = mnet;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
