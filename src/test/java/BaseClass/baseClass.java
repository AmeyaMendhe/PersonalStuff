//package BaseClass;
//
//import Runner.ScreenshotUtils;
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
////import io.cucumber.java.Scenario;
//
//import java.io.File;
//import java.io.IOException;
//
//
//public class baseClass {
//WebDriver driver = new ChromeDriver();
//    @Before
//    public void beforeScenario(){
//        WebDriver driver= new ChromeDriver();
//    }
//
//    @After
//    public void afterScenario(){
//        if (driver != null){
//            if (scenario.isFailed()){
//                String screenshotPath = ScreenshotUtils.captureScreenshot(driver, scenario.getName()+"Fail");
//                scenario.attach(screenshotPath.getBytes(), "image/png", scenario.getName());
//            }
//            else {
//                String screenshotPath = ScreenshotUtils.captureScreenshot(driver, scenario.getName()+"Pass");
//                scenario.attach(screenshotPath.getBytes(), "image/png", scenario.getName());
//            }
//        }
//    }
//
////    why using protected search it
//    public void TakeSS() throws IOException {
//        WebDriver driver = new ChromeDriver();
//        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
//
//
//        File srcFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
//        File destFile = new File("C:\\Users\\ameya\\Carters\\src\\test\\Screenshots\\fullpage.png");
//
//        FileUtils.copyFile(srcFile, destFile);
//
//        if (driver != null)
//            driver.quit();
//
//    }
//
//}
