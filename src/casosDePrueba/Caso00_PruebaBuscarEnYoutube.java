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
		
		//Se establece la url de la app
		String baseUrl = Const.URL_YouTube;

		try {
			
			// Estableciendo time out de respuesta de la conexión en 5 seg
			driverGlobal.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
			// Accediendo a la url
			driverGlobal.get(baseUrl);
			// Maximizando ventana
			driverGlobal.manage().window().maximize();

			// Pruebas
//-----------------------------------------------------------------------------

			// Se describe el paso
			paso = "Se introduce texto a buscar";
			numPaso = Utils.describirPaso(paso, numPaso);
			
			//Insertando valor
			Utils.accion(1, "0002222", Const.CAMPO_busqueda, 1000, driverGlobal);
			Utils.accion(1, "0003333", Const.CAMPO_busqueda, 1000, driverGlobal);
			Utils.accion(1, "0004444", Const.CAMPO_busqueda, 2000, driverGlobal);

			// Se captura la evidencia
			Utils.capturarPantalla(casoDePrueba, pasos, paso);

//-----------------------------------------------------------------------------
			
			// Se describe el paso
			paso = "Se pulsa buscar";
			numPaso = Utils.describirPaso(paso, numPaso);
						
			// Se realiza la acción
			Utils.accion(2, null, Const.BOTON_buscar, 2000, driverGlobal);
			
			// Se captura la evidencia
			Utils.capturarPantalla(casoDePrueba, pasos, paso);

//-----------------------------------------------------------------------------
			// generamos el documeto de evidencias con todas las capturas y descripciones
			Utils.generarPDF(casoDePrueba, pasos);
			
		} catch (Exception E) {
			System.out.println("Se ha interrumpido la ejecución");
			System.out.println(E);
			
		} finally {
			driverGlobal.quit();
		}
	}

}
