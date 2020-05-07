package clasesXML;

/**
 * Se utiliza con una llamada del tipo:<br>
 * JAXBContext jaxbContext = JAXBContext.newInstance(Tutorials.class); <br>
 * Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();<br>
 * Tutorials tutorials = (Tutorials) jaxbUnmarshaller.unmarshal(this.getFile());<br>
 * @author Enrique Ruiz
 *
 */
import javax.xml.bind.annotation.XmlElement;

import utiles.Const;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class RecordXml {
	
	@XmlElement(name = Const.DB_id)
    private int id;
	
    @XmlElement(name = Const.DB_firstName)
    private String first_name;
    
    @XmlElement(name = Const.DB_lastName)
    private String last_name; 
    
    @XmlElement(name = Const.DB_email)
    private String email;
    
    @XmlElement(name = Const.DB_phone)
    private int phone; 

    @XmlElement(name = Const.DB_ip_address)
    private String ip_address; 
  

    
    
    
    
    


	//GETTERS & SETTERS --------------------
	public int getId() {  
	    return id;  
	}  
	
	public void setId(int id) {  
	    this.id = id;  
	}
	
    public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getIp_address() {
		return ip_address;
	}

	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
}  
