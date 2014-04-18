package coms362.scoretracker.management;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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

    private static SimpleDateFormat dateFormat;
	public GameManagementSystem() {
        dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm aa");
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
    		gameDAO.startGame(gameId);
    		return true;
    	} catch (Exception ex) {
    		ex.printStackTrace();
    		return false;
    	}
    }
    public boolean pauseGame(int gameId) {
    	try {
    		gameDAO.pauseGame(gameId);
    		return true;
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
        try {
            cal.setTime(dateFormat.parse(newTime));
        } catch (ParseException e) {
            e.printStackTrace();
            return 4;
        }
        return gameDAO.editScheduledGame(gameId, cal);
    }
}
