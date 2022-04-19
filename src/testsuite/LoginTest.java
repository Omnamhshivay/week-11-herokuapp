package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl="http://the-internet.herokuapp.com/login";
    @Before
    public void setUp(){
        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials(){
        //find username field element
        WebElement emailFiled=driver.findElement(By.id("username"));
        emailFiled.sendKeys("tomsmith");
        WebElement passwordField= driver.findElement(By.id("password"));
        passwordField.sendKeys("SuperSecretPassword!");// send keys to password field
        WebElement loginButton=driver.findElement(By.xpath("//button[@class='radius']/i"));// login button
        loginButton.click();//click login button
        WebElement secureMsg=driver.findElement(By.xpath("//div[@id='content']/div/h2"));
        String actualtext=secureMsg.getText();
        String expectedtext="Secure Area";
        Assert.assertEquals("Secure area text not visible",expectedtext,actualtext);
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        //find an element of username field
        WebElement userNameElement= driver.findElement(By.tagName("input#username"));
        //send username in to username field
        userNameElement.sendKeys("tomsmith1");
        //find an element of password field
        WebElement passwordElement = driver.findElement(By.id("password"));
        // send password in to password field
        passwordElement.sendKeys("SuperSecretPassword!");
        //find login element
        WebElement loginElement= driver.findElement(By.className("radius"));
        // click on login button
        loginElement.click();
        //verify the error message "Your username is invalid!"
        String expectedMessage="Your username is invalid!";
        //find the actual message element and get text
        WebElement actualMessageElement= driver.findElement(By.xpath("//div[@id='flash']"));
        String actualMessage=actualMessageElement.getText();
        //validate expected and actual message
        Assert.assertEquals("Username is not valid ",expectedMessage,actualMessage);

    }
    @Test
    public void verifyThePasswordErrorMessage(){
        //find username field element
        WebElement userNameFieldElement = driver.findElement(By.xpath("//input[@id='username']"));
        //send username in to username field element
        userNameFieldElement.sendKeys("tomsmith");
        //find element of password
        WebElement passwordElement =driver.findElement(By.id("password"));
        // send password in to password field element
        passwordElement.sendKeys("SuperSecretPassword");
        //get element of login button
        WebElement logInElement = driver.findElement(By.className("radius"));
        //click on login button
        logInElement.click();
        // verify secure area is requirement
        String expectedMessage= "Your password is invalid!";
        //find the Secure Area text element and get text
        WebElement actualMessageElement= driver.findElement(By.linkText("//div[@id='flash']"));
        String actualMessage =actualMessageElement.getText();
        System.out.println(actualMessage);
        // validate actual message and expected message
        Assert.assertEquals("Your password is invalid!",expectedMessage,actualMessage);

    }
@After
    public void close(){
        driver.close();
}
}
