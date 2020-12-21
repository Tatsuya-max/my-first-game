package MondaiEX;

public abstract class Item {
	private String name;
	private String text;
	private int price;

	public Item( ) {
}
	public Item(String name, String text,int price) {
		this.setName(name);
		this.setText(text);
		this.price = price;
	}

	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getText() {return text;}
	public void setText(String text) {this.text = text;}
	public int getPrice() {return price;}
	public void setPrice(int price) {this.price = price;}
}
