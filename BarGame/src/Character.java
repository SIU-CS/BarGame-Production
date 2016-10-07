
public class Character {
	protected int level;
	protected int exp;
	protected int str;
	protected int def;
	protected int hp;
	protected static String gender;
	protected static String playerDescription;
	protected static String name;
	protected int expForLevelUp;
	
	//CONSTRUCTOR
	
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getExp() {
		return exp;
	}
	public void setExp(int exp) {
		this.exp = exp;
	}
	public int getStr() {
		return str;
	}
	public void setStr(int str) {
		this.str = str;
	}
	public int getDef() {
		return def;
	}
	public void setDef(int def) {
		this.def = def;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPlayerDescription() {
		return playerDescription;
	}
	public void setPlayerDescription(String playerDescription) {
		this.playerDescription = playerDescription;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		name = name;
	}
	public int getExpForLevelUp() {
		return expForLevelUp;
	}
	public void setExpForLevelUp(int expForLevelUp) {
		this.expForLevelUp = expForLevelUp;
	}
	
	public void levelUp() {
		level++;
		if (exp > expForLevelUp) {
			exp -= expForLevelUp;
		}
		
		else {
			exp = 0;
		}
			expForLevelUp *= level;
		
	}	
	
}
