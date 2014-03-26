/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:41 AM
 */
public class TeamManagementSystem implements ITeamManagementSystem {
    public ITeam getTeam(String teamName) {
        return null; //TODO implement method
    }

    public void addNoteToPlayer(String playerID, String teamID, String note) {
        ITeam team = getTeam(teamID);
        team.addNoteToPlayer(note, playerID); //TODO: Player name or ID?
    }

    public void addNoteToTeam(String note, String teamName) {
        ITeam team = getTeam(teamName);
        team.addNote(note);
    }

    public boolean createPlayer(String firstName, String lastName, int number, String teamName, String position, double weight) {
        ITeam team = getTeam(teamName);
        Player player = new Player(firstName, lastName, number, teamName, position, weight);
        return team.addPlayer(player);
    }

    public void addNoteToGame(String note, int gameID) {

    }
}
