package Homework.SauceFormTestsAssert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertEquals;

public class CheckoutTwo {
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
    }




    @Test
    public void title() {
        WebElement title = driver.findElement(By.cssSelector(".title"));
        if (title.isDisplayed()) {
            System.out.println("Title 'Checkout: Overview' displayed in left corner of page.");
        }
    }

    @Test
    public void qtyDescription() {
        WebElement qty = driver.findElement(By.cssSelector(".cart_quantity_label"));
        WebElement description = driver.findElement(By.cssSelector(".cart_desc_label"));

        if (qty.isDisplayed()) {
            System.out.println("Label 'QTY' displayed." );
        }

        if (description.isDisplayed()) {
            System.out.println("Label 'Description' displayed.");
        }
    }

    @Test
    public void itemOneTitle() {
        WebElement itemOne = driver.findElement(By.cssSelector("#item_2_title_link"));
        if (itemOne.isDisplayed()) {
            System.out.println("First item Sauce Labs Onesie presented.");
        }
    }

    /*@Test
    public void itemOneQuantity() {
        WebElement itemQty = driver.findElement(By.cssSelector(""));
    }

    @Test
    public void itemOneText() {
        WebElement itemText = driver.findElement(By.cssSelector(""));
    }

    @Test
    public void itemOnePrice() {
        WebElement itemPrice = driver.findElement(By.cssSelector(""));
    }*/

    @Test
    public void itemTwoTitle() {
        WebElement itemTwo = driver.findElement(By.cssSelector("#item_3_title_link"));
        if (itemTwo.isDisplayed()) {
            System.out.println("Second item T-Shirt (Red) presented.");
        }
    }

    /*@Test
    public void itemTwoQuantity() {
        WebElement itemQty = driver.findElement(By.cssSelector(""));
    }

    @Test
    public void itemTwoText() {
        WebElement itemText = driver.findElement(By.cssSelector(""));
    }

    @Test
    public void itemTwoPrice() {
        WebElement itemPrice = driver.findElement(By.cssSelector(""));
    }*/

   /* @Test
    public void paymentInfo() {
        WebElement payment = driver.findElement(By.cssSelector(""));
    }

    @Test
    public void paymentValue() {
        WebElement paymentValue = driver.findElement(By.cssSelector(""));
    }

    @Test
    public void shipInfo() {
        WebElement shipInfo = driver.findElement(By.cssSelector(""));
    }

    @Test
    public void shipInfoText() {
        WebElement shipInfoText = driver.findElement(By.cssSelector(""));
    }

    @Test
    public void priceTotal() {
        WebElement priceTotal = driver.findElement(By.cssSelector(""));
    }*/

    @Test
    public void itemTotal() {
        WebElement itemTotal = driver.findElement(By.cssSelector(".summary_subtotal_label"));
        if (itemTotal.isDisplayed()) {
            System.out.println("Item total amount is displayed.");
        }
    }

    @Test
    public void tax() {
        WebElement tax = driver.findElement(By.cssSelector(".summary_tax_label"));
        if (tax.isDisplayed()) {
            System.out.println("Tax amount is displayed.");
        }
    }

    /*@Test
    public void total() {
        WebElement total = driver.findElement(By.cssSelector(""));
    }*/

    @Test
    public void cancel() {
        WebElement cancelButton = driver.findElement(By.cssSelector("#cancel"));
        if (cancelButton.isDisplayed()) {
            System.out.println("Cancel button displayed on bottom of page.");
        }
    }

    @Test
    public void goBack() {
        WebElement cancelButton = driver.findElement(By.cssSelector("#cancel"));
        cancelButton.click();

        String productsPage = driver.getCurrentUrl();
        assertEquals(productsPage, "https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void finish() {
        WebElement finishButton = driver.findElement(By.cssSelector("#finish"));
        if (finishButton.isDisplayed()) {
            System.out.println("Finish button displayed on bottom of page.");
        }
    }

    @Test
    public void finishButtonColor() {
        WebElement finishButton = driver.findElement(By.cssSelector("#finish"));
        String color = finishButton.getCssValue("background-color");
        assertEquals(color, "rgba(61, 220, 145, 1)");
        System.out.println(color);
    }

    @Test
    public void goFinish() {
        WebElement finishButton = driver.findElement(By.cssSelector("#finish"));
        finishButton.click();

        String finishPage = driver.getCurrentUrl();
        assertEquals(finishPage, "https://www.saucedemo.com/checkout-complete.html");
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
