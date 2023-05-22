package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CartTesting {
    WebDriver driver;
    @BeforeTest(enabled = false)
    public void InitializeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test(groups = {"Group1"})
    public void AddToCart() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/tokyo-freebase/");
        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);
        jse.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[2]/Div/Div[2]/Div/Div[3]/Div/Div/Div[2]/Div[1]/Div/Div[2]/Div[2]/Div[3]/A")).click();
        Thread.sleep(5000);
    }

    @Test
    public void AddToCartFromQuickView() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/tokyo-freebase/");
        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);
        jse.executeScript("window.scrollBy(0,130)");
        Thread.sleep(1500);
        Actions a = new Actions(driver);

        WebElement e = driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[2]/Div/Div[2]/Div/Div[3]/Div/Div/Div[2]/Div[1]/Div/Div[2]/Div[1]/Div[1]/A/Img"));

        a.moveToElement(e).perform();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[2]/Div/Div[2]/Div/Div[3]/Div/Div/Div[2]/Div[1]/Div/Div[2]/Div[1]/Div[4]/A")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/Html/Body/Div[2]/Div/Div[1]/Div/Div/Div/Div[2]/Div/Form/Button")).click();
        Thread.sleep(5000);
    }



    @Test
    public void AddToCartFromProductDetails() throws InterruptedException {
        driver.get("https://vapesdirect.pk/tokyo-freebase/");
        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);

        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[2]/Div/Div[2]/Div/Div[3]/Div/Div/Div[2]/Div[1]/Div/Div[2]/Div[1]/Div[1]/A/Img")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/div[2]/main/div/div[2]/div/div[2]/div[2]/div/div[6]/form/button")).click();
        Thread.sleep(5000);
    }

    @Test(groups = {"Group1"})
    public void ViewCartAfterAddingProduct() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/vapes-shop-in-pakistan/");

        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);

        jse.executeScript("window.scrollBy(0,800)");
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[8]/Div/Div[2]/Div[2]/Div[3]/A")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[8]/Div/Div[2]/Div[2]/Div[3]/A[2]")).click();
        Thread.sleep(5000);
    }

    @Test
    public void ViewCartFromTopNav() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/vapes-shop-in-pakistan/");

        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);

        jse.executeScript("window.scrollBy(0,800)");
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[8]/Div/Div[2]/Div[2]/Div[3]/A")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("/Html/Body/Div[2]/Header/Div/Div[2]/Div[1]/Div[4]/Ul/Li[10]/A/Span/Strong")).click();
        Thread.sleep(5000);

    }

    @Test
    public void DecrementProductInCart() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/vapes-shop-in-pakistan/");

        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);
        jse.executeScript("window.scrollBy(0,750)");
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[8]/Div/Div[2]/Div[1]/Div[1]/A/Img")).click();
        Thread.sleep(1500);
        jse.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("/html/body/div[2]/main/div/div[2]/div/div[2]/div[2]/div/div[6]/form/div/input[3]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/main/div/div[2]/div/div[2]/div[2]/div/div[6]/form/button")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/div[2]/header/div/div[2]/div[1]/div[4]/ul/li[10]/a/span/strong")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("html/body/div[1]/main/div[2]/div/div[2]/div[1]/form/div/table/tbody/tr[1]/td[5]/div/input[1]")).click();
        Thread.sleep(5000);
//
    }

    @Test
    public void IncrementProductInCart() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/vapes-shop-in-pakistan/");

        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);
        jse.executeScript("window.scrollBy(0,750)");
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[8]/Div/Div[2]/Div[1]/Div[1]/A/Img")).click();
        Thread.sleep(1500);
        jse.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("/html/body/div[2]/main/div/div[2]/div/div[2]/div[2]/div/div[6]/form/div/input[3]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/main/div/div[2]/div/div[2]/div[2]/div/div[6]/form/button")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/div[2]/header/div/div[2]/div[1]/div[4]/ul/li[10]/a/span/strong")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[2]/div[1]/form/div/table/tbody/tr[1]/td[5]/div/input[3]")).click();
        Thread.sleep(5000);
    }

    @Test(groups = {"Group1"})
    public void DeleteProductFromCart() throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/vapes-shop-in-pakistan/");

        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);
        jse.executeScript("window.scrollBy(0,750)");
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[8]/Div/Div[2]/Div[1]/Div[1]/A/Img")).click();
        Thread.sleep(1500);
        jse.executeScript("window.scrollBy(0,500)");
        driver.findElement(By.xpath("/html/body/div[2]/main/div/div[2]/div/div[2]/div[2]/div/div[6]/form/div/input[3]")).click();
        driver.findElement(By.xpath("/html/body/div[2]/main/div/div[2]/div/div[2]/div[2]/div/div[6]/form/button")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/div[2]/header/div/div[2]/div[1]/div[4]/ul/li[10]/a/span/strong")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[2]/div[1]/form/div/table/tbody/tr[1]/td[1]/a")).click();
        Thread.sleep(5000);

    }
    @AfterTest()
    public void Teardown(){
        driver.quit();
    }
}
