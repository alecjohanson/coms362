/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:42 AM
 */
public class TeamController implements ITeamController {
    public boolean addTeam(String teamName) {
        return false; //TODO implement method

    }

    public void addNotetoPlayer(String playerName, int teamID, String note) {
        TeamManagementSystem tms = new TeamManagementSystem();
        String teamName="";
        tms.addNoteToPlayer(playerName, teamName, note);
    }

    public void addNotetoTeam(int teamID, String note) {
        String teamName= "";
        TeamManagementSystem tms = new TeamManagementSystem();
        tms.addNoteToTeam(note,teamName);

    }

    public boolean createPlayer(String firstName, String lastName, int number, String team, String position, double weight) {
        TeamManagementSystem tms = new TeamManagementSystem();
        return tms.createPlayer(firstName, lastName,number, team, position, weight);
    }
}
