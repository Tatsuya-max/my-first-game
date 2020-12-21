package MondaiEX;

import java.util.ArrayList;
import java.util.Scanner;

public class ItemStore {
	public static void counter(ArrayList<ArrayList<Item>> possessions,ArrayList<ArrayList<Item>> storages) {
		boolean toTown = false;
		System.out.println("店主「いらっしゃい」");
		do {
			System.out.println("店主「何か買うかい？それとも売るかい？」");
			switch(inputInt("1.買う 2.売る 0.店を出る")){
				case 1:
					playerBuys(possessions,storages);
					break;
				case 2:
					playerSells(possessions,storages);
					break;
				default:
					toTown = true;
					break;
			}
		}while(toTown == false);
	}
	public static void playerBuys(ArrayList<ArrayList<Item>> p,ArrayList<ArrayList<Item>> s) {
		boolean toBeginning = false;
		do {
			System.out.println("店主「どれにするんだい？」　所持金：" + Character.getMoney() + " 新元");
			for(int i = 0; i <  s.get(0).size(); i++)  {
				System.out.println((i + 1) + "." + s.get(0).get(i).getName() + "　" + s.get(0).get(i).getText() + "　" + s.get(0).get(i).getPrice() + "新元");
			}
			int num = inputInt(("0.戻る"));
			if(num >= (s.get(0).size() + 1) || num == 0){
				toBeginning = true;
			}else {
				Item selectedConsumable = (Consumable)s.get(0).get(num -1);
				System.out.println("店主「" + selectedConsumable.getName() + "でいいかい？」");
				num = inputInt("1.はい 2.いいえ");
				if(num == 1 && Character.getMoney() >=  selectedConsumable.getPrice()) {
					System.out.println(selectedConsumable.getName() + "を買った");
					p.get(0).add(selectedConsumable);
					Character.setMoney(Character.getMoney() - selectedConsumable.getPrice());
				}else if(Character.getMoney() <  selectedConsumable.getPrice()){
					System.out.println("店主「お金が足りないねぇ…」");
				}
			}
		}while(toBeginning == false);
	}

	public static void playerSells(ArrayList<ArrayList<Item>> p,ArrayList<ArrayList<Item>> s) {
		boolean toBeginning = false;
		do {
			System.out.println("店主「どれを売ってくれるんだい？」　所持金：" + Character.getMoney() + " 新元");
			for(int i = 0; i <  p.get(0).size(); i++)  {
				System.out.println((i + 1) + "." + p.get(0).get(i).getName() + "　売値：" + (p.get(0).get(i).getPrice())/2 + " 新元");
			}
			int num = inputInt(("0.戻る"));
			if(num >= (p.get(0).size() + 1) || num == 0){
				toBeginning = true;
			}else {
				Item selectedItem = (Item)p.get(0).get(num -1);
				int selectedItemNum = num -1;
				System.out.println("店主「" + selectedItem.getName() + "なら " + (selectedItem.getPrice())/2 + " 新元で買い取ろうか？」");
				num = inputInt("1.はい 2.いいえ");
				if(num ==1) {
					System.out.println(selectedItem.getName() + "を売った");
					p.get(0).remove(selectedItemNum);
					Character.setMoney(Character.getMoney() + (selectedItem.getPrice())/2);
				}
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
