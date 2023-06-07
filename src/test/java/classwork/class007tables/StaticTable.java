package classwork.class007tables;

import homework.utils.CommonMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class StaticTable extends CommonMethods {
    public static void main(String[] args) {
        String url = "https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html";
        String browser = "chrome";
        openBrowserAndLaunchApplication(url, browser);

       // print the whole table on the console

        /** Table level access -> gets the whole table information as "a single string" L19,20,21 */
        // get the whole elements
        WebElement wholeTable = driver.findElement(By.xpath("//table[@id='customers']"));
        String allTextOfTable = wholeTable.getText();
        System.out.println("Table Name is : " + allTextOfTable);

        System.out.println("..............................................................");

        /** Row level access -> gets all the rows */
        // prints all the rows of the table separately
        // modified: print the row that contains google as company name
        List<WebElement> allRows = driver.findElements(By.xpath("//table[@id='customers']/tbody/tr"));
        for(WebElement row: allRows){
            String rowText = row.getText();
            if(rowText.contains("Google")){
                System.out.println(rowText);
            }

        }

        System.out.println("..............................................................");

        /** column level access -> gets all the cell */
        // prints each and every columns elements separately
        List<WebElement> allCellData = driver.findElements(By.xpath("//*[@id='customers']/tbody/tr/td"));
        for (WebElement cellData : allCellData) {
            String cellText = cellData.getText();
            System.out.println(cellText);

        }
    }
}
