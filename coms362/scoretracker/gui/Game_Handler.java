package coms362.scoretracker.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;

import coms362.scoretracker.controller.IGameController;

public class Game_Handler {

	@Autowired
	private static IGameController gameController;
	
	private static int gameIDforStartandPause; 
	
	static void Game_Handler_Method() throws IOException {
		boolean exit = false;
		String read_in = null;
		int choice = 0;
		
		//ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//gameController = (IGameController) context.getBean("gameController");
		
		while(!exit){
			System.out.println("1. Add Game\n2. Add Note to Game\n3. Log Event\n4. Add a Scheduled Game\n5. Edit Scheduled Game\n"
					+ "6. Start Game\n7. Pause Game\n8. Create Custom Sport\n9. Get Game Statistics\n"
					+ "10. Finalize Game\n11. Return to Categories ");
			System.out.println("Enter choice: ");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			try {
				read_in = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
	
			choice = Integer.parseInt(read_in);
			
			switch(choice){
				case 1: GuicreateGame();
					break;
				case 2: GuiAddNotetoGame();
					break;
				case 3: GuiLogEvent();
					break;
				case 4: GuiAddScheduledGame();
					break; 
				case 5: GuiEditScheduledGame();
					break;
				case 6: GuiStartGame();
					break;
				case 7: GuiPauseGame();
					break;
				case 8: GuiCreateCustomSport();
					break;
				case 9: GuiGetGameStats();
					break;
				case 10: GuiFinalizeGame();
					break;
				case 11: exit = true; 
					break;
				default: System.out.println("You have entered an invalid choice, please try again");
					break;
			}
		}
			
	}
	
	private static void GuiFinalizeGame() {
		// TODO Auto-generated method stub
		GuiPauseGame();
	}

	private static void GuiGetGameStats() throws NumberFormatException, IOException {
		String stats = null; 
		int gameID = 0; 
		
		System.out.println("Please Enter the game ID number you would like to get statistics for: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gameID = Integer.parseInt(br.readLine());
		
		stats = gameController.getGameStats(gameID);
		
		System.out.println("The statistics for game ID: " + gameID + " are: " + stats);
	}

	private static void GuiCreateCustomSport() throws IOException {
		String file = null; 
		int ret = 0; 
		
		System.out.println("Please Enter the rules for your custom sport (all at once): ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		file = br.readLine();
		
		ret = gameController.createCustomSport(file);
		
		if(ret == 0){
			System.out.println("Your custom sport was created successfully!");
		}else if(ret == 1 || ret == 2){
			System.out.println("Something went wrong when creating your sport.");
		}
	}

	private static void GuiPauseGame() {
		boolean gamePaused;
		
		gamePaused = gameController.pauseGame(gameIDforStartandPause);
		
		if(gamePaused){
			System.out.println("Game is Paused");
		}else{
			System.out.println("Game did not Pause");
		}
	}

	private static void GuiStartGame() throws NumberFormatException, IOException {
		boolean gameStart;
		
		System.out.println("Please enter the ID number of the game you would like to start: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gameIDforStartandPause = Integer.parseInt(br.readLine());
		
		gameStart = gameController.startGame(gameIDforStartandPause);
		
		if(gameStart){
			System.out.println("Game has started");
		}else{
			System.out.println("Game has failed to start");
		}
	}

	private static void GuiEditScheduledGame() {
		int gameID = 0; 
		String timeEdited = null; 
		String newTime = null;
		
		timeEdited = gameController.editScheduledGame(gameID,  newTime);
		
		System.out.println(timeEdited);
		
	}

	private static void GuiAddScheduledGame() throws IOException {
		String retVal = null;
		String team1 = null;
		String team2 = null;
		String sport = null;
		String date = null; 
		
		System.out.println("Please enter the first team in the game: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		team1 = br.readLine();
		
		System.out.println("Please enter the second team in the game: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		team2 = br.readLine();
		
		System.out.println("Please enter the sport to be played: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		sport = br.readLine();
		
		System.out.println("Please enter the date and time of the game (ex. 4/24/2014 6:00 pm): ");
		br = new BufferedReader(new InputStreamReader(System.in));
		date = br.readLine();
		
		retVal = gameController.addScheduledGame(team1, team2, sport, date);
		
		System.out.println(retVal);
		
	}

	private static void GuiLogEvent() throws NumberFormatException, IOException {
		int eventId = 0;
		int playerId = 0; 
		int gameId = 0; 
		String log = null; 
		
		System.out.println("Please enter the event ID: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		eventId = Integer.parseInt(br.readLine());
		
		System.out.println("Please enter the player ID: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		playerId = Integer.parseInt(br.readLine());
		
		System.out.println("Please enter the game ID: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		gameId = Integer.parseInt(br.readLine());
		
		log = gameController.logEvent(eventId, playerId, gameId);
		
		System.out.println(log);
		
	}

	private static void GuiAddNotetoGame() throws IOException {
		String note = null;
		//int teamID = 0;
		int gameID = 0;

		/*System.out.println("Please enter the team ID: ");
		teamID = Integer.parseInt(br.readLine());*/
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Please enter the game ID: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		gameID = Integer.parseInt(br.readLine());

		System.out.println("Please enter the note: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		note = br.readLine();

		gameController.addGameNote(/*teamID,*/ gameID, note);
	}
	private static void GuicreateGame() throws IOException {
		String createdGame = null;
		String team1 = null;
		String team2 = null;
		String sport = null;

		System.out.println("Please enter the first team you would like have in the game: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		team1 = br.readLine();

		System.out.println("Please enter the first team you would like have in the game: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		team2 = br.readLine();

		System.out.println("Please enter the sport of the game that will be played: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		sport = br.readLine();

		createdGame = gameController.createGame(team1, team2, sport);

		if (createdGame.isEmpty()) {
			System.out.println("Game has been created with Team 1: " + team1 + " and Team 2: " + team2 + "\n");
		} else {
			System.out.println("Your game was not created correctly, the error is: " + createdGame + ". Please try again");
		}

	}
}
