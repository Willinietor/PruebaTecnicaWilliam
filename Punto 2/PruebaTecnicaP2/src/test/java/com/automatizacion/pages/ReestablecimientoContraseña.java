package com.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReestablecimientoContraseña {
    private WebDriver driver;

    private By emailInput = By.id("input-email");
    private By continueBtn = By.cssSelector("input[type='submit']");
    private By successMessage = By.cssSelector("div.alert.alert-success");
    private By warningMessage = By.cssSelector("div.alert.alert-danger");

    public ReestablecimientoContraseña(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Login")).click();
        driver.findElement(By.linkText("Forgotten Password")).click();
    }

    public void resetPassword(String email) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(continueBtn).click();
    }

    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }

    public String getWarningMessage() {
        return driver.findElement(warningMessage).getText();
    }
}
