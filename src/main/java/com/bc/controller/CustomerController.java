

package com.bc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bc.exception.CustomerException;
import com.bc.exception.FeedbackException;
import com.bc.model.Customer;
import com.bc.model.Feedback;
import com.bc.service.CustomerService;
import com.bc.service.FeedbackService;





@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService cService;
	
	@Autowired
	private FeedbackService feedbackService;

	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer c) throws CustomerException {
		return new ResponseEntity<Customer>(cService.addCustomer(c), HttpStatus.OK);
	}

	@PutMapping("/update")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer c) throws CustomerException {
		return new ResponseEntity<Customer>(cService.updateCustomer(c), HttpStatus.OK);
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Customer> removeCustomerById(@PathVariable("id") Integer customerId) throws CustomerException {
		return new ResponseEntity<Customer>(cService.remove(customerId), HttpStatus.OK);
	}

	@GetMapping("/view")
	public ResponseEntity<List<Customer>> viewAllCustomer() throws CustomerException {
		return new ResponseEntity<List<Customer>>(cService.viewAllCustomer(), HttpStatus.OK);
	}


	///////////////////////////feedback Controller Part

	@GetMapping("/feedbackcustomer/{customerId}")
	public ResponseEntity<List<Feedback>> findByCustomerId(@PathVariable("customerId") Integer customerId)
			throws FeedbackException, CustomerException {

		List<Feedback> feedBacks = feedbackService.findByCustomerId(customerId);

		return new ResponseEntity<List<Feedback>>(feedBacks, HttpStatus.OK);

	}

	@GetMapping("/feedbacks")
	public ResponseEntity<List<Feedback>> viewAllFeedbacks() throws FeedbackException {
		return new ResponseEntity<List<Feedback>>(feedbackService.viewAllFeedbacks(), HttpStatus.OK);
	}

	@PostMapping("/feedbacks/{customerId}")
	public ResponseEntity<Feedback> addFeedback(@Valid @RequestBody Feedback feedback,
			@PathVariable("customerId") Integer customerId) throws FeedbackException, CustomerException {

		return new ResponseEntity<Feedback>(feedbackService.addFeedback(feedback, customerId), HttpStatus.ACCEPTED);
	}

}
