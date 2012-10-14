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
 * @author RENISH
 * 
 */
@Entity
@Table(name = "STATION_STATUS")
public class StationStatus {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private long id;
	
	@Column(name = "STATUS")
	private String status;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
