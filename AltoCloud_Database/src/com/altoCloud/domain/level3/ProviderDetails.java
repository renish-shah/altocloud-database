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
@Table(name = "Provider_Details")
public class ProviderDetails {

	@Id
	@Column(name = "provider_id", unique = true, nullable = false)
	private String providerId;
	
	@Column(name = "provider_name", unique = true, nullable = false)
	private String providerName;

	public String getProviderId() {
		return providerId;
	}

	public void setProviderId(String providerId) {
		this.providerId = providerId;
	}

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}
	

	
}
