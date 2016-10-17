
public class Character {

	private String Name;
	private int level;
	protected int exp;
	private String gender;
	private int defense;
	private int health;
	private int strength;
	
	public Character( int level, int exp, String gender,String Name,int defense, int health, int strength )
	{
	
		this.gender=gender;
		this.level=level;
		this.exp=exp;
		this.Name=Name;
		this.strength=strength;
		this.health=health;
		this.defense=defense;
	}

	
	


	protected int getDefense() {
		return defense;
	}


	protected void setDefense(int defense) {
		this.defense = defense;
	}


	protected int getHealth() {
		return health;
	}


	protected void setHealth(int health) {
		this.health = health;
	}


	protected int getStrength() {
		return strength;
	}


	protected void setStrength(int strength) {
		this.strength = strength;
	}


	protected String getName() {
		return Name;
	}


	protected void setName(String name) {
		Name = name;
	}


	protected String getGender() {
		return gender;
	}


	protected void setGender(String gender) {
		this.gender = gender;
	}


	protected int getLevel() {
		return level;
	}


	protected void setLevel(int level) {
		this.level = level;
	}
	protected int getExp() {
		return exp;
	}
	protected void setExp(int exp) {
		this.exp = exp;
	}
	
	public String toString() {
		return("Name: "+Name+"\nGender: "+gender+"\nExperience: "+exp+"\nLevel: "+level);
	}
	
}
