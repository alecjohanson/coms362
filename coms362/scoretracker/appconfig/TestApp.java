package coms362.scoretracker.appconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import coms362.scoretracker.controller.IGameController;
import coms362.scoretracker.controller.ILeagueController;
import coms362.scoretracker.controller.ITeamController;

public class TestApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ITeamController teamController = (ITeamController) context.getBean("teamController");
		ILeagueController leagueController = (ILeagueController) context.getBean("leagueController");
		IGameController gameController = (IGameController) context.getBean("gameController");
//		teamController.addTeam("Iowa Hawkeyes");
//		if (teamController.createPlayer("Naz", "Long", 10, "Iowa State Cyclones", "G", 190))
//			System.out.println("Success");
//		else
//			System.out.println("Failed");

//		if (leagueController.addLeague("Big 10"))
//			System.out.println("Success");
//		else
//			System.out.println("Failed");
//		
//		if (leagueController.addTeam("Iowa Hawkeyes", "Big 10"))
//			System.out.println("Success");
//		else
//			System.out.println("Failed");
		
		//teamController.addNotetoTeam("Iowa State Cyclones", "This team is very good");
		//gameController.createGame("Iowa State Cyclones", "Iowa Hawkeyes", "Basketball");
		
		gameController.startGame(2);
		gameController.stopGame(1);
	
	}

}
