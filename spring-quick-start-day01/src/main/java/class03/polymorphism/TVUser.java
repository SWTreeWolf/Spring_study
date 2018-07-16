package class03.polymorphism;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/*
 * 유지보수가 어렵다.
 */
public class TVUser {
	public static void main(String[] args) {
		/*SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.VolumeDown();*/
		
		/*LgTv tv = new LgTv();
		tv.turnOn();
		tv.turnOff();
		tv.soundUp();
		tv.soundDown();*/
		/*
		// 위에서는 유지 보수가 어렵다는 사실을 알리기 위함
		// 아래부터는 factory 디자인 패턴을 보여줌
		
		//1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory =
				new GenericXmlApplicationContext("class03/polymorphism/applicationContext.xml");
		
		//2. Spring 컨테이너로부터 필요한 객체를 요청(LookUp)한다.(DL)
		TV tv = (TV) factory.getBean("tv");
		tv.powerOn();
		tv.powerOff();
		tv.volumeUp();
		tv.volumeDown();
		
		//3. Spring 컨테이너를 종료한다.
		factory.close();
		*/
		
		/*
		 * sington 결과값
		 * ==> SamsungTV 객체 생성
		 * 
		 * prototype 결과값
		 * ==> SamsungTV 객체 생성
		 * ==> SamsungTV 객체 생성
		 * ==> SamsungTV 객체 생성
		 */
		
		//1. Spring 컨테이너를 구동한다.
		AbstractApplicationContext factory =
			new GenericXmlApplicationContext("class03/polymorphism/applicationContext.xml");
		
		//2. 스프링 컨테이너로부터 필요한 객체를 요청
		TV tv1 = (TV)factory.getBean("tv");
		TV tv2 = (TV)factory.getBean("tv");
		TV tv3 = (TV)factory.getBean("tv");
		
		//3. 스프링 컨테이너를 종료한다.
		factory.close();
		
	}
}
