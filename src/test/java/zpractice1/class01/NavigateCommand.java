package zpractice1.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateCommand {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        Thread.sleep(1000);

        driver.navigate().to("https://facebook.com");
        Thread.sleep(1000);

        driver.navigate().refresh();

        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();




    }
}
