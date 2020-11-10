package com.cybertek.library.step_definition;

import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.LoginPage;
import com.cybertek.library.utils.ConfigurationReader;
import com.cybertek.library.utils.Driver;
import io.cucumber.java.AfterStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefinition {

LoginPage loginPage = new LoginPage();
LandingPage landingPage = new LandingPage();
Driver driver = new Driver();

    @Given("I am on the login page")
    public void i_am_on_the_login_page() {

        String url = ConfigurationReader.getProperties("q2_url");
        Driver.getDriver().get(url);

    }




    @When("I login as a librarian")
    public void i_login_as_a_librarian() {

        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperties("librarianUsername"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperties("librarianPassword"), Keys.ENTER);



    }
    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {

        String expected = "#dashboard";

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains(expected));

        String actual = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));





    }


    @When("I login as a student")
    public void iLoginAsAStudent() {

        loginPage.usernameInput.sendKeys(ConfigurationReader.getProperties("studentUsername"));
        loginPage.passwordInput.sendKeys(ConfigurationReader.getProperties("studentPassword"), Keys.ENTER);


    }

    @Then("books should be displayed")
    public void booksShouldBeDisplayed() {

        String expected = "books";

        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.urlContains(expected));

        String actual = Driver.getDriver().getCurrentUrl();
        Assert.assertTrue(actual.contains(expected));



    }

    @When("I enter username {string}")
    public void i_enter_username(String string1) {
        String username = string1;

        loginPage.usernameInput.sendKeys(username);



    }

    @When("I enter password {string}")
    public void i_enter_password(String string2) throws InterruptedException {


        String password = string2;
        loginPage.passwordInput.sendKeys(password,Keys.ENTER);



    }

    @Then("there should be {int} users")
    public void there_should_be_users(Integer int1) throws InterruptedException {
     Thread.sleep(2000);

        int exceptedNum = int1;

        String exceptedNumber = String.valueOf(exceptedNum);
        String actualNumber =  landingPage.userCount.getText();

        Assert.assertEquals(exceptedNumber,actualNumber);
        Driver.closeDriver();



    }

    @When("I login using {string}and {string}")
    public void iLoginUsingAnd(String username, String password) {

        loginPage.usernameInput.sendKeys(username);
        loginPage.passwordInput.sendKeys(password,Keys.ENTER);


    }

    @And("there should be {int} {string}")
    public void thereShouldBeUsers(int users) {

String exceptedNumber =  String.valueOf(users);
String actualNumber = landingPage.userCount.getText();

Assert.assertEquals(exceptedNumber,actualNumber);



    }
}
