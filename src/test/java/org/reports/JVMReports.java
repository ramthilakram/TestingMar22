package org.reports;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

public class JVMReports {
	
	public static void cucumberReport(String json) {
		
		File f = new File("C:\\Users\\Rosin\\eclipse-workspace\\March22\\target");
		
		Configuration config = new Configuration(f, json);
		
		config.addClassifications("Sprint Number", "2");
		config.addClassifications("Functionality", "Login");
		config.addClassifications("Windows", "GoogleChrome");
		config.addClassifications("BrowserVersion", "98");
		
		List<String> l = new ArrayList<String>();
		l.add(json);
		
		ReportBuilder r = new ReportBuilder(l, config);
		
		Reportable generateReports = r.generateReports();
		System.out.println(generateReports);

	}

}
