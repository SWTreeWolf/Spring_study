package class04.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 유지보수가 어렵다.
 */
public class TVUser {
	public static void main(String[] args) {
		//1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory =
			new GenericXmlApplicationContext("class04/polymorphism/applicationContext.xml");
		
		//2. 스프링 컨테이너로부터 필요한 객체를 요청
		TV tv = (TV)factory.getBean("tv");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		//3. 스프링 컨테이너를 종료한다.
		factory.close();
		
	}
}
