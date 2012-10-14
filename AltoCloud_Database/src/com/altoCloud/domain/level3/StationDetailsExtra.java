/**
 * 
 */
package com.altoCloud.domain.level3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

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
	@Column(name = "STN_DET_EX_ID")
	private long Id;

	@Column(name = "STN_SEC_ID")
	private String stnSecId; // station Secondary ID

	@OneToOne
	@JoinColumn(name = "NETWORK_ID")
	private NetworkDetails networkDetails;

	@OneToOne
	@JoinColumn(name = "TER_PRO_ID")
	private ProviderDetails terProDetails;

	@OneToOne
	@JoinColumn(name = "PRI_PRO_ID")
	private ProviderDetails priProDetails;

	@OneToOne
	@JoinColumn(name = "SEC_PRO_ID")
	private ProviderDetails secProDetails;

	public ProviderDetails getTerProDetails() {
		return terProDetails;
	}

	public void setTerProDetails(ProviderDetails terProDetails) {
		this.terProDetails = terProDetails;
	}

	public ProviderDetails getPriProDetails() {
		return priProDetails;
	}

	public void setPriProDetails(ProviderDetails priProDetails) {
		this.priProDetails = priProDetails;
	}

	public ProviderDetails getSecProDetails() {
		return secProDetails;
	}

	public void setSecProDetails(ProviderDetails secProDetails) {
		this.secProDetails = secProDetails;
	}

	public NetworkDetails getNetworkDetails() {
		return networkDetails;
	}

	public void setNetworkDetails(NetworkDetails networkDetails) {
		this.networkDetails = networkDetails;
	}

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getStnSecId() {
		return stnSecId;
	}

	public void setStnSecId(String stnSecId) {
		this.stnSecId = stnSecId;
	}

	// public String getNetworkId() {
	// return networkId;
	// }
	//
	// public void setNetworkId(String networkId) {
	// this.networkId = networkId;
	// }

	// public String getPriProId() {
	// return priProId;
	// }
	//
	// public void setPriProId(String priProId) {
	// this.priProId = priProId;
	// }
	//
	// public String getSecProId() {
	// return secProId;
	// }
	//
	// public void setSecProId(String secProId) {
	// this.secProId = secProId;
	// }
	//
	// public String getTerProId() {
	// return terProId;
	// }
	//
	// public void setTerProId(String terProId) {
	// this.terProId = terProId;
	// }

}
