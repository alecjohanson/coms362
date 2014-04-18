package coms362.scoretracker.appconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import coms362.scoretracker.controller.IGameController;
import coms362.scoretracker.controller.ILeagueController;
import coms362.scoretracker.controller.ITeamController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestApp {

	public static void main(String[] args) throws InterruptedException {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ITeamController teamController = (ITeamController) context.getBean("teamController");
		ILeagueController leagueController = (ILeagueController) context.getBean("leagueController");
		IGameController gameController = (IGameController) context.getBean("gameController");


		System.out.println(teamController.getPlayerStats("Melvin Ejim"));


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
        /*gameController.startGame(4);
        gameController.logEvent(5, 6, 4);
        gameController.logEvent(5, 6, 4);
        gameController.logEvent(5, 6, 4);
        gameController.logEvent(6, 6, 4);
        gameController.logEvent(7, 6, 4);
        gameController.logEvent(7, 6, 4);
        gameController.logEvent(7, 6, 4);
        gameController.logEvent(7, 6, 4);
        gameController.logEvent(7, 6, 4);
        gameController.logEvent(7, 6, 4);
        gameController.logEvent(7, 6, 4);
        System.out.println("Sleeping...");
        Thread.sleep(2000);
        gameController.logEvent(1, 6, 4);
        gameController.logEvent(1, 6, 4);
        gameController.logEvent(1, 6, 4);
        gameController.logEvent(3, 6, 4);
        gameController.logEvent(1, 6, 4);
        gameController.logEvent(3, 6, 4);
        gameController.logEvent(5, 6, 4);
        gameController.logEvent(5, 6, 4);
        gameController.logEvent(5, 6, 4);
        gameController.logEvent(6, 6, 4);
        gameController.logEvent(9, 6, 4);
        gameController.logEvent(10, 6, 4);
        gameController.logEvent(11, 6, 4);
        gameController.logEvent(12, 6, 4);
        gameController.logEvent(12, 6, 4);
        System.out.println("Sleeping...");
        Thread.sleep(2000);
        gameController.logEvent(1, 4, 4);
        gameController.logEvent(1, 4, 4);
        gameController.logEvent(1, 4, 4);
        gameController.logEvent(3, 4, 4);
        gameController.logEvent(1, 4, 4);
        gameController.logEvent(3, 4, 4);
        gameController.logEvent(5, 4, 4);
        gameController.logEvent(5, 4, 4);
        gameController.logEvent(5, 4, 4);
        gameController.logEvent(6, 4, 4);
        gameController.logEvent(9, 4, 4);
        gameController.logEvent(10, 4, 4);
        gameController.logEvent(11, 4, 4);
        gameController.logEvent(12, 4, 4);
        gameController.logEvent(12, 4, 4);
        System.out.println("Sleeping...");
        Thread.sleep(2000);
        gameController.logEvent(1, 5, 4);
        gameController.logEvent(1, 5, 4);
        gameController.logEvent(1, 5, 4);
        gameController.logEvent(3, 5, 4);
        gameController.logEvent(1, 5, 4);
        gameController.logEvent(3, 5, 4);
        gameController.logEvent(5, 5, 4);
        gameController.logEvent(5, 5, 4);
        gameController.logEvent(5, 5, 4);
        gameController.logEvent(6, 5, 4);
        gameController.logEvent(9, 5, 4);
        gameController.logEvent(10, 5, 4);
        gameController.logEvent(11, 5, 4);
        gameController.logEvent(12, 5, 4);
        gameController.logEvent(12, 5, 4);
        System.out.println("Sleeping...");
        Thread.sleep(2000);
        gameController.logEvent(1, 1, 4);
        gameController.logEvent(1, 1, 4);
        gameController.logEvent(1, 1, 4);
        gameController.logEvent(3, 1, 4);
        gameController.logEvent(1, 1, 4);
        gameController.logEvent(3, 1, 4);
        gameController.logEvent(5, 1, 4);
        gameController.logEvent(5, 1, 4);
        gameController.logEvent(5, 1, 4);
        gameController.logEvent(6, 1, 4);
        gameController.logEvent(9, 1, 4);
        gameController.logEvent(10, 1, 4);
        gameController.logEvent(11, 1, 4);
        gameController.logEvent(12, 1, 4);
        gameController.logEvent(12, 1, 4);

        gameController.logEvent(7, 1, 4);
        gameController.logEvent(8, 1, 4);
        gameController.logEvent(7, 1, 4);
        gameController.logEvent(8, 1, 4);
        gameController.logEvent(7, 1, 4);
        gameController.logEvent(8, 1, 4);
        gameController.logEvent(7, 1, 4);
        gameController.logEvent(8, 1, 4);

        gameController.logEvent(5, 3, 4);
        gameController.logEvent(5, 3, 4);
        gameController.logEvent(5, 3, 4);
        gameController.logEvent(6, 3, 4);
        gameController.logEvent(7, 3, 4);
        gameController.logEvent(7, 3, 4);
        gameController.logEvent(7, 3, 4);
        gameController.logEvent(7, 3, 4);
        gameController.logEvent(7, 3, 4);
        gameController.logEvent(7, 3, 4);
        gameController.logEvent(7, 3, 4);
        System.out.println("Sleeping...");
        Thread.sleep(2000);
        gameController.logEvent(1, 3, 4);
        gameController.logEvent(1, 3, 4);
        gameController.logEvent(1, 3, 4);
        gameController.logEvent(3, 3, 4);
        gameController.logEvent(1, 3, 4);
        gameController.logEvent(3, 3, 4);
        gameController.logEvent(5, 3, 4);
        gameController.logEvent(5, 3, 4);
        gameController.logEvent(5, 3, 4);
        gameController.logEvent(6, 3, 4);
        gameController.logEvent(9, 3, 4);
        gameController.logEvent(10, 3, 4);
        gameController.logEvent(11, 3, 4);
        gameController.logEvent(12, 3, 4);
        gameController.logEvent(12, 3, 4);
        System.out.println("Sleeping...");
        Thread.sleep(2000);
        gameController.logEvent(1, 4, 3);
        gameController.logEvent(1, 4, 3);
        gameController.logEvent(1, 4, 3);
        gameController.logEvent(3, 4, 3);
        gameController.logEvent(1, 4, 3);
        gameController.pauseGame(4);*/
        //System.out.println(gameController.addScheduledGame("Iowa State Cyclones", "Kansas Jayhawks", "Basketball", "4/29/2014 8:00 pm"));
        //System.out.println(gameController.editScheduledGame(5, "4/29/2014 7:00 pm"));
    }
}
