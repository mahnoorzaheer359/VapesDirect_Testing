package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class SideNavTesting {
    WebDriver driver;

    @BeforeTest
    public void InitializeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(priority = 1)
    public void SideNavSearch() throws InterruptedException {
        driver.get("https://vapesdirect.pk/vapes-shop-in-pakistan/");

        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);

        driver.findElement(By.id("s")).sendKeys("pod", Keys.RETURN);
        Thread.sleep(5000);
    }


    @Test(priority = 2)
    public void SideNavProducts() throws InterruptedException {
        driver.get("https://vapesdirect.pk/vapes-shop-in-pakistan/");

//        Thread.sleep(3500);
//        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);

        driver.findElement(By.id("menu-item-27238")).click();
        Thread.sleep(5000);
    }

    //@Ignore
    @Test(priority = 3)
    public void SideNavBrowse() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/vapes-shop-in-pakistan/");

//        Thread.sleep(3500);
//        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);
        jse.executeScript("window.scrollBy(0,200)");
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[1]/Div/Div/Div/Aside[3]/Span[2]/Span[1]/Span/Span[1]/Span")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/Html/Body/Span[2]/Span/Span[1]/Input")).sendKeys("Pods",Keys.RETURN);
        Thread.sleep(5000);
    }

    @Test(priority = 4)
    public void SideNavFilter() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/vapes-shop-in-pakistan/");

//        Thread.sleep(3500);
//        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);
        jse.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[1]/Div/Div/Div/Aside[4]/Form/Span/Span[1]/Span/Span[1]/Span")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/Html/Body/Span[2]/Span/Span[1]/Input")).sendKeys("0.5 Ohm",Keys.RETURN);
        Thread.sleep(5000);
    }
    @AfterTest()
    public void Teardown(){
        driver.quit();
    }

}
