package com.hibernateonemanybidirectional.pojo;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "REG_OFFICE", schema = "MYDB")
public class RegOffice implements Serializable {

	private static final long serialVersionUID = 8468635416695557588L;

	@Id
	@GeneratedValue
	@Column(name = "OID", unique = true, nullable = false)
	private Integer oId;

	@Column(name = "REG_O_ID", unique = true, nullable = false)
	private Integer regOId;

	@Column(name = "LOCATION", unique = true, nullable = false)
	private String location;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "REG_OID", nullable = false)
	private Set<Vehicle> vehicles;

	public RegOffice() {
	}

	public RegOffice(Integer regOId, String location) {
		super();
		this.regOId = regOId;
		this.location = location;
	}

	public Integer getoId() {
		return oId;
	}

	public void setoId(Integer oId) {
		this.oId = oId;
	}

	public Integer getRegOId() {
		return regOId;
	}

	public void setRegOId(Integer regOId) {
		this.regOId = regOId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set<Vehicle> getVehicles() {
		if (vehicles == null) {
			vehicles = new HashSet<Vehicle>();
		}
		return vehicles;
	}

	public void setVehicles(Set<Vehicle> vehicles) {
		this.vehicles = vehicles;
	}

	@Override
	public String toString() {
		final int maxLen = 10;
		return "RegOffice [oId=" + oId + ", regOId=" + regOId + ", location="
				+ location + ", vehicles="
				+ (vehicles != null ? toString(vehicles, maxLen) : null) + "]";
	}

	private String toString(Collection<?> collection, int maxLen) {
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int i = 0;
		for (Iterator<?> iterator = collection.iterator(); iterator.hasNext()
				&& i < maxLen; i++) {
			if (i > 0)
				builder.append(", ");
			builder.append(iterator.next());
		}
		builder.append("]");
		return builder.toString();
	}

}
