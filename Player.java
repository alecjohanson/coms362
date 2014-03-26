/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:01 AM
 */
public class Player implements IPlayer
{
    public String name;
    public String lastName;
    public int number;
    public String team;
    public String position;
    public double weight;
    public String note;

    public Player(String firstName, String lastName, int number, String team, String position, double weight)
    {
        this.name = firstName;
        this.lastName = lastName;
        this.number = number;
        this.team = team;
        this.position = position;
        this. weight = weight;
    }

    public void addNote(String note) {
        this.note = note;
    }
}
