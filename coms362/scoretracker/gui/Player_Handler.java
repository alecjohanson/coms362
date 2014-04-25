package coms362.scoretracker.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;

import coms362.scoretracker.controller.ITeamController;

public class Player_Handler {

	private ITeamController teamController;
	private ApplicationContext context;
	
	public Player_Handler(ApplicationContext c) {
		context = c;
	}

	void Player_Handler_Method() throws IOException {
		boolean exit = false;
		String read_in = null;
		int choice = 0;
		teamController = (ITeamController) context.getBean("teamController");
		while(!exit){
			System.out.println("1. Add Player\n2. Add Note to Player\n3. Get Player Statistics\n"
					+ "4. Return to Categories ");
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
				case 1: GuicreatePlayer();
					break;
				case 2: GuiAddNotetoPlayer();
					break;
				case 3: GuiGetPlayerStats();
					break;
				case 4: exit = true; 
					break;
				default: System.out.println("You have entered an invalid choice, please try again");
					break;
			}
		}
	}
	
	private void GuiGetPlayerStats() throws IOException {
		// TODO Auto-generated method stub
		String stats = null;
		String playerName = null; 
		
		System.out.println("Please enter the player's name: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		playerName = br.readLine();
		
		stats = teamController.getPlayerStats(playerName);
		
		System.out.println(stats);
		
	}

	private void GuiAddNotetoPlayer() throws IOException {
		String note = null;
		int PlayerID = 0;
		String teamname;

		System.out.println("Please enter the player ID: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PlayerID = Integer.parseInt(br.readLine());

		System.out.println("Please enter the team name: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		teamname = br.readLine();

		System.out.println("Please enter the note: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		note = br.readLine();

		teamController.addNotetoPlayer(PlayerID, teamname, note);

		System.out.println("Your note was successfully added to " + PlayerID + " on team: " + teamname);

	}

	

	private void GuicreatePlayer() throws IOException {
		boolean createdPlayer = false;
		String playerFirstName = null;
		String playerLastName = null;
		int playerNumber = 0;
		String playerTeamName = null;
		String playerPosition = null;
		String playerWeightString = null;
		double playerWeight = 0;

		System.out.println("Please enter the first name of the player you would like to create: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		playerFirstName = br.readLine();

		System.out.println("Please enter the last name of the player you would like to create: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		playerLastName = br.readLine();

		System.out.println("Please enter the number of the player you would like to create: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			playerNumber = Integer.parseInt(br.readLine());
		} catch (NumberFormatException nex) {
			// TODO Auto-generated catch block
			System.out.println("Please enter an integer value for the player number:");
			br = new BufferedReader(new InputStreamReader(System.in));
			playerNumber = Integer.parseInt(br.readLine());
			//nex.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Please enter the name of the team you would like to add the player to: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		playerTeamName = br.readLine();
		while (playerTeamName.isEmpty()) {
			System.out.println("You did not enter the team name, please enter the name: ");
			br = new BufferedReader(new InputStreamReader(System.in));
			playerTeamName = br.readLine();
		}

		System.out.println("Please enter the position of the player you are creating: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		playerPosition = br.readLine();

		System.out.println("Please enter the weight of the player you are creating: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		playerWeightString = br.readLine();

		if (!playerWeightString.isEmpty()) {
			playerWeight = Double.parseDouble(playerWeightString);
		}else{
			playerWeight = 100.00; 
		}
		
		createdPlayer = teamController.createPlayer(playerFirstName, playerLastName, playerNumber, playerTeamName, playerPosition, playerWeight);
		
		if (createdPlayer) {
			System.out.println("Your player: " + playerFirstName + " "+ playerLastName
					+ ", number " + playerNumber + ", position "  + playerPosition + " has been created");
			if (playerWeight != 0) {
				System.out.println("Their weight is: " + playerWeight);
			}
		} else {
			System.out.println("Your game was not created correctly.  Please try again");
		}
	}

}
