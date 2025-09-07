package com.automatizacion.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;


public class CarritoPagina {
        private WebDriver driver;

        private By viewCartBtn = By.cssSelector("strong i.fa-shopping-cart");
        private By removeFirstProductBtn = By.cssSelector("button.btn-danger");
        private By successMessage = By.cssSelector("div.alert-success");
        private By cartTotal = By.id("cart-total");
        private By checkoutButton = By.xpath("//span[text()='Checkout']");
        public CarritoPagina(WebDriver driver) {
            this.driver = driver;
        }

        public void clickCartTotal() {
            driver.findElement(cartTotal).click();
            try {
                Thread.sleep(10000); // espera de 10 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

       public void openCart() {
            driver.findElement(viewCartBtn).click();
       }

       public void eliminarProductoPorNombre(String nombreProducto) {
            List<WebElement> filas = driver.findElements(By.cssSelector("table.table tbody tr"));
                for (WebElement fila : filas) {
                    String nombre = fila.findElement(By.cssSelector("td.text-left a")).getText();
                if (nombre.equalsIgnoreCase(nombreProducto)) {
                        fila.findElement(By.cssSelector("button.btn-danger")).click();
                  break;
                }
            }
       }


       public String getSuccessMessage() {
            return driver.findElement(successMessage).getText();
       }

       public boolean isProductRemoved(String productName) {
            try {
              return driver.findElement(By.linkText(productName)) == null;
                } catch (Exception e) {
              return true;
           }
       }

    public void irACheckout() {
        driver.findElement(checkoutButton).click();
        try {
            Thread.sleep(5000); // espera 5 segundos para visualizar la página
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
