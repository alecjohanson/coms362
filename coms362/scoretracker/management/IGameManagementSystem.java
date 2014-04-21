package coms362.scoretracker.management;

import coms362.scoretracker.model.IGame;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:29 AM
 */
public interface IGameManagementSystem {
    public int createGame(String team1, String team2, String sport);
    public int createCustomSport(String file);
    public boolean startGame(int gameId);
	public String getGameStats(int gameId);
    public boolean pauseGame(int gameId);
    public int logEvent(int eventId, int playerId, int gameId);
    /**
     * Adds a game with two teams and the start time specified by the date passed in
     * 
     * @param team1Name Home team
     * @param team2Name Away team
     * @param sport Game sport
     * @param date Date of game. Formatted - mm/dd/yyyy hh:mm aa
     * @return zero, or error code
     */
	public int addScheduledGame(String team1Name, String team2Name,
			String sport, String date);

    public int editScheduledGame(int gameId, String newTime);
	public boolean finalizeGame(int gameId);
}
