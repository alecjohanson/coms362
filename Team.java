import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:01 AM
 */
public class Team  implements ITeam
{
    public List<IPlayer> playerList;
    public String note;

    public void addNoteToPlayer(String note, String playerName) {
        IPlayer player = findPlayer(playerName);
        player.addNote(note);
    }

    public void addNoteToGame(String note, int gameID) {
        //TODO
    }

    public void addNote(String note) {
        this.note = note;
    }

    public boolean addPlayer(IPlayer player) {
        return playerList.add(player);
    }

    private IPlayer findPlayer(String playerName)
    {
        for(int i=0; i<playerList.size();i++)
            if(playerList.get(i).name == playerName)
               playerList.get(i);
        return null;
    }
}
