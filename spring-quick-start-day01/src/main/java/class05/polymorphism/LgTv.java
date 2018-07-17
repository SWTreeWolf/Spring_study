package class05.polymorphism;

import org.springframework.stereotype.Component;

@Component("tv")
public class LgTv implements TV{

	public LgTv() {
		// TODO Auto-generated constructor stub
		System.out.println("lgtv 객체 생성");
	}
	
	@Override
	public void powerOn() {
		// TODO Auto-generated method stub
		System.out.println("==>lgtv 켠다");
	}

	@Override
	public void powerOff() {
		// TODO Auto-generated method stub
		System.out.println("==>lgtv 끈다");
	}

	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("==>lgtv 소리 높인다");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("==>lgtv 낮춘다");
	}
	
}
