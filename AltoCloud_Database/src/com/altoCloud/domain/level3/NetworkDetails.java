/**
 * 
 */
package com.altoCloud.domain.level3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * @author RENISH
 *
 */
@Entity
@Table(name = "Network_Details")
public class NetworkDetails {

	@Id
	@Column(name = "network_id", unique = true, nullable = false)
	private String networkId;
	
	@Column(name = "network_name", unique = true, nullable = false)
	private String networkName;
	
	
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
