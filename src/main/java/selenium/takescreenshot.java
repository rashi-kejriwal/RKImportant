package selenium;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class takescreenshot {

    @Test
    public void TakeScreenshot() throws IOException {

        // Open Firefox
        WebDriver driver=new FirefoxDriver();
        // Maximize the window
        driver.manage().window().maximize();
        // Pass the url
        driver.get("http://www.google.com");

        //take screenshot
        TakesScreenshot ts= (TakesScreenshot) driver;
        File file=ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file,new File("C:/selenium/error.png"));

    }
}
