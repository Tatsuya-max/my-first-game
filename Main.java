package MondaiEX;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    //武器作成
    Equipment handgun = new Weapon("ハンドガン",3,"片手で持って携帯できる小型の銃",1000);
    Equipment shotgun = new Weapon("ショットガン",5,"有効射程は短いが、大口径で威力が大きい銃",2000);
    Equipment submachineGun = new Weapon("サブマシンガン",9,"拳銃弾などを連射する小型の機関銃",5000);
    Equipment assaultRifle = new Weapon("アサルトライフル",14,"長い銃身を備えた銃で、威力・精度ともに拳銃を凌駕する",7000);
    Equipment rocketLauncher = new Weapon("ロケットランチャー",35,"個人が肩に担ぐなどして使用する小型の破壊兵器",20000);
    //防具作成
    Equipment chestRig  = new Armor("皮の胸当て",2,"衣服の上から胸部にあてがう布",300);
    Equipment tacticalVest = new Armor("メッシュベスト",4,"様々な用途に使えるメッシュ製のベスト",800);
    Equipment bulletproofVest = new Armor("防弾ベスト",8,"銃弾などから身を守るために使用されるベスト状の防護服",2500);
    Equipment bodyArmor = new Armor("ボディアーマー",11,"緩衝材や装甲板などで強化された重装甲",4000);
    Equipment TALOS = new Armor("強化スーツ",50,"身体能力を大幅に向上させる軍用パワードスーツ",100000);
    //アクセサリー作成
    Equipment scrapPart  = new Accessory("スクラップパーツ",2,"脳の記憶メモリを増設する",900);
    Equipment extensionBoard  = new Accessory("拡張ボード",4,"脳電位を活性化させる",3000);
    Equipment combatBoard = new Accessory("戦闘用ボード",8,"攻撃本能を刺激して興奮を促す",5000);
    Equipment illegalMemoryBoard = new Accessory("裏メモリーボード",11,"脳の未知なる領域を開放する",30000);
    Equipment artificialParasite = new Accessory("人工寄生蟲",30,"脳に寄生し身体機能を強化する蟲",50000);
    //アイテム作成
    Item energyBoostingDrink = new Consumable("エナジードリンク","滋養強壮、疲労回復を促進させる",200);
    Item medicalKit = new Consumable("医療キット","応急処置のために使用される薬品や医療器具を収納した箱",500);
     Item medicinalLiquor = new Consumable("薬用酒","健康の保持増進に効果があるとされる酒",300);
     Item sacredSake = new Consumable("神酒","神に供える酒　\"みき\"とも読む",700);
    Item philopon = new Consumable("医療医薬品","強い中枢興奮作用および精神依存性、薬剤耐性がある有機化合物",1500);
    //所持装備・道具リスト
    ArrayList<Equipment> weaponList = new ArrayList<Equipment>();
    Collections.addAll(weaponList,handgun);
    ArrayList<Equipment> armorList = new ArrayList<Equipment>();
    Collections.addAll(armorList,chestRig);
    ArrayList<Equipment> accessoryList = new ArrayList<Equipment>();
    Collections.addAll(accessoryList,scrapPart);
    ArrayList<Item> consumableList = new ArrayList<Item>();
    Collections.addAll(consumableList,energyBoostingDrink,medicinalLiquor);

    ArrayList<ArrayList<Equipment>> equipmentList = new ArrayList<ArrayList<Equipment>>();
    Collections.addAll(equipmentList,weaponList,armorList,accessoryList);
    ArrayList<ArrayList<Item>> itemList = new ArrayList<ArrayList<Item>>();
    Collections.addAll(itemList,consumableList);
    //お店の品物リスト
    ArrayList<Equipment> storeWeaponList = new ArrayList<Equipment>();
    Collections.addAll(storeWeaponList,handgun,shotgun,submachineGun,assaultRifle,rocketLauncher);
    ArrayList<Equipment> storeArmorList = new ArrayList<Equipment>();
    Collections.addAll(storeArmorList,chestRig,tacticalVest,bulletproofVest,bodyArmor,TALOS);
    ArrayList<Equipment> storeAccessoryList = new ArrayList<Equipment>();
    Collections.addAll(storeAccessoryList,scrapPart,extensionBoard,combatBoard,illegalMemoryBoard,artificialParasite);
    ArrayList<Item> storeConsumableList = new ArrayList<Item>();
    Collections.addAll(storeConsumableList,energyBoostingDrink,medicalKit,medicinalLiquor,sacredSake,philopon);

    ArrayList<ArrayList<Equipment>> storeEquipmentList = new ArrayList<ArrayList<Equipment>>();
    Collections.addAll(storeEquipmentList,storeWeaponList,storeArmorList,storeAccessoryList);
    ArrayList<ArrayList<Item>> storeItemList = new ArrayList<ArrayList<Item>>();
    Collections.addAll(storeItemList,storeConsumableList);
    //ゲーム開始
    Character c1 = new Human(null,null,null);
    ((Human)c1).createHuman();
    Character.setMoney(10000);
    System.out.println("闇の世界へようこそ、旅が始まります");
    System.out.println();
    while(true) {
      System.out.println("どこへ行きますか？");
      switch(inputInt("1.街 2.ステータスを確認 3.装備確認 4.アイテム一覧 0.ダンジョン")) {
        case 1:
          Town.town(equipmentList,itemList,storeEquipmentList,storeItemList);
          break;
        case 2:
          c1.showStatus();
          break;
        case 3:
          c1.showEquipment(equipmentList);
          break;
        case 4:
          c1.showItem(itemList);
          break;
        case 0:
          System.out.println("門番「この中は非常に危険です 許可証がなければお通しできません」");
          break;
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
