package com.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LaptopsPagina {
    private WebDriver driver;

    private By laptopsMenu = By.linkText("Laptops & Notebooks");
    private By showAllLaptops = By.linkText("Show All Laptops & Notebooks");
    private By macbookPro = By.linkText("MacBook Pro");
    private By addToCartBtn = By.id("button-cart");
    private By successMessage = By.cssSelector("div.alert-success");


    public LaptopsPagina(WebDriver driver) {
        this.driver = driver;
    }

    public void openAllLaptops() {
        driver.findElement(laptopsMenu).click();
        driver.findElement(showAllLaptops).click();
    }

    public void selectMacbookPro() {
        driver.findElement(macbookPro).click();
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public String getSuccessMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage));
        return alert.getText();
    }
}
