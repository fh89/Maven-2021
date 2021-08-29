package Action_Items;

import Reusable_Classes.Reusable_Methods;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ActionItem5 {

    public static void main(String[] args) throws InterruptedException, BiffException, IOException {


        //Locating Excel Sheet
       // Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/ActionItem5Excel.xls"));

        //create a writable file that mimics the readable in order to write back your result
     //   WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/ActionItem5Excel_results.xls"), readableFile);

        //Step 2 : Accessing the excel sheet from the workbook
      //  WritableSheet writableSheet = writableFile.getSheet(0);

        //Step 3 : row count will tell you the rows that are not empty
    //    int rowCount = writableSheet.getRows();

        //Set up the Driver
        WebDriver driver = Reusable_Methods.setDriver();

        //call the for loop to iterate through your test data from excel
   //     for (int i = 3; i < rowCount; i++) {

     //       String size = writableSheet.getCell(0, i).getContents();
    //        String quantity = writableSheet.getCell(1, i).getContents();
    //        String firstName = writableSheet.getCell(2, i).getContents();
   //         String lastName = writableSheet.getCell(3, i).getContents();
   //         String email = writableSheet.getCell(4, i).getContents();
   //         String phoneNumber = writableSheet.getCell(5, i).getContents();
    //        String address = writableSheet.getCell(6, i).getContents();
  //          String postalCode = writableSheet.getCell(7, i).getContents();
  //          String city = writableSheet.getCell(8, i).getContents();
  //          String state = writableSheet.getCell(9, i).getContents();

            //Step 1 Open WebPage
            driver.navigate().to("https://www.express.com/");
            Thread.sleep(2500);

            //Step 2 Click On X on Pop Up
            Reusable_Methods.clickMethod(driver,"//*[@id='closeModal']","Closing Pop Up");


            //Step 3 Hover to the Mens Tab and click on polo
            Reusable_Methods.mouseHover(driver,"//*[@text()='Men']", "Mens Tab");
         //   Reusable_Methods.clickMethod(driver,"//*[@class='_399XX MegaMenuListItem_menuItem__yCJSl']","Polos");
            Thread.sleep(3500);

            //Step 4






        }//End Of For Loop


    }//End Of Main Method
//}//End of Class