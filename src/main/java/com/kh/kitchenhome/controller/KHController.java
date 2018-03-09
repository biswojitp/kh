package com.kh.kitchenhome.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;
import org.springframework.web.bind.annotation.ResponseBody;

import com.kh.kitchenhome.config.DataSourceConfig;
import com.kh.kitchenhome.model.Kitchen;
import com.kh.kitchenhome.repository.KitchenRepository;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;

@Controller
public class KHController {

	@Autowired
	KitchenRepository kitchenRepository;

	@Autowired
	DataSourceConfig dataSourceConfig;

	@RequestMapping("/")
	String home() {
		return "app.welcome";
	}

	@RequestMapping("/login")
	String login() {
		return "app.login";
	}

	@RequestMapping("/signup.htm")
	String signup() {
		return "app.signup";
	}

	@RequestMapping(value = "/findlist")
	public String home(Map<String, Object> model) {
		model.put("message", "HowToDoInJava Reader !!");
		List<Kitchen> klist = kitchenRepository.findAll();
		return "testjsp";
	}

	@RequestMapping("/testjsp")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", "testjsp");
		return "testjsp";
	}

	@RequestMapping(path = "/pdf", method = RequestMethod.GET)
	@ResponseBody
	public Object report(HttpServletResponse response) {

		InputStream kitchenReportStream = getClass().getResourceAsStream("/reports/my_kitchen_report.jrxml");
			JasperReport jasperReport=null;
			try {
				jasperReport = JasperCompileManager.compileReport(kitchenReportStream);
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		
		JasperPrint jasperPrint=null;
		try {
			
				jasperPrint = JasperFillManager.fillReport(
				jasperReport, null, dataSourceConfig.dataSource().getConnection());
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JRPdfExporter exporter = new JRPdfExporter();
		 
		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		exporter.setExporterOutput(
		  new SimpleOutputStreamExporterOutput("kitchenReport1.pdf"));
		 
		SimplePdfReportConfiguration reportConfig
		  = new SimplePdfReportConfiguration();
		reportConfig.setSizePageToContent(true);
		reportConfig.setForceLineBreakPolicy(false);
		 
		SimplePdfExporterConfiguration exportConfig
		  = new SimplePdfExporterConfiguration();
		exportConfig.setMetadataAuthor("baeldung");
		exportConfig.setEncrypted(true);
		exportConfig.setAllowedPermissionsHint("PRINTING");
		 
		exporter.setConfiguration(reportConfig);
		exporter.setConfiguration(exportConfig);
		
		 
		try {
			exporter.exportReport();
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 	response.setContentType("application/x-pdf");
	        response.setHeader("Content-disposition", "inline;filename=" + "kitchenReport1.pdf");

	        OutputStream outStream;
			try {
				outStream = response.getOutputStream();
			
	        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(outStream));
	       // exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, outStream);
	        
				exporter.exportReport();
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}

}
