package edu.siu.bargame;
public class Inventory extends Character{
	static String[] battleItems = new String[20];
	String[] keyItems = new String[6];
	String[] equipment = new String[5];
	
	public void initArray() {
		for (int i = 0; i < battleItems.length; i++) {
			battleItems[i] = "";
		}
		for (int i = 0; i < keyItems.length-1; i++) {
			keyItems[i] = "";
		}
		for (int i = 0; i < equipment.length-1; i++) {
			equipment[i] = "";
		}
	}
	
	public void setStartItems() {
		addBattleItem("potion");
		addBattleItem("potion");
		addBattleItem("potion");
		addBattleItem("potion");
		addKeyItem("damaged necklace");
		addEquipment("leather cap");
		addEquipment("leather jacket");
		addEquipment("leather leggings");
		addEquipment("leather shoes");
		addEquipment("wooden sword");
	}
	
	protected String[] getBattleItems() {
		return battleItems;
	}

	protected void setBattleItems(String[] battleItems) {
		this.battleItems = battleItems;
	}

	protected String[] getKeyItems() {
		return keyItems;
	}

	protected void setKeyItems(String[] keyItems) {
		this.keyItems = keyItems;
	}

	protected String[] getEquipment() {
		return equipment;
	}

	protected void setEquipment(String[] equipment) {
		this.equipment = equipment;
	}

	public String addBattleItem(String item) {
		boolean added = false;
		for (int i = 0; i<=battleItems.length - 1; i++) {
			if (battleItems[i] == "") {
				battleItems[i] = item;
				added = true;
				break;
			}
		}
		
		if (added == true) {
			return item + " has been added to your inventory.";
		}
		
		else {
			return "Inventory full";
		}
	}
	
	public static String removeBattleItem(String item) {
		boolean remove = false;
		for (int i = 0; i <= battleItems.length - 1; i++) {
			if (battleItems[i] == item) {
				battleItems[i] = "";
				remove = true;
				break;
			}
		}
		
		if (remove == true) {
			return item + " has been removed.";
		}
		
		else {
			return "Unable to remove.";
		}
	}
	
	public String addKeyItem(String item) {
		for (int i = 0; i <= keyItems.length - 1; i++) {
			if (keyItems[i] == "") {
				keyItems[i] = item;
				break;
			}
		}
		return item + " added to Key Items";
	}
	
	public String addEquipment(String item) {
		boolean added = false;
		for (int i = 0; i <= equipment.length - 1; i++) {
			if (equipment[i] == "") {
				equipment[i] = item;
				added = true;
				break;
			}
		}
		
		if (added == true) {
			return item + " added to equipment.";
		}
		
		else {
			return "Inventory full.";
		}
	}
	
	public String removeEquipment(String item) {
		boolean remove = false;
		for (int i = 0; i <= equipment.length - 1; i++) {
			if (equipment[i] == item) {
				equipment[i] = "";
				remove = true;
				break;
			}
		}
		if (remove = true) {
			return item + " successfully removed.";
		}
		
		else {
			return "Unable to remove.";
		}
	}
	
	public static void printBattleItems() {
		for (int i = 0; i <= battleItems.length-1; i++) {
			System.out.println(battleItems[i] + "\n");
		}
	}
	
	public void printKeyItems() {
		for (int i = 0; i < keyItems.length - 1; i++) {
			System.out.println(keyItems[i] + "\n");
		}
	}
	
	public void printEquipment() {
		for (int i = 0; i <= equipment.length - 1; i++) {
			System.out.println(equipment[i] + "\n");
		}
	}
	
	public static void useItem(String item) {
		switch(item) {
			case "potion":
				if (player.getCurHp() != player.getMaxHp()) {
					if (player.getMaxHp()-player.getCurHp() <= 20) {
						player.setCurHp(player.getMaxHp());
						removeBattleItem(item.toLowerCase());
						System.out.println("Hp Maxed Out!");
					}
					else {
						player.setCurHp(player.getCurHp()+20);
						removeBattleItem(item.toLowerCase());
						System.out.println("Current Hp increased by 20!");
					}
					
				}
				break;
			//auto use case "Pheonix Down":
			case "great potion":
				if (player.getCurHp() != player.getMaxHp()) {
					if (player.getMaxHp()-player.getCurHp() <= 60) {
						player.setCurHp(player.getMaxHp());
						System.out.println("Hp Maxed Out!");
					}
					else {
						player.setCurHp(player.getCurHp()+60);
					System.out.println("Current Hp increased by 60!");
					}
					removeBattleItem(item);
				}
				break;
		}
	}
	
	public void equipBonus() {
		//String head, torso, leggings, boots, weapon;//leather, iron, steel, blessed\\wooden, iron, steel, blessed
		switch (equipment[0]) {
			case "leather cap":
				player.setDef(player.getDef()+2);
				break;
			case "iron helmet":
				player.setDef(player.getDef()+4);
				break;
			case "steel helm":
				player.setDef(player.getDef()+6);
				break;
			case "blessed helm":
				player.setDef(player.getDef()+10);
				player.setMaxHp(player.getMaxHp()+50);
				break;
			default:
		}
		switch (equipment[1]) {
			case "leather jacket":
				player.setDef(player.getDef()+2);
				break;
			case "chain mail":
				player.setDef(player.getDef()+4);
				break;
			case "steel chestplate":
				player.setDef(player.getDef()+6);
				break;
			case "blessed chestplate":
				player.setDef(player.getDef()+10);
				player.setMaxHp(player.getMaxHp()+50);
				break;
			default:
		}
		switch (equipment[2]) {
			case "leather leggings":
				player.setDef(player.getDef()+2);
				break;
			case "iron shinguards":
				player.setDef(player.getDef()+4);
				break;
			case "steel leggings":
				player.setDef(player.getDef()+2);
				break;
			case "blessed leggings":
				player.setDef(player.getDef()+10);
				player.setMaxHp(player.getMaxHp()+50);
				break;
			default:
	}
		switch (equipment[2]) {
		case "leather shoes":
			player.setDef(player.getDef()+2);
			break;
		case "iron boots":
			player.setDef(player.getDef()+4);
			break;
		case "steel boots":
			player.setDef(player.getDef()+2);
			break;
		case "blessed shoes":
			player.setDef(player.getDef()+10);
			player.setMaxHp(player.getMaxHp()+50);
			break;
		default:
}
		switch (equipment[4]) {
		case "wooden sword":
			player.setStr(player.getStr()+2);
			break;
		case "iron sword":
			player.setStr(player.getStr()+4);
			break;
		case "steel sword":
			player.setStr(player.getStr()+6);
			break;
		case "blessed sword":
			player.setStr(player.getStr()+10);
			player.setDef(player.getDef()+50);
			break;
		default:
		}
	}
}