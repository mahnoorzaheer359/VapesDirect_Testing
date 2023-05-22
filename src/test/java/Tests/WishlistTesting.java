package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class WishlistTesting {
    WebDriver driver;

    @BeforeTest//(enabled = false)
    public void InitializeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(groups = {"Group2"})
    public void AddToWishlist() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver= new ChromeDriver();
//        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/vapes-shop-in-pakistan/");

        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);

        jse.executeScript("window.scrollBy(0,550)");

        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[6]/Div/Div[2]/Div[1]/Div[2]/Div/Button/I")).click();
        Thread.sleep(5000);
    }

    @Test
    public void BrowseToWishlist() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver= new ChromeDriver();
//        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/vapes-shop-in-pakistan/");

        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);

        jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(1500);

        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[6]/Div/Div[2]/Div[1]/Div[2]/Div/Button/I")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[6]/Div/Div[2]/Div[1]/Div[2]/Div/Div/Div/Div/A")).click();
        Thread.sleep(5000);
    }

    @Ignore
    @Test
    public void RemoveFromWishlist() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/vapes-shop-in-pakistan/");

//        Thread.sleep(3500);
//        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);

        jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(1500);

        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[6]/Div/Div[2]/Div[1]/Div[2]/Div/Button/I")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[6]/Div/Div[2]/Div[1]/Div[2]/Div/Div/Div/Div/A")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/form/table/tbody/tr[1]/td[6]/a[2]")).click();
        Thread.sleep(5000);
    }

    @Ignore
    @Test
    public void DeleteFromWishList() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/vapes-shop-in-pakistan/");

//        Thread.sleep(3500);
//        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);

        jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(1500);

        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[6]/Div/Div[2]/Div[1]/Div[2]/Div/Button/I")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[6]/Div/Div[2]/Div[1]/Div[2]/Div/Div/Div/Div/A")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/form/table/tbody/tr/td[1]/div/a")).click();
        Thread.sleep(5000);
    }

    @AfterTest()
    public void Teardown(){
        driver.quit();
    }
}
