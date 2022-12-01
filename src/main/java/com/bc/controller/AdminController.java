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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bc.exception.AdminException;
import com.bc.exception.ReportException;
import com.bc.model.Report;
import com.bc.service.AdminService;
import com.bc.service.ReportService;



@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@Autowired
	private ReportService reportService;


	@PostMapping("/add")
	public ResponseEntity<String> createAdmin() throws AdminException {
		return new ResponseEntity<String>(adminService.createNewAdmin(), HttpStatus.CREATED);
	}
	
	
	
	/////////////////////////// Report Controller Part

	@GetMapping("/report")
	public ResponseEntity<List<Report>> viewAllReports() throws ReportException {
		return new ResponseEntity<List<Report>>(reportService.viewAllReports(), HttpStatus.OK);
	}
	@PostMapping("/report")
	public ResponseEntity<Report> addReport(@Valid @RequestBody Report report) throws ReportException, AdminException {
		return new ResponseEntity<Report>(reportService.addReport(report), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/report/{reportId}")
	public ResponseEntity<Report> deleteReport(@PathVariable("reportId") Integer reportId) throws ReportException, AdminException {
		return new ResponseEntity<Report>(reportService.deleteReport(reportId), HttpStatus.OK);
	}

	@GetMapping("/report/{reportId}")
	public ResponseEntity<Report> findByReportId(@PathVariable("reportId") Integer reportId) throws ReportException {
		return new ResponseEntity<Report>(reportService.findByReportId(reportId), HttpStatus.OK);
	}




}
