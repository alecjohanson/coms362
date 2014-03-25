package coms362.scoretracker.controller;
/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:13 AM
 */
public interface IGameController {
    public boolean createGame(String team1, String team2);
    public void addGameNote(int teamID, int gameID, String note);
}