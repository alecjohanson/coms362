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
		//teamController.addTeam("Oklahoma Sooners");
//		if (teamController.createPlayer("Naz", "Long", 10, "Iowa State Cyclones", "G", 190))
//			System.out.println("Success");
//		else
//			System.out.println("Failed");

//		if (leagueController.addLeague("Big 10"))
//			System.out.println("Success");
//		else
//			System.out.println("Failed");
//		
		/*if (leagueController.addTeam("Oklahoma Sooners", "Big 12"))
			System.out.println("Success");
		else
			System.out.println("Failed");*/
		
		//teamController.addNotetoTeam("Iowa State Cyclones", "This team is very good");
		//gameController.createGame("Iowa State Cyclones", "Iowa Hawkeyes", "Basketball");
		
		/*gameController.startGame(2);
		gameController.stopGame(1);*/
        //gameController.createGame("Iowa State Cyclones", "Kansas Jayhawks", "Basketball");
        //gameController.startGame(3);
        try {
            System.out.println(gameController.logEvent(3, 3, 3));
            Thread.sleep(4000);
            System.out.println(gameController.logEvent(4, 3, 3));
            System.out.println("success");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        gameController.pauseGame(3);
	
	}

}
