package Homework.SauceFormTestsAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class ProductsPage {
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
    }


    @Test
    public void logo() {
        WebElement logo = driver.findElement(By.cssSelector(".app_logo"));
        if (logo.isDisplayed()) {
            System.out.println("Logo is displayed on this page. QA very happy :)");
        }
    }

    @Test
    public void burgerMenu() {
        WebElement burgerMenu = driver.findElement(By.cssSelector("#react-burger-menu-btn"));
        if (burgerMenu.isDisplayed()) {
            System.out.println("Burger menu displayed top left corner of page.");
        }
    }

    @Test
    public void shoppingCart(){
        WebElement shoppingCart = driver.findElement(By.cssSelector(".shopping_cart_link"));
        if (shoppingCart.isDisplayed()) {
            System.out.println("Shopping cart icon-link is displayed top right corner of page.");
        }
    }

    @Test
    public void goCart() {
        WebElement shoppingCart = driver.findElement(By.cssSelector(".shopping_cart_link"));
        shoppingCart.click();

        String cart = driver.getCurrentUrl();
        assertEquals(cart,
                "https://www.saucedemo.com/cart.html");
    }

    @Test
    public void titleProducts() {
        WebElement titleProducts = driver.findElement(By.cssSelector(".title"));
        if (titleProducts.isDisplayed()) {
            System.out.println("Title 'Products' displayed.");
        }
    }

    @Test
    public void sortContainer() {
        WebElement sortContainer = driver.findElement(By.cssSelector(".product_sort_container"));
        if (sortContainer.isDisplayed()) {
            System.out.println("Sort container displayed.");
        }
    }

    @Test
    public void inventoryList() {
        WebElement inventoryList = driver.findElement(By.cssSelector(".inventory_list"));
        if (inventoryList.isDisplayed()) {
            System.out.println("Products list presented.");
        }
    }

    @Test
    public void twitterLink() {
        WebElement twitter = driver.findElement(By.cssSelector(".social_twitter"));
        if (twitter.isDisplayed()) {
            System.out.println("Twitter link presented in footer. ");
        }
    }

    @Test
    public void fbLink() {
        WebElement fb = driver.findElement(By.cssSelector(".social_facebook"));
        if (fb.isDisplayed()) {
            System.out.println("Facebook link presented in footer.");
        }
    }

    @Test
    public void linkedIn() {
        WebElement linkedIn = driver.findElement(By.cssSelector(".social_linkedin"));
        if (linkedIn.isDisplayed()) {
            System.out.println("LinkedIn link presented in footer.");
        }
    }

    @Test
    public void terms() {
        WebElement terms = driver.findElement(By.cssSelector(".footer_copy"));
        if (terms.isDisplayed()) {
            System.out.println("Terms of use presented in footer.");
        }
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
