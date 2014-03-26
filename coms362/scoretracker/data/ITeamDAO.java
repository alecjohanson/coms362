package coms362.scoretracker.data;

import coms362.scoretracker.model.ITeam;

public interface ITeamDAO {
	
	/**
	 * 
	 * @param team
	 */
	void addTeam(ITeam team);
	
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
	void putTeam(ITeam team);
	
}
