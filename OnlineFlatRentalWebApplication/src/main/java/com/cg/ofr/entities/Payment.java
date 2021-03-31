package com.cg.ofr.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity

public class Payment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue

	private int paymentId;

	@OneToOne(cascade = CascadeType.ALL)

	private FlatBooking flatBooking;
	private String status;
	
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public FlatBooking getFlatBooking() {
		return flatBooking;
	}
	public void setFlatBooking(FlatBooking flatBooking) {
		this.flatBooking = flatBooking;
	}
	public Payment(int paymentId,String status, FlatBooking flatBooking) {
		super();
		this.paymentId = paymentId;
		this.status = status;
		this.flatBooking = flatBooking;
	}
	public Payment() {
		super();
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", status=" + status + ", flatBooking="
				+ flatBooking + "]";
	}

	

}