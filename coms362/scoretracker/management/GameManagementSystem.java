package coms362.scoretracker.management;

import coms362.scoretracker.model.IGame;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    private static SimpleDateFormat dateFormat;
	public GameManagementSystem() {
        dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
	}

	public IGame getGame(int gameId)
	{
		return gameDAO.getGame(gameId);
	}

	public String getGameStats(int gameID) {
		return getGame(gameID).getStats();
	}
	
	public int createGame(String team1, String team2, String sport) {
		Game game = new Game(team1, team2, sport);
		game.setStatus(Game.STATUS_NEW);
		return gameDAO.putGame(game);
	}
    public int createCustomSport(String file)
    {
    	return gameDAO.createCustomSport(file);
    }
    
    public boolean startGame(int gameId) 
    {
    	try {
    		Game game = gameDAO.getGame(gameId);
			game.setStatus(Game.STATUS_INPROGRESS);
			game.setLaststarttime(System.currentTimeMillis());
            return gameDAO.updateGame(game);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		return false;
    	}
    }
    public boolean pauseGame(int gameId) {
    	try {
    		Game game = gameDAO.getGame(gameId);
    		Long curTime = System.currentTimeMillis();
            game.setStatus(Game.STATUS_PAUSED);
    		game.setTimeleft(game.getTimeleft() - (curTime - game.getLaststarttime()));
    		return gameDAO.updateGame(game);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		return false;
    	}
    }
    
    public boolean finalizeGame(int gameId) {
    	try {
    		Game game = gameDAO.getGame(gameId);
    		game.setStatus(Game.STATUS_COMPLETE);
    		game.setTimeleft(0L);
    		return gameDAO.updateGame(game);
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		return false;
    	}
    }

    public int logEvent(int eventId, int playerId, int gameId) {
        try {
            return gameDAO.logEvent(eventId, playerId, gameId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 3;
        }
    }

	/**
	 *
	 */
	public int addScheduledGame(String team1Name, String team2Name,
			String sport, String date) {
		Calendar cal = Calendar.getInstance();
		try {
			cal.setTime(dateFormat.parse(date));
		} catch (ParseException e) {
			e.printStackTrace();
			return 4;
		}
		return gameDAO.addScheduledGame(team1Name, team2Name, sport.toLowerCase(), cal);
	}

    public int editScheduledGame(int gameId, String newTime) {
        Calendar cal = Calendar.getInstance();
        Game game = gameDAO.getGame(gameId);
        try {
            cal.setTime(dateFormat.parse(newTime));
        } catch (ParseException e) {return 4;}
        game.setStarttime(cal.getTimeInMillis());
        if (gameDAO.updateGame(game))
        	return 0;
        return 1;
    }
}
