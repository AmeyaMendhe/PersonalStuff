package Runner;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import io.cucumber.testng.CucumberFeatureWrapper;
//import io.cucumber.testng.CucumberScenarioWrapper;
//import io.cucumber.testng.PickleEventWrapper;
import io.cucumber.testng.TestNGCucumberRunner;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;

import java.sql.Driver;


public class TestListener implements ITestListener {

    private ExtentReports extentReports;
    private ExtentTest test;
    WebDriver driver = new ChromeDriver();


    @Override
    public void onStart(ITestContext context) {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("target/extent-spark-report.html");


        sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);
        sparkReporter.config().setReportName("BDD Cucumber Test Report");
        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);

        extentReports.setSystemInfo("Environment","US Development");
        extentReports.setSystemInfo("Browser", "Chrome");
        extentReports.setSystemInfo("OS", "Windows 11");
        extentReports.setSystemInfo("Version", "XYZ");


    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extentReports.createTest(result.getName());
//        driver.get("https://www.google.com/");
//        driver.manage().window().maximize();
//        System.out.println("1");



    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test NG Passed");
        String screenshotPath = null;
        try {
            Thread.sleep(2000);
            screenshotPath = ScreenshotUtils.captureScreenshot(driver, result.getName() + "_pass");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        String screenshotPath = null;
        try {
            Thread.sleep(2000);
            screenshotPath = ScreenshotUtils.captureScreenshot(driver, result.getName() + "_fail");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(screenshotPath);
        System.out.println("Test NG fail");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.skip("Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
        driver.quit();
    }

    @AfterSuite
    public void teardown()
    {
        if (driver!= null)
        {
            driver.quit();
        }
    }


}
