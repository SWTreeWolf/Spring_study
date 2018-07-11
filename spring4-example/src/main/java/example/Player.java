package example;

public class Player implements PlayerInterface {
	private Dice dice;

	public Player(Dice dice) {
		this.dice = dice;
	}

	@Override
	public void prn() {
		System.out.printf("플레이어 : %d, %s\n",dice.getNum(),dice.getName());
	}

}//end class
