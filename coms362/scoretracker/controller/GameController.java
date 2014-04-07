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
	private ITeamManagementSystem teamManager;
	
	public boolean createGame(String team1, String team2) {
		return false; //TODO implement method

	}

	public void addGameNote(int teamID, int gameID, String note) {
		teamManager.addNoteToGame(gameID, note);

	}

	public List<IGame> getGames() {
		return null; //TODO implement method

	}
}
