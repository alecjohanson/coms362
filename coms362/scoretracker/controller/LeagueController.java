package coms362.scoretracker.controller;

import org.springframework.beans.factory.annotation.Autowired;

import coms362.scoretracker.management.ILeagueManagementSystem;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:43 AM
 */

public class LeagueController implements ILeagueController{
	
	@Autowired
	private ILeagueManagementSystem leagueManager;
	
    public boolean addTeam(String teamName, String leagueName) {
        return leagueManager.addTeam(teamName, leagueName);
    }

    public boolean addLeague(String leagueName) {
    	return leagueManager.addLeague(leagueName);
    }
}
