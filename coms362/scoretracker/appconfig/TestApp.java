package coms362.scoretracker.appconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import coms362.scoretracker.controller.ITeamController;

public class TestApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		ITeamController teamController = (ITeamController) context.getBean("teamController");
		//teamController.addTeam("Iowa State Cyclones");
		if (teamController.createPlayer("Melvin", "Ejim", 3, "Iowa State Cyclones", "F", 210))
			System.out.println("Success");
		else
			System.out.println("Failed");
	}

}
