package coms362.scoretracker.model;
/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:02 AM
 */
public interface ITeam {
    public void addNoteToPlayer(String note, String playerName);
    public void addNoteToGame(String note, int gameID);
    public void addNote(String note);
<<<<<<< HEAD:coms362/scoretracker/model/ITeam.java
    public void addPlayer(Player player);
=======
    public boolean addPlayer(IPlayer player);
>>>>>>> origin/master:ITeam.java
}
