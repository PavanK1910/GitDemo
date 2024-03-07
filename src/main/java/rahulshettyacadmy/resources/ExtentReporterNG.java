package rahulshettyacadmy.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

		public static ExtentReports getReportoject() {

			//ExtentReports , ExtentsSparkReporter
			String path  = System.getProperty("user.dir")+"\\reports\\index.html";
			ExtentSparkReporter reporter = new ExtentSparkReporter(path);
			reporter.config().setReportName("Web Automation result");
			reporter.config().setDocumentTitle("Test Results");
			
			
			//this is main class
			ExtentReports  extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("Tester", "Pavan Kade");
			return extent;
		}
}
