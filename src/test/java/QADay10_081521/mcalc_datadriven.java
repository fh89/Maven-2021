package QADay10_081521;

import Reusable_Classes.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import okhttp3.Route;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class mcalc_datadriven {

    public static void main(String[] args) throws BiffException, IOException, InterruptedException, WriteException {


        //Step 1 : locate
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/Mlcalc_datadriven.xls"));

        //create a writable file that mimics the readable in order to write back your result
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/Mcalc_datadriven_results.xls"), readableFile);

        //Step 2 : Accessing the excel sheet from the workbook
        WritableSheet writableSheet = writableFile.getSheet(0);

        //Step 3 : row count will tell you the rows that are not empty
        int rowCount = writableSheet.getRows();

        //Set up the Driver
        WebDriver driver = Reusable_Methods.setDriver();

        //call the for loop to iterate through your test data from excel
        for (int i = 1; i < rowCount; i++){

        String purchasePrice = writableSheet.getCell(0,i).getContents();
        String dPayment = writableSheet.getCell(1,i).getContents();
        String mTerm = writableSheet.getCell(2,i).getContents();
        String iRate = writableSheet.getCell(3,i).getContents();
        String sMonth = writableSheet.getCell(4,i).getContents();
        String sYear = writableSheet.getCell(5,i).getContents();

            //navigate to mlcalc
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(2500);
            //clear and enter a purchase price
            Reusable_Methods.sendKeysMethod(driver,"//*[@id='ma']",purchasePrice,"Purchase Price");
            //clear and enter down payment
            Reusable_Methods.sendKeysMethod(driver,"//*[@id='dp']",dPayment,"Down Payment");
            //clear and enter mortgage term
            Reusable_Methods.sendKeysMethod(driver,"//*[@id='mt']",mTerm,"Mortagage Term");
            //clear and enter interest rate
            Reusable_Methods.sendKeysMethod(driver,"//*[@id='ir']",iRate,"Interest Rate");
            //Click Show Advanced Options
            Reusable_Methods.clickMethod(driver,"//*[text()='Show advanced options']","Show Advance Options");
            //Select the start Month
            Reusable_Methods.dropdownMethod(driver,"//*[@name='sm']",sMonth,"Start Month");
            //Select the start Year
            Reusable_Methods.dropdownMethod(driver,"//*[@name='sy']",sYear,"Start Year");
            //Select on Calculate
            Reusable_Methods.clickMethod(driver,"//*[@value='Calculate']","Calculate");
            Thread.sleep(2500);

            //capture the monthly payment and send it back to writable excel sheet
            String result = Reusable_Methods.getTextByIndex(driver,"//div[@style='font-size: 32px']",0,"Monthly Payment");
            System.out.println("My monthly payment is " + result);
            //send the result back to the writable excel sheet
            Label label = new Label(6,i,result);
            writableSheet.addCell(label);

        }//end of for loop

        //write back to excel
        writableFile.write();
        //close the file
        writableFile.close();

        //outside of loop quit the driver
        driver.quit();


    }//End of Main Method

}//End of Class
