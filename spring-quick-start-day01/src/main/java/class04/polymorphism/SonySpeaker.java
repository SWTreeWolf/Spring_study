package class04.polymorphism;

public class SonySpeaker{
	public SonySpeaker() {
		System.out.println("==> sonyspeaker 객체 생성");
	}
	
	public void volumeup() {
		System.out.println("SonySpeaker--소리 올린다");
	}
	
	public void volumedown() {
		System.out.println("SonySpeaker--소리 내린다");
	}
}
