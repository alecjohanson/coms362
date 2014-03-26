/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:28 AM
 */
public class Game implements IGame{
    public String note;
    public String team1;
    public String team2;

    public Game(String team1, String team2)
    {
        this.team1 = team1;
        this.team2 = team2;
    }

    public void addNote(String note) {
        this.note = note;
    }
}
