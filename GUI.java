package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GUI{
	static GameManagementSystem GMS = new GameManagementSystem();
	static TeamManagementSystem TMS = new TeamManagementSystem();
	static LeagueManagementSystem LMS = new LeagueManagementSystem();
	
	public static void main(String[] args) throws IOException{
		boolean run = true; 
		String choice = null; 
		int choiceNum = 0;
		while(run){
		
			System.out.println("1. Create Player\n2. Create Team\n3. Create League\n4. Create Game\n5. Add a team to a League\n"
					+ "6. Add a note to a Player\n7. Add a note to a Team\n8. Add a note to a Game\n10. Exit");
			System.out.println("Please Choose what you would like to do: \n");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			try {
				choice = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			choiceNum = Integer.parseInt(choice);
			/*if(choice.contains("1")){
				choiceNum = 1;
			}else if(choice.contains("2")){
				choiceNum = 2; 
			}else if(choice.contains("3")){
				choiceNum = 3; 
			}else if(choice.contains("4")){
				choiceNum = 4; 
			}else if(choice.contains("5")){
				choiceNum = 5; 
			}else if(choice.contains("10")){
				choiceNum = 10; 
			}else{
				System.out.println("You did not enter a valid choice");
				choiceNum = 100; 
			}*/
			
			switch (choiceNum){
				case 1: GuicreatePlayer();
					break;
				case 2: GuicreateTeam(); 
					break;
				case 3: GuicreateLeague();
					break;
				case 4: GuicreateGame(); 
					break; 
				case 5: GUIAddTeamtoLeague();
					break;
				case 6: GuiAddNotetoPlayer();
					break;
				case 7: GuiAddNotetoTeam();
					break;
				case 8: GuiAddNotetoGame();
					break; 
				case 9: 
					break;
				case 10: run = false; 
					break;	
				default: System.out.println("You did not enter a valid choice");
					break;
			}
				
		}
	}
	
	private static void GUIAddTeamtoLeague() throws IOException {
		boolean addTeam = false;
		String teamName = null; 
		String leagueName = null;
		
		System.out.println("Please enter the team name you would like to add to the league: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		teamName = br.readLine();
		
		System.out.println("Please enter the league name you would like to put the team in: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		leagueName = br.readLine();
		
		addTeam = LMS.addTeam(teamName, leagueName); 
		
		if(addTeam){
			System.out.println("The team: " + teamName + " has been added to the league: " + leagueName + "\n");
		}else{
			System.out.println(teamName + " was not added to: " + leagueName + ".  Please try again");
		}
	}

	private static void GuiAddNotetoGame() throws IOException {
		// TODO Auto-generated method stub
		boolean addNote = false;
		String note = null; 
		int gameID = 0;
		
		
		addNote = TMS.addNoteToGame(note, gameID);
	}

	private static void  GuiAddNotetoTeam() throws IOException {
		// TODO Auto-generated method stub
		
	}

	private static void GuiAddNotetoPlayer() throws IOException {
		// TODO Auto-generated method stub
		
	}

	private static void GuicreateGame() throws IOException {
		boolean createdGame = false;
		String team1; 
		String team2; 
		
		System.out.println("Please enter the first team you would like have in the game: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		team1 = br.readLine();
		
		System.out.println("Please enter the first team you would like have in the game: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		team2 = br.readLine();
		
		createdGame = GMS.createGame(team1, team2);
		
		if(createdGame){
			System.out.println("Game has been created with Team 1: " + team1 + " and Team 2: " + team2 + "\n");
		}else{
			System.out.println("Your game was not created correctly.  Please try again");
		}
		
		
	}

	private static void GuicreatePlayer() throws IOException{
		boolean createdPlayer = false;
		String playerFirstName = null; 
		String playerLastName = null;
		String playerNumberString = null; 
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
		playerNumberString = br.readLine();
		playerNumber = Integer.parseInt(playerNumberString);
		
		System.out.println("Please enter the name of the team you would like to add the player to: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		playerTeamName = br.readLine();
		while(playerTeamName.isEmpty()){
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
		
		if(!playerWeightString.isEmpty()){
			playerWeight = Double.parseDouble(playerWeightString);
		}
		
		createdPlayer = TMS.createPlayer(playerFirstName, playerLastName, playerNumber, playerTeamName, playerPosition, playerWeight);
		if(createdPlayer){
			System.out.println("Your player: " + playerFirstName + playerLastName + ", number " + playerNumber + ", position " + 
					playerPosition + "has been created");
			if(playerWeight != 0){
				System.out.println("Their weight is: " + playerWeight);
			}
		}else{
			System.out.println("Your game was not created correctly.  Please try again");
		}
	}
	
	private static void GuicreateTeam() throws IOException{
		boolean createdTeam = false;
		String teamName; 
		
		System.out.println("Please enter the name of the team you would like to create: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		teamName = br.readLine();
		
		createdTeam = TMS.addTeam(teamName);
		
		if(createdTeam){
			System.out.println("Your team has been created with the name: " + teamName + "\n");
		}else{
			System.out.println("Your team was not created correctly.  Please try again");
		}
	}
	
	private static void GuicreateLeague() throws IOException{
		boolean createdLeague = false;
		String leagueName; 
		
		System.out.println("Please enter the name for the name of the league you would like to create: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		leagueName = br.readLine();
		
		createdLeague = LMS.addLeague(leagueName);
		
		if(createdLeague){
			System.out.println("Your new league has been created with the name: " + leagueName + "\n");
		}else{
			System.out.println("Your league was not created correctly.  Please try again");
		}
	}
	
}
