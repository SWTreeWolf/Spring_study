package example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



/*
 * IoC
 * 자바가 등장하고 자바 기반으로 애플리케이션을 개발하기 시작하던 최초의 시기에는 자바 객체를 생성하고 객체간의 의존관계를 
 * 연결시키는 등의 제어권을 개발자가 직접 가지고 있었다. 그러나 서블릿, EJB가 등장하면서 개발자들의 독점적으로 가지고 있던 
 * 제어권이 서블릿과 EJB를 관리하는 컨테이너에게 넘어가 버렸다. 객체에 대한 제어권이 컨테이너에게 넘어가면서 객체의 생명주기를
 * 관리하는 권한 또한 컨테이너들이 전담할 수 밖에 없게 되었다. 
 * 이처럼 객체의 생성에서부터 생명주기의 관리까지 모든 객체에 대한제어권이 바뀐것을 의미하는 것이 제어권의 역전, 즉 Ioc라는 개념이다.
 * 
 * DL(Dependency Lookup) : 모든 IoC 컨테이너는 각 컨테이너에서 관리해야 하는 객체들을 관리하기 위한 별도의 저장소를 가진다. 
 * Bean에 접근하기 위하여 컨테이너에서 제공하는 API를 이용하여 사용하고자 하는 Bean을 Lookup 하는 것으로 
 * 컨테이너 API와 의존관계를 많이 가지면 가질수록 어플리케이션에 종속되는 단점이 있다.
 */

public class TestSpring {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("example/config.xml");
		PlayerInterface p = (PlayerInterface) context.getBean("play");
		p.prn();
		
		SingletonBean singleton = (SingletonBean) context.getBean("singletonBean");
		PrototypeBean prototypeBeanA = singleton.getPrototypeBean();
		PrototypeBean prototypeBeanB = singleton.getPrototypeBean();
		System.out.println(prototypeBeanA);
		System.out.println(prototypeBeanB);
		System.out.println("두 개의 프로토타입은 같은건가? " + (prototypeBeanA == prototypeBeanB));
	}//end main()
}//end class
