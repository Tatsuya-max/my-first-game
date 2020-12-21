package MondaiEX;

public class Weapon extends Equipment{
	private int attackPower;

	public Weapon(){
	}
	public Weapon(String name,int attackPower, String text,int price){
		super(name,attackPower,text,price);
		this.attackPower = attackPower;
	}

	public int getAttackPower() {return attackPower;}
	public void setAttackPower(int attackPower) {this.attackPower = attackPower;}

}
