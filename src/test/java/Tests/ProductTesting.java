package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class ProductTesting {
    WebDriver driver;
    @BeforeTest(enabled = false)
    public void InitializeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(groups = {"Group1","Group2"})
    public void ProductQuickView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/tokyo-freebase/");
        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);
        jse.executeScript("window.scrollBy(0,125)");
        Thread.sleep(1500);
        Actions a = new Actions(driver);

        WebElement e = driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[2]/Div/Div[2]/Div/Div[3]/Div/Div/Div[2]/Div[1]/Div/Div[2]/Div[1]/Div[1]/A/Img"));

        a.moveToElement(e).perform();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[2]/Div/Div[2]/Div/Div[3]/Div/Div/Div[2]/Div[1]/Div/Div[2]/Div[1]/Div[4]/A")).click();
        Thread.sleep(5000);
    }

    @Ignore
    @Test
    public void ProductDetails() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/tokyo-freebase/");
        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);
        jse.executeScript("window.scrollBy(0,100)");

        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[2]/Div/Div[2]/Div/Div[3]/Div/Div/Div[2]/Div[1]/Div/Div[2]/Div[1]/Div[1]/A/Img")).click();
        Thread.sleep(5000);
    }

    @Test
    public void SelectOptionsOfProduct() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/tokyo-freebase/");
//        Thread.sleep(3500);
//        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);
        jse.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("//Html/Body/Div[2]/Main/Div/Div/Section[2]/Div/Div[2]/Div/Div[3]/Div/Div/Div[2]/Div[5]/Div/Div[2]/Div[2]/Div[3]/A")).click();
        Thread.sleep(1500);
        jse.executeScript("window.scrollBy(0,200)");
        WebElement e = driver.findElement(By.xpath("//*[@id=\"pa_strength\"]"));

        Select select = new Select(e);

        select.selectByValue("3mg");
        select.selectByIndex(1);
        select.selectByVisibleText("3MG");
        Thread.sleep(5000);
    }

    @Test
    public void QuantityOfProduct() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/tokyo-freebase/");
        Thread.sleep(3500);
//        driver.findElement(By.className("yes")).click();
//        Thread.sleep(1500);
        jse.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("//Html/Body/Div[2]/Main/Div/Div/Section[2]/Div/Div[2]/Div/Div[3]/Div/Div/Div[2]/Div[5]/Div/Div[2]/Div[2]/Div[3]/A")).click();
        Thread.sleep(1500);

        jse.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("/html/body/div[2]/main/div/div[2]/div/div[2]/div[2]/div/div[6]/form/div/div[2]/div/input[3]")).click();
        Thread.sleep(5000);
    }
    @AfterTest()
    public void Teardown(){
        driver.quit();
    }
}
