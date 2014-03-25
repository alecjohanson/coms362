package coms362.scoretracker.management;
import coms362.scoretracker.model.ITeam;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:30 AM
 */
public interface ITeamManagementSystem {
    public ITeam getTeam(String teamName);
    public void addTeam(String teamName);
    public boolean addNoteToPlayer(String playerID, String teamID, String note);
    public boolean addNoteToTeam(String note, String teamName);
    public boolean createPlayer(String firstName, String lastName, int number, String team, String position, double weight);
    public boolean addNoteToGame(String note, int gameID);
}