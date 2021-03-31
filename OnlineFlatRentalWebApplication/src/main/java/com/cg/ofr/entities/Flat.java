package com.cg.ofr.entities;

import java.io.Serializable;


import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;


import org.springframework.stereotype.Component;

@Component
@Entity
public class Flat implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int flatId;
	private float cost;

	@Embedded
	private FlatAddress flatAddress;

	private String availibilty;

	public int getFlatId() {
		return flatId;
	}

	public void setFlatId(int flatId) {
		this.flatId = flatId;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public FlatAddress getFlatAddress() {
		return flatAddress;
	}

	public void setFlatAddress(FlatAddress flatAddress) {
		this.flatAddress = flatAddress;
	}

	public String getAvailibilty() {
		return availibilty;
	}

	public void setAvailibilty(String availibilty) {
		this.availibilty = availibilty;
	}

	@Override
	public String toString() {
		return "Flat [flatId=" + flatId + ", cost=" + cost + ", flatAddress=" + flatAddress + ", availibilty="
				+ availibilty + "]";
	}

	public Flat(int flatId, float cost, FlatAddress flatAddress, String availibilty) {
		super();
		this.flatId = flatId;
		this.cost = cost;
		this.flatAddress = flatAddress;
		this.availibilty = availibilty;
	}

	public Flat() {
		super();
	}

	
}