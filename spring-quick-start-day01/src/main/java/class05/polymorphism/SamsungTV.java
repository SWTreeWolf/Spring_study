package class05.polymorphism;

public class SamsungTV implements TV {
	//private SonySpeaker speaker;
	private Speaker speaker;
	private int price;
	
	public SamsungTV() {
		// TODO Auto-generated constructor stub
		System.out.println("==> samsungTV(1) 객체 생성");
	}

	public SamsungTV(Speaker speaker) {
		System.out.println("==> samsungTV(2) 객체 생성");
		this.speaker = speaker;
	}

	public SamsungTV(Speaker speaker, int price) {
		System.out.println("==> samsungTV(3) 객체 생성");
		this.speaker = speaker;
		this.price = price;
	}

	public void powerOn() {
		System.out.println("SamsungTV---전원 켠다.");
	}

	public void powerOff() {
		System.out.println("SamsungTV---전원 끈다.");
	}

	public void volumeUp() {
		//speaker = new SonySpeaker();
		System.out.println("SamsungTV---소리 올린다.");
	}

	public void volumeDown() {
		//speaker = new SonySpeaker();
		System.out.println("SamsungTV---소리 내린다.");
	}

	public Speaker getSpeaker() {
		return speaker;
	}

	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
