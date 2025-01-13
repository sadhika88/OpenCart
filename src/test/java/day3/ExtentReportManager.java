package day3;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	public ExtentSparkReporter sparkReporter;//ui of the report
	public ExtentReports extent;//populate common info on the report,tester name broweser name ,os name,project name,module,environment name
	public ExtentTest test;//createing test case entries in the report and update status of the  test methods
	public void onStart(ITestContext context) {
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+ "/report/myReport.html");//specify location of the report
		sparkReporter.config().setDocumentTitle("Automation Report");//title of the report
		sparkReporter.config().setReportName("Functional Testing");//name of the report
		sparkReporter.config().setTheme(Theme.STANDARD);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name", "localhost");
		extent.setSystemInfo("Environment", "QA");
		extent.setSystemInfo("Tester Name", "sadhika");
		extent.setSystemInfo("os", "Windows10");
		extent.setSystemInfo("Browser name", "Chrome");
		
	}
	public  void onTestSuccess(ITestResult result) {
		test=extent.createTest(result.getName());//create new entry in the report
		test.log(Status.PASS, "Test case passed is : " +result.getName());//update status p/f/s
		}
	public void onTestFailure(ITestResult result) {
		test=extent.createTest(result.getName());//create new entry in the report
		test.log(Status.FAIL, "Test case failed is : " +result.getName());//update status p/f/s
		test.log(Status.FAIL, "Test case failed caused  is : " +result.getThrowable());
	}
	public void onTestSkipped(ITestResult result) {
		test=extent.createTest(result.getName());//create new entry in the report
		test.log(Status.SKIP, "Test case skipped is : " +result.getName());//update status p/f/s
		
	} 
	public void onFinish(ITestContext context) {
		extent.flush();
	}
}
