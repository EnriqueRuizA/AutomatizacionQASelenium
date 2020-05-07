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
	private List<RecordXml> ListXml;
	
	public ListXml() {}
	
	public ListXml(List<RecordXml> ListXml) {  
	    super();  
	    this.ListXml = ListXml;  
	}
	
	public List<RecordXml> getListXml() {
		return ListXml;
	}
	
	public void setListXml(List<RecordXml> ListXml) {
		this.ListXml=ListXml;
	}
	
	public void setUserListXml(RecordXml recordXml) {
		this.ListXml.add(recordXml);
	}
	
	
}
