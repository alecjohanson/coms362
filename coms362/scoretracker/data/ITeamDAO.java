package coms362.scoretracker.data;

import coms362.scoretracker.model.ITeam;
import coms362.scoretracker.model.Team;

public interface ITeamDAO {
	
	/**
	 * 
	 * @param team
	 */
	void addTeam(Team team);
	
	/**
	 * 
	 * @param team
	 * @return
	 */
	ITeam getTeam(String team);
	
	/**
	 * 
	 * @param team
	 */
	void putTeam(Team team);
	
}
