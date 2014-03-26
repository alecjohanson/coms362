package coms362.scoretracker.data;

import coms362.scoretracker.model.IGame;

public interface IGameDAO {

	/**
	 * 
	 * @param gameID
	 * @return
	 */
	IGame getGame(int gameID);
	
	/**
	 * 
	 * @param game
	 */
	void putGame(IGame game);
	
}
