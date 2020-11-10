package com.cybertek.library.pages;

import com.cybertek.library.utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);


    }

    @FindBy(id = "inputEmail")
    public WebElement usernameInput;

    @FindBy(id = "inputPassword")
    public WebElement passwordInput;


}
