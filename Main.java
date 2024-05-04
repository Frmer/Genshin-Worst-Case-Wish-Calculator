package main;

import java.util.Scanner;
import java.util.Vector;

public class Main {

	Scanner scan = new Scanner(System.in);
	Vector<Integer> wish_goal_vector = new Vector<>();
	Vector<Integer> wish_test2 = new Vector<>();
	
	public Main() {
		
		int input = 0;
		int rate_input = 0;
		int character_input = 0;
		int intertwined_input = 0;
		int wishes_for_character = 4;
		int guaranteed_wish = 90;
		int wish_goal = 0;
		boolean fiftyfifty = true;
		
		try {
			System.out.print("Input primo gems amount : ");
			input = scan.nextInt(); scan.nextLine();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Please input a number");
			System.exit(0);
		}
		
		try {
			System.out.println("Input intertwined fate amount (if none then type 0) : ");
			intertwined_input = scan.nextInt(); scan.nextLine();
		} catch (Exception e) {
			System.out.println("Listen, you have to put a number. Now do it again from the beginning!");
			System.exit(0);
		}
		
		try {
			System.out.println("Is 50/50 on or off");
			System.out.println("Input '1' if on");
			System.out.println("Input '0' if off");
			rate_input = scan.nextInt(); scan.nextLine();
		} catch (Exception e) {
			System.out.println("I know Genshin players can't read... but damn.");
			System.exit(0);
		}
		
		if (rate_input == 1) {
			fiftyfifty = true;
		} else if (rate_input == 0) {
			fiftyfifty = false;
		} 
		
		try {
			System.out.println("How much pulls for the character : ");
			character_input = scan.nextInt(); scan.nextLine();
			wishes_for_character = character_input;
		} catch (Exception e) {
			System.out.println("Moron");
			System.exit(0);
		}
		
		do {
			if (fiftyfifty == true) {
				wish_goal = (guaranteed_wish * 2);
				fiftyfifty = false;
				wishes_for_character--;
			} else if (fiftyfifty == false) {
				wish_goal = guaranteed_wish;
				fiftyfifty = true;
				wishes_for_character--;
			}
			
			wish_goal_vector.add(wish_goal);
			
		} while (wishes_for_character != 0);
		
		wishes_for_character = character_input;
		
		int final_wish_goal = 0;
		
		int primo_amount_1 = (input/160) + intertwined_input;
		
		for (int i = 0; i < wishes_for_character; i++) {
			final_wish_goal += wish_goal_vector.get(i); //masalahnya di rumus ini
			System.out.println(wish_goal_vector.get(i));
			//hasil = 360
			//hasil2 = 720
			
		}
		
		System.out.println("You will have : "+primo_amount_1+" wishes");
		System.out.println("You will need : "+(final_wish_goal - primo_amount_1) +" more wishes to get Character (Maximum)");
		System.out.println("Which means you will need : "+((final_wish_goal - primo_amount_1)*160)+" primogems (Maximum)");
		
	}

	public static void main(String[] args) {
		new Main();

	}

}
