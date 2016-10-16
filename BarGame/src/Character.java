
public class Character {

	private String name;
	private int currentHP;
	private int MaxHP;
	private int strength;
	private int defense;
	private char gender;// M or F
	
	
	private Character(String name, int curHP, int maxHP, int str, int def, char gender){
		this.name = name;
		this.MaxHP = maxHP;
		currentHP = MaxHP;
		this.strength = str * -1;//by making attack negative we can add it to the opponents health for reductions
		this.defense = def;
		this.gender = gender;
	}
	
	
	private String getName(){
		return name;
	}
	
	private int getCurrentHP(){
		return currentHP;
	}
	
	public void setCurrent_health(int health_Difference) {// we can use the same method to both reduce health (attacked) and increase health (potion)
		if (currentHP + health_Difference <= MaxHP
				&& currentHP + health_Difference > 0)
			currentHP += health_Difference;

		else if (currentHP + health_Difference > MaxHP) {
			currentHP = MaxHP;
		} else
			currentHP = 0;

	}
	
	private int getMaxHP(){
		return currentHP;
	}
	
	private int getStrength(){
		return strength;
	}
	
	private int getDefense(){
		return defense;
	}
	
	private char getGender(){
		return gender;
	}
	
	public void attack(Character opponent) {

		opponent.setCurrent_health(strength);// takes in an opponent to attack and sets their health minus attackers strength since strenght is negative

	}
}
