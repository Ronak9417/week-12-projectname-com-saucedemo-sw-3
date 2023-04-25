package testsuite;

import browserfactory.Utilities;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LoginTest extends Utilities {

    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {

        // Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");
        // Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");
        // Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //Verify the text “PRODUCTS”
        assertVerifyText(By.xpath("//span[@class='title']"),"Products");
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage(){
        // Enter “standard_user” username
        sendTextToElement(By.xpath("//input[@id='user-name']"),"standard_user");
        // Enter “secret_sauce” password
        sendTextToElement(By.xpath("//input[@id='password']"),"secret_sauce");
        // Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@id='login-button']"));
        //Verify that six products are displayed on page
       List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']"));
       int actualResult = products.size();
        int expectedText = 6;
        Assert.assertEquals("Error has occurred --->  Test failed : ", expectedText,actualResult);
    }

}
