
public class Character {


	/*private String name;
	private int currentHP;
	private int MaxHP;
	private int strength;
	private int defense;
	private char gender;// M or F
	
	
	public Character(String name, int curHP, int maxHP, int str, int def, char gender){
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
*/
	protected int level;
	protected int exp;
	protected int str;
	protected int def;
	protected int hp;
	protected int MaxHP;
	protected static char gender; // M or F
	protected static String playerDescription;
	protected static String name;
	protected int expForLevelUp;
	
	//CONSTRUCTOR
	public  Character(String name, int hp, int str, int def){
		this.name = name;
		this.hp = hp;
		MaxHP = hp;
		this.str = str;
		this.def = def;
		this.gender = gender;
	}
	
	
	public Character() {
		// TODO Auto-generated constructor stub
	}


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
	
	
	public int getDef() {
		return def;
	}
	
	
	
	public int getHp() {
		return hp;
	}
	
	
	
	public char getGender() {
		return gender;
	}
	
	public void setGender(char gender) {
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