package MondaiEX;

public class Armor extends Equipment{
	private int defensePower;

	public Armor(){
	}
	public Armor(String name,int defensePower,String text,int price){
		super(name,defensePower,text,price);
		this.defensePower = defensePower;
	}

	public int getDefensePower() {return defensePower;}
	public void setDefensePower(int defensePower) {this.defensePower = defensePower;}

}
