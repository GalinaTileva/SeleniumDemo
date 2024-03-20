package Homework.SauceFormTestsAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CheckoutOne {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement usernameField = driver.findElement(By.cssSelector("#user-name"));
        WebElement passwordField = driver.findElement(By.cssSelector("#password"));
        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));

        usernameField.sendKeys("standard_user");
        passwordField.sendKeys("secret_sauce");
        loginButton.click();

        String inventoryUrl = driver.getCurrentUrl();
        assertEquals(inventoryUrl, "https://www.saucedemo.com/inventory.html");

        WebElement onesie = driver.findElement(By.cssSelector("#add-to-cart-sauce-labs-onesie"));
        onesie.click();
        WebElement redShirt = driver.findElement(By.cssSelector
                ("[name='add-to-cart-test.allthethings()-t-shirt-(red)']"));
        redShirt.click();

        WebElement cart = driver.findElement(By.cssSelector(".shopping_cart_link"));
        cart.click();
        String cartUrl = driver.getCurrentUrl();
        assertEquals(cartUrl, "https://www.saucedemo.com/cart.html");

        WebElement checkoutButton = driver.findElement(By.cssSelector("#checkout"));
        checkoutButton.click();
        String checkoutUrl = driver.getCurrentUrl();
        assertEquals(checkoutUrl, "https://www.saucedemo.com/checkout-step-one.html");

    }


    @Test
    public void title() {
        WebElement title = driver.findElement(By.cssSelector(".title"));
        if (title.isDisplayed()) {
            System.out.println("Title 'Checkout: Your information' is presented.");
        }
    }

    @Test
    public void checkoutForm() {
        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        if (firstName.isDisplayed()) {
            System.out.println("Input field 'First name' is displayed.");
        }

        WebElement lastName = driver.findElement(By.cssSelector("#last-name"));
        if (lastName.isDisplayed()) {
            System.out.println("Input field 'Last name' is displayed.");
        }

        WebElement postCode = driver.findElement(By.cssSelector("#postal-code"));
        if (postCode.isDisplayed()) {
            System.out.println("Input field 'Zip/Postal code' is displayed.");
        }
    }

    @Test
    public void cancelButton() {
        WebElement cancel = driver.findElement(By.cssSelector("#cancel"));
        if (cancel.isDisplayed()) {
            System.out.println("Cancel button is displayed");
        }
    }

    @Test
    public void goCancel() {
        WebElement cancel = driver.findElement(By.cssSelector("#cancel"));
        cancel.click();

        String cartUrl = driver.getCurrentUrl();
        assertEquals(cartUrl, "https://www.saucedemo.com/cart.html");
    }

    @Test
    public void noInputForm() {
        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();

        WebElement errorMess = driver.findElement(By.cssSelector(".error-message-container"));
        String message = errorMess.getText();
        assertEquals(message, "Error: First Name is required");
    }

    @Test
    public void skipFirstName() {
        WebElement lastName = driver.findElement(By.cssSelector("#last-name"));
        WebElement postCode = driver.findElement(By.cssSelector("#postal-code"));
        lastName.sendKeys("Alien");
        postCode.sendKeys("Mars");

        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();

        WebElement errorMess = driver.findElement(By.cssSelector(".error-message-container"));
        String message = errorMess.getText();
        assertEquals(message, "Error: First Name is required");
    }

    @Test
    public void skipLastName() {
        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        WebElement postCode = driver.findElement(By.cssSelector("#postal-code"));
        firstName.sendKeys("Green");
        postCode.sendKeys("Mars");

        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();

        WebElement errorMess = driver.findElement(By.cssSelector(".error-message-container"));
        String message = errorMess.getText();
        assertEquals(message, "Error: Last Name is required");

    }

    @Test
    public void skipPostCode() {
        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        WebElement lastName = driver.findElement(By.cssSelector("#last-name"));
        firstName.sendKeys("Green");
        lastName.sendKeys("Alien");

        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();

        WebElement errorMess = driver.findElement(By.cssSelector(".error-message-container"));
        String message = errorMess.getText();
        assertEquals(message, "Error: Postal Code is required");
    }

    @Test // !!!BUG DETECTED !!!
    public void spaceForm() {
        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        WebElement lastName = driver.findElement(By.cssSelector("#last-name"));
        WebElement postCode = driver.findElement(By.cssSelector("#postal-code"));

        firstName.sendKeys(" ");
        lastName.sendKeys(" ");
        postCode.sendKeys(" ");

        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();

        String checkoutUrl = driver.getCurrentUrl();
        assertEquals(checkoutUrl, "https://www.saucedemo.com/checkout-step-one.html");
        System.out.println("BUG DETECTED ! You should stay on checkout page until valid data is provided.");
    }

    @Test
    public void happyCheckout() {
        WebElement firstName = driver.findElement(By.cssSelector("#first-name"));
        WebElement lastName = driver.findElement(By.cssSelector("#last-name"));
        WebElement postCode = driver.findElement(By.cssSelector("#postal-code"));

        firstName.sendKeys("Green");
        lastName.sendKeys("Alien");
        postCode.sendKeys("Mars");

        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        continueButton.click();

        String nextCheckout = driver.getCurrentUrl();
        assertEquals(nextCheckout, "https://www.saucedemo.com/checkout-step-two.html");
    }

    @Test
    public void continueButtonColor() {
        WebElement continueButton = driver.findElement(By.cssSelector("#continue"));
        String color = continueButton.getCssValue("background-color");
        assertEquals(color, "rgba(61, 220, 145, 1)");
        System.out.println(color);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
