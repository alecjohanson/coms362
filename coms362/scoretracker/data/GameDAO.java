package coms362.scoretracker.data;

import org.springframework.stereotype.Repository;

import coms362.scoretracker.model.IGame;

@Repository
public class GameDAO implements IGameDAO {

	public GameDAO() {
		
	}
	
	@Override
	public IGame getGame(int gameID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putGame(IGame game) {
		// TODO Auto-generated method stub

	}

}
