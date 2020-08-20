package utiles;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import clasesXML.ListXml;
import clasesXML.RecordXml;

public class Utils {

	/**
	 * Este método obtendrá el driver para realizar las pruebas con: <br>
	 * - Explorer <br>
	 * - Chrome
	 * 
	 * @param
	 */
	public static WebDriver probarEn(String navegador) {
		String key = null;
		String value = null;
		String text = null;
		WebDriver driver = null;

		if (navegador.equalsIgnoreCase("chrome")) {
			key = Const.chromeKey;
			value = Const.chromeValue;
			text = Const.chromeText;
			driver = new ChromeDriver();
			System.setProperty(key, value);
		} else {
			// por defecto explorer
			key = Const.explorerKey;
			value = Const.explorerValue;
			text = Const.explorerText;
			System.setProperty(key, value);

			InternetExplorerOptions cap = new InternetExplorerOptions();
			cap.ignoreZoomSettings();
			driver = new InternetExplorerDriver(cap);

		}

		System.out.println(text);
		return driver;
	}

	/**
	 * Este método obtendrá el driver para realizar las pruebas con Explorer
	 */
	public static WebDriver probarEnExplorer() {
		System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "\\drivers\\IEDriverServer32.exe");
		WebDriver driver = new InternetExplorerDriver();
		System.out.println("Ejecutando prueba en Internet Explorer");
		return driver;
	}

	/**
	 * Este método obtendrá el driver para realizar las pruebas con Chrome
	 */
	public static WebDriver probarEnChrome() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\drivers\\chromedriver32.exe");
		WebDriver driver = new ChromeDriver();
		System.out.println("Ejecutando prueba en Chrome");
		return driver;
	}

	/**
	 * Este método sirve para validar si el resultado es el esperado.
	 * 
	 * @param spectedResult
	 * @param actualResult
	 */
	public static void probarResultado(String spectedResult, String actualResult) {
		if (spectedResult.equalsIgnoreCase(actualResult)) {
			System.out.println("----------Resultado correcto: " + spectedResult);
		} else {
			System.out.println("xxxxx-----Resultado erroneo: " + actualResult);
		}
		// Vaciamos las variables
		spectedResult = null;
		actualResult = null;
	}

	/**
	 * Método para generar una captura de pantalla en jpg con el nombre que se
	 * defina.
	 * 
	 * @param
	 */
	public static ArrayList<String> capturarPantalla(String casoDePrueba, ArrayList<String> pasos, String paso)
			throws AWTException, IOException {

		Dimension area = new Dimension(Toolkit.getDefaultToolkit().getScreenSize());

		// se define tamaño horizontal/vertical
		area.setSize(area.getWidth() - 50, area.getHeight() - 100);
		Rectangle rectangulo = new Rectangle(area);

		// se define el origen de captura horizontal/vertical
		rectangulo.setLocation((int) rectangulo.getX() + 20, (int) rectangulo.getY() + 70);

		System.out.println("Área de la captura '" + paso + "' comienza en: ");
		System.out.println(rectangulo.getLocation());
		System.out.println("y tiene un tamaño de: ");
		System.out.println(area.getSize());

		BufferedImage captura = new Robot().createScreenCapture(rectangulo);

		// Guardar Como JPEG
		File file = new File(Const.RUTA_CASOS + casoDePrueba + "-" + paso + ".jpg");
		ImageIO.write(captura, "jpg", file);

		// Guardando el paso en la lista de pasos del caso de prueba
		pasos.add(paso);
		return pasos;
	}

	/**
	 * @throws MalformedURLException
	 * @throws FileNotFoundException
	 */
	public static void generarPDF(String casoDePrueba, ArrayList<String> pasos)
			throws MalformedURLException, FileNotFoundException {

		// Obtenemos la carpeta de caso
		String rutaCaso = Const.RUTA_CASOS;

		// declaracion del pdf
		PdfWriter writer = new PdfWriter(rutaCaso + "\\" + casoDePrueba + ".pdf");
		PdfDocument pdf = new PdfDocument(writer);
		Document doc = new Document(pdf);

		for (String paso : pasos) {

			// Obtenemos la imagen a adjuntar
			String rutaImg = Const.RUTA_CASOS + casoDePrueba + "-" + paso + ".jpg";
			ImageData paramImg = ImageDataFactory.create(rutaImg);
			Image image = new Image(paramImg);
			image.scaleAbsolute(455, 249);

			Paragraph p1 = new Paragraph(paso);
			doc.add(p1);
			Paragraph p2 = new Paragraph().add(image);
			doc.add(p2);
		}
		doc.close();
	}

	/**
	 * Método para obtener el webElement de un campo concreto
	 */
	public static WebElement obtenerCampo(WebDriver driverGlobal, String xpath) {
		WebElement campo_nombre = driverGlobal.findElement(By.xpath(xpath));
		return campo_nombre;
	}

	/**
	 * TODO Revisar o eliminar Método campos
	 * 
	 * @return
	 */
	public static HashMap<String, WebElement> campos() {
		HashMap<String, WebElement> listaDeCampos = new HashMap<String, WebElement>();
		WebDriver driverGlobal = Utils.probarEn("explorer");
		// Campo Nombre
		String xpath_nombre = "/html/body/div[3]/div[4]/div/div/div/form/div/div/div[2]/fieldset/fieldset/div[2]/input";
		WebElement campo_nombre = driverGlobal.findElement(By.xpath(xpath_nombre));
		// WebElement campo_nombre= driver.findElement(By.id("formConsulta:name"));
		listaDeCampos.put("campo_nombre", campo_nombre);

		return listaDeCampos;
	}

	/**
	 * 
	 */
	public static HashMap<String, String> obtenerDatosCliente() {
		HashMap<String, String> listaDeCampos = new HashMap<String, String>();
		WebDriver driverGlobal = Utils.probarEnChrome();
		String baseUrl = Const.URL_GENERADOR;
		driverGlobal.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		// Accediendo a la url
		driverGlobal.get(baseUrl);
		driverGlobal.manage().window().maximize();

		WebElement campo_dni = Utils.obtenerCampo(driverGlobal, Const.CAMPO_GEN_DNI);
		listaDeCampos.put("campo_dni", campo_dni.getText());

		WebElement campo_nombre = Utils.obtenerCampo(driverGlobal, Const.CAMPO_GEN_NOMBRE);
		listaDeCampos.put("campo_nombre", campo_nombre.getText());

		WebElement campo_apellido1 = Utils.obtenerCampo(driverGlobal, Const.CAMPO_GEN_APELLIDO1);
		listaDeCampos.put("campo_apellido1", campo_apellido1.getText());

		WebElement campo_apellido2 = Utils.obtenerCampo(driverGlobal, Const.CAMPO_GEN_APELLIDO2);
		listaDeCampos.put("campo_apellido2", campo_apellido2.getText());

		WebElement campo_mail = Utils.obtenerCampo(driverGlobal, Const.CAMPO_GEN_MAIL);
		listaDeCampos.put("campo_mail", campo_mail.getText());

		WebElement campo_telf = Utils.obtenerCampo(driverGlobal, Const.CAMPO_GEN_TELF);
		listaDeCampos.put("campo_telf", campo_telf.getText());

		System.out.println(listaDeCampos);

		return listaDeCampos;
	}

	public static void addUserXml(int id, String name, String xml) throws Exception {

		// Llenamos el objeto UserXml
		RecordXml userXml = new RecordXml();
		userXml.setId(id);
		userXml.setFirst_name(name);

		ListXml listXml = new ListXml();

		// Creamos la ruta de salida
		File file = new File(xml);
		if (!file.exists()) {
			file.createNewFile();
			// Creamos una lista de users
			List<RecordXml> list = new ArrayList<>();
			list.add(userXml);
			// Llenamos el objeto ListXml
			listXml.setListXml(list);
		} else {
			JAXBContext jaxbContext = JAXBContext.newInstance(ListXml.class, RecordXml.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			ListXml list = (ListXml) jaxbUnmarshaller.unmarshal(file);
			List<RecordXml> auxList = list.getListXml();
			auxList.add(userXml);
			listXml.setListXml(auxList);
		}

		FileOutputStream fileOuputStream = new FileOutputStream(file);
		// Creamos el xml
		JAXBContext jaxbContext = JAXBContext.newInstance(ListXml.class, RecordXml.class);
		Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
		jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
		jaxbMarshaller.marshal(listXml, fileOuputStream);
	}

	public static List<RecordXml> obtenerTodosLosDatos(String xml) {
		List<RecordXml> listaDeResultados = new ArrayList<>();
		try {
			File file = new File(Const.nombreXML);
			JAXBContext jaxbContext = JAXBContext.newInstance(ListXml.class, RecordXml.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			ListXml list = (ListXml) jaxbUnmarshaller.unmarshal(file);

			for (RecordXml user : list.getListXml()) {
				listaDeResultados.add(user);
				System.out.print("| Id: " + user.getId());
				System.out.print("| First_name: " + user.getFirst_name());
				System.out.print("| Last_name: " + user.getLast_name());
				System.out.print("| Email: " + user.getEmail());
				System.out.print("| Phone: " + user.getPhone());
				System.out.println("| Ip_address: " + user.getIp_address() + " |");
			}

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return listaDeResultados;
	}

	public static List<RecordXml> filtrarRecord(String campo, String valor) {
		List<RecordXml> listaDeResultados = new ArrayList<>();
		try {
			File file = new File(Const.nombreXML);
			JAXBContext jaxbContext = JAXBContext.newInstance(ListXml.class, RecordXml.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			ListXml list = (ListXml) jaxbUnmarshaller.unmarshal(file);

			for (RecordXml user : list.getListXml()) {
				if ((campo.equalsIgnoreCase(Const.DB_firstName) && user.getFirst_name().equalsIgnoreCase(valor))
						|| (campo.equalsIgnoreCase(Const.DB_lastName) && user.getLast_name().equalsIgnoreCase(valor))) {
					System.out.println(user.getId() + " " + user.getFirst_name());
					listaDeResultados.add(user);
				}
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return listaDeResultados;
	}

}
