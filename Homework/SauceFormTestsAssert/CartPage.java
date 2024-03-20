package Homework.SauceFormTestsAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CartPage {
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
    public void yourCart() {
        WebElement yourCart = driver.findElement(By.cssSelector(".title"));
        if (yourCart.isDisplayed()) {
            System.out.println("Title Your Cart on left corner of this page.");
        }
    }

    @Test
    public void qty() {
        WebElement qty = driver.findElement(By.cssSelector(".cart_quantity_label"));
        if (qty.isDisplayed()) {
            System.out.println("QTY label presented on top of products list.");
        }
    }

    @Test
    public void description() {
        WebElement description = driver.findElement(By.cssSelector(".cart_desc_label"));
        if (description.isDisplayed()) {
            System.out.println("Description label presented on top of products list.");
        }
    }

    @Test
    public void onesieDescription() {
        WebElement onesie = driver.findElement(By.cssSelector("#item_2_title_link"));
        String onesieCheck = onesie.getText();
        assertEquals(onesieCheck, "Sauce Labs Onesie");
    }

    @Test
    public void onesieQuantity() {
        WebElement qty = driver.findElement(By.xpath
                ("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[1]"));
        String qtyCheck = qty.getText();
        assertEquals(qtyCheck, "1");
    }

     @Test
    public void onesieText() {
        WebElement onesieText = driver.findElement(By.xpath
                ("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[1]"));
        String onesieTextCheck = onesieText.getText();
        assertEquals(onesieTextCheck, "Rib snap infant onesie for the junior automation engineer in development. " +
                "Reinforced 3-snap bottom closure, two-needle hemmed sleeved and bottom won't unravel.");
    }

    @Test
    public void onesiePrice() {
        WebElement onesiePrice = driver.findElement(By.xpath
                ("//*[@id=\"cart_contents_container\"]/div/div[1]/div[3]/div[2]/div[2]/div"));
        String price = onesiePrice.getText();
        assertEquals(price, "$7.99");
    }

    @Test
    public void onesieRemove() {
        WebElement onesieRemove = driver.findElement(By.cssSelector("#remove-sauce-labs-onesie"));
        if (onesieRemove.isDisplayed()) {
            System.out.println("Remove button presented for item 'Sauce Labs Onesie'.");
        }
    }

    @Test
    public void redShirtDescription() {
        WebElement redShirt = driver.findElement(By.cssSelector("#item_3_title_link"));
        String shirtTitle = redShirt.getText();
        assertEquals(shirtTitle, "Test.allTheThings() T-Shirt (Red)");
    }

     @Test
    public void redShirtQuantity() {
        WebElement quantity = driver.findElement(By.xpath
                ("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[1]"));
        String qty = quantity.getText();
        assertEquals(qty, "1");
    }

    @Test
    public void redShirtText() {
        WebElement redShirtText = driver.findElement(By.xpath
                ("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[1]"));
        String redShirtTextCheck = redShirtText.getText();
        assertEquals(redShirtTextCheck, "This classic Sauce Labs t-shirt is perfect to wear when cozying up" +
                " to your keyboard to automate a few tests. Super-soft and comfy ringspun combed cotton.");
    }

    @Test
    public void redShirtPrice() {
        WebElement redShirtPrice = driver.findElement(By.xpath
                ("//*[@id=\"cart_contents_container\"]/div/div[1]/div[4]/div[2]/div[2]/div"));
        String price = redShirtPrice.getText();
        assertEquals(price, "$15.99");
    }

    @Test
    public void redShirtRemove() {
        WebElement redShirtRemove = driver.findElement(By.cssSelector
                ("[name='remove-test.allthethings()-t-shirt-(red)']"));
        if (redShirtRemove.isDisplayed()) {
            System.out.println("Remove button displayed for item 'Test.allTheThings() T-Shirt (Red)'.");
        }
    }

    @Test
    public void continueShopping() {
        WebElement shop = driver.findElement(By.cssSelector("#continue-shopping"));
        if (shop.isDisplayed()) {
            System.out.println("Continue shopping button is displayed on left bottom corner.");
        }
    }

    @Test
    public void goBack() {
        WebElement shop = driver.findElement(By.cssSelector("#continue-shopping"));
        shop.click();

        String productsPage = driver.getCurrentUrl();
        assertEquals(productsPage, "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void checkout() {
        WebElement checkout = driver.findElement(By.cssSelector("#checkout"));
        if (checkout.isDisplayed()) {
            System.out.println("Checkout button is displayed on bottom right corner.");
        }
    }

    @Test
    public void checkoutColor() {
        WebElement checkout = driver.findElement(By.cssSelector("#checkout"));
        String color = checkout.getCssValue("background-color");
        assertEquals(color, "rgba(61, 220, 145, 1)");
        System.out.println(color);
    }

    @Test
    public void goCheckout() {
        WebElement checkout = driver.findElement(By.cssSelector("#checkout"));
        checkout.click();

        String checkoutPage = driver.getCurrentUrl();
        assertEquals(checkoutPage, "https://www.saucedemo.com/checkout-step-one.html");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
