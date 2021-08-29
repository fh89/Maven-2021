package Action_Items;

import Reusable_Classes.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ActionItem6 {

    //declare the global variables outside the annotation methods
    WebDriver driver;
    Workbook readableFile;
    WritableWorkbook writableFile;
    WritableSheet writableSheet;
    int rowCount;

    //precondition for express
    @BeforeSuite
    public void setTheDriverAndWorkbook() throws IOException, BiffException {
        //step 1: locate the file path where you save it
        readableFile = Workbook.getWorkbook(new File("src/main/resources/ActionItem6Excel.xls"));
        //create a writable file that mimics the readable in order to write back your result and not corrupt the readable
        writableFile = Workbook.createWorkbook(new File("src/main/resources/ActionItem6Excel_Results.xls"),readableFile);
        //Step 2: accessing the excel sheet from the workbook
        writableSheet = writableFile.getSheet(0);
        //Step 3: row count will return all the rows which is not empty
        rowCount = writableSheet.getRows();
        //set the driver
        driver = Reusable_Methods.setDriver();
    }//end of before suite

@Test
public void AtenaIteration() throws InterruptedException, WriteException {
    for (int i = 1; i < 3; i++) {

        String zipcode = writableSheet.getCell(0, i).getContents();
        String miles = writableSheet.getCell(1, i).getContents();
        String doctor_location = writableSheet.getCell(2, i).getContents();


        //navigate to atena
        driver.navigate().to("https://www.aetna.com/");
        Thread.sleep(2500);
        //click shop for plan
        Reusable_Methods.clickMethod(driver, "//*[text()='Shop for a plan']", "Shopping for Plan");
        Thread.sleep(2500);
        //click on Medicare
        Reusable_Methods.clickMethod(driver, "//*[text()='Medicare']", "Medicare");
        Thread.sleep(2500);
        //click on find a doctor
        Reusable_Methods.clickMethod(driver, "//*[@href='https://www.aetna.com/dsepublic/#/contentPage?page=providerSearchLanding&site_id=medicare&language=en']", "Find A Doctor");
        Thread.sleep(2500);
        //click on Plan For Yourself
        Reusable_Methods.clickMethod(driver, "//*[text()='2021 Medicare plans you purchase yourself']", "Plan For Yourself");
        Thread.sleep(2500);
        //send keys zipcode
        Reusable_Methods.sendKeysMethod(driver, "//*[@id='medZip']", zipcode, "zipcode field");
        //click on zipcode
        Reusable_Methods.clickMethod(driver, "//*[@a href tabindex='-1']", "City");

        //Move Miles
        Reusable_Methods.mousesliderbydraganddrop(driver,"//*[contains(@class,'rz-pointer')]","Slider");


        //Click Skip Plan Selection
        Reusable_Methods.clickMethod(driver, "//*[text()='Skip plan selection*']", "Skip Plan Selection");
        Thread.sleep(2500);

        //Click Medical Doctors and Specialists
        Reusable_Methods.clickMethod(driver, "//*[@href='#/contentPage?page=providerMedical&site_id=medicare&language=en']", "Find A Doctor");
        Thread.sleep(2500);

        //Click All Primary Care Physicians
        Reusable_Methods.clickMethod(driver, "//*[text()='All Primary Care Physicians']", "All Primary Care Physicians");
        Thread.sleep(3000);

        //capture text from delivery options and write to excel
        String deliveryText = Reusable_Methods.getText(driver, "//*[@class='_1Q4iDku_IopeC7OgnKsdoD']", "Deliver options text");
        System.out.println(deliveryText);
        Label label = new Label(3, i, deliveryText);
        writableSheet.addCell(label);

        //delete cookies
        driver.manage().deleteAllCookies();


    }//End Of Loop


}//End Of Iteration


    @AfterSuite
    public void writeExcelAndQuitDriver() throws IOException, WriteException {
        writableFile.write();
        writableFile.close();
        driver.quit();
    }//end of after suite

}//End Of Class
