package coms362.scoretracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import coms362.scoretracker.management.IGameManagementSystem;
import coms362.scoretracker.management.ITeamManagementSystem;
import coms362.scoretracker.model.IGame;

/**
 * Created with IntelliJ IDEA. User: alecjohanson Date: 3/28/14 Time: 10:54 AM
 */
public class GameController implements IGameController {

	@Autowired
	IGameManagementSystem gameManager;

	@Autowired
	ITeamManagementSystem teamManager;

	/**
	 * Error codes:<br><br>
	 * 0 -- no error<br>
	 * 1 -- Team 1 invalid<br>
	 * 2 -- Team 2 invalid<br>
	 * 3 -- Unexpected exception
	 */
	public String createGame(String team1, String team2, String sport) {
		int retval = gameManager.createGame(team1, team2, sport);
		String message = "";
		switch (retval) {
		case 1:
			message = "Team 1 invalid";
			break;
		case 2:
			message = "Team 2 invalid";
			break;
		case 3:
			message = "Error - see logs";
			break;
		}
		return message;
	}

	public void addGameNote(/*int teamID,*/ int gameID, String note) {
		teamManager.addNoteToGame(note, gameID);
	}
	
	public String getGameStats(int gameID) {
		return gameManager.getGameStats(gameID);
	}

	public List<IGame> getGames() {
		return null; // TODO implement method
	}

	public int createCustomSport(String file) {
		return gameManager.createCustomSport(file);
	}

	public boolean startGame(int gameId) {
		return gameManager.startGame(gameId);
	}

	public boolean pauseGame(int gameId) {
		return gameManager.pauseGame(gameId);
	}
	
	public boolean finalizeGame(int gameId) {
		return gameManager.finalizeGame(gameId);
	}

	/**
	 * Error codes:<br><br>
	 * 0 -- no error<br>
	 * 1 -- Game not in progress<br>
	 * 2 -- Game doesn't exist<br>
	 * 3 -- Unexpected exception
	 */
	public String logEvent(int eventId, int playerId, int gameId) {
		int retval = gameManager.logEvent(eventId, playerId, gameId);
		String message = "";
		switch (retval) {
		case 1:
			message = "Game not in progress";
			break;
		case 2:
			message = "Game doesn't exist";
			break;
		case 3:
			message = "Error - see logs";
			break;
		}
		return message;
	}
	
	/**
	 * Error codes:<br><br>
	 * 0 -- no error<br>
	 * 1 -- Team 1 invalid<br>
	 * 2 -- Team 2 invalid<br>
	 * 3 -- Unexpected exception<br>
	 * 4 -- Invalid date
	 */
	public String addScheduledGame(String team1Name, String team2Name,
			String sport, String date) {
		int retval = gameManager.addScheduledGame(team1Name, team2Name, sport,
				date);
		String message = "";
		switch (retval) {
            case 0:
                message = "Game scheduled for " + date;
                break;
            case 1:
                message = "Team 1 invalid";
                break;
            case 2:
                message = "Team 2 invalid";
                break;
            case 3:
                message = "Error - see logs";
                break;
            case 4:
                message = "Invalid date";
                break;
		}
		return message;
	}

    public String editScheduledGame(int gameId, String newTime) {
        int retval = gameManager.editScheduledGame(gameId, newTime);
        String message = "";
        switch (retval) {
            case 0:
                message = "Game rescheduled for " + newTime;
                break;
            case 3:
                message = "Error - see logs";
                break;
            case 4:
                message = "Invalid date";
                break;
        }
        return message;
    }
}
