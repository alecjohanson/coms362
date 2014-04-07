package coms362.scoretracker.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms362.scoretracker.data.ITeamDAO;
import coms362.scoretracker.model.ITeam;
import coms362.scoretracker.model.Player;
import coms362.scoretracker.model.Team;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:41 AM
 */

@Service
public class TeamManagementSystem implements ITeamManagementSystem {

	@Autowired
	private ITeamDAO teamDAO;

	public TeamManagementSystem() {

	}

	public ITeam getTeam(String teamName) {
		return teamDAO.getTeam(teamName);
	}

	public boolean addNoteToPlayer(int playerID, int teamID, String note) {
		List<Player> players = teamDAO.getPlayers(teamID);
		Player player = null;
		for(int i=0; i<players.size(); i++)
		{
			if (players.get(i).getRowid() == playerID)
			{
				player = players.get(i);
			}
		}
		if (player == null)
			return false;
		else
			player.addNote(note);
	}

	public boolean addNoteToTeam(String note, String teamName) {
		try {
			ITeam curTeam = teamDAO.getTeam(teamName);
			if (curTeam == null)
				return false;
			curTeam.addNote(note);
			teamDAO.putTeam(curTeam);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean createPlayer(String firstName, String lastName, int number, String team, String position, double weight) {
		try {
			ITeam curTeam = teamDAO.getTeam(team);
			if (curTeam == null)
				return false;
			curTeam.addPlayer(new Player(firstName, lastName, number, position, weight));
			teamDAO.putTeam((ITeam) curTeam);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean addNoteToGame(String note, int gameID) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addTeam(String teamName) {
		try {
			ITeam team = new Team(teamName);
			teamDAO.addTeam(team);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
