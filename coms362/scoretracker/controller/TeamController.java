package coms362.scoretracker.controller;

import org.springframework.beans.factory.annotation.Autowired;

import coms362.scoretracker.management.ITeamManagementSystem;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:42 AM
 */
public class TeamController implements ITeamController {
<<<<<<< HEAD:coms362/scoretracker/controller/TeamController.java
	
	@Autowired
	private ITeamManagementSystem teamManager;
    
	public boolean addTeam(String teamName) {
        return teamManager.addTeam(teamName);
=======
    public boolean addTeam(String teamName) {
        return false; //TODO implement method

>>>>>>> origin/master:TeamController.java
    }

    public void addNotetoPlayer(String playerName, int teamID, String note) {
        TeamManagementSystem tms = new TeamManagementSystem();
        String teamName="";
        tms.addNoteToPlayer(playerName, teamName, note);
    }

    public void addNotetoTeam(int teamID, String note) {
        String teamName= "";
        TeamManagementSystem tms = new TeamManagementSystem();
        tms.addNoteToTeam(note,teamName);

    }

    public boolean createPlayer(String firstName, String lastName, int number, String team, String position, double weight) {
<<<<<<< HEAD:coms362/scoretracker/controller/TeamController.java
        return teamManager.createPlayer(firstName, lastName, number, team, position, weight);
=======
        TeamManagementSystem tms = new TeamManagementSystem();
        return tms.createPlayer(firstName, lastName,number, team, position, weight);
>>>>>>> origin/master:TeamController.java
    }
}
