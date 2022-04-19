package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {

    String baseUrl = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
        @Test
                public void userShouldLoginSuccessfullyWithValidCredentials(){
            //Enter "Admin" as a user name in username field
            WebElement userName = driver.findElement(By.id("txtUsername"));
            userName.sendKeys("Admin");
            //Enter "admin123" as a password in password field
            WebElement password = driver.findElement(By.name("txtPassword"));
            password.sendKeys("admin123");
            //Click on login button
            WebElement login = driver.findElement(By.id("btnLogin"));
            login.click();
            // This is from requirement and get the text
            String expectedMessage = "Welcome";

            //Find welcome text element and get the text
            WebElement actualMessageElement = driver.findElement(By.id("welcome"));
            String actualMessage = actualMessageElement.getText().substring(0,7);
            //Validate actual and expected message
            Assert.assertEquals("Welcome",expectedMessage,actualMessage);

        }

    @After
    public void tearDown(){
       closebrowser();
    }
}
