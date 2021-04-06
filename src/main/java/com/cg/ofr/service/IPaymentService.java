package com.cg.ofr.service;

import java.util.List;

import com.cg.ofr.entities.Payment;

import com.cg.ofr.exception.PaymentNotFoundException;

/**
 * This is an interface for payment service with methods of
 * add,update,delete,get and getall payments
 * 
 * @author Nishitha.
 * 
 **/

public interface IPaymentService {

	public Payment addPayment(Payment payment);

	public Payment getPaymentDetails(int id) throws PaymentNotFoundException;

	public Payment deletePayment(Payment payment);

	public List<Payment> getAllPaymentDetails();

	public Payment updatePayment(Payment payment);
}