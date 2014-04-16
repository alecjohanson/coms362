package coms362.scoretracker.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms362.scoretracker.data.IGameDAO;
import coms362.scoretracker.model.Game;

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
    public boolean pauseGame(int gameId) {
    	try {
    		gameDAO.pauseGame(gameId);
    		return true;
    	} catch (Exception ex) {
    		System.out.println(ex);
    		return false;
    	}
    }

    public int logEvent(int eventId, int playerId, int gameId) {
        try {
            return gameDAO.logEvent(eventId, playerId, gameId);
        } catch (Exception ex) {
            System.out.println(ex);
            return 3;
        }
    }
}
