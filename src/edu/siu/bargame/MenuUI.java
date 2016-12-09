package edu.siu.bargame;

import java.util.Scanner;

public class MenuUI {
	
	private int choice;
	Scanner Scan = new Scanner(System.in);
	
	
	//Inventory inventory = new Inventory();
	

	public void Interface(){
		
	
		System.out.print("______________________________________________\n"
					+    "-   1: Explore         2: Inventory          -\n"
					+	 "-                                            -\n"
					+	 "-                                            -\n"
					+	 "-   3: Stats           4: Battle             -\n"
					+    "-                                            -\n"
					+	 "-                                            -\n"
					+	 "-   5: Save            6: Quit Game          -\n"
					+    "______________________________________________\n");
					
		//System.out.println(" Where would you like to go? ");
	}
	
	
	public int getChoice(){
		
		choice = Scan.nextInt();
		return choice;
	}
	
	
	
	
	
}