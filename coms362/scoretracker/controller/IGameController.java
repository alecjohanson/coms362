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
	
	/**
	 * Adds an unscheduled game and sets the start time to now.
	 * 
	 * @param team1 Home team
	 * @param team2 Away team
	 * @param sport Sport
	 * @return Error message -- see implemented method in {@link GameController#createGame}
	 */
    public String createGame(String team1, String team2, String sport);
    public void addGameNote(int teamID, int gameID, String note);
	public List<IGame> getGames();
	public int createCustomSport(String file);
	public boolean startGame(int gameId);
	public boolean pauseGame(int gameId);
	
	/**
	 * Adds an event given the game, player, and event ids. 
	 * 
	 * @param eventId Event id
	 * @param playerId Player id
	 * @param gameId Game id
	 * @return Error message -- see implemented method in {@link GameController#logEvent}
	 */
    public String logEvent(int eventId, int playerId, int gameId);
    
    /**
	 * Adds a scheduled game
	 * 
	 * @param team1Name Home team
	 * @param team2Name Away team
	 * @param sport Sport
	 * @param time Date format fot the String date is: MM/dd/yyyy hh:mm aa
	 * @return Error message -- see implemented method in {@link GameController#addScheduledGame}
	 */
    public String addScheduledGame(String team1Name, String team2Name, String sport, String time);

    public String editScheduledGame(int gameId, String newTime);
}
