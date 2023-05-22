package Tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CheckoutTesting {
    WebDriver driver;
    @BeforeTest
    public void InitializeBrowser(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }
    @Test
    public void Checkout() throws InterruptedException {
//        WebDriverManager.chromedriver().setup();
//        driver= new ChromeDriver();
//        driver.manage().window().maximize();
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/vapes-shop-in-pakistan/");

        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);

        jse.executeScript("window.scrollBy(0,800)");
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[8]/Div/Div[2]/Div[2]/Div[3]/A")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[8]/Div/Div[2]/Div[2]/Div[3]/A[2]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[2]/div[2]/div/div[1]/div/a")).click();


        Thread.sleep(2000);
        driver.findElement(By.id("billing_first_name")).sendKeys("ABC");
        driver.findElement(By.id("billing_last_name")).sendKeys("ABC");
        Thread.sleep(2000);
        driver.findElement(By.id("billing_company")).sendKeys("ABC");
        Thread.sleep(2000);
        driver.findElement(By.id("billing_address_1")).sendKeys("ABC");
        driver.findElement(By.id("billing_address_2")).sendKeys("ABC");
        Thread.sleep(2000);
        driver.findElement(By.id("billing_city")).sendKeys("ABC");
        jse.executeScript("window.scrollBy(0,550)");
        Thread.sleep(2000);
        driver.findElement(By.id("select2-billing_state-container")).click();
        Thread.sleep(1500);
        driver.findElement(By.className("select2-search__field")).sendKeys("Punjab", Keys.RETURN);
        Thread.sleep(1500);
        driver.findElement(By.id("billing_postcode")).sendKeys("ABC");
        Thread.sleep(1500);
        driver.findElement(By.id("billing_phone")).sendKeys("ABC");
        Thread.sleep(1500);
        driver.findElement(By.id("billing_email")).sendKeys("ABC");
        Thread.sleep(1500);
        jse.executeScript("window.scrollBy(0,400)");
        driver.findElement(By.id("mailchimp_woocommerce_newsletter")).click();


        Thread.sleep(1500);
        driver.findElement(By.id("account_username")).sendKeys("ABC");
        Thread.sleep(1500);
        driver.findElement(By.id("account_password")).sendKeys("ABC");
        Thread.sleep(1500);
        driver.findElement(By.id("order_comments")).sendKeys("ABC");
        Thread.sleep(5000);
    }

    @Test
    public void CheckoutWithHardAssertion() throws InterruptedException{
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/vapes-shop-in-pakistan/");

        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);

        jse.executeScript("window.scrollBy(0,800)");
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[8]/Div/Div[2]/Div[2]/Div[3]/A")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[8]/Div/Div[2]/Div[2]/Div[3]/A[2]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[2]/div[2]/div/div[1]/div/a")).click();


        Thread.sleep(2000);
        driver.findElement(By.id("billing_first_name")).sendKeys("ABC");
        driver.findElement(By.id("billing_last_name")).sendKeys("ABC");
        Thread.sleep(2000);
        driver.findElement(By.id("billing_company")).sendKeys("ABC");
        Thread.sleep(2000);
        driver.findElement(By.id("billing_address_1")).sendKeys("ABC");
        driver.findElement(By.id("billing_address_2")).sendKeys("ABC");
        jse.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.id("place_order")).click();

        //Assertions

        //Title Assertion
        String actualTitle= driver.getTitle();
        String expectedTitle= "Checkout - Vapes Direct Pk";
        Assert.assertSame(actualTitle,expectedTitle,"Title is mismatched");

        //URL Assertion
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://vapesdirect.pk/checkout//";
        Assert.assertNotSame(actualUrl,expectedUrl, "URL is mismatched");

        //Text Assertion
        String actualText= driver.findElement(By.id("billing_first_name")).getAttribute("value");
        String expectedText = "";
        Assert.assertNotEquals(actualText,expectedText);

        //Border Assertion
        Thread.sleep(1500);
        String actualBorder = driver.findElement(By.id("billing_city")).getCssValue("border-color");
        String expectedBorder = "rgb(178, 0, 0)";
        Assert.assertEquals(actualBorder,expectedBorder);


        //Error Assertion
        Thread.sleep(1500);
        String actualError = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/form[3]/div[1]/ul/li[1]/div")).getText();
        String expectedError = "Billing Town / City is a required field.";
        Assert.assertEquals(actualError,expectedError);
        Thread.sleep(5000);
    }

    @Test
    public void CheckoutWithSoftAssertion() throws InterruptedException{
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        driver.get("https://vapesdirect.pk/vapes-shop-in-pakistan/");

        Thread.sleep(3500);
        driver.findElement(By.className("yes")).click();
        Thread.sleep(1500);

        jse.executeScript("window.scrollBy(0,800)");
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[8]/Div/Div[2]/Div[2]/Div[3]/A")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("/Html/Body/Div[2]/Main/Div/Div/Section[1]/Div/Div[2]/Div/Div[3]/Div/Div/Div/Div/Div[2]/Div[8]/Div/Div[2]/Div[2]/Div[3]/A[2]")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/div/div[2]/div[2]/div/div[1]/div/a")).click();


        Thread.sleep(2000);
        driver.findElement(By.id("billing_first_name")).sendKeys("ABC");
        driver.findElement(By.id("billing_last_name")).sendKeys("ABC");
        Thread.sleep(2000);
        driver.findElement(By.id("billing_company")).sendKeys("ABC");
        Thread.sleep(2000);
        driver.findElement(By.id("billing_address_1")).sendKeys("ABC");
        driver.findElement(By.id("billing_address_2")).sendKeys("ABC");
        jse.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.id("place_order")).click();

        //Assertions
        SoftAssert softAssert = new SoftAssert();

        //Title Assertion
        String actualTitle= driver.getTitle();
        String expectedTitle= "Checkout - Vapes Direct Pk";
        softAssert.assertSame(actualTitle,expectedTitle,"Title is mismatched");

        //URL Assertion
        String actualUrl=driver.getCurrentUrl();
        String expectedUrl="https://vapesdirect.pk/checkout//";
        softAssert.assertNotSame(actualUrl,expectedUrl);

        //Text Assertion
        String actualText= driver.findElement(By.id("billing_first_name")).getAttribute("value");
        String expectedText = "";
        softAssert.assertNotEquals(actualText,expectedText);

        //Border Assertion
        Thread.sleep(1500);
        String actualBorder = driver.findElement(By.id("billing_city")).getCssValue("border-color");
        String expectedBorder = "rgb(178, 0, 0)";
        softAssert.assertEquals(actualBorder,expectedBorder);


        //Error Assertion
        Thread.sleep(1500);
        String actualError = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div/div[2]/form[3]/div[1]/ul/li[1]/div")).getText();
        String expectedError = "Billing Town / City is a required field.";
        softAssert.assertEquals(actualError,expectedError);

        softAssert.assertAll();
        Thread.sleep(5000);
    }
    @AfterTest()
    public void Teardown(){
        driver.quit();
    }
}
