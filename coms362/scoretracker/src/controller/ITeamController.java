package coms362.scoretracker.controller;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:15 AM
 */
public interface ITeamController {
    public boolean addTeam(String teamName);
    public void addNotetoPlayer(int playerID, int teamID, String note);
    public void addNotetoTeam(String teamName, String note);
    public boolean createPlayer(String firstName, String lastName, int number, String team, String position, double weight);
    public String getPlayerStats(String playerName);
    public String getTeamStats(String playerName);
}
