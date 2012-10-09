package com.altoCloud.domain;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Station_Details_extra")
public class Station_Details_extra implements Serializable{

	
	//private String stn;
	private Station_Details stn_details;
	private String secondary_id;
	/*
	 * @Column(nullable = false) private String stn_name;
	 * 
	 * @Column(nullable = false) private String state;
	 * 
	 * @Column(nullable = false) private String country;
	 * 
	 * @Column(nullable = false) private double lat;
	 * 
	 * @Column(nullable = false) private double lon;
	 * 
	 * @Column(nullable = false) private double elev;
	 * 
	 * @Column(nullable = false) private int mnet;
	 */
	
	private String network_name;
	
	private int primary_provider_id;
	//@Column(nullable = false)
	private String primary_provider;
	private int secondary_provider_id;
	private String secondary_provider;
	private int tertiary_provider_id;
	private String tertiary_provider;
	private String status;
//	@Id
//	@Column(name = "stn", updatable = false, nullable = false)
//	 public String getStn() {
//	 return stn;
//	 }
//	
//	 public void setStn(String stn) {
//	 this.stn = stn;
//	 }

	public String getSecondary_id() {
		return secondary_id;
	}

	public void setSecondary_id(String secondary_id) {
		this.secondary_id = secondary_id;
	}

	// public String getStn_name() {
	// return stn_name;
	// }
	//
	// public void setStn_name(String stn_name) {
	// this.stn_name = stn_name;
	// }
	//
	// public String getState() {
	// return state;
	// }
	//
	// public void setState(String state) {
	// this.state = state;
	// }
	//
	// public String getCountry() {
	// return country;
	// }
	//
	// public void setCountry(String country) {
	// this.country = country;
	// }
	//
	// public double getLat() {
	// return lat;
	// }
	//
	// public void setLat(double lat) {
	// this.lat = lat;
	// }
	//
	// public double getLon() {
	// return lon;
	// }
	//
	// public void setLon(double lon) {
	// this.lon = lon;
	// }
	//
	// public double getElev() {
	// return elev;
	// }
	//
	// public void setElev(double elev) {
	// this.elev = elev;
	// }
	//
	// public int getMnet() {
	// return mnet;
	// }
	//
	// public void setMnet(int mnet) {
	// this.mnet = mnet;
	// }
	@Column(nullable = false)
	public String getNetwork_name() {
		return network_name;
	}

	public void setNetwork_name(String network_name) {
		this.network_name = network_name;
	}
	@Column(nullable = false)
	public int getPrimary_provider_id() {
		return primary_provider_id;
	}

	public void setPrimary_provider_id(int primary_provider_id) {
		this.primary_provider_id = primary_provider_id;
	}
	@Column(nullable = false)
	public String getPrimary_provider() {
		return primary_provider;
	}

	public void setPrimary_provider(String primary_provider) {
		this.primary_provider = primary_provider;
	}

	public int getSecondary_provider_id() {
		return secondary_provider_id;
	}

	public void setSecondary_provider_id(int secondary_provider_id) {
		this.secondary_provider_id = secondary_provider_id;
	}

	public String getSecondary_provider() {
		return secondary_provider;
	}

	public void setSecondary_provider(String secondary_provider) {
		this.secondary_provider = secondary_provider;
	}

	public int getTertiary_provider_id() {
		return tertiary_provider_id;
	}

	public void setTertiary_provider_id(int tertiary_provider_id) {
		this.tertiary_provider_id = tertiary_provider_id;
	}

	public String getTertiary_provider() {
		return tertiary_provider;
	}

	public void setTertiary_provider(String tertiary_provider) {
		this.tertiary_provider = tertiary_provider;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	public Station_Details getStn_details() {
		return this.stn_details;
	}
	public void setStn_details(Station_Details stn_details) {
		this.stn_details = stn_details;
	}

}
