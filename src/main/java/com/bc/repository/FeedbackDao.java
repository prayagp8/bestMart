package com.bc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bc.model.Feedback;



@Repository
public interface FeedbackDao extends JpaRepository<Feedback, Integer> {
	
	
	

}
