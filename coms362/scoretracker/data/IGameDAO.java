package coms362.scoretracker.data;

import coms362.scoretracker.model.Game;

public interface IGameDAO {

	/**
	 * 
	 * @param gameID
	 * @return
	 */
	Game getGame(int gameID);
	
	/**
	 * 
	 * @param game
	 */
	void putGame(Game game);

	int createCustomSport(String file);
	
	int startGame(int gameId);
	
	void stopGame(int gameId);
}
