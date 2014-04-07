package coms362.scoretracker.data;

import coms362.scoretracker.model.ITeam;
import coms362.scoretracker.model.Player;

import java.util.List;

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

	public List<Player> getPlayers(int teamid);
	/**
	 * 
	 * @param team
	 */
	void putTeam(ITeam team);
	
}
