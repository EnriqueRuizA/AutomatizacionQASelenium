package casosDePrueba;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utiles.Const;
import utiles.Utils;

public class Caso01_ObteniendoDatosLogin {

	//Declarando variables GLOBALES
	private static final String casoDePrueba = "Caso01_ObteniendoDatosLogin";
	private static ArrayList<String> pasos = new ArrayList<String>();
	private static WebDriver driverGlobal=null;
	private static String paso;
    
    public static void lanzarPrueba(WebDriver driverGlobal) {
    	
        String baseUrl = Const.URL_SEPE;
        
    	try {
            //Estableciendo time out de 5 seg
    		driverGlobal.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            //Accediendo a la url
    		driverGlobal.get(baseUrl);
            driverGlobal.manage().window().maximize();

            //Pruebas            
//-----------------------------------------------------------------------------
            
            //Primera pagina, formulario
            paso = "Primera pagina, formulario";
            System.out.println("01....."+paso);
            
            //Introducimos el primer valor
            String xpath_nombre = "//*[@id=\"formConsulta:name\"]";
            WebElement campo_nombre= driverGlobal.findElement(By.xpath(xpath_nombre));
            
			campo_nombre.sendKeys("Fulanito");
            String campoNombre = campo_nombre.getTagName();
            System.out.println("03....."+campoNombre);
            //Thread.sleep(1000);
            
            String paso1 = "Se introduce fulanito";
            Utils.capturarPantalla(casoDePrueba, pasos, paso1);
            
//-----------------------------------------------------------------------------
            campo_nombre.clear();
            campo_nombre.sendKeys("Menganito");
            campoNombre = campo_nombre.getTagName();
            System.out.println("04....."+campoNombre);
            String paso2 = "Se introduce Menganito";
            Utils.capturarPantalla(casoDePrueba, pasos, paso2);
            campo_nombre.clear();
            Utils.generarPDF(casoDePrueba, pasos);
//-----------------------------------------------------------------------------

        }catch (Exception E){
            System.out.println("Se ha interrumpido la ejecución");
            System.out.println(E);
        }finally {
        	driverGlobal.quit();
        }
    }

}
