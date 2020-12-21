package MondaiEX;

import java.util.ArrayList;
import java.util.Scanner;

public class Town {
	public static void town(ArrayList<ArrayList<Equipment>> equipments,ArrayList<ArrayList<Item>> Items,ArrayList<ArrayList<Equipment>> storeEquipments,ArrayList<ArrayList<Item>> storeItems){
		System.out.println("新東京セントラルエリアです");
		while(true) {
			System.out.println("どこへ行きますか？");
			switch(inputInt("1.ホテル 2.酒場 3.武具屋 4.道具屋 0.キャンプ")) {
				case 1:
					System.out.println("受付「ゲンザイ マンシツデス マタノゴライテンヲ オマチシテイマス」");
					break;
				case 2:
					System.out.println("男「申し訳ございません 当店は会員制です ご紹介がなければ入店できません」");
					break;
				case 3:
					EquipmentStore.counter(equipments,storeEquipments);
					break;
				case 4:
					ItemStore.counter(Items,storeItems);
					break;
				case 0:
					return;
				default:
					break;
			}
		}
	}

	public static int inputInt(String msg){
		System.out.println(msg);
		System.out.print(" > ");
		int num = new Scanner(System.in).nextInt();
		return num;
	}
}
