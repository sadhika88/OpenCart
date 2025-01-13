package day3;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener{
	public void onStart(ITestContext context) { //onstart executd only once before starting the all test methods
	    System.out.println("Test Execution started.....");
	  }
	 public  void onTestStart(ITestResult result) {//onstart executes multiple times before every test method
		 System.out.println("Test  started.....");
	  }
	 public void onTestSuccess(ITestResult result) {//on testsuccess executes whenever my test method got passed
		 System.out.println("Test passed.....");
		  }
	 public void onTestFailure(ITestResult result) {////on testfailure executes whenever my test method got failed
		 System.out.println("Test  failed.....");
		  }
	 public void onTestSkipped(ITestResult result) {//on testskipped executes whenever my test method got skipped
		 System.out.println("Test skipped.....");
		  }
	 public void onFinish(ITestContext context) {//on testince executes once it finisthes all the testcases
		 System.out.println("Test Execution  is completed.....");
		  }
		

}
