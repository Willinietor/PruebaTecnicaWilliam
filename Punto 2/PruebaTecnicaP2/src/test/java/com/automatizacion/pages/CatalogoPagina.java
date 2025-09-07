package com.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogoPagina {
    private WebDriver driver;

    private By searchBox = By.name("search");
    private By searchButton = By.cssSelector("div#search button");
    private By firstProductAddToCartBtn = By.cssSelector("div.product-layout:first-child button[onclick*='cart.add']");

    public CatalogoPagina(WebDriver driver) {
        this.driver = driver;
    }

    public void buscarProducto(String nombre) {
        driver.findElement(searchBox).clear();
        driver.findElement(searchBox).sendKeys(nombre);
        driver.findElement(searchButton).click();
    }

    public void agregarPrimerProductoAlCarrito() {
        driver.findElement(firstProductAddToCartBtn).click();
    }
}
