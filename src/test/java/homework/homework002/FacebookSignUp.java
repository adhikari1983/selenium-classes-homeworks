/*
    HW  (only use XPATH)
    navigate to fb.com
    click on create new account
    fill up all the textboxes
    close the popup
    close the browser
    Note : in order for ur code to work
    u have to put Thread.sleep(2000) after clicking on Create new account
 */
package homework.homework002;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookSignUp {
    public static void main(String[] args) throws InterruptedException {
        //creates the instance of chrome driver
        WebDriver driver = new ChromeDriver();

        //navigates to facebook.com
        driver.get("https://www.facebook.com/");

        //clicks the creates new accounts
        driver.findElement(By.xpath("//a[text()='Create new account']")).click();
        Thread.sleep(2000);

        // fills up all the textBoxes
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Kiran");

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("123pass");

        WebElement email = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        email.sendKeys("kiran123@gmail.com");

        WebElement confirmEmail = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        confirmEmail.sendKeys("kiran123@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='password_step_input']"));
        password.sendKeys("123pass");

        WebElement month = driver.findElement(By.xpath("//select[@id='month']"));
        month.sendKeys("Dec");

        WebElement birthDay = driver.findElement(By.xpath("//select[@id='day']"));
        birthDay.sendKeys("29");

        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        year.sendKeys("1988");

        WebElement gender = driver.findElement(By.xpath("//label[text()='Male']"));
        gender.click();

        //closes the popUp
        WebElement signUp = driver.findElement(By.xpath("//button[text()='Sign Up']"));
        signUp.click();

        //slowing down execution of the program to see the SignUp button clicked
        Thread.sleep(2000);

        //closes the browser
        driver.quit();

    }
}
