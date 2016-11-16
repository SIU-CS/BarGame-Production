package edu.siu.bargame;
public class Inventory extends Character{
	static String[] battleItems = new String[20];
	String[] keyItems = new String[6];
	String[] equipmentItems = new String[5];
	
	public void setStartItems() {
		addBattleItem("Potion");
		addBattleItem("Potion");
		addBattleItem("Potion");
		addBattleItem("Potion");
		addKeyItem("Damaged Necklace");
		addEquipment("leather");
		addEquipment("leather");
		addEquipment("leather");
		addEquipment("leather");
		addEquipment("wooden");
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
		return equipmentItems;
	}

	protected void setEquipment(String[] equipment) {
		this.equipmentItems = equipment;
	}

	public String addBattleItem(String item) {
		boolean added = false;
		for (int i = 0; i<=battleItems.length - 1; i++) {
			if (battleItems[i] == null) {
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
	
	public String removeBattleItem(String item) {
		boolean remove = false;
		for (int i = 0; i <= battleItems.length - 1; i++) {
			if (battleItems[i].equals(item)) {
				battleItems[i] = null;
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
			if (keyItems[i] == null) {
				keyItems[i] = item;
				break;
			}
		}
		return item + " added to Key Items";
	}
	
	public String addEquipment(String item) {
		boolean added = false;
		for (int i = 0; i <= equipmentItems.length - 1; i++) {
			if (equipmentItems[i] == null) {
				equipmentItems[i] = item;
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
		for (int i = 0; i <= equipmentItems.length - 1; i++) {
			if (equipmentItems[i].equals(item)) {
				equipmentItems[i] = null;
				remove = true;
				break;
			}
		}
		if (remove ) {
			return item + " successfully removed.";
		}
		
		else {
			return "Unable to remove.";
		}
	}
	
	public static void printBattleItems() {
		for (int i = 0; i <= battleItems.length - 1; i++) {
			if(battleItems[i] != null)
			System.out.println(battleItems[i] + "\n");
		}
	}
	
	public void printKeyItems() {
		for (int i = 0; i < keyItems.length - 1; i++) {
			if(keyItems[i] != null)
			System.out.println(keyItems[i] + "\n");
		}
	}
	
	public void printEquipment() {
		for (int i = 0; i <= equipmentItems.length - 1; i++) {
			if(equipmentItems[i] != null)
			System.out.println(equipmentItems[i] + "\n");
		}
	}
	
	public static void useItem(String item) {
		switch(item.toLowerCase()) {
			case "potion":
				player.setCurHp(player.getCurHp()+10);
				if(player.getCurHp() >= player.getMaxHp()){
					player.setCurHp(player.getMaxHp());
				}
				System.out.println("You drink the potion, you're health is now " + player.getCurHp());
				break;
			//auto use case "Pheonix Down":
			case "Great Potion":
				player.setCurHp(player.getCurHp()+60);
				System.out.println(player.getCurHp());
				break;
			case "Max Potion":
				player.setCurHp(player.getMaxHp());
				System.out.println(player.getCurHp());
				break;
			case "exit":
				break;
			default:
				System.out.println("Item not found!");
		}
	}
	
	public void equipBonus() {
		//String head, torso, leggings, boots, weapon;//leather, iron, steel, blessed\\wooden, iron, steel, blessed
		switch (equipmentItems[0]) {
			case "leather":
				player.setDef(player.getDef()+2);
				break;
			case "iron":
				player.setDef(player.getDef()+4);
				break;
			case "steel":
				player.setDef(player.getDef()+6);
				break;
			case "blessed":
				player.setDef(player.getDef()+10);
				player.setMaxHp(player.getMaxHp()+50);
				break;
			default:
		}
		switch (equipmentItems[1]) {
			case "leather":
				player.setDef(player.getDef()+2);
				break;
			case "iron":
				player.setDef(player.getDef()+4);
				break;
			case "steel":
				player.setDef(player.getDef()+6);
				break;
			case "blessed":
				player.setDef(player.getDef()+10);
				player.setMaxHp(player.getMaxHp()+50);
				break;
			default:
		}
		switch (equipmentItems[2]) {
			case "leather":
				player.setDef(player.getDef()+2);
				break;
			case "iron":
				player.setDef(player.getDef()+4);
				break;
			case "steel":
				player.setDef(player.getDef()+2);
				break;
			case "blessed":
				player.setDef(player.getDef()+10);
				player.setMaxHp(player.getMaxHp()+50);
				break;
			default:
	}
		switch (equipmentItems[3]) {
		case "wooden":
			player.setStr(player.getStr()+2);
			break;
		case "iron":
			player.setStr(player.getStr()+4);
			break;
		case "steel":
			player.setStr(player.getStr()+6);
			break;
		case "blessed":
			player.setStr(player.getStr()+10);
			player.setDef(player.getDef()+50);
			break;
		default:
		}
	}
}