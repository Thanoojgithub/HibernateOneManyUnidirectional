package com.hibernateonemanybidirectional.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "VEHICLE", schema = "MYDB")
public class Vehicle implements Serializable {

	private static final long serialVersionUID = 1678793790517725816L;

	@Id
	@GeneratedValue
	@Column(name = "VID", unique = true, nullable = false)
	private Integer vId;

	@Column(name = "V_REGNO", unique = true, nullable = false)
	private Integer vRegNo;

	public Vehicle() {
	}

	public Vehicle(Integer vRegNo) {
		super();
		this.vRegNo = vRegNo;
	}

	public Integer getvId() {
		return vId;
	}

	public void setvId(Integer vId) {
		this.vId = vId;
	}

	public Integer getvRegNo() {
		return vRegNo;
	}

	public void setvRegNo(Integer vRegNo) {
		this.vRegNo = vRegNo;
	}

	@Override
	public String toString() {
		return "Vehicle [vId=" + vId + ", vRegNo=" + vRegNo + "]";
	}
}
