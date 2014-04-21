package coms362.scoretracker.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GUI{

	public static void main(String[] args) throws IOException {

		boolean run = true;
		String choice = null;
		int category_choice = 0;
		while (run) {
			System.out.println("1. Player\n2. Team\n3. League\n4. Game\n5. Exit");
			System.out.println("Please choose a category: ");

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				choice = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}

			category_choice = Integer.parseInt(choice);

			switch (category_choice) {
			case 1:
				Player_Handler.Player_Handler_Method();
				break;
			case 2:
				Team_Handler.Team_Handler_Method();
				break;
			case 3:
				League_Handler.League_Handler_Method();
				break;
			case 4:
				Game_Handler.Game_Handler_Method();
				break;
			case 5:
				run = false;
				break;
			default:
				System.out.println("You did not enter a valid choice");
				break;
			}

		}
	}

}
