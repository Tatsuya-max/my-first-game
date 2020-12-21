package MondaiEX;

public class Equipment {
	private String name;
	private int power;
	private String text;
	private int price;

	public Equipment(){
	}
	public Equipment(String name,int power,String text,int price){
		this.name = name;
		this.power = power;
		this.text = text;
		this.price = price;
	}

	public String getName() {return this.name;}
	public void setName(String name) {this.name = name;}
	public int getPower() {return power;}
	public void setPower(int power) {this.power = power;}
	public String getText() {return text;}
	public void setText(String text) {this.text = text;}
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}
}
