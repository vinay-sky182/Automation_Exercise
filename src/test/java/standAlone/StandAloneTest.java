package standAlone;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;
import org.testng.Assert;

public class StandAloneTest {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Navigate to url 'http://automationexercise.com'
        driver.get("https://automationexercise.com/");
        driver.manage().window().maximize();

        // 3. Verify that home page is visible successfully
        String titile = driver.getTitle();
        System.out.println(titile);
        Assert.assertEquals(titile, "Automation Exercise");

        // 4. Click on 'Signup / Login' button
        driver.findElement(By.cssSelector("i[class=\"fa fa-lock\"]")).click();

        // 5. Verify 'New User Signup!' is visible
        String signUp = driver.findElement(By.xpath("//div [@class=\"signup-form\"]/h2")).getText();
        System.out.println(signUp);
        Assert.assertEquals(signUp, "New User Signup!");

        // input[@data-qa="signup-name"]
        // 6. Enter name and email address
        driver.findElement(By.xpath("//input[@data-qa=\"signup-name\"]")).sendKeys("shubham tyagi");
        driver.findElement(By.xpath("//input[@data-qa=\"signup-email\"]")).sendKeys("ayush.am77@gmail.com");

        // 7. Click 'Signup' buttonT
        driver.findElement(By.xpath("//button[@data-qa=\"signup-button\"]")).click();

        // 8. Verify that 'ENTER ACCOUNT INFORMATION' is visible

        String signUpPage = driver.findElement(By.xpath("//div[@class=\"login-form\"]/h2")).getText();
        SoftAssert sa = new SoftAssert();
        sa.assertEquals(signUpPage, "Enter Account Informatio");
        System.out.println(signUpPage);

        // 9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.id("id_gender1")).click();
        driver.findElement(By.id("id_gender1")).isSelected();

        driver.findElement(By.id("password")).sendKeys("TyagiG");

        Select dropDownDay = new Select(driver.findElement(By.id("days")));
        dropDownDay.selectByIndex(2);
        Select dropDownMonths = new Select(driver.findElement(By.id("months")));
        dropDownMonths.selectByValue("4");
        Select dropDownYears = new Select(driver.findElement(By.id("years")));
        dropDownYears.selectByVisibleText("2016");

        // 10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.id("newsletter")).click();
//      driver.findElement(By.id("newsletter")).isSelected();

        // 11. Select checkbox 'Receive special offers from our partners!'

        driver.findElement(By.id("optin")).click();
//      driver.findElement(By.id("optin")).isSelected();

        // 12. Fill details: First name, Last name, Company, Address, Address2, Country,
        // State, City, Zipcode, Mobile Number
        driver.findElement(By.id("first_name")).sendKeys("Shubham");
        driver.findElement(By.id("last_name")).sendKeys("Tyagi");
        driver.findElement(By.id("company")).sendKeys("Keywords");
        driver.findElement(By.id("address1")).sendKeys("sector 45");
        driver.findElement(By.id("address2")).sendKeys("gurgaon");
        driver.findElement(By.id("state")).sendKeys("haryana");
        driver.findElement(By.xpath("//label[@for=\"city\"]/following-sibling::input[@data-qa=\"city\"]"))
                .sendKeys("delhi");
        driver.findElement(By.id("zipcode")).sendKeys("122087");
        driver.findElement(By.id("mobile_number")).sendKeys("2456531441");

        // 13. Click 'Create Account button'
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[1]")).click();

        // 14. Verify that 'ACCOUNT CREATED!' is visible

        String accountCreated = driver.findElement(By.xpath("//h2/b")).getText();
        sa.assertEquals(accountCreated, "Account Created!");
        System.out.println(accountCreated);
        // 15. Click 'Continue' button
        driver.findElement(By.xpath("//a[@class= 'btn btn-primary']")).click();

        // 16. Verify that 'Logged in as username' is visibleṭ
        String userName = driver.findElement(By.xpath("//a/b")).getText();
        sa.assertEquals(userName, "shubham tyagi");
        // 17. Click 'Delete Account' button
        driver.findElement(By.linkText("Delete Account")).click();

        // 18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue'
        String accountDeleted = driver.findElement(By.xpath("//h2/b")).getText();

        sa.assertEquals(accountDeleted, "Account Deleted!");
        System.out.println(accountDeleted);

        driver.findElement(By.xpath("//a[@class= 'btn btn-primary']")).click();

        sa.assertAll();
    }
}
