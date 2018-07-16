package class04.polymorphism;

public class AppleSpeaker implements Speaker{
	
	public AppleSpeaker() {
		// TODO Auto-generated constructor stub
		System.out.println("===> AppleSpeaker 객체 생성");
	}
	
	@Override
	public void volumeUp() {
		// TODO Auto-generated method stub
		System.out.println("--apple 소리 올린다");
	}

	@Override
	public void volumeDown() {
		// TODO Auto-generated method stub
		System.out.println("--apple 소리 내린다");
	}
	
}
