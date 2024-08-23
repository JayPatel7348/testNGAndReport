package ExtentReport;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.Assert;

import org.testng.annotations.*;
import pages.MouseHover;
import pages.SwitchWindow;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.screenShot;

import java.io.IOException;
import org.apache.commons.io.FileUtils;


public class GeeksForGeeks {

    ChromeDriver driver;
    screenShot ss;

    MouseHover mh;
    SwitchWindow sw;

    ExtentReports extent;
    @BeforeClass
    public void initExtentObject()
    {
        ExtentSparkReporter reporter = new ExtentSparkReporter("Reports/report.html");
        extent = new ExtentReports();
        extent.attachReporter(reporter);

        reporter.config().setDocumentTitle("Project Management System");
        reporter.config().setReportName("Regression report");

        extent.setSystemInfo("Project Name","Project Management System");
        extent.setSystemInfo("Dev Name","Jay Patel");
        extent.setSystemInfo("Project Deadline","23 Aug 2024");
        extent.setSystemInfo("Release date","31 Aug 2024");
        extent.setSystemInfo("Sprint","SP1.1");


    }

    @AfterClass
    public void writeToReport()
    {

        extent.flush();
    }
    @BeforeMethod
    public void browserLaunch() throws InterruptedException {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.geeksforgeeks.org/");
    }
    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

    @Test(dataProvider = "getData")
    public void openMenuDropdown(String mainmenu,String submenu,String submenu1,String submenu2,String expectedTitle) throws InterruptedException, IOException {

        ExtentTest test= extent.createTest("Open Dropdown Menu");
        //Mouse Hover
        mh=new MouseHover();
        mh.mouseHover(driver,"//*[normalize-space()='"+mainmenu+"']");

        Thread.sleep(1000);
        test.info("Mouse Hover performed on Main Menu");
        mh.mouseHover(driver,"//*[normalize-space()='"+submenu+"']");
        Thread.sleep(1000);
        test.info("Mouse Hover performed on Sub Menu");
        driver.findElement(By.xpath("//*[normalize-space()='"+submenu1+"']")).click();
        driver.findElement(By.xpath("//*[normalize-space()='"+submenu2+"']")).click();

        //Switching window
        sw=new SwitchWindow();
        sw.switchWindow1(driver);
        Thread.sleep(1000);
        //Take screenshot of switched window
        ss=new screenShot();
        ss.Screenshot(driver);
        //Take Fullpage screenshot


        String subject= driver.getTitle();
        Assert.assertEquals(subject,expectedTitle);


    }

    @DataProvider
    Object[][] getData()
    {
        Object[][] data=new Object[2][5];

        data[0][0]="Practice";
        data[0][1]="Language Wise Coding Practice";
        data[0][2]="Java";
        data[0][3]="Java Hello World";
        data[0][4]="Practice | GeeksforGeeks | A computer science portal for geeks";

        data[1][0]="Practice";
        data[1][1]="Practice Problems Difficulty Wise";
        data[1][2]="Easy";
        data[1][3]="Missing in Array";
        data[1][4]="Practice | GeeksforGeeks | A computer science portal for geeks";
        return data;
    }

}



