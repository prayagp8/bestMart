package com.bc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bc.model.Report;



@Repository
public interface ReportDao extends JpaRepository<Report, Integer> {

}
