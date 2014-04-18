package coms362.scoretracker.data;

import coms362.scoretracker.model.ITeam;
import coms362.scoretracker.model.Player;
import coms362.scoretracker.stats.BasketballStats;

import java.util.List;
import java.util.Map;

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

    Map<String, BasketballStats> getTeamStats(String teamName);
    Map<String, BasketballStats> getPlayerStats(String playerName);
}
