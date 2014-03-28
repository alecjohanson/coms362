package coms362.scoretracker.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:01 AM
 */
public class Team implements ITeam {

	private String teamName;
	private Integer teamId;
	private List<Player> players;
	private List<Player> newPlayers;

	public Team(String teamName) {
		this.setTeamName(teamName);
		players = new ArrayList<Player>();
		newPlayers = new ArrayList<Player>();
	}

	/* (non-Javadoc)
	 * @see coms362.scoretracker.model.Itemp#addNoteToPlayer(java.lang.String, java.lang.String)
	 */

	public void addNoteToPlayer(String note, String playerName) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	/* (non-Javadoc)
	 * @see coms362.scoretracker.model.Itemp#addNoteToGame(java.lang.String, int)
	 */

	public void addNoteToGame(String note, int gameID) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	/* (non-Javadoc)
	 * @see coms362.scoretracker.model.Itemp#addNote(java.lang.String)
	 */

	public void addNote(String note) {
		//To change body of implemented methods use File | Settings | File Templates.
	}

	/* (non-Javadoc)
	 * @see coms362.scoretracker.model.Itemp#addPlayer(coms362.scoretracker.model.Player)
	 */

	public void addPlayer(Player player) {
		newPlayers.add(player);
	}

	/* (non-Javadoc)
	 * @see coms362.scoretracker.model.Itemp#getTeamName()
	 */

	public String getTeamName() {
		return teamName;
	}

	/* (non-Javadoc)
	 * @see coms362.scoretracker.model.Itemp#setTeamName(java.lang.String)
	 */

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	/* (non-Javadoc)
	 * @see coms362.scoretracker.model.Itemp#getTeamId()
	 */

	public Integer getTeamId() {
		return teamId;
	}

	/* (non-Javadoc)
	 * @see coms362.scoretracker.model.Itemp#setTeamId(java.lang.Integer)
	 */

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	/* (non-Javadoc)
	 * @see coms362.scoretracker.model.Itemp#getPlayers()
	 */

	public List<Player> getPlayers() {
		return this.players;
	}

	/* (non-Javadoc)
	 * @see coms362.scoretracker.model.Itemp#getNewPlayers()
	 */

	public List<Player> getNewPlayers() {
		return this.newPlayers;
	}

	/* (non-Javadoc)
	 * @see coms362.scoretracker.model.Itemp#setPlayers(java.util.List)
	 */

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	/* (non-Javadoc)
	 * @see coms362.scoretracker.model.Itemp#toString()
	 */

	public String toString() {
		return this.teamName;
	}
}
