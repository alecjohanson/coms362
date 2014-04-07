package coms362.scoretracker.controller;

import org.springframework.beans.factory.annotation.Autowired;

import coms362.scoretracker.management.ITeamManagementSystem;
import coms362.scoretracker.management.TeamManagementSystem;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:42 AM
 */
public class TeamController implements ITeamController {

	@Autowired
	private ITeamManagementSystem teamManager;

	public boolean addTeam(String teamName) {
		return teamManager.addTeam(teamName);
	}

	public void addNotetoPlayer(String playerName, int teamID, String note) {
		teamManager.addNoteToPlayer(playerName, teamID, note);
	}

	public void addNotetoTeam(String teamName, String note) {
		teamManager.addNoteToTeam(note, teamName);
	}

	public boolean createPlayer(String firstName, String lastName, int number, String team, String position, double weight) {
		return teamManager.createPlayer(firstName, lastName, number, team, position, weight);

	}
}
