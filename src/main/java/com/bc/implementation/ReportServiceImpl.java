package com.bc.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bc.exception.AdminException;
import com.bc.exception.ReportException;
import com.bc.model.Admin;
import com.bc.model.Report;
import com.bc.repository.AdminRepo;
import com.bc.repository.ReportDao;
import com.bc.service.ReportService;



@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private ReportDao reportDao;
	
	@Autowired
	private AdminRepo adRepo;

	@Override
	public Report addReport(Report report) throws ReportException, AdminException {
		  Admin admin = adRepo.findByEmail("admin@gmail.com");
		  if(admin==null) {
			  throw new AdminException("admin not loggedIn!");
		  }
		Report report2 = reportDao.save(report);
		if (report2 == null) {
			throw new ReportException("Report can not be added.");
		}
		return report2;
	}

	@Override
	public Report deleteReport(Integer reportId) throws ReportException, AdminException {
		 Admin admin = adRepo.findByEmail("admin@gmail.com");
		  if(admin==null) {
			  throw new AdminException("admin not loggedIn!");
		  }
		Optional<Report> opt = reportDao.findById(reportId);
		if (opt == null) {
			throw new ReportException("Report can not be deleted.");
		}
		Report report = opt.get();
		reportDao.delete(report);
		return report;
	}

	@Override
	public Report findByReportId(Integer reportId) throws ReportException {
		Optional<Report> opt = reportDao.findById(reportId);
		if (opt == null) {
			throw new ReportException("Report does not exists with Report Id : " + reportId);
		}
		return opt.get();
	}

	@Override
	public List<Report> viewAllReports() throws ReportException {
		List<Report> reports = reportDao.findAll();
		if (reports.isEmpty()) {
			throw new ReportException("No report exists.");
		}
		return reports;
	}	

}
