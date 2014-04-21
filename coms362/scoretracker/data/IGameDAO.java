package coms362.scoretracker.data;

import java.util.Calendar;

import coms362.scoretracker.model.Game;

public interface IGameDAO {

	/**
	 * 
	 * @param gameID Game ID
	 * @return Game, if found in database
	 */
	Game getGame(int gameID);
	
	/**
	 * 
	 * @param game Game to be put in database
	 */
	int putGame(Game game);

	boolean updateGame(Game game);
	
	int createCustomSport(String file);
	
	/*int startGame(int gameId);
	
	int pauseGame(int gameId);*/
	
    int logEvent(int eventId, int gameId, int playerId);

	int addScheduledGame(String team1Name, String team2Name, String sport,
			Calendar cal);

    /*int editScheduledGame(int gameId, Calendar cal);

	void finalizeGame(int gameId);*/
}
