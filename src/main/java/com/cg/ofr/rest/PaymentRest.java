package com.cg.ofr.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Payment;
import com.cg.ofr.exception.PaymentNotFoundException;
import com.cg.ofr.service.IPaymentService;

import io.swagger.annotations.Api;


/****************************
 * @author         Nishitha.
 * Description     It is a controller class that controls the
          		   data flow into model object and updates the view whenever data
           		   changes Version 1.0 Created Date 26-MARCH-2021
 ****************************/
@RestController
@Api(value = "Swagger2DemoRestController")
public class PaymentRest {

	@Autowired
	private IPaymentService paymentService;
	/****************************
	 * Method: 					addPayment
	 * Description: 			It is used to add payment into Payment table 
	 * @param Payment: 		    Payment's reference variable.
	 * @returns Payment         It returns Payment with details
	 * @PostMapping:            It is used to handle POST type of request method
	 * @RequestBody:            It maps the HttpRequest body to a transfer or domain object
	 * Created By               Nishitha.
	 * Created Date             26-MARCH-2021
	 * 
	 ****************************/
	


	@PostMapping("/payment")
	public Payment addPayment(@RequestBody Payment payment) {
		Payment payment1 = paymentService.addPayment(payment);
		return payment1;
	}
	/****************************
	 * Method: 			getPaymentDetails
	 * Description: 	To display the payment details by Id (Primary key) 
	 * @param id: 		id of the payment.
	 * @returns Payment - If Payment with Id presents it returns Payment else throws
	                      PaymentNotFoundException
	 * @throws PaymentNotFoundException - It is raised due to invalid PaymentId
	 * @GetMapping:      It is used to handle GET type of request method.
	 * @PathVariable:    It is used for data passed in the URI and transfer its values
	                     to parameter variables. 
	 * Created By        Nishitha.
	 * Created Date     26-MARCH-2021
	 
	 ****************************/
	


	@GetMapping("/payment/{id}")
	public Payment getPaymentDetails(@PathVariable("id") int id) throws PaymentNotFoundException {
		Payment payment1 = paymentService.getPaymentDetails(id);
		return payment1;
	}
	/****************************
	 * Method: 						updatePayment
	 * Description: 				It is used to update Payment details into 
	 * 								Payment table.
	 * @param Payment: 			    Payment's reference variable.
	 * @returns Payment			    It returns updated details of the existed Payment.
	 * @PuttMapping: 				It is used to handle PUT type of request method
	 * @RequestBody: 				It maps the HttpRequest body to a transfer or domain object
	 * Created By 					Nishitha.
	 * Created Date                 26-MARCH-2021
	 * 
	 ****************************/
	


	@PutMapping("/payment")
	public Payment updatePayment(@RequestBody Payment payment) {
		Payment payment1 = paymentService.updatePayment(payment);
		return payment1;
	}
	/****************************
	 * Method: 						   deletePayment
	 * Description: 				   It is used to delete payment.
	 * @param Payment:			       Payment's reference variable.
	 * @returns Payment                It returns the payment that has been deleted
	 * @throws PaymentNotFoundException:  It is raised due to invalid payment details.
	 * @DeleteMapping:                 It is used to handle DELETE type of request method.
	 * @RequestBody:                   It maps the HttpRequest body to a transfer 
	 								   or domain object
	 * Created By                      Nishitha.
	 * Created Date -                  26-MARCH-2021
	 * 
	 ****************************/
	


	@DeleteMapping("/payment")
	public Payment deletePayment(@RequestBody Payment payment) {
		Payment payment1 = paymentService.deletePayment(payment);
		return payment1;
	}
	/****************************
	 * Method: 				getAllPaymentDetails
	 * Description: 		To display all the payment details.
	 * 
	 * @returns List<Payment>  It returns all the payment details present in database
	 * @GetMapping: 		It is used to handle GET type of request method.
	 * Created By           Nishitha.
	 * Created Date         26-MARCH-2021
	 * 
	 ****************************/

	@GetMapping("/payments")
	public List<Payment> getAllPaymentDetails() {
		List<Payment> payments = paymentService.getAllPaymentDetails();
		return payments;
	}
}