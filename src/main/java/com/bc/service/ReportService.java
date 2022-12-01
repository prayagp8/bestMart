package com.bc.service;

import java.util.List;

import com.bc.exception.AdminException;
import com.bc.exception.ReportException;
import com.bc.model.Report;



public interface ReportService {

	public Report addReport(Report report) throws ReportException,AdminException;

	public Report deleteReport(Integer reportId) throws ReportException,AdminException;

	public Report findByReportId(Integer reportId) throws ReportException;

	public List<Report> viewAllReports() throws ReportException;
		
}
