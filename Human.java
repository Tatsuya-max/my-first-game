package MondaiEX;

import java.util.Scanner;

public class Human extends Character{
	public Human(){
	}
	public Human(Equipment weapon,Equipment armor,Equipment accessory) {
		super(weapon,armor,accessory);
	}
	public Human(String name, String race, int hp,int mp, int str, int vit, int agi, int intel) {
		super(name, race, hp, mp, str, vit, agi, intel);
	}

	public void showStatus() {
		super.showStatus();
	}

	public void createHuman() {
		System.out.println("キャラクターを作成します、名前を入力して下さい。");
		System.out.print(">");
		String name = new Scanner(System.in).nextLine();
		//各パラメータの数値をランダムで割り振り。
		int hp; int mp;int str; int vit; int agi;  int intel; int sum;
		do {
			str = (int)(Math.random()*15) + 5;
			vit = (int)(Math.random()*15) + 5;
			agi = (int)(Math.random()*15) + 5;
			intel = (int)(Math.random()*15) + 5;
			sum = str + vit + agi + intel;
			}while(45 < sum && sum < 55);
		//パラメータにより、HP,MPの割り振りパターンを２つに分岐。
		do {
			if(str >= intel) {
				hp = (int)(Math.random()*40) + 60;
				mp = (int)(Math.random()*60) + 40;
				sum = hp + mp;
			}else{
				hp = (int)(Math.random()*60) + 40;
				mp = (int)(Math.random()*40) + 60;
				sum = hp + mp;
			}
		}while(130 < sum && sum < 170);
		this.setName(name); this.setRace("人間");
		this.setHp(hp); this.setMp(mp);
		this.setStr(str); this.setVit(vit);
		this.setAgi(agi); this.setInt(intel);
		this.setCurrentHp(hp); this.setCurrentMp(mp);

		System.out.println(this.getRace() + " " + this.getName() + "を作成しました");
	}
}
