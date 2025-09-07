package com.automatizacion.tests;

import com.automatizacion.pages.CarritoPagina;
import com.automatizacion.pages.CatalogoPagina;
import com.automatizacion.pages.DatosUsuario;
import com.automatizacion.pages.LaptopsPagina;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LaptopsCPTest extends BaseCPTest {
    @Test
    public void testGestionCompletaCarrito() {
        LaptopsPagina laptopsPage = new LaptopsPagina(driver);
        CarritoPagina carritoPage = new CarritoPagina(driver);
        CatalogoPagina catalogoPage = new CatalogoPagina(driver);
        DatosUsuario login = new DatosUsuario(driver);


        // Abrir laptops
        laptopsPage.openAllLaptops();

        // Agregar mackbook
        laptopsPage.openAllLaptops();
        laptopsPage.selectMacbookPro();
        laptopsPage.addToCart();
        String success = laptopsPage.getSuccessMessage();
        Assert.assertTrue(success.contains("MacBook Pro"),
                "El producto no se agregó correctamente al carrito. Mensaje: " + success);

        // Agregar Tablet
        catalogoPage.buscarProducto("Samsung Galaxy Tab");
        catalogoPage.agregarPrimerProductoAlCarrito();
        String mensajeTablet = laptopsPage.getSuccessMessage();
        Assert.assertTrue(mensajeTablet.contains("Success"), "No se agregó la tablet al carrito.");

        // Eliminar mackbook
        carritoPage.clickCartTotal();
        carritoPage.eliminarProductoPorNombre("MacBook Pro");
        Assert.assertTrue(carritoPage.isProductRemoved("MacBook Pro"), "No se eliminó MacBook Pro del carrito.");

        // Agregar tablet
        catalogoPage.buscarProducto("Samsung Galaxy Tab");
        catalogoPage.agregarPrimerProductoAlCarrito();
        String mensajeTablet2 = laptopsPage.getSuccessMessage();
        Assert.assertTrue(mensajeTablet.contains("Success"), "No se agregó la tablet al carrito.");

        carritoPage.irACheckout();
        login.login("usuario_existente@mail.com", "contraseña123");
        carritoPage.irACheckout();
        System.out.println("Página de checkout abierta correctamente.");

        driver.quit();
    }

}
