package com.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class RegistroPagina {
    private WebDriver driver;

    private By firstName = By.id("input-firstname");
    private By lastName = By.id("input-lastname");
    private By email = By.id("input-email");
    private By telephone = By.id("input-telephone");
    private By password = By.id("input-password");
    private By confirmPassword = By.id("input-confirm");
    private By agreePolicy = By.name("agree");
    private By continueBtn = By.cssSelector("input[type='submit']");
    private By successMessage = By.cssSelector("div#content h1");

    public RegistroPagina(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.linkText("Register")).click();
    }

    public void register(String fName, String lName, String mail, String phone, String pass) {
        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(email).sendKeys(mail);
        driver.findElement(telephone).sendKeys(phone);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(confirmPassword).sendKeys(pass);
        driver.findElement(agreePolicy).click();
        driver.findElement(continueBtn).click();
    }


    public String getSuccessMessage() {
        return driver.findElement(successMessage).getText();
    }
}
