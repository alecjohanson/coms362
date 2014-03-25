package coms362.scoretracker.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:01 AM
 */
public class Team  implements ITeam{
	
	private String teamName;
	private Integer teamId;
	private List<Player> players;
	private List<Player> newPlayers;
	
	public Team(String teamName) {
		this.setTeamName(teamName);
		players = new ArrayList<Player>();
		newPlayers = new ArrayList<Player>();
	}
	
    public void addNoteToPlayer(String note, String playerName) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void addNoteToGame(String note, int gameID) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void addNote(String note) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    public void addPlayer(Player player) {
        newPlayers.add(player);
    }

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getTeamId() {
		return teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	
	public List<Player> getPlayers() {
		return this.players;
	}
	
	public List<Player> getNewPlayers() {
		return this.newPlayers;
	}
	
	public void setPlayers(List<Player> players) {
		this.players = players;
	}
}
