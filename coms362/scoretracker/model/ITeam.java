package coms362.scoretracker.model;

import java.util.List;

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
    public void addPlayer(Player player);
    
	public abstract String getTeamName();

	public abstract void setTeamName(String teamName);

	public abstract Integer getTeamId();

	public abstract void setTeamId(Integer teamId);

	public abstract List<Player> getPlayers();

	public abstract List<Player> getNewPlayers();

	public abstract void setPlayers(List<Player> players);

	public abstract String toString();
	
	public abstract List<String> getNewNotes();
}
