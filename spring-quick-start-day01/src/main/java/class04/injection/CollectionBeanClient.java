package class04.injection;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.web.servlet.mvc.Controller;

public class CollectionBeanClient {
	public static void main(String[] args) {
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("class04/injection/applicationContext.xml");
		
		CollectionBean bean = (CollectionBean) factory.getBean("CollectionBean");
		
		// map 하는 방법
		Map<String, String> map = bean.getAddressList(); 
		Set<String> key = map.keySet();
		Iterator<String> ite = key.iterator();
		
		while(ite.hasNext()) {
			String ite_key = ite.next();
			System.out.println(ite_key + "," + map.get(ite_key));
		}
		
		//list 이용 방법
		/*List<String> addressList = bean.getAddressList();
		
		for(String address : addressList) {
			System.out.println(address.toString());
		}*/
		
		factory.close();
	}
}
