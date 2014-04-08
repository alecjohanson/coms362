package coms362.scoretracker.management;
/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:29 AM
 */
public interface IGameManagementSystem {
    public boolean createGame(String team1, String team2, String sport);
    public int createCustomSport(String file);
    public boolean startGame(int gameId);
    public boolean stopGame(int gameId);
}
