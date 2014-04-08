package coms362.scoretracker.controller;

import java.util.List;

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
	
	public boolean createGame(String team1, String team2, String sport) {
		return gameManager.createGame(team1, team2, sport);
	}

	public void addGameNote(int teamID, int gameID, String note) {
		//TODO implement method

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
	public boolean stopGame(int gameId) {
		return gameManager.stopGame(gameId);
	}
}
