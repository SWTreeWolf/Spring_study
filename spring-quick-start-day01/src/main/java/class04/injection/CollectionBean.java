package class04.injection;

import java.util.List;
import java.util.Map;

import org.springframework.web.servlet.mvc.Controller;

public class CollectionBean {
	//private List<String> addressList;
	/*public void setAddressList(List<String> addressList) {
		this.addressList = addressList;
	}
	
	public List<String> getAddressList() {
		return addressList;
	}*/
	
	private Map<String, String> addressList;
	
	public void setAddressList(Map<String, String> addressList) {
		this.addressList = addressList;
	}
	
	public Map<String, String> getAddressList() {
		return addressList;
	}

}
