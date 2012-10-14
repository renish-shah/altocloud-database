package com.altoCloud.domain;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Weather")
public class Weather implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "weather_Id")
	private long id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "stn")
	private StationDetails stnDetails;

	
	// private Date date;
	// private Time time;
	// temporary solution
	
	private String timestamp;
	private String MNET;
	private String SLAT;
	private String SLON;
	private String SELV;
	
	private double TMPF;
	private double SKNT;
	private double DRCT;
	private double GUST;
	private double PMSL;
	private double ALTI;
	private double DWPF;
	private double RELH;
	private double WTHR;
	private double P24I;

	public String getMNET() {
		return MNET;
	}

	public void setMNET(String mNET) {
		MNET = mNET;
	}

	public String getSLAT() {
		return SLAT;
	}

	public void setSLAT(String sLAT) {
		SLAT = sLAT;
	}

	public String getSLON() {
		return SLON;
	}

	public void setSLON(String sLON) {
		SLON = sLON;
	}

	public String getSELV() {
		return SELV;
	}

	public void setSELV(String sELV) {
		SELV = sELV;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	// @ManyToOne(cascade = CascadeType.ALL)

	public StationDetails getStnDetails() {
		return stnDetails;
	}

	public void setStnDetails(StationDetails stn) {
		this.stnDetails = stn;
	}

	/*
	 * public Date getDate() { return date; }
	 * 
	 * public void setDate(Date date) { this.date = date; }
	 * 
	 * public Time getTime() { return time; }
	 * 
	 * public void setTime(Time time) { this.time = time; }
	 */
	public double getTMPF() {
		return TMPF;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public void setTMPF(double tMPF) {
		TMPF = tMPF;
	}

	public double getSKNT() {
		return SKNT;
	}

	public void setSKNT(double sKNT) {
		SKNT = sKNT;
	}

	public double getDRCT() {
		return DRCT;
	}

	public void setDRCT(double dRCT) {
		DRCT = dRCT;
	}

	public double getGUST() {
		return GUST;
	}

	public void setGUST(double gUST) {
		GUST = gUST;
	}

	public double getPMSL() {
		return PMSL;
	}

	public void setPMSL(double pMSL) {
		PMSL = pMSL;
	}

	public double getALTI() {
		return ALTI;
	}

	public void setALTI(double aLTI) {
		ALTI = aLTI;
	}

	public double getDWPF() {
		return DWPF;
	}

	public void setDWPF(double dWPF) {
		DWPF = dWPF;
	}

	public double getRELH() {
		return RELH;
	}

	public void setRELH(double rELH) {
		RELH = rELH;
	}

	public double getWTHR() {
		return WTHR;
	}

	public void setWTHR(double wTHR) {
		WTHR = wTHR;
	}

	public double getP24I() {
		return P24I;
	}

	public void setP24I(double p24i) {
		P24I = p24i;
	}

}
