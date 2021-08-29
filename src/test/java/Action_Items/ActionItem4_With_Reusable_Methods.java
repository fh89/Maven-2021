package Action_Items;

import Reusable_Classes.Reusable_Methods;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.IOException;
import java.util.ArrayList;

public class ActionItem4_With_Reusable_Methods {

    public static void main(String[] args) throws InterruptedException, IOException {


        WebDriver driver = Reusable_Methods.setDriver();


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


        //Create A For Loop
        for (int i = 0; i < FirstName.size(); i++) {


            //navigate to UHC
            driver.navigate().to("https://www.uhc.com");

            Actions mouseMove = new Actions(driver);
            Thread.sleep(3000);

            //Click On Find A Doctor
            Reusable_Methods.clickMethod(driver,"//*[@class='position-relative bg-blueDark color-white display-block width-100 lg-bg-white p-4 size-17 talign-center']","Find A Doctor");
            Thread.sleep(2000);

            // Click Sign In DropDown
            Reusable_Methods.clickMethod(driver,"//*[@class='jump-menu__button m-0 py-0 pl-4 pr-8 position-relative border-grey borderColor-greyDark borderRadius-default width-auto color-inherit bg-white weight-bold cursor-pointer sm-width-100 lineHeight-h4 py-2 talign-left']","Sign In On Drop Down");
            Thread.sleep(2000);

            //Select Medicare Plan
            Reusable_Methods.clickMethod(driver,"//*[@aria-label='Medicare plan Opens a new window']","Medicare");
            Thread.sleep(2000);

            //Switch To New Tab
            ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tabs.get(1));

            //Click On Register Now
            Reusable_Methods.clickMethod(driver,"//*[@class='uhc-tempo-link__icon uhc-tempo-link__icon--large uhc-tempo-link__icon--internal']","Register Now");
            Thread.sleep(2000);

            //Input FirstName
            Reusable_Methods.sendKeysMethod(driver,"//*[@id='piFirstName']", FirstName.get(i),"FirstName");

            //Input LastName
            Reusable_Methods.sendKeysMethod(driver,"//*[@id='piLastName']", lastName.get(i),"LastName");

            //Input DoB
            Reusable_Methods.sendKeysMethod(driver,"//*[@id='piDoB']", dob.get(i),"DoB");

            //Input ZipCode
            Reusable_Methods.sendKeysMethod(driver,"//*[@id='piZipCode']", zipCode.get(i),"zipCode");

            //Input ZipCode
            Reusable_Methods.sendKeysMethod(driver,"//*[@id='piMemberId4Mnr']", planId.get(i),"planID");


            //Click Continue
           Reusable_Methods.clickMethod(driver,"//*[@id='step1Btn']","Continue");
           Thread.sleep(2000);

            //Capture Error Message

            Reusable_Methods.getText(driver, "//*[@id='pageErrors']","Error Message");
            Thread.sleep(2000);

            //Close Current Tab
            driver.close();

            //Switch Back TO Tab
            driver.switchTo().window(tabs.get(0));


        }//End Of Loop
    }//End Of Main Method
}//End Of Class