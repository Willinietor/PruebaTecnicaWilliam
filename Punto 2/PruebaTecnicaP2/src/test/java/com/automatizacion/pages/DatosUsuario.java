package com.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DatosUsuario {
    private WebDriver driver;

    private By emailInput = By.id("input-email");
    private By passwordInput = By.id("input-password");
    private By loginButton = By.cssSelector("input[value='Login']");

    public DatosUsuario(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password) {
        driver.findElement(emailInput).sendKeys(email);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginButton).click();
    }
}
