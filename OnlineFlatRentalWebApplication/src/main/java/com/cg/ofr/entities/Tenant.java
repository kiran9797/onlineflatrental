package com.cg.ofr.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Tenant implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int tenantId;
	private int age;

	@OneToOne(cascade = CascadeType.ALL)

	private FlatBooking flatbooking;

	public Tenant() {
		super();
	}


	public Tenant(int tenantId, int age, FlatBooking flatbooking) {
		super();
		this.tenantId = tenantId;
		this.age = age;
		this.flatbooking = flatbooking;
	}


	public int getTenantId() {
		return tenantId;
	}

	public void setTenantId(int tenantId) {
		this.tenantId = tenantId;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

		public FlatBooking getFlatbooking() {
		return flatbooking;
	}


	public void setFlatbooking(FlatBooking flatbooking) {
		this.flatbooking = flatbooking;
	}


	@Override
	public String toString() {
		return "Tenant [tenantId=" + tenantId + ", age=" + age + ", flatbooking=" + flatbooking + "]";
	}


		
}