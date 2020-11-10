package com.cybertek.library.step_definition;

import com.cybertek.library.pages.BasePage;
import com.cybertek.library.pages.LandingPage;
import com.cybertek.library.pages.UserPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class PageNavigation_StepDefinition {

    LandingPage landingPage = new LandingPage();
    UserPage userPage = new UserPage();
    Select select;

    @When("I click on {string} link")
    public void i_click_on_link(String link) {

        if ("dashboard".equals(link.toLowerCase())) {
            landingPage.dashboardPageLink.click();
        }else if ("books".equals(link.toLowerCase())){
            landingPage.booksPageLink.click();
        }else {
            landingPage.userPageLink.click();
        }



    }




    @Then("show records default value should be {int}")
    public void show_records_default_value_should_be(Integer int1) {

        select = new Select(userPage.showRecordsDropdown);
   String actual =  select.getFirstSelectedOption().getText();
       // Assert.assertEquals(actual,String.valueOf(int1));
        Assert.assertEquals(actual,int1+"");


    }
    @Then("show records should have following options:")
    public void show_records_should_have_following_options(List<String> options) {

       // System.out.println("options.size() = " + options.size());
     //   System.out.println("options = " + options);
        select = new Select(userPage.showRecordsDropdown);

        List<String> webElements = new ArrayList<String>();

        for (String el : options){
            webElements.add(el);
        }

Assert.assertEquals(webElements,options);
        System.out.println(webElements);
    }

}
