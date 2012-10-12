/**
 * 
 */
package com.altoCloud.domain.level3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author RENISH mesowest_csv.tbl - updates every 2 hours
 * 
 */
@Entity
@Table(name = "STN_DETAILS_EXTRA")
public class StationDetailsExtra {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	private long id;

	@Column(name = "STN_SEC_ID")
	private String stnSecId; // station Secondary ID

	@Column(name = "NETWORK_ID")
	private String networkId;

	@Column(name = "PRI_PRO_ID")
	private String priProId; // primary provider ID

	@Column(name = "SEC_PRO_ID")
	private String secProId; // Secondary provider ID

	@Column(name = "TER_PRO_ID")
	private String terProId; // tertiary provider ID

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getStnSecId() {
		return stnSecId;
	}

	public void setStnSecId(String stnSecId) {
		this.stnSecId = stnSecId;
	}

	public String getNetworkId() {
		return networkId;
	}

	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}

	public String getPriProId() {
		return priProId;
	}

	public void setPriProId(String priProId) {
		this.priProId = priProId;
	}

	public String getSecProId() {
		return secProId;
	}

	public void setSecProId(String secProId) {
		this.secProId = secProId;
	}

	public String getTerProId() {
		return terProId;
	}

	public void setTerProId(String terProId) {
		this.terProId = terProId;
	}

}
