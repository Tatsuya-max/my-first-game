package MondaiEX;

import java.util.ArrayList;
import java.util.Scanner;

public class EquipmentStore {

	public static void counter(ArrayList<ArrayList<Equipment>> pe,ArrayList<ArrayList<Equipment>> se) {
		boolean toTown = false;
		System.out.println("店主「いらっしゃい」");
		do {
			System.out.println("店主「何か買うかい？それとも売るかい？」");
			switch(inputInt("1.買う 2.売る 0.店を出る")){
				case 1:
					playerBuys(pe,se);
					break;
				case 2:
					playerSells(pe,se);
					break;
				default:
					toTown = true;
					break;
			}
		}while(toTown == false);
	}
	public static void playerBuys(ArrayList<ArrayList<Equipment>> pe,ArrayList<ArrayList<Equipment>> se) {
		boolean toBeginning = false;
		do {
			System.out.println("店主「何を買うんだい？」");
			boolean toSelectType = false;
			switch(inputInt("1.武器 2.防具 3.装飾 0.戻る")){
				case 1:
					do {
						System.out.println("店主「どれにするんだい？」　所持金：" + Character.getMoney() + " 新元");
						for(int i = 0; i <  se.get(0).size(); i++)  {
							System.out.print((i + 1) + ".");
							System.out.printf("%-10s攻撃力：%-3d%-25s%5d 新元\n" , se.get(0).get(i).getName(),se.get(0).get(i).getPower(),se.get(0).get(i).getText(),se.get(0).get(i).getPrice());
//							System.out.println((i + 1) + "." + se.get(0).get(i).getName() + "　攻撃力：" + se.get(0).get(i).getPower() + "　" + se.get(0).get(i).getText() + "　" + se.get(0).get(i).getPrice() + "新元");
						}
						int num = inputInt(("0.戻る"));
						if(num >= (se.get(0).size() + 1) || num == 0){
							toSelectType = true;
						}else {
							Equipment selectedWeapon = (Weapon)se.get(0).get(num -1);
							System.out.println("店主「" + selectedWeapon.getName() + "でいいかい？」");
							num = inputInt("1.はい 2.いいえ");
							if(num == 1 && Character.getMoney() >=  selectedWeapon.getPrice()) {
								System.out.println(selectedWeapon.getName() + "を買った");
								pe.get(0).add(selectedWeapon);
								Character.setMoney(Character.getMoney() - selectedWeapon.getPrice());
							}else if(Character.getMoney() <  selectedWeapon.getPrice()){
								System.out.println("店主「お金が足りないねぇ…」");
							}
						}
					}while(toSelectType == false);
					break;
				case 2:
					do {
						System.out.println("店主「どれにするんだい？」　所持金：" + Character.getMoney() + " 新元");
						for(int i = 0; i <  se.get(1).size(); i++)  {
							System.out.println((i + 1) + "." + se.get(1).get(i).getName() + "　攻撃力：" + se.get(1).get(i).getPower() + "　" + se.get(1).get(i).getText() + "　" + se.get(1).get(i).getPrice() + "新元");
						}
						int num = inputInt(("0.戻る"));
						if(num >= (se.get(1).size() + 1) || num == 0){
							toSelectType = true;
						}else {
							Equipment selectedArmor = (Armor)se.get(1).get(num -1);
							System.out.println("店主「" + selectedArmor.getName() + "でいいかい？」");
							num = inputInt("1.はい 2.いいえ");
							if(num == 1 && Character.getMoney() >=  selectedArmor.getPrice()) {
								System.out.println(selectedArmor.getName() + "を買った");
								pe.get(1).add(selectedArmor);
								Character.setMoney(Character.getMoney() - selectedArmor.getPrice());
							}else if(Character.getMoney() <  selectedArmor.getPrice()){
								System.out.println("店主「お金が足りないねぇ…」");
							}
						}
					}while(toSelectType == false);
					break;
				case 3:
					do {
						System.out.println("店主「どれにするんだい？」　所持金：" + Character.getMoney() + " 新元");
						for(int i = 0; i <  se.get(2).size(); i++)  {
							System.out.println((i + 1) + "." + se.get(2).get(i).getName() + "　攻撃力：" + se.get(2).get(i).getPower() + "　" + se.get(2).get(i).getText() + "　" + se.get(2).get(i).getPrice() + "新元");
						}
						int num = inputInt(("0.戻る"));
						if(num >= (se.get(2).size() + 1) || num == 0){
							toSelectType = true;
						}else {
							Equipment selectedAccessory = (Accessory)se.get(2).get(num -1);
							System.out.println("店主「" + selectedAccessory.getName() + "でいいかい？」");
							num = inputInt("1.はい 2.いいえ");
							if(num == 1 && Character.getMoney() >=  selectedAccessory.getPrice()) {
								System.out.println(selectedAccessory.getName() + "を買った");
								pe.get(0).add(selectedAccessory);
								Character.setMoney(Character.getMoney() - selectedAccessory.getPrice());
							}else if(Character.getMoney() <  selectedAccessory.getPrice()){
								System.out.println("店主「お金が足りないねぇ…」");
							}
						}
					}while(toSelectType == false);
					break;
				default:
					toBeginning = true;
					break;
			}
		}while(toBeginning == false);
	}

	public static void playerSells(ArrayList<ArrayList<Equipment>> pe,ArrayList<ArrayList<Equipment>> se) {
		boolean toBeginning = false;
		do {
			System.out.println("店主「何を売ってくれるんだい？」");
			boolean toSelectType = false;
			switch(inputInt("1.武器 2.防具 3.装飾 0.戻る")){
				case 1:
					do {
						System.out.println("店主「どれを売ってくれるんだい？」　所持金：" + Character.getMoney() + " 新元");
						for(int i = 0; i <  pe.get(0).size(); i++)  {
							System.out.println((i + 1) + "." + pe.get(0).get(i).getName() + "　売値：" + (pe.get(0).get(i).getPrice())/2 + " 新元");
						}
						int num = inputInt(("0.戻る"));
						if(num >= (pe.get(0).size() + 1) || num == 0){
							toSelectType = true;
						}else {
							Equipment selectedWeapon = (Weapon)pe.get(0).get(num -1);
							int selectedWeaponNum = num -1;
							System.out.println("店主「" + selectedWeapon.getName() + "なら " + (selectedWeapon.getPrice())/2 + " 新元で買い取ろうか？」");
							num = inputInt("1.はい 2.いいえ");
							if(num == 1) {
								System.out.println(selectedWeapon.getName() + "を売った");
								pe.get(0).remove(selectedWeaponNum);
								Character.setMoney(Character.getMoney() + (selectedWeapon.getPrice())/2);
							}
						}
					}while(toSelectType == false);
					break;
				case 2:
					do {
						System.out.println("店主「どれを売ってくれるんだい？」　所持金：" + Character.getMoney() + " 新元");
						for(int i = 0; i <  pe.get(1).size(); i++)  {
							System.out.println((i + 1) + "." + pe.get(1).get(i).getName() + "　売値：" + (pe.get(1).get(i).getPrice())/2 + " 新元");
						}
						int num = inputInt(("0.戻る"));
						if(num >= (pe.get(1).size() + 1) || num == 0){
							toSelectType = true;
						}else {
							Equipment selectedArmor = (Armor)pe.get(1).get(num -1);
							int selectedArmorNum = num -1;
							System.out.println("店主「" + selectedArmor.getName() + "なら " + (selectedArmor.getPrice())/2 + " 新元で買い取ろうか？」");
							num = inputInt("1.はい 2.いいえ");
							if(num == 1) {
								System.out.println(selectedArmor.getName() + "を売った");
								pe.get(1).remove(selectedArmorNum);
								Character.setMoney(Character.getMoney() + (selectedArmor.getPrice())/2);
							}
						}
					}while(toSelectType == false);
					break;
				case 3:
					do {
						System.out.println("店主「どれを売ってくれるんだい？」　所持金：" + Character.getMoney() + " 新元");
						for(int i = 0; i <  pe.get(2).size(); i++)  {
							System.out.println((i + 1) + "." + pe.get(2).get(i).getName() + "　売値：" + (pe.get(2).get(i).getPrice())/2 + " 新元");
						}
						int num = inputInt(("0.戻る"));
						if(num >= (pe.get(2).size() + 1) || num == 0){
							toSelectType = true;
						}else {
							Equipment selectedAccessory = (Accessory)pe.get(2).get(num -1);
							int selectedAccessoryNum = num -1;
							System.out.println("店主「" + selectedAccessory.getName() + "なら " + (selectedAccessory.getPrice())/2 + " 新元で買い取ろうか？」");
							num = inputInt("1.はい 2.いいえ");
							if(num == 1) {
								System.out.println(selectedAccessory.getName() + "を売った");
								pe.get(2).remove(selectedAccessoryNum);
								Character.setMoney(Character.getMoney() + (selectedAccessory.getPrice())/2);
							}
						}
					}while(toSelectType == false);
					break;
				default:
					toBeginning = true;
					break;
			}
		}while(toBeginning == false);
	}

	public static int inputInt(String msg){
		System.out.println(msg);
		System.out.print(" > ");
		int num = new Scanner(System.in).nextInt();
		return num;
	}
}
