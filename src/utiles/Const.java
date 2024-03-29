package utiles;

public class Const {

	// Configuración: webdrivers
	public final static String explorerKey = "webdriver.ie.driver";
	public final static String explorerValue = System.getProperty("user.dir") + "\\drivers\\IEDriverServer32.exe";
	public final static String explorerText = "Ejecutando prueba en Explorer";

	public final static String chromeKey = "webdriver.chrome.driver";
	public final static String chromeValue = System.getProperty("user.dir") + "\\drivers\\chromedriver32.exe";
	public final static String chromeText = "Ejecutando prueba en Chrome";

	public final static String RUTA_CASOS = System.getProperty("user.dir") + "\\CASOS DE PRUEBA\\";// +casoDePrueba";

	// Configuración: Variables relacionadas con XML
	public final static String nombreXML = "baseDeDatos.xml";
	public final static String DB_id = "id";
	public final static String DB_firstName = "first_name";
	public final static String DB_lastName = "lastName";
	public final static String DB_email = "email";
	public final static String DB_phone = "phone";
	public final static String DB_ip_address = "ip_address";

	// Configuración: Urls & Xpath campos de la aplicación
	public final static String BOTON_Cookies = "/html/body/ytd-app/ytd-consent-bump-v2-lightbox/tp-yt-paper-dialog/div[4]/div/div[6]/div[1]/ytd-button-renderer[2]/a/tp-yt-paper-button/yt-formatted-string";
	public final static String URL_YouTube = "https://www.youtube.com/";
	public final static String CAMPO_busqueda = "/html/body/ytd-app/div/div/ytd-masthead/div[3]/div[2]/ytd-searchbox/form/div/div[1]/input";
	public final static String BOTON_buscar = "//*[@id=\"search-icon-legacy\"]";

	// Variables para https://generadordni.es/#profiles
	public final static String URL_GENERADOR = "https://generadordni.es/#profiles";
	public final static String CAMPO_GEN_DNI = "/html/body/div[1]/div[2]/div[5]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div[1]/div[1]/span/span";
	public final static String CAMPO_GEN_NOMBRE = "/html/body/div[1]/div[2]/div[5]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div[1]/div[2]/span/span";
	public final static String CAMPO_GEN_APELLIDO1 = "/html/body/div[1]/div[2]/div[5]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div[1]/div[3]/span";
	public final static String CAMPO_GEN_APELLIDO2 = "/html/body/div[1]/div[2]/div[5]/div/div[2]/div/div[2]/div[2]/div/div[1]/div/div/div[1]/div[4]/span/span";
	public final static String CAMPO_GEN_TELF = "/html/body/div[1]/div[2]/div[5]/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[2]/span/span";
	public final static String CAMPO_GEN_MAIL = "/html/body/div[1]/div[2]/div[5]/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[1]/span/span";
	public final static String CAMPO_GEN_CP = "/html/body/div[1]/div[2]/div[5]/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[6]/span/span";
	public final static String CAMPO_GEN_MUNICIPIO = "/html/body/div[1]/div[2]/div[5]/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[7]/span/span";
	public final static String CAMPO_GEN_PROVINCIA = "/html/body/div[1]/div[2]/div[5]/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[8]/span/span";
	public final static String CAMPO_GEN_DIRECCION = "/html/body/div[1]/div[2]/div[5]/div/div[2]/div[2]/div[2]/div[2]/div/div[1]/div/div/div[2]/div[5]/span/span";

	public final static String CAMPO_nuevaOperacion1 = "/html/body/div[2]/div[5]/div[3]/div[2]/div[1]/div/ul/li[1]/a";
	public final static String CAMPO_nuevaOperacion2 = "/html/body/div[2]/div[3]/div/ul/li[1]/ul/li[1]/a";
	public final static String CAMPO_vendedorNum = "/html/body/div[2]/div[5]/div[2]/form/div/table[1]/tbody/tr[1]/td[2]/input";// Usar
																																// este
																																// campo
																																// poniendo
																																// 1578814
	public final static String CAMPO_vendedorNombre = "/html/body/div[2]/div[5]/div[2]/form/div/table[1]/tbody/tr[2]/td[2]/input";
	public final static String CAMPO_vendedorSelectRed = "/html/body/div[2]/div[5]/div[2]/form/div/table[1]/tbody/tr[3]/td[2]/select";
	public final static String CAMPO_vendedorBoton = "/html/body/div[2]/div[5]/div[2]/form/div/table[2]/tbody/tr[2]/td/input";
//		public final static String CAMPO_GEN_NIF = "";
//		public final static String CAMPO_GEN_NIF = "";
//		public final static String CAMPO_GEN_NIF = "";
//		public final static String CAMPO_GEN_NIF = "";
//		public final static String CAMPO_GEN_NIF = "";
//		public final static String CAMPO_GEN_NIF = "";
//		public final static String CAMPO_GEN_NIF = "";

	// Contenido campos de la aplicacion

	// Spected Results

}
