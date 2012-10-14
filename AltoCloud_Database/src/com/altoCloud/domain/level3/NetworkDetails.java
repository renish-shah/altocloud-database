/**
 * 
 */
package com.altoCloud.domain.level3;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author RENISH
 * 
 */
@Entity
@Table(name = "Network_Details")
public class NetworkDetails {

	@Id
	@Column(name = "network_id", nullable = false)
	private String networkId;

	@Column(name = "network_name", nullable = false)
	private String networkName;

	@OneToOne(mappedBy = "networkDetails")
	private StationDetailsExtra stnDetailsExtra;

	public StationDetailsExtra getStnDetailsExtra() {
		return stnDetailsExtra;
	}

	public void setStnDetailsExtra(StationDetailsExtra stnDetailsExtra) {
		this.stnDetailsExtra = stnDetailsExtra;
	}

	public String getNetworkId() {
		return networkId;
	}

	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}

	public String getNetworkName() {
		return networkName;
	}

	public void setNetworkName(String networkName) {
		this.networkName = networkName;
	}

}
