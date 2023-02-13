package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.page.HomePage;
import com.nopcommerce.demo.page.LoginPage;
import com.nopcommerce.demo.testbase.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    HomePage homepage = new HomePage();
    LoginPage loginPage=new LoginPage();

    @Test
    public void userShouldNavigateToLoginPageSuccessFully() {
        homepage.clickOnLoginLink();
        String actualMessage=loginPage.getWelcomeText();
        String expedctedMessage = "Welcome, Please Sign In!";
        Assert.assertEquals(actualMessage,expedctedMessage,"Login page verified");
    }

    @Test
    public void verifyErrorWithInValidCredentials(){
        homepage.clickOnLoginLink();
        loginPage.enterEmailId("abcd@gmail.com");
        loginPage.enterPassword("12345");
        loginPage.clickOnLoginButton();
        String actual=loginPage.getErrorMessage();
        String expected= "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found";
        Assert.assertEquals(actual,expected,"error message with inavalid credentials");
    }
    @Test
    public void verifyLoginSuccessFullyWithValidCredentials() {
        homepage.clickOnLoginLink();
        loginPage.enterEmailId("abc@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        String actual = loginPage.getlogOut();
        String expected = "Log out";
        Assert.assertEquals(actual, expected, "Log out");
    }
    @Test
    public void verifyUserLogoutSuccessFully() {
        homepage.clickOnLoginLink();
        loginPage.enterEmailId("abc@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        loginPage.getlogOut();
        String actual = loginPage.getlogOut();
        String expected = "Log out";
        Assert.assertEquals(actual, expected, "Log out");
    }
}
