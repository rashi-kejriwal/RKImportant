package selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.File;

public class RetryFailedTest implements IRetryAnalyzer {
    int minretryCount=0;
    int maxretryCount=2;
    WebDriver driver=new FirefoxDriver();
    public boolean retry(ITestResult result) {
        if (minretryCount<=maxretryCount){

            // print the test name for log purpose

            System.out.println("Following test is failing===="+result.getName());

            // print the counter value

            System.out.println("Retrying the test Count is=== "+ (minretryCount+1));

            // increment counter each time by 1

            minretryCount++;

            return true;

        }
        return false;
    }
    //specify in testcase
    @Test(retryAnalyzer = RetryFailedTest.class)
    public void googleSearch(){

    }

    //Take screenshot of failed tests
    @AfterMethod
    public void tearDown(ITestResult result)
    {

        // Here will compare if test is failing then only it will enter into if condition
        if(ITestResult.FAILURE==result.getStatus())
        {
            try
            {
                // Create refernce of TakesScreenshot
                TakesScreenshot ts=(TakesScreenshot)driver;

                // Call method to capture screenshot
                File source=ts.getScreenshotAs(OutputType.FILE);

                 // Copy files to specific location here it will save all screenshot in our project home directory and
                 // result.getName() will return name of test case so that screenshot name will be same
                FileUtils.copyFile(source, new File("./Screenshots/"+result.getName()+".png"));

                System.out.println("Screenshot taken");
            }
            catch (Exception e)
            {

                System.out.println("Exception while taking screenshot "+e.getMessage());
            }
        }
        // close application
        driver.quit();
    }
}
