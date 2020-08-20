package casosDePrueba;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utiles.Const;
import utiles.Utils;

public class Caso00_PruebaBuscarEnYoutube {

	// Declarando variables GLOBALES
	private static final String casoDePrueba = "Caso00_PruebaBuscarEnYoutube";
	private static ArrayList<String> pasos = new ArrayList<String>();
	private static String paso = "";
	private static int numPaso = 0;

	public static void lanzarPrueba(WebDriver driverGlobal) {

		String baseUrl = Const.URL_YouTube;

		try {
			// Estableciendo time out de 5 seg
			driverGlobal.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			// Accediendo a la url
			driverGlobal.get(baseUrl);
			driverGlobal.manage().window().maximize();

			// Pruebas
//-----------------------------------------------------------------------------

			// Se describe el paso
			paso = "Se introduce texto a buscar";
			System.out.println(++numPaso + "....." + paso);

			// Definimos el valor a buscar
			String valorBusqueda = "00001111";

			// Establecemos el fullContextPath del cuadro de búsqueda
			WebElement campo_busqueda = driverGlobal.findElement(By.xpath(Const.CAMPO_busqueda));
			campo_busqueda.clear();

			// Se introduce el valor en el campo
			campo_busqueda.sendKeys(valorBusqueda);
			// Thread.sleep(1000);

			// Se captura la evidencia
			Utils.capturarPantalla(casoDePrueba, pasos, paso);

//-----------------------------------------------------------------------------

			// Se describe el paso
			paso = "Se pulsa buscar";
			System.out.println(++numPaso + "....." + paso);

			// Establecemos el fullContextPath del boton de búsqueda
			WebElement boton_busqueda = driverGlobal.findElement(By.xpath(Const.BOTON_buscar));

			// Pulsaos el botón
			boton_busqueda.click();
			Thread.sleep(2000);
			// Se captura la evidencia
			Utils.capturarPantalla(casoDePrueba, pasos, paso);

//-----------------------------------------------------------------------------
			// generamos el documeto de evidencias
			Utils.generarPDF(casoDePrueba, pasos);
		} catch (Exception E) {
			System.out.println("Se ha interrumpido la ejecución");
			System.out.println(E);
		} finally {
			driverGlobal.quit();
		}
	}

}
