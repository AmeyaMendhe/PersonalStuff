package Runner;

import com.aventstack.extentreports.ExtentTest;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ScreenshotUtils {
//    public static String captureScreenshot(WebDriver driver, String screenshotName) throws InterruptedException {
//
//        Thread.sleep(3000);
//        File screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//        String destinationPath = "target/screenshots/" + screenshotName + ".png";
//        File destinationFile = new File(destinationPath);
//
//        try {
//            FileUtils.copyFile(screenshot, destinationFile);
//
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        return destinationPath;
//    }

    public static String captureScreenshot(WebDriver driver, String screenshotName) throws InterruptedException {
        // Ensure the screenshot directory exists
        String screenshotDir = "target/screenshots/";
        File dir = new File(screenshotDir);
        if (!dir.exists()) {
            dir.mkdirs(); // Create directory if it doesn't exist
        }

        // Implicit wait to make sure elements are loaded properly
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Capture screenshot
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Destination path where screenshot will be saved
        String destinationPath = screenshotDir + screenshotName + ".png";
        File destinationFile = new File(destinationPath);

        try {
            // Copy the screenshot to the destination path
            FileUtils.copyFile(screenshot, destinationFile);
            Thread.sleep(500); // Add a small delay

            System.out.println("Screenshot saved to: " + destinationPath);
        } catch (IOException e) {
            System.err.println("Error while saving screenshot: " + e.getMessage());
            e.printStackTrace();
        }

        return destinationPath;
    }



}
