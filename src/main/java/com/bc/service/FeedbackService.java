package com.bc.service;

import java.util.List;

import com.bc.exception.CustomerException;
import com.bc.exception.FeedbackException;
import com.bc.model.Feedback;



public interface FeedbackService {

	public Feedback addFeedback(Feedback feedback, Integer customerId) throws FeedbackException,CustomerException;

	public Feedback findByFeeedbackId(Integer feedbackId) throws FeedbackException;

	public List<Feedback> findByCustomerId(Integer customerId) throws FeedbackException,CustomerException;

	public List<Feedback> viewAllFeedbacks() throws FeedbackException;
	
	

}
