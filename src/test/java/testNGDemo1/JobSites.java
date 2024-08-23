package testNGDemo1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class JobSites {

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

    @Test
    public void naukri()
    {
        driver.get("http://naukri.com");
    }
    @Test
    public void foundit()
    {
        driver.get("http://foundit.com");
    }
    @Test
    public void shine()
    {
        driver.get("https://shine.com/");
    }

}