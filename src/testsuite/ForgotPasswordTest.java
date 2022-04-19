package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldNevigateToForgotPasswordPageSuccessfully(){
        WebElement forgotYourPassword = driver.findElement(By.linkText("Forgot your password?"));
        forgotYourPassword.click();

        //Reqirement
        String expectedMessage = "Forgot Your Password?";

        //find forgot your password text element
        WebElement actualMessageElements = driver.findElement(By.xpath("//h1[contains(text(),'Forgot Your Password?')]"));
        String actualMessage = actualMessageElements.getText();
        //validate actual and expected message
        Assert.assertEquals("Forgot Your Password?",expectedMessage,actualMessage);
    }
    @After
    public void tearDown(){
        closebrowser();
    }
}
