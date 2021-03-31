package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.Payment;

public interface IPaymentService {
	public Payment addPayment(Payment payment);

	public Payment getPaymentDetails(int id);

	public Payment updatePayment(Payment payment);

	public Payment deletePayment(Payment payment);

	public List<Payment> getAllPaymentDetails();
}
