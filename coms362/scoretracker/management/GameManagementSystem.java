package coms362.scoretracker.management;

import coms362.scoretracker.model.IGame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms362.scoretracker.data.IGameDAO;
import coms362.scoretracker.model.Game;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:43 AM
 */

@Service
public class GameManagementSystem implements IGameManagementSystem{
	
	@Autowired
	private IGameDAO gameDAO;
	
	public GameManagementSystem() {
		
	}

	public boolean createGame(String team1, String team2, String sport) {
    	try {
            Game game = new Game(team1, team2, sport);
            game.setStatus(Game.STATUS_NEW);
            gameDAO.putGame(game);
            return true;
    	} catch (Exception ex) {
    		System.out.println(ex);
    		return false;
    	}
    }

	public IGame getGame(int gameId)
	{
		return gameDAO.getGame(gameId);
	}

	public String getGameStats(int gameID) {
		return getGame(gameID).getStats();
	}

    public int createCustomSport(String file)
    {
    	return gameDAO.createCustomSport(file);
    }
    
    public boolean startGame(int gameId) 
    {
    	try {
    		gameDAO.startGame(gameId);
    		return true;
    	} catch (Exception ex) {
    		System.out.println(ex);
    		return false;
    	}
    }
    public boolean stopGame(int gameId) {
    	try {
    		gameDAO.stopGame(gameId);
    		return true;
    	} catch (Exception ex) {
    		System.out.println(ex);
    		return false;
    	}
    }
}
