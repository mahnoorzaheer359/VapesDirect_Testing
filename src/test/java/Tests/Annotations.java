package Tests;

import org.testng.annotations.*;

public class Annotations {

    @BeforeSuite
    public void beforeSuite(){
        System.out.println("In before suite method. It will be executed before the suite.");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("In after suite method. It will be executed after the suite.");
    }

    @BeforeTest
    public void beforeTest(){
        System.out.println("In before test method. It will be executed before every test.");
    }

    @AfterTest
    public void afterTest(){
        System.out.println("In after test method. It will be executed after every test.");
    }

    @BeforeClass
    public void beforeClass(){
        System.out.println("In before class method. It will be executed before every class.");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("In after class method. It will be executed after every class.");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("In before method. It will be executed before every method.");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("In after  method. It will be executed after every method.");
    }

    @Test
    public void Test1(){
        System.out.println("In test 1.");
    }
    @Test
    public void Test2(){
        System.out.println("In test 2.");
    }
}
