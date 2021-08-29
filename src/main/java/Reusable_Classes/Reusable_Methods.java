package Reusable_Classes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.internal.WebElementToJsonConverter;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.transform.Source;
import java.io.IOException;

public class Reusable_Methods {


    //method to declare and define a chrome driver
    public static WebDriver setDriver() throws IOException {
        //killing all the chrome instance that you have opened
        //Runtime.getRuntime().exec("taskkill /im chrome.exe /f");
        //setup your driver
        WebDriverManager.chromedriver().setup();
        //set the conditions for chromeoptions before the webdriver is defined
        ChromeOptions options = new ChromeOptions();
        //set arguments to maximize the driver and make it incognito
        options.addArguments("start-maximized");
        //options.addArguments("headless");
        options.addArguments("incognito");
        //define the webdriver
        WebDriver driver = new ChromeDriver(options);

        return driver;
    }//end of set driver method



    //clear and enter a value using sendKeys
    public static void sendKeysMethod(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            System.out.println("Entering a value on " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.clear();
            element.sendKeys(userValue);
        } catch (Exception err) {
            System.out.println("Unable to enter a value on " + elementName);
        }
    }//end of sendKeysMethod




    //click on element
    public static void clickMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            System.out.println("Clicking on " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception err) {
            System.out.println("Unable to click on " + elementName);
        }
    }//end of clickMethod



    //submit on element
    public static void submitMethod(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            System.out.println("Submitting on " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.submit();
        } catch (Exception err) {
            System.out.println("Unable to submit on " + elementName);
        }
    }//end of submitMethod




//select method
    public static void selectMethod(WebDriver driver, String xpath, String userValue, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        try {
            System.out.println("Selecting by text from " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Select choiceSelect = new Select(element);
        } catch (Exception err) {
            System.out.println("Unable to select by text from " + elementName);
        }

    }//end of selectMethod




    //Get Text Method


    public static String getText(WebDriver driver, String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        String Result = "";
        try {
            System.out.println(" Getting Text " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            Result = element.getText();
        } catch (Exception err) {
            System.out.println("Unable to Get Text " + elementName);
        }
        return Result;
    }//end of getText





    // DropDown Method

    public static void dropdownMethod(WebDriver driver, String xpath, String choice, String elementName){
        WebDriverWait wait = new WebDriverWait(driver,15);
        try{
            System.out.println("Selecting from dropdown menu " + elementName);
            //define object for the dropdown WebElement
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            //define object for selection and pass it the dropdown object
            Select choiceSelect = new Select(element);
            //use selectByVisbibleText method on to the selection object and pass it the choice
            choiceSelect.selectByVisibleText(choice);
        } catch(Exception err){
            System.out.println("Unable to select from " + elementName + " " + err);
        }//end of try catch
    }//end of selectMethod



    //Get Text Index Method
    public static String getTextByIndex(WebDriver driver, String xpath, int indexNumber, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        String Result = "";
        try {
            System.out.println(" Getting Text " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(xpath))).get(indexNumber);
            Result = element.getText();
            System.out.println("Result is " + Result);
        } catch (Exception err) {
            System.out.println("Unable to Get Text " + elementName);
        }
        return Result;
    }//end of getTextIndex



    //hover over an element
    public static void mouseHover(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,15);
        Actions actions = new Actions(driver);
        try{
            System.out.println("Hovering on " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception err) {
            System.out.println("Unable to hover on " + elementName);
        }
    }//end of hover method

    //click on pop up element
    public static void clickIfPopupExist(WebDriver driver,String xpath,String elementName){
        WebDriverWait wait = new WebDriverWait(driver,5);
        try{
            System.out.println("Clicking on " + elementName);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
            element.click();
        } catch (Exception err) {
            System.out.println("Popup didn't appear...Proceed to next step");
        }
    }//end of clickIfPopupExist


    //hover slider
    public static void mousesliderbydraganddrop(WebDriver driver, String xpath , String elementName)
    {
        WebDriverWait wait = new WebDriverWait(driver,15);
       Actions actions = new Actions(driver);
        try{
            System.out.println("Sliding on " + elementName);
            Actions action = new Actions(driver);
            WebElement slider = driver.findElement(By.xpath(xpath));
            action.click(slider).build().perform();
            action.sendKeys(Keys.ARROW_LEFT).build().perform();
            action.sendKeys(Keys.ARROW_RIGHT).build().perform();

       } catch (Exception err) {
            System.out.println("Unable to slide on " + elementName);
        }
    }//end of slider method


    //slider by SendKeys method
    public static void sliderSendKeysMethod(WebDriver driver, String xpath, int resetPoint, int desiredPoint, String elementName) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 15);

        try {

            //storing the WebElement as a variable
            WebElement slider = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

            //calling mouse action to click on the slider
            Actions action = new Actions(driver);
            action.click(slider).build().perform();
            Thread.sleep(1500);

            //reset loop
            for (int i = 0; i < resetPoint; i++) {
                action.sendKeys(Keys.ARROW_LEFT).build().perform();
            }//end of reset

            Thread.sleep(1500);

            //desired loop
            for (int i = 0; i < desiredPoint; i++) {
                action.sendKeys(Keys.ARROW_RIGHT).build().perform();
            }//end of desired

            Thread.sleep(1500);

        } catch (Exception e) {

            System.out.println("Unable to move the slider " + elementName + " " + e);

        }//end of slider by SendKeys method

    }//end of slider method



    }//End Of Class






