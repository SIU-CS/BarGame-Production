package edu.siu.bargame;
public class Inventory extends Character{
	String[] battleItems = new String[20];
	String[] keyItems = new String[6];
	String[] equipment = new String[5];
	
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
		return equipment;
	}

	protected void setEquipment(String[] equipment) {
		this.equipment = equipment;
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
			if (battleItems[i] == item) {
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
		for (int i = 0; i <= equipment.length - 1; i++) {
			if (equipment[i] == null) {
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
				equipment[i] = null;
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
	
	public void printBattleItems() {
		for (int i = 0; i <= battleItems.length; i++) {
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
	
	public void useItem(String item) {
		switch(item) {
			case "Potion":
				hero.setCurHp(hero.getCurHp()+20);
				System.out.println(hero.getCurHp());
				break;
			//auto use case "Pheonix Down":
			case "Great Potion":
				hero.setCurHp(hero.getCurHp()+60);
				System.out.println(hero.getCurHp());
				break;
			case "Max Potion":
				hero.setCurHp(hero.getMaxHp());
				System.out.println(hero.getCurHp());
				break;
			default:
				System.out.println("Item not found!");
		}
	}
	
	public void equipBonus() {
		//String head, torso, leggings, boots, weapon;//leather, iron, steel, blessed\\wooden, iron, steel, blessed
		switch (equipment[0]) {
			case "leather":
				hero.setDef(hero.getDef()+2);
				break;
			case "iron":
				hero.setDef(hero.getDef()+4);
				break;
			case "steel":
				hero.setDef(hero.getDef()+6);
				break;
			case "blessed":
				hero.setDef(hero.getDef()+10);
				hero.setMaxHp(hero.getMaxHp()+50);
				break;
			default:
		}
		switch (equipment[1]) {
			case "leather":
				hero.setDef(hero.getDef()+2);
				break;
			case "iron":
				hero.setDef(hero.getDef()+4);
				break;
			case "steel":
				hero.setDef(hero.getDef()+6);
				break;
			case "blessed":
				hero.setDef(hero.getDef()+10);
				hero.setMaxHp(hero.getMaxHp()+50);
				break;
			default:
		}
		switch (equipment[2]) {
			case "leather":
				hero.setDef(hero.getDef()+2);
				break;
			case "iron":
				hero.setDef(hero.getDef()+4);
				break;
			case "steel":
				hero.setDef(hero.getDef()+2);
				break;
			case "blessed":
				hero.setDef(hero.getDef()+10);
				hero.setMaxHp(hero.getMaxHp()+50);
				break;
			default:
	}
		switch (equipment[3]) {
		case "wooden":
			hero.setStr(hero.getStr()+2);
			break;
		case "iron":
			hero.setStr(hero.getStr()+4);
			break;
		case "steel":
			hero.setStr(hero.getStr()+6);
			break;
		case "blessed":
			hero.setStr(hero.getStr()+10);
			hero.setDef(hero.getDef()+50);
			break;
		default:
		}
	}
}