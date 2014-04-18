package coms362.scoretracker.controller;

import coms362.scoretracker.model.IGame;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:13 AM
 */
public interface IGameController {
    public boolean createGame(String team1, String team2, String sport);
    public void addGameNote(int teamID, int gameID, String note);
	public String getGameStats(int gameID);
	public int createCustomSport(String file);
	public boolean startGame(int gameId);
	public boolean stopGame(int gameId);
}
