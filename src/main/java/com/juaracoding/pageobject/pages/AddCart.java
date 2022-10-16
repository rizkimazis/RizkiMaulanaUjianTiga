package com.juaracoding.pageobject.pages;

import com.juaracoding.pageobject.drivers.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddCart {

    private WebDriver driver;

    public AddCart() {
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"noo-site\"]/div[2]/div[2]/div/div/div[5]/div/h3")
    WebElement clickItem;

    @FindBy(id = "pa_color")
    WebElement color;

    @FindBy(id = "pa_size")
    WebElement size;

    @FindBy(xpath = "//*[@id=\"product-1225\"]/div[1]/div[2]/form/div/div[2]/div/div/button[2]/i")
    WebElement clickQtyIncrement;

    @FindBy(xpath = "//*[@id=\"product-1225\"]/div[1]/div[2]/form/div/div[2]/button")
    WebElement btnAddCart;

    @FindBy(id = "nav-menu-item-cart")
    WebElement btnViewCart;

    public void shopItem() {
        clickItem.click();
        System.out.println("Click Item");
    }

    public void addToCart() {
        Select selectMenuColor = new Select(this.color);
        Select selectMenuSize = new Select(this.size);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        selectMenuColor.selectByValue("black");
        System.out.println("Select Menu Color");
        selectMenuSize.selectByValue("large");
        System.out.println("Select Menu Size");
        clickQtyIncrement.click();
        System.out.println("Click button Qty");
        btnAddCart.click();
        System.out.println("Click button AddCart");
        btnViewCart.click();
        System.out.println("Click Icon Cart");
        js.executeScript("window.scrollBy(0,1000)");

    }
}
