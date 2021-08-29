package Action_Items;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionItem2 {


    public static void main(String[] args) throws InterruptedException {
        String[] colors=new String[3];

        colors[0]= "Red";
        colors[1]= "Blue";
        colors[2]= "Yellow";

        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        for(int i=0; i<colors.length; i++) {

            driver.navigate().to("https://www.bing.com");
            driver.manage().window().maximize();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(colors[i]);
            driver.findElement(By.xpath("//*[@id='sb_form']")).submit();
            Thread.sleep(4000);
            String result = driver.findElement(By.xpath("//*[@class='sb_count']")).getText();

            String[] arrayResult = result.split(" ");

            System.out.println("My search number for color " + colors[i] + " is " + arrayResult[0]);



        }
        driver.quit();
    }

}

