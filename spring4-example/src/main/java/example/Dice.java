package example;

public class Dice {
	private int num;
	private String name;
	
	public Dice() {
		
	}
	
	public Dice(String name) {
		super();
		this.name = name;
	}


	//constructor
	public Dice(int num, String name) {
		this.num = num;
		this.name = name;
	}

	//getter,setter
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}//end class
