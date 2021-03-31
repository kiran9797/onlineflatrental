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
import com.cg.ofr.exception.EntityNotFoundException;
import com.cg.ofr.exception.EntityUpdationException;
import com.cg.ofr.repository.IPaymentRepository;

@Service
@Transactional
public class PaymentServiceImpl implements IPaymentService {
	@Autowired
	private IPaymentRepository paymentRepository;

	@Override
	public Payment addPayment(Payment payment) {

		try {
			return paymentRepository.save(payment);
		} catch (Exception e) {
			throw new EntityCreationException(e.getMessage());
		}

	}

	@Override
	public Payment getPaymentDetails(int id) {
		try {
			Optional<Payment> payment = paymentRepository.findById(id);
			if (payment.isPresent()) {

				return payment.get();
			} else {
				throw new EntityNotFoundException("the payment with id " + id + " is not found");
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public Payment updatePayment(Payment payment) {
		try {

			Optional<Payment> payment1 = paymentRepository.findById(payment.getPaymentId());
			if (payment1.isPresent()) {
				Payment payment2 = paymentRepository.save(payment);
				return payment2;
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new EntityUpdationException(e.getMessage());
		}
	}

	@Override
	public Payment deletePayment(Payment payment) {

		try {
			Optional<Payment> payment1 = paymentRepository.findById(payment.getPaymentId());
			if (payment1.isPresent()) {
				paymentRepository.delete(payment);
				return payment1.get();
			} else {
				return null;
			}
		} catch (Exception e) {
			throw new EntityDeletionException(e.getMessage());
		}
	}

	@Override
	public List<Payment> getAllPaymentDetails() {
		// TODO Auto-generated method stub
		List<Payment> payments = new ArrayList<>();
		try {
			payments = paymentRepository.findAll();
			if (payments.isEmpty()) {
				throw new EmptyEntityListException("no payments found");
			} else {
				return payments;
			}

		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}