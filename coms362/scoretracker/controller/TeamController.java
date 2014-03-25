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
	
	@Autowired
	private ITeamManagementSystem teamManager;
    
	public void addTeam(String teamName) {
        teamManager.addTeam(teamName);
    }

    public void addNotetoPlayer(String playerName, int teamID, String note) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void addNotetoTeam(int teamID, String note) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean createPlayer(String firstName, String lastName, int number, String team, String position, double weight) {
        return teamManager.createPlayer(firstName, lastName, number, team, position, weight);
    }
}