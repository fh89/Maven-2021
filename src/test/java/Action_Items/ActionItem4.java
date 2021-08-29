package Action_Items;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import javax.imageio.ImageReader;
import java.io.IOException;
import java.util.ArrayList;


public class ActionItem4 {

    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriverManager.chromedriver().setup();

        //Open Chrome And navigate to UHC (WORKS)
        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized");
        options.addArguments("incognito");

        WebDriver driver = new ChromeDriver(options);



        Thread.sleep(3000);


        //Registration Information Array

        ArrayList<String> FirstName = new ArrayList<>();
        FirstName.add("Farhan");
        FirstName.add("Jason");
        FirstName.add("Daniel");


        ArrayList<String> lastName = new ArrayList<>();
        lastName.add("Hossain");
        lastName.add("Fan");
        lastName.add("Manager");

        ArrayList<String> dob = new ArrayList<>();
        dob.add("11/11/1999");
        dob.add("09/21/1999");
        dob.add("05/21/1999");

        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("08817");
        zipCode.add("08818");
        zipCode.add("08819");


        ArrayList<String> planId = new ArrayList<>();
        planId.add("24566215");
        planId.add("26356678");
        planId.add("25645677");

        //Put In a For Loop

        for(int i = 0; i < FirstName.size(); i++) {

            driver.navigate().to("https://www.uhc.com");

            Actions mouseMove = new Actions(driver);
            Thread.sleep(3000);


            //click on find a doctor
            try {
                System.out.println("Finding a doctor...");
                driver.findElement(By.xpath("//*[@class='position-relative bg-blueDark color-white display-block width-100 lg-bg-white p-4 size-17 talign-center']")).click();
            } catch (Exception err)
            { System.out.println("Unable to find a doctor " + err); }

            Thread.sleep(3000);

            //Wait 5 Seconds for Popup
          //  Thread.sleep(5000);

            //Exit the pop up
        //    try {
        //        System.out.println("Exiting Popup...");
        //       driver.findElement(By.xpath("//*[@id='ip-close']")).click();
        //   } catch (Exception err)
        //    { System.out.println("Unable to find Popup " + err); }


            // Click Sign In DropDown

             try {
                System.out.println("Clicking DropDown...");
                driver.findElement(By.xpath("//*[@class='jump-menu__button m-0 py-0 pl-4 pr-8 position-relative border-grey borderColor-greyDark borderRadius-default width-auto color-inherit bg-white weight-bold cursor-pointer sm-width-100 lineHeight-h4 py-2 talign-left']")).click();
            } catch (Exception err)
            { System.out.println("Unable to Dropdown " + err);
            }//End of send tab exception


            Thread.sleep(3000);


            //Select Medicare Plan
            try {
                System.out.println("Selecting Plan...");
                WebElement selectPlan = driver.findElement(By.xpath("//*[@aria-label='Medicare plan Opens a new window']"));
                mouseMove.moveToElement(selectPlan).click().perform();
            } catch (Exception err) {
                System.out.println("Unable to find Medicare Plan" + err);
            }//end of send tab exception

            Thread.sleep(3000);

            //Switch To New Tab

            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            Thread.sleep(3000);


            //Click On Register Now
                try {
                    System.out.println("Register Now..");
                    driver.findElement(By.xpath("//*[@class='uhc-tempo-link__icon uhc-tempo-link__icon--large uhc-tempo-link__icon--internal']")).click();
                } catch (Exception err) {
                    System.out.println("Unable Register Now" + err);
                }//end of send tab exception

            Thread.sleep(3000);

            //Input Information Into Form

              try {
                System.out.println("Inputting Information..");
                driver.findElement(By.xpath("//*[@id='piFirstName']")).sendKeys(FirstName.get(i));
                driver.findElement(By.xpath("//*[@id='piLastName']")).sendKeys(lastName.get(i));
                driver.findElement(By.xpath("//*[@id='piDoB']")).sendKeys(dob.get(i));
                driver.findElement(By.xpath("//*[@id='piZipCode']")).sendKeys(zipCode.get(i));
                driver.findElement(By.xpath("//*[@id='piMemberId4Mnr']")).sendKeys(planId.get(i));
            } catch (Exception err) {
                System.out.println("Unable Input Information Now" + err);
                 Thread.sleep(3000);

            }//end of send tab exception

            //Click Continue

            Thread.sleep(3000);

            try {
                System.out.println("Clicking Continue..");
                driver.findElement(By.xpath("//*[@id='step1Btn']")).click();
            } catch (Exception err) {
                System.out.println("Unable Continue" + err);
                Thread.sleep(5000);

            }//end of send tab exception

            //Capture Error Message
            Thread.sleep(5000);
            String result = driver.findElement(By.xpath("//*[@id='pageErrors']")).getText();
            System.out.println("The Result is" + result + " ");
            Thread.sleep(3000);


            //Close Current Tab
            driver.close();

            //Switch Back TO Tab
            driver.switchTo().window(tabs.get(0));


        }//End Of For Loop
        driver.quit();

    }//End Of Main Method
}//End Of Class
