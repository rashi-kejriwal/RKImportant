package testNg;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

/**
<listeners>
        <listener class-name="testngDemo.ListenerDemoExample"/>
</listeners>
<listeners>
    <listener class-name="testngDemo.testNgListner"/>
</listeners>
**/

public class testNgListner implements ITestListener {
    public void onTestStart(ITestResult result) {
        Reporter.log("About to begin executing Suite " + result.getName(), true);
    }

    public void onTestSuccess(ITestResult result) {

    }

    public void onTestFailure(ITestResult result) {

    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
