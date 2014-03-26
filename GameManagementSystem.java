/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:43 AM
 */
public class GameManagementSystem implements IGameManagementSystem{

    public boolean createGame(String team1, String team2) {
        Game game = new Game(team1, team2);
        //TODO: Add game where needed
        return false;
    }
}
