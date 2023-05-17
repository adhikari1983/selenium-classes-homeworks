package classwork.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateCommand {

    public static void main(String[] args) throws InterruptedException {
        //create web-driver instance
        WebDriver driver = new ChromeDriver();

        //goto google.com
        driver.get("https://google.com");

        //slow down => to be able to see the whole process ->  Thread.sleep(3000);
        Thread.sleep(2000);

        //navigate to facebook
        driver.navigate().to("https://facebook.com");

        //slow down
        Thread.sleep(2000);

        //refresh the page
        driver.navigate().refresh();
        Thread.sleep(1000);

        //go back to previous page
        driver.navigate().back();
        Thread.sleep(2000);

        //then go forward
        driver.navigate().forward();
        Thread.sleep(2000);
       // driver.manage().window().fullscreen();
        //Thread.sleep(2000);

        //closing the current tab
        driver.close();

    }

}
