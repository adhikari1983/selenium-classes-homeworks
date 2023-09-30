package zpractice1.class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchingBrowser {
    public static void main(String[] args) throws InterruptedException {
        // Use WebDriverManager to set up ChromeDriver
       // WebDriverManager.chromedriver().setup();
        // Set the desired ChromeDriver version
        //WebDriverManager.chromedriver().browserVersion("114.0.5735.90").setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");
        //driver.navigate().to("https://www.google.com");
        driver.manage().window().maximize();
        //driver.manage().window().fullscreen();

        System.out.println(driver.getTitle());

        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
        driver.findElement(By.name("pass")).sendKeys("abc123");

       // driver.quit();
    }
}
