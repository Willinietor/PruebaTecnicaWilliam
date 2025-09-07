package com.automatizacion.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.automatizacion.pages.RegistroPagina;

public class RegistroCPTest extends BaseCPTest{
    @Test
    public void testRegisterNewUser() {
        RegistroPagina registerPage = new RegistroPagina(driver);
        registerPage.open();

        String email = "test_" + System.currentTimeMillis()  + "@mail.com";

        registerPage.register("Juan", "Pérez", email, "3001234567", "Password123!");

        String actualMessage = registerPage.getSuccessMessage();
        System.out.println("Mensaje obtenido: " + actualMessage);

        Assert.assertEquals(actualMessage, "Account");

    }
}
