package edu.siu.bargame;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main {

	public static void main(String[] args) {

		/*JFrame frame = new JFrame("Test-ReadngX");
		JPanel panel = new JPanel();
		panel.setLayout(new FlowLayout());
		
		JLabel label = new JLabel("LABEL!");
		
		JButton button = new JButton();
		button.setText("BUTTON!");
		
		panel.add(label);
		panel.add(button);
		
		frame.add(panel);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);*/
		Character player = new Character(5, 5, 15);
		player.createCharacter();
	//	Forest forest = new Forest();
		
		Inventory inv = new Inventory();
		inv.initArray();
		inv.setStartItems();
		
		//Character player = new Character(20,20,40);
		//Enemy en1= new Enemy(20,15,15,25);//victory, 20, 15, 15, 25; victory with item, 27, 23, 14, 25; run and lose, 40, 30, 20, 80
		
		player.setHero(player);
		
		System.out.print(player);
		System.out.println(player.PrintStats());
		
		Battle.battle();
		
	}

}