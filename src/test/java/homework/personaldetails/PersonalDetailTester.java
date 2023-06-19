package homework.personaldetails;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PersonalDetailTester {
    public static void main(String[] args) throws InterruptedException {

        // Reading the personal details from Excel sheet
        var excelSheetData = ExcelReader.reader(Constants.EXCEL_FILE_PATH, "Sheet1");

        // Opening the browser
        WebDriver driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();

        // LogIn with the valid credentials
        WebElement userName = driver.findElement(By.xpath("//input[@name='txtUsername']"));
        userName.sendKeys("Admin");
        WebElement userPassword = driver.findElement(By.xpath("//input[@name='txtPassword']"));
        userPassword.sendKeys("Hum@nhrm123");
        WebElement logInBtn = driver.findElement(By.xpath("//input[contains(@id, 'btn')]"));
        logInBtn.click();

        for (var map : excelSheetData) {
            // Pim tab click
            WebElement pimTab = driver.findElement(By.xpath("//a[@id='menu_pim_viewPimModule']"));
            pimTab.click();

            // Add employee tab
            WebElement addEmployee = driver.findElement(By.xpath("//a[@id='menu_pim_addEmployee']"));
            addEmployee.click();

            // Filling up the personal details
            // Full Name
            WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
            firstName.sendKeys(map.get("FirstName"));
            WebElement middleName = driver.findElement(By.xpath("//input[@id='middleName']"));
            middleName.sendKeys(map.get("MiddleName"));
            WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
            lastName.sendKeys(map.get("LastName"));

            // Save btn
            WebElement saveBtn1 = driver.findElement(By.xpath("//input[@id='btnSave']"));
            saveBtn1.click();

            // Edit btn
            WebElement editBtn = driver.findElement(By.xpath("//input[@id='btnSave']"));
            editBtn.click();

            // Employee Id
            WebElement employeeId = driver.findElement(By.xpath("//input[@id='personal_txtEmployeeId']"));
            employeeId.clear();
            employeeId.sendKeys(map.get("EmployeeId"));

            // Other Id
            WebElement otherId = driver.findElement(By.xpath("//input[@id='personal_txtOtherID']"));
            otherId.sendKeys(map.get("OtherId"));

            // Driver's License Number
            WebElement licenseNumber = driver.findElement(By.xpath("//input[@id='personal_txtLicenNo']"));
            licenseNumber.sendKeys(map.get("DriverLicenseNumber"));

            // Getting License Expiry Date calendar
            WebElement licenseExpiryDatePicker = driver.findElement(By.xpath("//img[contains(@src,'calendar.png' )]"));
            licenseExpiryDatePicker.click();

            // Selecting the year of License Expiry Date
            WebElement yearOfLicenseExpiry = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
            Select selectYear = new Select(yearOfLicenseExpiry);
            selectYear.selectByVisibleText(map.get("YearOfLicenseExpiryDate"));

            // Selecting the month of License Expiry Date
            WebElement monthOfLicenseExpiry = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
            Select selectMonth = new Select(monthOfLicenseExpiry);
            selectMonth.selectByVisibleText(map.get("MonthOfLicenseExpiryDate"));

            // Selecting the day of License Expiry Date
            List<WebElement> daysOfLicenseExpiry = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td"));
            for (WebElement expiryDay : daysOfLicenseExpiry) {
                String dayText = expiryDay.getText();
                if (dayText.equals(map.get("DayOfLicenseExpiryDate"))) {
                    expiryDay.click();
                    break;
                }
            }

            // SSN Number
            WebElement ssnNumber = driver.findElement(By.xpath("//input[@id='personal_txtNICNo']"));
            ssnNumber.sendKeys(map.get("SSNNumber"));

            // SIN Number
            WebElement sinNumber = driver.findElement(By.xpath("//input[@id='personal_txtSINNo']"));
            sinNumber.sendKeys(map.get("SINNumber"));

            // Selecting the Gender
            if (map.get("Gender").equals("Male")) {
                driver.findElement(By.xpath("//input[@id='personal_optGender_1']")).click();
            } else if (map.get("Gender").equals("Female")) {
                driver.findElement(By.xpath("//input[@id='personal_optGender_2']")).click();
            }

            // Marital Status
            WebElement maritalStatus = driver.findElement(By.xpath("//select[@id='personal_cmbMarital']"));
            Select selectMartialStatus = new Select(maritalStatus);
            selectMartialStatus.selectByVisibleText(map.get("MaritalStatus"));

            // Nationality
            WebElement nationality = driver.findElement(By.xpath("//select[@id='personal_cmbNation']"));
            Select selectNationality = new Select(nationality);
            selectNationality.selectByVisibleText(map.get("Nationality"));

            // Getting Date Of Birth calendar
            WebElement dateOfBirthDatePicker = driver.findElement(By.xpath("//input[@id='personal_DOB']"));
            dateOfBirthDatePicker.click();

            // Selecting the year of Date Of Birth
            WebElement yearOfDateOfBirth = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
            Select selectYearOfDOB = new Select(yearOfDateOfBirth);
            selectYearOfDOB.selectByVisibleText(map.get("DateOfBirthYear"));

            // Selecting the month of Date Of Birth
            WebElement monthOfDateOfBirth = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
            Select selectMonthOfDOB = new Select(monthOfDateOfBirth);
            selectMonthOfDOB.selectByVisibleText(map.get("DateOfBirthMonth"));

            // Selecting the day of Date Of Birth
            List<WebElement> daysOfDOB = driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr/td"));
            for(WebElement birthDay: daysOfDOB){
                String birthDayText = birthDay.getText();
                if(birthDayText.equals(map.get("DateOfBirthDay"))){
                    birthDay.click();
                    break;
                }
            }

            // Nick Name
            WebElement nickName = driver.findElement(By.xpath("//input[@id='personal_txtEmpNickName']"));
            nickName.sendKeys("NickName");

            // Smoker or Non-smoker
            WebElement smokerCheckBox = driver.findElement(By.xpath("//input[@id='personal_chkSmokeFlag']"));
            smokerCheckBox.click();

            //Military Service
            WebElement militaryService = driver.findElement(By.xpath("//input[@id='personal_txtMilitarySer']"));
            militaryService.sendKeys("MilitaryService");

            // Save btn
            WebElement saveBtn2 = driver.findElement(By.xpath("//input[@id='btnSave']"));
            //saveBtn2.click();

        }

    }

}


