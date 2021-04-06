package com.cg.ofr.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.ofr.entities.Payment;
import com.cg.ofr.exception.EmptyEntityListException;
import com.cg.ofr.exception.EntityCreationException;
import com.cg.ofr.exception.EntityDeletionException;

import com.cg.ofr.exception.EntityUpdationException;
import com.cg.ofr.exception.PaymentNotFoundException;
import com.cg.ofr.repository.IPaymentRepository;

/****************************
 * @author Nishitha. Description It is a payment service implementation class
 *         that defines the methods mentioned in its interface. Version 1.0
 *         Created Date 24-MARCH-2021
 ****************************/
@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {
	@Autowired
	private IPaymentRepository paymentRepository;

	/****************************
	 * Method: addPayment Description: It is used to add Payment into Payment table
	 * 
	 * @param Payment: Payment's reference variable.
	 * @returns Payment It returns Payment with details Created By Nishitha. Created
	 *          Date 24-MARCH-2021
	 * 
	 ****************************/
	@Override
	public Payment addPayment(Payment payment) {
		try {
			return paymentRepository.save(payment);
		} catch (Exception e) {
			throw new EntityCreationException(e.getMessage());
		}

	}

	/****************************
	 * Method: getPaymentDetails Description: To display the Payment details by Id
	 * (Primary key)
	 * 
	 * @param id: Payment id of the tenant.
	 * @returns Payment if Payment with Id presents it returns payment details else
	 *          throws PaymentNotFoundException
	 * @throws PaymentNotFoundException It is raised due to invalid PaymentId
	 *                                  Created By Nishitha. Created Date
	 *                                  24-MARCH-2021
	 * 
	 ****************************/

	@Override
	public Payment getPaymentDetails(int id) throws PaymentNotFoundException {
		try {
			Optional<Payment> payment = paymentRepository.findById(id);
			if (payment.isPresent()) {

				return payment.get();
			} else {
				throw new PaymentNotFoundException("the payment with id " + id + " is not found");
			}
		} catch (Exception e) {
			throw new PaymentNotFoundException(e.getMessage());
		}
	}

	/****************************
	 * Method: updatePayment Description: It is used to update Payment details into
	 * Payment table.
	 * 
	 * @param Payment Payment's reference variable.
	 * @returns Payment It returns updated details of the existed payment. Created
	 *          By Nishitha. Created Date 24-MARCH-2021
	 * 
	 ****************************/
	@Override
	public Payment updatePayment(Payment payment) {
		try {

			Optional<Payment> payment1 = paymentRepository.findById(payment.getPaymentId());
			if (payment1.isPresent()) {
				Payment payment2 = paymentRepository.save(payment);
				return payment2;
			} else {
				throw new EntityUpdationException("cannot update payment with id " + payment.getPaymentId());
			}
		} catch (Exception e) {
			throw new EntityUpdationException(e.getMessage());
		}
	}

	/****************************
	 * Method: deletePayment Description: It is used to remove payment
	 * 
	 * @param Payment: Payment's reference variable.
	 * @returns Payment It returns the Payment that has been deleted
	 * @throws PaymentNotFoundException:It is raised due to invalid Payment. Created
	 *                                     By Nishitha. Created Date 24-MARCH-2021
	 * 
	 ****************************/

	@Override
	public Payment deletePayment(Payment payment) {

		try {
			Optional<Payment> payment1 = paymentRepository.findById(payment.getPaymentId());
			if (payment1.isPresent()) {
				paymentRepository.delete(payment);
			}
			return payment1.get();
		} catch (Exception e) {
			throw new EntityDeletionException("Invalid payment details");
		}

	}

	/****************************
	 * Method: getAllPaymentDetails Description: To display payment details of all
	 * tenants.
	 * 
	 * @returns List<Payment> It returns payment details of all tenants. Created By
	 *          Nishitha. Created Date 24-MARCH-2021
	 * 
	 ****************************/

	@Override
	public List<Payment> getAllPaymentDetails() {

		List<Payment> payments = new ArrayList<>();
		try {
			payments = paymentRepository.findAll();
			if (payments.isEmpty()) {
				throw new EmptyEntityListException("no payments found");
			} else {
				return payments;
			}

		} catch (Exception e) {
			throw new EmptyEntityListException(e.getMessage());
		}
	}

}