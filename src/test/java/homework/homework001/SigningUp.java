/*
HW1:
navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
fill out the form
close the browser
Note: use name or id as locators
HW2:
navigate to "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx"
enter the username "Tester"
enter the password "test"
get the title of the webPage and confirm that it is  "Web Orders Login"
 */
package homework.homework001;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SigningUp {

    public static void main(String[] args) throws InterruptedException {
        //creating the instance
        WebDriver driver = new ChromeDriver();

        //navigating to the web page to sign up
        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");

        //finding the tagName by ids & filling up the form
        driver.findElement(By.id("customer.firstName")).sendKeys("Kiran");
        driver.findElement(By.id("customer.lastName")).sendKeys("Adhikari");
        driver.findElement(By.id("customer.address.street")).sendKeys("5555 Right there St.");
        driver.findElement(By.id("customer.address.city")).sendKeys("Springfield");
        driver.findElement(By.id("customer.address.state")).sendKeys("VA");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("22151");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("1-221-515-0050");
        driver.findElement(By.id("customer.ssn")).sendKeys("222-515-6666");

        //slowing down the execution
        Thread.sleep(2000);
        driver.findElement(By.id("customer.username")).sendKeys("kiran123");
        driver.findElement(By.id("customer.password")).sendKeys("123pass");
        driver.findElement(By.id("repeatedPassword")).sendKeys("123pass");

        //slowing down the execution
        Thread.sleep(2000);

        //getting the web page tittle and verifying it.
        String title = driver.getTitle();
        System.out.println("The current web page title is : " + title);
        if (title.equalsIgnoreCase("ParaBank | Register for Free Online Account Access")) {
            System.out.println("Title is correct which is \nParaBank | Register for Free Online Account Access");
        } else {
            System.out.println("Title is not correct which is \nWeb Orders Login");
        }

        //closing the window
        driver.close();
    }
}
