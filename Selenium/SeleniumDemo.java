package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;


public class SeleniumDemo extends MainDriver {

    @Test
    public void testOpenBrowser() throws InterruptedException {

        List<WebElement> myList = driver.findElements(By.cssSelector("input"));
                myList.get(2).click();

        Thread.sleep(3000);



        /*//CSS
        WebElement textInput = driver.findElement(By.cssSelector("#my-text-id"));
        textInput.click();
        WebElement password = driver.findElement(By.name("my-password"));
        password.click();
        WebElement textArea = driver.findElement(By.name("my-textarea"));
        textArea.click();
        WebElement checkBox = driver.findElement(By.id("my-check-1"));
        checkBox.click();
        WebElement checkBoxTwo = driver.findElement(By.id("my-check-2"));
        checkBoxTwo.click();
        WebElement checkRadio = driver.findElement(By.id("my-radio-1"));
        checkRadio.click();
        WebElement defaultRadio = driver.findElement(By.id("my-radio-2"));
        defaultRadio.click();
        WebElement submit = driver.findElement(By.cssSelector("button[type=submit]"));
        submit.click();*/

        // XPATH, в търсачката //*[contains (text(), 'Textarea')]
        /*WebElement textInput = driver.findElement(By.xpath("//*[@name='my-password']"));
        textInput.click();*/

    }

}