package main;

import utiles.*;

import casosDePrueba.Caso01_ObteniendoDatosLogin;

public class Main {
    public static void main (String[] args) throws Exception{   
        
    	//Lanzar casos de prueba
        //Caso01_ObteniendoDatosLogin.lanzarPrueba(Utils.probarEn("explorer"));
        Caso01_ObteniendoDatosLogin.lanzarPrueba(Utils.probarEnChrome());
        //Caso02_WACC_CETELEM_AltaDeNuevoCliente.lanzarPrueba(Utils.probarEnExplorer());
        
    	
    	//Utils.addUserXml(5, "huerta", Const.nombreXML);
    	//Utils.addUserXml(2, "qweqw", Const.nombreXML);
    	//Utils.obtenerTodosLosDatos(Const.nombreXML);
    	
    	//Utils.filtrarRecord(Const.DB_firstName, "Caitlin");
    }
    
    
 
    
}
