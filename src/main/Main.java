package main;

import casosDePrueba.Caso00_PruebaBuscarEnYoutube;
import utiles.Utils;

public class Main {
	public static void main(String[] args) throws Exception {

		// Lanzar casos de prueba
		// Caso01_ObteniendoDatosLogin.lanzarPrueba(Utils.probarEn("explorer"));
		Caso00_PruebaBuscarEnYoutube.lanzarPrueba(Utils.probarEnChrome());
		// Utils.addUserXml(5, "huerta", Const.nombreXML);
		// Utils.addUserXml(2, "qweqw", Const.nombreXML);
		// Utils.obtenerTodosLosDatos(Const.nombreXML);
		// Utils.filtrarRecord(Const.DB_firstName, "Caitlin");

	}
}
