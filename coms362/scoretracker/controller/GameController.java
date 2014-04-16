package coms362.scoretracker.controller;

import java.util.List;

import coms362.scoretracker.management.ITeamManagementSystem;
import org.springframework.beans.factory.annotation.Autowired;

import coms362.scoretracker.management.IGameManagementSystem;
import coms362.scoretracker.model.IGame;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/28/14
 * Time: 10:54 AM
 */
public class GameController implements IGameController{
	
	@Autowired
	IGameManagementSystem gameManager;
	private ITeamManagementSystem teamManager;
	
	public boolean createGame(String team1, String team2, String sport) {
		return gameManager.createGame(team1, team2, sport);
	}

	public void addGameNote(int teamID, int gameID, String note) {
		teamManager.addNoteToGame(note, gameID);
	}

	public List<IGame> getGames() {
		return null; //TODO implement method
	}
	
	public int createCustomSport(String file)
	{
		return gameManager.createCustomSport(file);
	}
	public boolean startGame(int gameId) {
		return gameManager.startGame(gameId);
	}
	public boolean pauseGame(int gameId) {
		return gameManager.pauseGame(gameId);
	}
    public String logEvent(int eventId, int playerId, int gameId) {
        int retval = gameManager.logEvent(eventId, playerId, gameId);
        String message = "";
        switch (retval) {
            case 1: message = "Game not in progress"; break;
            case 2: message = "Game doesn't exist"; break;
            case 3: message = "Error - see logs"; break;
        }
        return message;
    }
}
