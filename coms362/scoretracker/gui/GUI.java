package coms362.scoretracker.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import coms362.scoretracker.appconfig.ApplicationConfig;

public class GUI {

	public static void main(String[] args) throws IOException {

		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Team_Handler team_handler = new Team_Handler(context);
		Game_Handler game_handler = new Game_Handler(context);
		League_Handler league_handler = new League_Handler(context);
		Player_Handler player_handler = new Player_Handler(context);
		
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
				player_handler.Player_Handler_Method();
				break;
			case 2:
				team_handler.Team_Handler_Method();
				break;
			case 3:
				league_handler.League_Handler_Method();
				break;
			case 4:
				game_handler.Game_Handler_Method();
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
