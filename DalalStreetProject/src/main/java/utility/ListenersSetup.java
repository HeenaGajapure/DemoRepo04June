package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.testBase.TestBase;

public class ListenersSetup extends TestBase implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		
		System.out.println("Testcase execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Testcase execution passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Testcase execution failed");
		UtilClass.takeScreenShot(result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Testcase execution skipped");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

	}