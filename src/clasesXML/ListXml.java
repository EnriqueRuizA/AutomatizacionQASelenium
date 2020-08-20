package clasesXML;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dataset")
public class ListXml {
	
	@XmlElement(name = "record")
	private List<RecordXml> ListaDeRecords;
	
	public ListXml() {}
	
	public ListXml(List<RecordXml> ListXml) {  
	    super();  
	    this.ListaDeRecords = ListXml;  
	}
	
	public List<RecordXml> getListXml() {
		return ListaDeRecords;
	}
	
	public void setListXml(List<RecordXml> ListXml) {
		this.ListaDeRecords=ListXml;
	}
	
	public void setUserListXml(RecordXml recordXml) {
		this.ListaDeRecords.add(recordXml);
	}
	
	
}
