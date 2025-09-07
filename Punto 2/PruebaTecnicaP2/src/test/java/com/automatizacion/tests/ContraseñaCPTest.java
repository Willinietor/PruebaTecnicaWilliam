package com.automatizacion.tests;

import com.automatizacion.pages.ReestablecimientoContraseña;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContraseñaCPTest extends BaseCPTest {
    @Test
    public void testPasswordReset() {
        ReestablecimientoContraseña resetPage = new ReestablecimientoContraseña(driver);
        resetPage.open();

        String email = "test_pruebatecnica@mail.com";
        resetPage.resetPassword(email);

        String success = resetPage.getSuccessMessage();
        Assert.assertTrue(success.contains("confirmation link has been sent"),
                "El restablecimiento falló. Mensaje recibido: " + success);
    }
}
