package Homework.SauceFormTestsAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CompletePage {
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

        WebElement finishButton = driver.findElement(By.cssSelector("#finish"));
        finishButton.click();

        String finishPage = driver.getCurrentUrl();
        assertEquals(finishPage, "https://www.saucedemo.com/checkout-complete.html");
    }


    @Test
    public void title() {
        WebElement title = driver.findElement(By.cssSelector(".title"));
        if (title.isDisplayed()) {
            System.out.println("Title 'Checkout: Complete!' is displayed.");
        }
    }

    @Test
    public void icon() {
        WebElement icon = driver.findElement(By.cssSelector(".pony_express"));
        if (icon.isDisplayed()) {
            System.out.println("Check icon displayed.");
        }
    }

    @Test
    public void header() {
        WebElement header = driver.findElement(By.cssSelector(".complete-header"));
        if (header.isDisplayed()) {
            System.out.println("Header is displayed.");
        }
    }

    @Test
    public void headerCheck() {
        WebElement header = driver.findElement(By.cssSelector(".complete-header"));
        String text = header.getText();
        assertEquals(text, "Thank you for your order!");
    }

    @Test
    public void text() {
        WebElement text = driver.findElement(By.cssSelector(".complete-text"));
        if (text.isDisplayed()) {
            System.out.println("Informative text is displayed.");
        }
    }

    @Test
    public void textCheck() {
        WebElement text = driver.findElement(By.cssSelector(".complete-text"));
        String textCheck = text.getText();
        assertEquals(textCheck, "Your order has been dispatched, " +
                "and will arrive just as fast as the pony can get there!");
    }

    @Test
    public void backButton() {
        WebElement backButton = driver.findElement(By.cssSelector("#back-to-products"));
        if (backButton.isDisplayed()) {
            System.out.println("Button 'Back Home' is displayed on bottom of page");
        }
    }

    @Test
    public void backButtonColor() {
        WebElement backButton = driver.findElement(By.cssSelector("#back-to-products"));
        String color = backButton.getCssValue("background-color");
        assertEquals(color, "rgba(61, 220, 145, 1)");
        System.out.println(color);
    }

    @Test
    public void goBackHome() {
        WebElement backButton = driver.findElement(By.cssSelector("#back-to-products"));
        backButton.click();
        String productsPage = driver.getCurrentUrl();
        assertEquals(productsPage, "https://www.saucedemo.com/inventory.html");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
