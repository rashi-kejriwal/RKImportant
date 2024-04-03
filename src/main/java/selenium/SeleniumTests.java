package selenium;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import static java.util.concurrent.TimeUnit.SECONDS;

public class SeleniumTests {

    @Test
    public void testSelenium(){

        WebDriver driver=new FirefoxDriver();
        WebDriver iedriver=new InternetExplorerDriver();

        //BROWSER COMMANDS

        driver.get("http://www.hotstar.com");  //load new webpage
        driver.manage().window().maximize();

        driver.getTitle(); //title of current page

        driver.getCurrentUrl(); //current url

        driver.getPageSource();//source code of page

        driver.close();// close current browser

        driver.quit(); //This method Closes all windows opened by the WebDriver


       //NAVIGATION COMMANDS

       driver.navigate().to("http://www.hotstar.com");
       driver.navigate().forward();
       driver.navigate().back();

       driver.navigate().refresh(); //This method Refresh the current page


        //WEBELEMENTS COMMANDS

        WebElement element=driver.findElement(By.id("UserName"));
        element.clear(); //If this element is a text entry element, this will clear the value
        element.sendKeys("ToolsQA"); //enter text

        element.click(); //click on element
        element.submit(); //for forms

        element.isDisplayed(); //if element is displayed, return false for hidden elements
        element.isEnabled(); //if enabled
        element.isSelected();//if selected


        element.getText();//This method will fetch the visible (i.e. not hidden by CSS) innerText of the element

        element.getTagName();

        element.getAttribute("id"); //value of attribute

        element.getSize();//This method fetch the width and height of the rendered element

        Point point = element.getLocation();//location of element

        WebElement oCheckBox = driver.findElement(By.cssSelector("input[value='Tools QA']")); //by css


        driver.findElement(By.partialLinkText("Partial"));
        driver.findElement(By.linkText("Partial Link Test"));

        driver.findElement(By.xpath("Element XPATHEXPRESSION"));


        //radio/checkbox
        List<WebElement> oRadioButton = driver.findElements(By.name("toolsqa"));
        Boolean bValue=false;
        bValue = oRadioButton.get(0).isSelected();
        if (bValue.equals(false))
            oRadioButton.get(0).click();



        //DropDown & Multiple Select

        //Note: Select class only works for elements with <select> tags.
        Select select=new Select(driver.findElement(By.id("Country")));

        select.selectByVisibleText("India"); //visible on UI
        select.selectByIndex(4);
        select.selectByValue("IND");

        List<WebElement> options=select.getOptions();
        List<WebElement> selectedoptions=select.getAllSelectedOptions();
        select.deselectAll();
        select.deselectByValue("Ind");

        select.isMultiple(); //supports multiple selection or not


        //wait

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  //implicit wait. Selenium that we would like it to wait for a certain amount of time before throwing an exception


        //fluent wait
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)

                .withTimeout(Duration.ofSeconds(30))

                .pollingEvery(Duration.ofSeconds(5))

                .ignoring(NoSuchElementException.class);

        //explicit wait
        WebDriverWait explicitwait=new WebDriverWait(driver,Duration.ofSeconds(10));
        explicitwait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("linkvalue")));

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
       WebElement element11 = wait1.until(ExpectedConditions.elementToBeClickable(By.id("someid")));


        //WindowHandles

        String window=driver.getWindowHandle();
        Set windows=driver.getWindowHandles(); //set of handles
        driver.switchTo().window(window);
        driver.switchTo().defaultContent();//switch back to default window


        //switch frames
        driver.switchTo().frame(0);//position
        driver.switchTo().frame("frameName");

        //Alert
        Alert alert=driver.switchTo().alert();
        alert.accept();
        alert.getText();
        alert.sendKeys("Yes");
        alert.dismiss();

        //Action


     //Drag and drop1
        WebElement source=driver.findElement(By.id("Country"));
        WebElement destination=driver.findElement(By.id("Country"));
        Actions action=new Actions(driver);
        action.dragAndDrop(source,destination);
        action.moveToElement(source).build().perform();


     //Drag and drop2
        Actions builder = new Actions(driver);
        WebElement dragElement=driver.findElement(By.id("draggable"));
        WebElement dropElement=driver.findElement(By.id("droppable"));
// To hold the drag element and then move it to drop element location
        Action dragDrop = builder.clickAndHold(dragElement).moveToElement(dropElement).build();  // build- Create Action object
        dragDrop.perform(); // perform- Execute all the actions build



        WebElement menu = driver.findElement(By.id("menu"));
        WebElement menuoption = driver.findElement(By.id("menuoption"));
//Move to the main menu option and then sub-option
        Action element1= builder.moveToElement(menu).moveToElement(menuoption).build();
// To Execute the Action
        element1.perform();

        //Verify tooltips
       builder.clickAndHold(element).moveByOffset(2,3).release();
     //get the value of the "title" attribute of the github icon
      String actualTooltip = element.getAttribute("title");



        //double click
        action.doubleClick();


        //right click
        action.moveToElement(source).build();
        action.contextClick().perform();

        //mouse hover
        action.moveToElement(element).build().perform();

        //tabs
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));

        //Open a new tab using Ctrl + t
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"t");
        //Switch between tabs using Ctrl + \t
        driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");


        //upload file
        element.sendKeys("c://ss/image.jpg");


        //javascriptexecutor
        ((JavascriptExecutor) driver).executeScript("arguments[0].click()", element); //click
        ((JavascriptExecutor)driver).executeScript("document.getElementById('text-8').scrollIntoView(true);"); //scroll into view
        ((JavascriptExecutor)driver).executeScript("window.scrollByLines(2)"); //scroll by lines

        //logger
        Logger logger=Logger.getLogger("Google");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        logger.info("Implicit wait given");

    }
}
