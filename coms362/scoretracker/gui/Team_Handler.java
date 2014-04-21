package coms362.scoretracker.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;

import coms362.scoretracker.controller.ITeamController;

public class Team_Handler {
	
	@Autowired
	private static ITeamController teamController;

	static void Team_Handler_Method() throws IOException {
		boolean exit = false;
		String read_in = null;
		int choice = 0;
		//ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		//teamController = (ITeamController) context.getBean("teamController");
		
		while(!exit){
			System.out.println("1. Add Team\n2. Add Note to Team\n3. Get Team Statistics\n4. Return to Categories ");
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
				case 1: GuicreateTeam();
					break;
				case 2: GuiAddNotetoTeam();
					break;
				case 3: GuiGetTeamStats();
					break;
				case 4: exit = true; 
					break;
				default: System.out.println("You have entered an invalid choice, please try again");
					break;
			}
		}
	}
	
	private static void GuiGetTeamStats() throws IOException {
		String stats = null; 
		String teamName = null; 
		
		System.out.println("Please enter the team name: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		teamName = br.readLine();
		
		stats = teamController.getTeamStats(teamName);
		
		System.out.println(stats);
		
	}

	private static void GuiAddNotetoTeam() throws IOException {
		String note = null;
		String teamName = null;

		System.out.println("Please enter the team ID: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		teamName = br.readLine();

		System.out.println("Please enter the note: ");
		br = new BufferedReader(new InputStreamReader(System.in));
		note = br.readLine();

		teamController.addNotetoTeam(teamName, note);

		System.out.println("Your note was successfully added to " + teamName);
	}


	private static void GuicreateTeam() throws IOException {
		boolean createdTeam = false;
		String teamName;

		System.out
				.println("Please enter the name of the team you would like to create: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		teamName = br.readLine();

		createdTeam = teamController.addTeam(teamName);

		if (createdTeam) {
			System.out.println("Your team has been created with the name: "
					+ teamName + "\n");
		} else {
			System.out
					.println("Your team was not created correctly.  Please try again");
		}
	}

}
