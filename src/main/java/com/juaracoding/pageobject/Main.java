package com.juaracoding.pageobject;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import com.juaracoding.pageobject.pages.AddCart;
import com.juaracoding.pageobject.pages.Dashboard;
import com.juaracoding.pageobject.pages.Login;
import com.juaracoding.pageobject.pages.Register;
import com.juaracoding.pageobject.utils.Constants;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;


public class Main {

    public static void main(String[] args) {
        DriverSingleton.getInstance(Constants.CHROME);
        WebDriver driver = DriverSingleton.getDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;

        Dashboard dashboard = new Dashboard();
        Register register = new Register();
        Login login = new Login();
        AddCart addCart = new AddCart();

        // Dashboard
        driver.get(Constants.URL);
        dashboard.dashboard();

        // Register Account
        driver.get(Constants.URL_LOGIN);
        register.registerForm("Rizki Maulana", "rizkimaulanaazis12@email.com", "RizkiM123456--");

        driver.navigate().back();
        driver.navigate().refresh();

        // Login Account
        login.loginForm("rizkimaulanaazis12@email.com", "RizkiM123456--");

        //Item list one product
        driver.get(Constants.URL_SHOP);
        js.executeScript("window.scrollBy(0,1000)");
        addCart.shopItem();

        // Add item in cart
        driver.get(Constants.URL_DETAIL_SHOP);
        js.executeScript("window.scrollBy(0,1000)");
        addCart.addToCart();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.quit();
    }
}