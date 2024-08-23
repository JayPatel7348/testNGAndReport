package testNGDemo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SocialSites {

    WebDriver driver;
    @BeforeClass // method below this annotation will run before every test method
    public void openBrowser()
    {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterClass // method below this annotation will run after every test method of the class
    public void closeBrowser() throws InterruptedException {
        driver.close();
    }

    @Test (priority = 1)
    public void facebook()
    {
        driver.get("http://facebook.com");
    }
    @Test (priority = 2)
    public void twitter()
    {
        driver.get("http://twitter.com");
    }
    @Test (priority = 3)
    public void instagram()
    {
        driver.get("http://instagram.com");
    }
    @Test (priority = 4)
    public void linkedin()
    {
        driver.get("http://linkedin.com");
    }
}