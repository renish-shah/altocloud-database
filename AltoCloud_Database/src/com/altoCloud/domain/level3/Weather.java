package com.altoCloud.domain.level3;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;


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

	@ManyToOne
	@JoinColumn(name = "STN_CODE")
	private StationDetails stationDetails;

	@Column(name = "TMPF")
	private double TMPF;

	public double getTMPF() {
		return TMPF;
	}

	public void setTMPF(double tMPF) {
		TMPF = tMPF;
	}

	public StationDetails getStationDetails() {
		return stationDetails;
	}

	public void setStationDetails(StationDetails stationDetails) {
		this.stationDetails = stationDetails;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	 @Column(name = "DATE")
	 private Date date;
	
	 @Column(name = "TIME")
	 private Time time;
	// // temporary solution
	// // private String timestamp;

	
	 @Column(name = "SKNT")
	 private double SKNT;
	
	 @Column(name = "DRCT")
	 private double DRCT;
	
	 @Column(name = "GUST")
	 private double GUST;
	
	 @Column(name = "PMSL")
	 private double PMSL;
	
	 @Column(name = "ALTI")
	 private double ALTI;
	
	 @Column(name = "DWPF")
	 private double DWPF;
	
	 @Column(name = "RELH")
	 private double RELH;
	
	 @Column(name = "WTHR")
	 private double WTHR;
	
	 @Column(name = "P24I")
	 private double P24I;

	 public Date getDate() {
	 return date;
	 }
	
	 public void setDate(Date date) {
	 this.date = date;
	 }
	
	 public Time getTime() {
	 return time;
	 }
	
	 public void setTime(Time time) {
	 this.time = time;
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
