package com.altoCloud.domain.level3;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Station_Details")
public class StationDetails {

	@Id
	@Column(name = "STN_CODE", unique = true, nullable = false, updatable = false)
	private String stnCode;

	@OneToOne(cascade = CascadeType.ALL)
	private StationDetailsExtra stnDetailsExtra;

	@OneToOne(cascade = CascadeType.ALL)
	private StationStatus stationStatus;

	@OneToMany(mappedBy = "stationDetails")
	private List<Weather> weather;

	@Column(name = "OTHER_ID")
	private long otherId;

	@Column(name = "STN_NAME")
	private String stnName;

	@Column(name = "STATE")
	private String state;

	@Column(name = "COUNTRY")
	private String country;

	@Column(name = "LAT")
	private double lat;

	@Column(name = "LON")
	private double lon;

	@Column(name = "ELEV")
	private double elev;

	@Column(name = "MNET")
	private int mnet;

	@Column(name = "STATUS")
	private String status;

	public String getStnCode() {
		return stnCode;
	}

	public void setStnCode(String stnCode) {
		this.stnCode = stnCode;
	}

	public StationDetailsExtra getStnDetailsExtra() {
		return stnDetailsExtra;
	}

	public void setStnDetailsExtra(StationDetailsExtra stnDetailsExtra) {
		this.stnDetailsExtra = stnDetailsExtra;
	}

	public StationStatus getStationStatus() {
		return stationStatus;
	}

	public void setStationStatus(StationStatus stationStatus) {
		this.stationStatus = stationStatus;
	}

	public List<Weather> getWeather() {
		return weather;
	}

	public void setWeather(List<Weather> weather) {
		this.weather = weather;
	}

	public long getOtherId() {
		return otherId;
	}

	public void setOtherId(long otherId) {
		this.otherId = otherId;
	}

	public String getStnName() {
		return stnName;
	}

	public void setStnName(String stnName) {
		this.stnName = stnName;
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
