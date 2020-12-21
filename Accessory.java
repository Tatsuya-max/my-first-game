package MondaiEX;

public class Accessory extends Equipment{
	private int increasedValue;

	public Accessory(){
	}
	public Accessory(String name,int increasedValue,String text,int price){
		super(name,increasedValue,text,price);
		this.increasedValue = increasedValue;
	}

	public int getIncrementHp() {return increasedValue;}
	public void setIncrementHp(int incrementHp) {this.increasedValue = incrementHp;}
}
