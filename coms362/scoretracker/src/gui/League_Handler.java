package gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.ILeagueController;

public class League_Handler {
	private static ILeagueController leagueController;

	static void League_Handler_Method() throws IOException {
		boolean exit = false;
		String read_in = null;
		int choice = 0;
		//ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//leagueController = (ILeagueController) context.getBean("leagueController");
		while(!exit){
			System.out.println("1. Add League\n2. Add Note to League\n3. Return to Categories ");
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
				case 1: GuicreateLeague();
					break;
				case 2: GUIAddTeamtoLeague();
					break;
				case 3: exit = true; 
					break;
				default: System.out.println("You have entered an invalid choice, please try again");
					break;
			}
		}
	}
	

	private static void GuicreateLeague() throws IOException {
		boolean createdLeague = false;
		String leagueName;

		System.out.println("Please enter the name for the name of the league you would like to create: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		leagueName = br.readLine();

		createdLeague = leagueController.addLeague(leagueName);

		if (createdLeague) {
			System.out.println("Your new league has been created with the name: "
							+ leagueName + "\n");
		} else {
			System.out.println("Your league was not created correctly.  Please try again");
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

		addTeam = leagueController.addTeam(teamName, leagueName);

		if (addTeam) {
			System.out.println("The team: " + teamName + " has been added to the league: " + leagueName + "\n");
		} else {
			System.out.println(teamName + " was not added to: " + leagueName + ".  Please try again");
		}
	}
}
