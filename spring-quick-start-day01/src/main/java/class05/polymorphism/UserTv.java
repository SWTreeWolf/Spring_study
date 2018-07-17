package class05.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class UserTv {
	public static void main(String[] args) {
		AbstractApplicationContext context
			= new GenericXmlApplicationContext("class05/polymorphism/applicationContext.xml");
		
		TV tv = (TV) context.getBean("tv");
		Speaker sony = (Speaker) context.getBean("sony");
		Speaker apple = (Speaker) context.getBean("apple");
	}//end main
}//end class
