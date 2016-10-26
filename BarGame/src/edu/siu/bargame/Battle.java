package Battle;
import java.awt.BorderLayout;
import java.util.Random;

import javax.swing.JFrame;

import Characters.Character;
public class Battle {
	//protected void gameOpen() {
	//	JFrame frame = new JFrame("game window");
	//	frame.getDefaultCloseOperation()add(emptyLabel, BorderLayout.CENTER).pack().setVisible(true);
	//}
	
	//create battle menu
	protected String battle() {
		boolean escape = false;
		if (menuoption.attack) {
			Character.attack();
			if (Enemy.hp <= 0) {
				Character.exp += Enemy.expGiven;
				//gold determined by battle location, specific
				//items determined by battle location, specific
				Character.levelUp();
				return "Player Victory!";
			}
			
			else if (Character.hp <= 0) {
				//gamestate reset method
				return "Player Loss...";
			}
			
			else {
				battle();
			}
		}
		
		else if (menuoption.run) {
			Random random = new Random();
				if (random.nextInt(100) <= 50) {
					return "Unable to Escape!";
				}
				
				else {
					//battle exit method
					return "Successfully escaped!";
				}
		}
		
		else if (menuoption.items) {
			//method to pull up item list
			//method to use item
			//item effects
			//return text describing what happened
		}
	}
	
	protected int attack() {
		if (Character.str > Enemy.def) {
			Enemy.hp = Character.str - Enemy.def;
		}
		
		if (Enemy.str > Character.def) {
			Character.hp = Enemy.str - Character.def;
		}
	}
}
