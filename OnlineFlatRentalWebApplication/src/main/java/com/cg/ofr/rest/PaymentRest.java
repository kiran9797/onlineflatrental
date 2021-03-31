package com.cg.ofr.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Payment;
import com.cg.ofr.service.IPaymentService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/payment")
@Api(value = "Swagger2DemoRestController")



public class PaymentRest {

	@Autowired
	private IPaymentService paymentService;

	@PostMapping("/add")
	public Payment addPayment(@RequestBody Payment payment) {
		Payment payment1=paymentService.addPayment(payment);
		return payment1;
	}

	@GetMapping("/get/{id}")
	public Payment getPaymentDetails(@PathVariable ("id") int id) {
		Payment payment1=paymentService.getPaymentDetails(id);
		return payment1;
	}

	@PutMapping("/update")
	public Payment updatePayment(@RequestBody Payment payment) {
		Payment payment1=paymentService.updatePayment(payment);
		return payment1;
	}

	@DeleteMapping("/delete")
	public Payment deletePayment(@RequestBody Payment payment) {
		Payment payment1=paymentService.deletePayment(payment);
		return payment1;
	}

	@GetMapping("/getAll")
	public List<Payment> getAllPaymentDetails() {
		List<Payment> payments=paymentService.getAllPaymentDetails();
		return payments;
	}
}