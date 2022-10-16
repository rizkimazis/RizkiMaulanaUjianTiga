package com.juaracoding.pageobject.pages;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Register {

    private WebDriver driver;

    public Register() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "reg_username")
    WebElement username;

    @FindBy(id = "reg_email")
    WebElement email;

    @FindBy(id = "reg_password")
    WebElement password;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/p[2]/span/span")
    WebElement visiblePassword;

    @FindBy(xpath = "//*[@id=\"customer_login\"]/div[2]/form/p[4]/button")
    WebElement btnRegister;

    public void registerForm(String username, String email, String password) {
        this.username.sendKeys(username);
        System.out.println("Insert username");
        this.email.sendKeys(email);
        System.out.println("Insert email");
        this.password.sendKeys(password);
        System.out.println("Insert password");
        visiblePassword.click();
        System.out.println("Visible password Clicked");
        btnRegister.click();
        System.out.println("Button Register Clicked");
    }
}

