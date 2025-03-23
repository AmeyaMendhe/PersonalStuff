package StepDefination;

import io.cucumber.java.After;
import io.cucumber.java.PendingException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import Locators.locator;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

public class login {

    WebDriver driver = new ChromeDriver();

    @Given("User launch Carters Homepage")
    public void user_launch_carters_homepage() throws InterruptedException {
        driver.get("https://development.carters.com/");
        driver.manage().window().maximize();
        System.out.println("1");
        driver.findElement(By.xpath(locator.MyAccBtn_Xpath)).isDisplayed();
        System.out.println("2");
//        Thread.sleep(3000);
//        throw new io.cucumber.java.PendingException();
    }

    @When("User clicks on My Account")
    public void user_clicks_on_my_account() throws InterruptedException {
        System.out.println("3");
        driver.findElement(By.xpath(locator.MyAccBtn_Xpath)).click();
//        Thread.sleep(2000);


    }

    @And("Clicks on Sign In CTA")
    public void clicks_on_sign_in_cta() {
        driver.findElement(By.xpath(locator.SignInBtn_Xpath)).click();

    }

    @Then("Email & Password field is displayed")
    public void email_password_field_is_displayed() throws InterruptedException {
        System.out.println("passing");
        Thread.sleep(2000);
        driver.findElement(By.id(locator.EmailID_Field_Xpath)).sendKeys("mendheameya1@gmail.com");
        System.out.println("NOT");
//        WebDriver wait = new WebDriverWait(driver,30);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator.Password_Field_Xpath)));
        Thread.sleep(2000);
        driver.findElement(By.id(locator.Password_Field_Xpath)).sendKeys("Testing@17");

    }

    @And("Enters valid Credentials")
    public void enters_valid_credentials() {
        System.out.println("Creds sent");
        driver.findElement(By.xpath(locator.SignIn_CTA_Xapth)).click();

    }

    @Then("User should be logged in successfully")
    public void user_should_be_logged_in_successfully() throws InterruptedException, IOException {

        driver.findElement(By.xpath(locator.FamilyStatus_Xpath)).isDisplayed();
        Thread.sleep(2000);
        System.out.println("Done");

    }


    @And("Enter Invalid credentials")
    public void enterInvalidCredentials() {
        driver.findElement(By.xpath(locator.Password_Field_Xpath)).sendKeys("BrunceWane@gmail.com");
        System.out.println("Second Scenario");
        driver.findElement(By.xpath(locator.Password_Field_Xpath)).sendKeys("Testing@17");
        driver.findElement(By.xpath(locator.SignIn_CTA_Xapth)).click();

    }

    @Then("Validation message should be displayed")
    public void validationMessageShouldBeDisplayed() throws InterruptedException {
        String orgmssg = "Incorrect username or password. Please update the required fields and try again.";
        System.out.println("ye");
        Thread.sleep(3000);
        WebElement element = driver.findElement(By.xpath("//*[text()='Incorrect username or password. Please update the required fields and try again.']"));
//        element.getText();
        if (orgmssg.equals(element))
            System.out.println(element.getText()+"Scenario 2 Passed");
        else
            System.out.println(element.getText()+"Scenario 2 Failed");
    }
}
