package coms362.scoretracker.data;

import coms362.scoretracker.model.ILeague;
import coms362.scoretracker.model.League;

public interface ILeagueDAO {

	/**
	 * 
	 * @param league
	 */
	void addLeague(ILeague league);
	
	/**
	 * 
	 * @param league
	 * @return
	 */
	ILeague getLeague(String league);
	
	/**
	 * 
	 * @param league
	 */
	void putLeague(ILeague league);
	
}
