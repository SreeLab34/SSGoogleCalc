package demo;

import java.lang.Thread;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.*;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestCases {
    ChromeDriver driver;
    public TestCases() throws MalformedURLException
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);
        options.addArguments("start-maximized");
        options.addArguments("--disable-blink-features=AutomationControlled");
        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();
    }
    
    public void testCase01() throws InterruptedException {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.google.com");
        // Get the current URL
         String currentURL = driver.getCurrentUrl();
         if (currentURL.contains("google")) {
            System.out.println("Test case passed: URL contains 'google'");
        } else {
            System.out.println("Test case failed: URL does not contain 'google'");
        }
         WebElement searchBar = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        // searchBar.click();
        searchBar.sendKeys("calculator");
        Thread.sleep(1000);
        searchBar.sendKeys(Keys.DOWN);
        searchBar.sendKeys(Keys.ENTER);
        String currentURL1 = driver.getCurrentUrl();

        // Verify that the URL contains "calculator"
        if (currentURL1.contains("calculator")) {
            System.out.println("Test case passed: URL contains 'calculator'");
        } else {
            System.out.println("Test case failed: URL does not contain 'calculator'");
        }
        WebElement cal = driver.findElement(By.xpath("//span[@id='cwos'][text()='0']"));
        if(cal.getText().contains("0"))
        {
             System.out.println("Test case passed:  contains 'zero'");
        } else {
            System.out.println("Test case failed:does not contain 'zero'");
        }
        System.out.println("End Test case: testCase01");
    }



    public void testCase02() throws InterruptedException
     {
        System.out.println("Start Test case: testCase02");
        driver.get("https://www.google.com");
        WebElement searchBar1 = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBar1.sendKeys("calculator");
        Thread.sleep(1000);
        searchBar1.sendKeys(Keys.DOWN);
        searchBar1.sendKeys(Keys.ENTER);
        WebElement five = driver.findElement(By.xpath("//div[@class='XRsWPe AOvabd'][text()=5]"));
        five.click();
         WebElement plus = driver.findElement(By.xpath("(//div[@class='XRsWPe MEdqYd'])[13]"));
        plus.click();
         WebElement seven = driver.findElement(By.xpath("//div[@class='XRsWPe AOvabd'][text()=7]"));
        seven.click();
        WebElement equal = driver.findElement(By.xpath("//div[@class='XRsWPe UUhRt']"));
        equal.click();        
        WebElement result = driver.findElement(By.id("cwos"));
        String additionResult = result.getText();
        System.out.println("Result of addition (5 + 7): " + additionResult);
        if (additionResult.equals("12")) {
            System.out.println("Addition test passed.");
        } else {
            System.out.println("Addition test failed.");
        }
         WebElement clr = driver.findElement(By.xpath("(//div[@class='XRsWPe MEdqYd'])[8]"));
        clr.click();
        WebElement one = driver.findElement(By.xpath("//div[@class='XRsWPe AOvabd'][text()=1]"));
        one.click();
       // WebElement five = driver.findElement(By.xpath("//div[@class='XRsWPe AOvabd'][text()=5]"));
        five.click();
         WebElement minus = driver.findElement(By.xpath("(//div[@class='XRsWPe MEdqYd'])[12]"));
        minus.click();
         WebElement eight = driver.findElement(By.xpath("//div[@class='XRsWPe AOvabd'][text()=8]"));
        eight.click();
       // WebElement equal = driver.findElement(By.xpath("//div[@class='XRsWPe UUhRt']"));
        equal.click();        
        //WebElement result = driver.findElement(By.id("cwos"));
        String subResult = result.getText();
        System.out.println("Result of sub: " + subResult);
        if (subResult.equals("7")) {
            System.out.println("sub test passed.");
        } else {
            System.out.println("sub test failed.");
        }
        clr.click();
        System.out.println("End Test case: testCase02");
    }



    public void testCase03() throws InterruptedException
     {
        System.out.println("Start Test case: testCase03");
        driver.get("https://www.google.com");
        WebElement searchBar2 = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBar2.sendKeys("calculator");
        Thread.sleep(1000);
        searchBar2.sendKeys(Keys.DOWN);
        searchBar2.sendKeys(Keys.ENTER);
        WebElement one = driver.findElement(By.xpath("//div[@class='XRsWPe AOvabd'][text()=1]"));
        one.click(); 
        WebElement zero = driver.findElement(By.xpath("//div[@class='XRsWPe AOvabd'][text()=0]"));
        zero.click();    
        WebElement mul = driver.findElement(By.xpath("(//div[@class='XRsWPe MEdqYd'])[11]"));
        mul.click();
         WebElement three = driver.findElement(By.xpath("//div[@class='XRsWPe AOvabd'][text()=3]"));
        three.click();
        WebElement equal = driver.findElement(By.xpath("//div[@class='XRsWPe UUhRt']"));
        equal.click();        
        WebElement result = driver.findElement(By.id("cwos"));
        String mulRes = result.getText();
        System.out.println("Result of addition (5 + 7): " + mulRes);
        if (mulRes.equals("30")) {
            System.out.println("Mul test passed.");
        } else {
            System.out.println("mul test failed.");
        }
        WebElement clr = driver.findElement(By.xpath("(//div[@class='XRsWPe MEdqYd'])[8]"));
        clr.click();
       // WebElement result = driver.findElement(By.id("cwos"));
        String z = result.getText();
       // System.out.println("Result of addition (5 + 7): " + mulRes);
        if (z.equals("0")) {
            System.out.println(" test passed.");
        } else {
            System.out.println(" test failed.");
        }
        System.out.println("End Test case: testCase03");
    }

    public void testCase04() throws InterruptedException
     {
        System.out.println("Start Test case: testCase04");
        driver.get("https://www.google.com");
        WebElement searchBar2 = driver.findElement(By.xpath("//textarea[@id='APjFqb']"));
        searchBar2.sendKeys("calculator");
        Thread.sleep(1000);
        searchBar2.sendKeys(Keys.DOWN);
        searchBar2.sendKeys(Keys.ENTER);
        WebElement two = driver.findElement(By.xpath("//div[@class='XRsWPe AOvabd'][text()=2]"));
        two.click(); 
        WebElement zero = driver.findElement(By.xpath("//div[@class='XRsWPe AOvabd'][text()=0]"));
        zero.click();    
        WebElement div = driver.findElement(By.xpath("(//div[@class='XRsWPe MEdqYd'])[10]"));
        div.click();
         WebElement three = driver.findElement(By.xpath("//div[@class='XRsWPe AOvabd'][text()=4]"));
        three.click();
        WebElement equal = driver.findElement(By.xpath("//div[@class='XRsWPe UUhRt']"));
        equal.click();        
        WebElement result = driver.findElement(By.id("cwos"));
        String divRes = result.getText();
        System.out.println("Result : " + divRes);
        if (divRes.equals("5")) {
            System.out.println("div test passed.");
        } else {
            System.out.println("div test failed.");
        }
      
        System.out.println("End Test case: testCase04");
    }


}
