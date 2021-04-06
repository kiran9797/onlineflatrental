package com.cg.ofr.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity

public class Payment implements Serializable {


	private static final long serialVersionUID = 1L;
	@Id

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

	public Payment(int paymentId, FlatBooking flatBooking,String status) {
		super();
		this.paymentId = paymentId;
		this.flatBooking = flatBooking;
		this.status = status;
	}

	public Payment() {
		super();
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", status=" + status + ", flatBooking=" + flatBooking + "]";
	}

}