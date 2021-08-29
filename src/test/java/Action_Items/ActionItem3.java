package Action_Items;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class ActionItem3 {

    public static void main(String[] args) throws InterruptedException {



        //Set Up Zip Code Array

        String[] zipCode = new String[3];

        zipCode[0] = "08817";
        zipCode[1] = "08818";
        zipCode[2] = "08819";

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        //maximize driver and make incognito

        options.addArguments("start-maximized");
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);



        //Iterate zipcode array


        for (int i = 0; i < zipCode.length; i++) {

            //navigate to website WORKS

            driver.navigate().to("https://www.weightwatchers.com/us/find-a-workshop");

            Thread.sleep(3000);

            //Select Studio WORKS
            driver.findElement(By.xpath("//*[@class='buttonWrapper-QK2gi']")).click();

            Thread.sleep(2000);

            //enter location WORKS
            driver.findElement(By.xpath("//*[@id='location-search']")).sendKeys(zipCode[i]);

            Thread.sleep(2000);

            //Search Zipcode and hit submit WORKS

            driver.findElement(By.xpath("//*[@class='rightArrow-daPRP']")).submit();

            Thread.sleep(2000);

            //If Else Condition Inside loop


            List<WebElement> address = driver.findElements(By.xpath("//[@class='linkUnderline-1_h4g]"));

            if (i == 0) {
                address.get(0).click();
            }


            if (i == 1) {
                address.get(1).click();
            }

            if (i == 2) {
                address.get(2).click();
            }

            //End off conditional statement
            Thread.sleep(3000);


            String address_1 = driver.findElement(By.xpath("(//div[@class='address-2PZwW'])/div[1]")).getText();
            String address_2 = driver.findElement(By.xpath("(//div[@class='address-2PZwW'])/div[2]")).getText();
            System.out.println("The address when i = " + i + " and zipcode = " + zipCode[i] +  " is " + address_1 + " " + address_2);


            //Scroll Down and capture
            JavascriptExecutor jse = (JavascriptExecutor) driver;
            jse.executeScript("scroll(0,1000)");
            Thread.sleep(3000);

            String result = driver.findElement(By.xpath("//*[@class='scheduleContainerMobile-1RfmF']")).getText();
            System.out.println("The hours are" + result + " ");

        }//End Of Loop

            driver.quit();

            }//end of main method


        }//end of java class


