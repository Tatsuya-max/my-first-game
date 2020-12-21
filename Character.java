package MondaiEX;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Character{
	private static int money;
	private String name; private String race;
	private int hitPoint; private int magicPoint;
	private int strength; private int vitality; private int agility; private int intelligence;
	private int currentHp; private int currentMp;
	private Weapon weapon; private Armor armor; private Accessory accessory;

	public Character() {
	}
	public Character(Equipment weapon,Equipment armor,Equipment accessory) {
		this.weapon = (Weapon)weapon;
		this.armor = (Armor)armor;
		this.accessory = (Accessory)accessory;
	}
	public Character(String name, String race, int hp,int mp, int str, int vit, int agi, int intel) {
		this.name = name; this.race = race; this.hitPoint = hp; this.magicPoint = mp;
		this.strength = str; this.vitality = vit; this.agility = agi; this.intelligence = intel;
	}
	public void showStatus() {
		System.out.printf("%s %s\n", this.race,this.name);
		System.out.printf("%3s%4d / %4d\n" , "HP：",this.currentHp,this.hitPoint);
		System.out.printf("%3s%4d / %4d\n" , "MP：",this.currentMp,this.magicPoint);
		System.out.printf("%-8s%3d\n" , "筋　力 STR：",this.strength);
		System.out.printf("%-8s%3d\n" , "体　力 VIT：",this.vitality);
		System.out.printf("%-8s%3d\n" , "俊敏性 AGI：" , this.agility);
		System.out.printf("%-8s%3d\n" , "知　力 INT：" , this.intelligence);
	}
	public void showEquipment(ArrayList<ArrayList<Equipment>> e) {
		boolean toTown = false;
		do {
			System.out.println(this.name);
			if(this.weapon != null) {
				System.out.println("武器：" + this.weapon.getName());
			}else{
				System.out.println("武器：なし");
			}
			if(this.armor != null) {
				System.out.println("防具：" + this.armor.getName());
			}else{
				System.out.println("防具：なし");
			}
			if(this.accessory != null) {
				System.out.println("装飾：" + this.accessory.getName());
			}else{
				System.out.println("装飾：なし");
			}
			//装備変更へ
			switch(inputInt("1.武器を変更 2.防具を変更 3.装飾を変更 0.戻る")){
				case 1:
					if(e.get(0).isEmpty()) {
						System.out.println("表示するものがありません");
					}else{
						if(this.weapon != null) {
							System.out.println("どれに変更しますか？" + "　現在装備中：" + this.weapon.getName());
						}else{
						System.out.println("どれに変更しますか？" + "　現在装備中：なし");
						}
						for(int i = 0; i <  e.get(0).size(); i++)  {
							System.out.println((i + 1) + "." + e.get(0).get(i).getName() + "　攻撃力：" + e.get(0).get(i).getPower()+ "　" + e.get(0).get(i).getText());
						}
						int num = inputInt(("0.戻る"));
						if(num >= (e.get(0).size() + 1) || num == 0){
						}else{
							Equipment unequippedWeapon = this.weapon;
							this.weapon = (Weapon)e.get(0).get(num -1);
							e.get(0).remove(num -1);
							if(unequippedWeapon != null) {
								e.get(0).add(unequippedWeapon);
							}
							System.out.println(this.weapon.getName()+ "を装備した");
						}
					}
					break;
				case 2:
					if(e.get(1).isEmpty()) {
						System.out.println("表示するものがありません");
					}else{
						if(this.armor != null) {
							System.out.println("どれに変更しますか？" + "　現在装備中：" + this.armor.getName());
						}else{
							System.out.println("どれに変更しますか？" + "　現在装備中：なし");
						}
						for(int i = 0; i <  e.get(1).size(); i++)  {
							System.out.println((i + 1) + "." + e.get(1).get(i).getName() + "　防御力：" + e.get(1).get(i).getPower() +  "　" + e.get(1).get(i).getText());
						}
						int num = inputInt(("0.戻る"));
						if(num >= (e.get(1).size() + 1) || num == 0){
						}else {
						 Equipment unequippedArmor = this.armor;
						 this.armor = (Armor)e.get(1).get(num -1);
						e.get(1).remove(num -1);
						if(unequippedArmor != null) {
							e.get(1).add(unequippedArmor);
						}
						System.out.println(this.armor.getName()+ "を装備した");
						}
					}
					break;
				case 3:
					if(e.get(2).isEmpty()) {
						System.out.println("表示するものがありません");
						break;
					}else{
						if(this.accessory != null) {
							System.out.println("どれに変更しますか？" + "　現在装備中：" + this.accessory.getName());
						}else{
							System.out.println("どれに変更しますか？" + "　現在装備中：なし");
						}
						for(int i = 0; i <  e.get(2).size(); i++)  {
							System.out.println((i + 1) + "." + e.get(2).get(i).getName() + "　上昇値：" + e.get(2).get(i).getPower() + "　" + e.get(2).get(i).getText());
						}
						int num = inputInt(("0.戻る"));
						if(num >= (e.get(2).size() + 1) || num == 0){
						}else {
							 Equipment unequippedAccessory = this.accessory;
							 this.accessory = (Accessory)e.get(2).get(num -1);
							e.get(2).remove(num -1);
							if(unequippedAccessory != null) {
								e.get(2).add(unequippedAccessory);
							}
							System.out.println(this.accessory.getName()+ "を装備した");
						}
					}
					break;
				default:
					toTown = true;
					break;
			}
		}while(toTown == false);
	}

	public void showItem(ArrayList<ArrayList<Item>> items) {
		System.out.println("アイテム一覧");
		System.out.printf("所持金：%,d 新元\n" , this.money);
		for(int i = 0; i <  items.get(0).size(); i++)  {
			System.out.println((i + 1) + "." + items.get(0).get(i).getName() + "　" + items.get(0).get(i).getText());
		}
	}
	public static int inputInt(String msg){
		System.out.println(msg);
		System.out.print(" > ");
		int num = new Scanner(System.in).nextInt();
		return num;
	}

	public static int getMoney() {return Character.money;}
	public static void setMoney(int money) {Character.money = money;}
	public String getName() {return this.name;}
	public void setName(String name) {this.name = name;}
	public String getRace() {return this.race;}
	public void setRace(String race) {this.race = race;}
	public int getHp() {return this.hitPoint;}
	public void setHp(int hp) {this.hitPoint = hp;}
	public int getMp() {return magicPoint;}
	public void setMp(int mp) {this.magicPoint = mp;}
	public int getStr() {return strength;}
	public void setStr(int str) {this.strength = str;}
	public int getVit() {return vitality;}
	public void setVit(int vit) {this.vitality = vit;}
	public int getAgi() {return agility;}
	public void setAgi(int agi) {this.agility = agi;}
	public int getInt() {return intelligence;}
	public void setInt(int intel) {this.intelligence = intel;}
	public int getCurrentHp() {return this.currentHp;}
	public void setCurrentHp(int currentHp) {this.currentHp = currentHp;}
	public int getCurrentMp() {return this.currentMp;}
	public void setCurrentMp(int currentMp) {this.currentMp = currentMp;}
	public Weapon getWeapon() {return this.weapon;}
	public void setWeapon(Weapon weapon) {this.weapon = weapon;}
	public Armor getArmor() {return this.armor;}
	public void setArmor(Armor armor) {this.armor = armor;}
	public Accessory getAccessory() {return this.accessory;}
	public void setAccessory(Accessory accessory) {this.accessory = accessory;}
}
