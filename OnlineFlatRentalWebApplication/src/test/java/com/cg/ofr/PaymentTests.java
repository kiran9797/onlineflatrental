package com.cg.ofr;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.entities.FlatAddress;
import com.cg.ofr.entities.FlatBooking;
import com.cg.ofr.entities.Payment;
import com.cg.ofr.entities.Tenant;

import com.cg.ofr.exception.PaymentNotFoundException;

import com.cg.ofr.service.IPaymentService;

@SpringBootTest
public class PaymentTests extends OnlineFlatRentalApplicationTests {

	@Autowired
	private IPaymentService paymentService;

	@Test
	public void addPaymentTest1() {

		FlatAddress flatAddress = new FlatAddress(100, "9", "hyderabad", "telangana", 500092, "India");
		Flat flat = new Flat(1001, 100000, flatAddress, "yes");
		Tenant tenant = new Tenant(21, 20, null);
		FlatBooking flatBooking = new FlatBooking(151, LocalDate.of(2020, 11, 21), LocalDate.of(2025, 11, 21), flat,
				tenant);
		tenant.setFlatbooking(flatBooking);
		Payment payment = new Payment(121, flatBooking, "not paid");
		assertNotNull(payment.getStatus());

	}

	@Test
	public void addPaymentTest2() {

		FlatAddress flatAddress = new FlatAddress(121, "9", "hyderabad", "telangana", 500092, "India");
		Flat flat = new Flat(1021, 100000, flatAddress, "yes");
		Tenant tenant = new Tenant(61, 20, null);
		FlatBooking flatBooking = new FlatBooking(191, LocalDate.of(2020, 11, 21), LocalDate.of(2025, 11, 21), flat,
				tenant);
		tenant.setFlatbooking(flatBooking);
		Payment payment = new Payment(131, flatBooking, "not paid");
		assertNotNull(payment.getStatus());

	}

	@Test
	public void getPaymentTest1() throws PaymentNotFoundException {
		FlatAddress flatAddress = new FlatAddress(1991, "9", "hyderabad", "telangana", 500092, "India");
		Flat flat = new Flat(1352, 100000, flatAddress, "no");
		Tenant tenant = new Tenant(202, 20, null);
		FlatBooking flatBooking = new FlatBooking(1502, LocalDate.of(2020, 11, 21), LocalDate.of(2025, 11, 21), flat,
				tenant);
		tenant.setFlatbooking(flatBooking);
		Payment payment = new Payment(1252, flatBooking, "not paid");
		paymentService.addPayment(payment);
		Payment paymentTest = paymentService.getPaymentDetails(payment.getPaymentId());
		assertEquals(payment.getPaymentId(), paymentTest.getPaymentId());
		paymentService.deletePayment(payment);
	}

	@Test
	public void getPaymentTest2() throws PaymentNotFoundException {
		FlatAddress flatAddress = new FlatAddress(1229, "9", "hyderabad", "telangana", 500092, "India");
		Flat flat = new Flat(1932, 100000, flatAddress, "no");
		Tenant tenant = new Tenant(6033, 20, null);
		FlatBooking flatBooking = new FlatBooking(1902, LocalDate.of(2020, 11, 21), LocalDate.of(2025, 11, 21), flat,
				tenant);
		tenant.setFlatbooking(flatBooking);
		Payment payment = new Payment(132, flatBooking, "not paid");
		paymentService.addPayment(payment);
		Payment paymentTest = paymentService.getPaymentDetails(payment.getPaymentId());
		assertEquals(payment.getPaymentId(), paymentTest.getPaymentId());
		paymentService.deletePayment(payment);

	}

	@Test
	public void updatePaymentTest1() {
		FlatAddress flatAddress = new FlatAddress(1020, "9", "hyderabad", "telangana", 500092, "India");
		Flat flat = new Flat(1003, 100000, flatAddress, "yes");
		Tenant tenant = new Tenant(23, 20, null);
		FlatBooking flatBooking = new FlatBooking(153, LocalDate.of(2020, 11, 21), LocalDate.of(2025, 11, 21), flat,
				tenant);
		tenant.setFlatbooking(flatBooking);
		Payment payment = new Payment(123, flatBooking, "not paid");
		paymentService.addPayment(payment);
		Payment paymentNew = new Payment(123, flatBooking, "paid");
		Payment testPayment = paymentService.updatePayment(paymentNew);
		assertEquals(paymentNew.getStatus(), testPayment.getStatus());
		paymentService.deletePayment(payment);
	}

	@Test
	public void updatePaymentTest2() {
		FlatAddress flatAddress = new FlatAddress(1992, "9", "hyderabad", "telangana", 500092, "India");
		Flat flat = new Flat(1693, 100000, flatAddress, "yes");
		Tenant tenant = new Tenant(163, 20, null);
		FlatBooking flatBooking = new FlatBooking(1883, LocalDate.of(2020, 11, 21), LocalDate.of(2025, 11, 21), flat,
				tenant);
		tenant.setFlatbooking(flatBooking);
		Payment payment = new Payment(1343, flatBooking, "not paid");
		paymentService.addPayment(payment);
		Payment paymentNew = new Payment(1343, flatBooking, "paid");
		Payment testPayment = paymentService.updatePayment(paymentNew);
		assertEquals(paymentNew.getStatus(), testPayment.getStatus());
		paymentService.deletePayment(payment);

	}

	@Test
	public void deletePaymentTest1() {
		FlatAddress flatAddress = new FlatAddress(199, "9", "hyderabad", "telangana", 500092, "India");
		Flat flat = new Flat(199, 100000, flatAddress, "yes");
		Tenant tenant = new Tenant(199, 20, null);
		FlatBooking flatBooking = new FlatBooking(199, LocalDate.of(2020, 11, 21), LocalDate.of(2025, 11, 21), flat,
				tenant);
		tenant.setFlatbooking(flatBooking);
		Payment payment = new Payment(1999, flatBooking, "paid");
		paymentService.addPayment(payment);
		Payment paymentTest = paymentService.deletePayment(payment);
		assertNotNull(paymentTest);

	}

	@Test
	public void deletePaymentTest2() {
		FlatAddress flatAddress = new FlatAddress(1610, "9", "hyderabad", "telangana", 500092, "India");
		Flat flat = new Flat(1111, 100000, flatAddress, "yes");
		Tenant tenant = new Tenant(101, 20, null);
		FlatBooking flatBooking = new FlatBooking(1231, LocalDate.of(2020, 11, 21), LocalDate.of(2025, 11, 21), flat,
				tenant);
		tenant.setFlatbooking(flatBooking);
		Payment payment = new Payment(136, flatBooking, "paid");
		paymentService.addPayment(payment);
		Payment paymentTest = paymentService.deletePayment(payment);
		assertNotNull(paymentTest);

	}

	@Test
	public void getAllPaymentTest1() {
		assertNotNull(paymentService.getAllPaymentDetails());

	}

}