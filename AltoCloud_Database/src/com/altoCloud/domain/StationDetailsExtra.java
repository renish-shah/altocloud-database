package com.altoCloud.domain;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "station_extra_details")
public class StationDetailsExtra implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	private StationDetails stn_details;
	
	private String secondary_id;
	private String network_id;
	@Column(nullable = false)
	private String network_name;
	@Column(nullable = false)
	private int primary_provider_id;
	@Column(nullable = false)
	private String primary_provider;
	private int secondary_provider_id;
	private String secondary_provider;
	private int tertiary_provider_id;
	private String tertiary_provider;
	private String status;

	public String getSecondary_id() {
		return secondary_id;
	}

	public void setSecondary_id(String secondary_id) {
		this.secondary_id = secondary_id;
	}

	public String getNetwork_id() {
		return network_id;
	}

	public void setNetwork_id(String network_id) {
		this.network_id = network_id;
	}
	public String getNetwork_name() {
		return network_name;
	}

	public void setNetwork_name(String network_name) {
		this.network_name = network_name;
	}
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
	public StationDetails getStn_details() {
		return this.stn_details;
	}
	public void setStn_details(StationDetails stn_details) {
		this.stn_details = stn_details;
	}

}
