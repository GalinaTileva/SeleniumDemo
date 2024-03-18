package Homework;

import org.testng.annotations.*;

public class TestBeforeAfter {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite: This method runs once before all tests in the suite.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest: This method runs once before any test method in the current <test> tag.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("BeforeClass: This method runs once before the first test method in the current class.");
    }

    @BeforeGroups(groups = {"group1"})
    public void beforeGroups() {
        System.out.println("BeforeGroups: This method runs once before all tests in specified group(s).");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("BeforeMethod: This method runs before each test method.");
    }



    @AfterMethod
    public void afterMethod() {
        System.out.println("AfterMethod: This method runs after each test method.");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("AfterClass: This method runs once after the last test method in the current class.");
    }

    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest: This method runs once after all test methods in the current <test> tag.");
    }

    @AfterGroups(groups = {"group1"})
    public void afterGroups() {
        System.out.println("AfterGroups: This method runs once after all tests in specified group(s).");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite: This method runs once after all tests in the suite.");
    }

    @Test(groups = {"group1"})
    public void testMethod1() {
        System.out.println("TestMethod1: This is test method 1.");
    }

    @Test(groups = {"group2"})
    public void testMethod2() {
        System.out.println("TestMethod2: This is test method 2.");
    }

}
