/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:29 AM
 */
public interface IGameManagementSystem {
    public boolean createGame(String team1, String team2);
    public boolean addNoteToGame(String note, int gameID);
}
