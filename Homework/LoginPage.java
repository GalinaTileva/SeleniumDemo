package Homework.SauceFormTestsAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class LoginPage {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }


    @Test
    public void happyLogin() {

        WebElement usernameField = driver.findElement(By.cssSelector("#user-name"));
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();
        assertEquals(currentUrl, "https://www.saucedemo.com/inventory.html");

    }

    @Test
    public void wrongLogin() {

        WebElement usernameField = driver.findElement(By.cssSelector("#user-name"));
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));

        usernameField.sendKeys("locked_out_user");
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();

        WebElement errorCont = driver.findElement(By.cssSelector(".error-message-container"));
        String test = errorCont.getText();
        assertEquals(test,"Epic sadface: Sorry, this user has been locked out.");

    }

    @Test
    public void spaceLogin() {
        WebElement usernameField = driver.findElement(By.cssSelector("#user-name"));
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));

        usernameField.sendKeys(" ");
        passwordField.sendKeys(" ");
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();

        WebElement errorMessCont = driver.findElement(By.cssSelector(".error-message-container"));

        String errorMessage = errorMessCont.getText();

        assertEquals(errorMessage, "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void noInputLogin() {
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();

        WebElement errorMessCont = driver.findElement(By.cssSelector(".error-message-container"));
        String errorMess = errorMessCont.getText();
        assertEquals(errorMess, "Epic sadface: Username is required");
    }

    @Test
    public void skipUserName() {
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();

        WebElement errorMessCont = driver.findElement(By.cssSelector(".error-message-container"));
        String message = errorMessCont.getText();
        assertEquals(message, "Epic sadface: Username is required");
    }

    @Test
    public void skipPassword() {
        WebElement usernameField = driver.findElement(By.cssSelector("#user-name"));
        usernameField.sendKeys("standard_user");

        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();

        WebElement errorMessCont = driver.findElement(By.cssSelector(".error-message-container"));
        String message = errorMessCont.getText();
        assertEquals(message, "Epic sadface: Password is required");
    }

    @Test
    public void colorCheck() {
        WebElement usernameField = driver.findElement(By.cssSelector("#user-name"));
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));

        usernameField.sendKeys(" ");
        passwordField.sendKeys(" ");
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();
        WebElement errorMessCont = driver.findElement(By.cssSelector(".error-message-container"));

        String errorMessColor = errorMessCont.getCssValue("background-color");
        assertEquals(errorMessColor, "rgba(226, 35, 26, 1)");
        System.out.println(errorMessColor);

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
