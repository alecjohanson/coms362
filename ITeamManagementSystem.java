/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:30 AM
 */
public interface ITeamManagementSystem {
    public ITeam getTeam(String teamName);
    public boolean addNoteToPlayer(String playerID, String teamID, String note);
    public boolean addNoteToTeam(String note, String teamName);
    public boolean createPlayer(String firstName, String lastName, int number, String team, String position, double weight);
}
