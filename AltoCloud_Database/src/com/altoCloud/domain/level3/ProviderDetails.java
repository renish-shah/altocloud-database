/**
 * 
 */
package com.altoCloud.domain.level3;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
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

	@OneToOne(mappedBy = "priProDetails")
	private StationDetailsExtra stnDetailsExtraPri;

	@OneToOne(mappedBy = "secProDetails")
	private StationDetailsExtra stnDetailsExtraSec;

	@OneToOne(mappedBy = "terProDetails")
	private StationDetailsExtra stnDetailsExtraTer; // tertiary

	public StationDetailsExtra getStnDetailsExtraTer() {
		return stnDetailsExtraTer;
	}

	public void setStnDetailsExtraTer(StationDetailsExtra stnDetailsExtraTer) {
		this.stnDetailsExtraTer = stnDetailsExtraTer;
	}

	public StationDetailsExtra getStnDetailsExtraPri() {
		return stnDetailsExtraPri;
	}

	public void setStnDetailsExtraPri(StationDetailsExtra stnDetailsExtraPri) {
		this.stnDetailsExtraPri = stnDetailsExtraPri;
	}

	public StationDetailsExtra getStnDetailsExtraSec() {
		return stnDetailsExtraSec;
	}

	public void setStnDetailsExtraSec(StationDetailsExtra stnDetailsExtraSec) {
		this.stnDetailsExtraSec = stnDetailsExtraSec;
	}

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
