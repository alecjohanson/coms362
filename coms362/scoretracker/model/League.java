package coms362.scoretracker.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:01 AM
 */
public class League implements ILeague {

	private List<ITeam> teams;
	private List<ITeam> newTeams;
	private String leagueName;
	private int leagueId;

	public League(String name) {
		this.leagueName = name;
		this.setTeams(new ArrayList<ITeam>());
		this.newTeams = new ArrayList<ITeam>();
	}

	public boolean addToLeague(ITeam team) {
		newTeams.add(team);
		return true;
	}

	public String getLeagueName() {
		return this.leagueName;
	}

	public void setLeagueName(String name) {
		this.leagueName = name;
	}

	public int getLeagueId() {
		return leagueId;
	}

	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	public List<ITeam> getTeams() {
		return teams;
	}

	public void setTeams(List<ITeam> teams) {
		this.teams = teams;
	}

	public List<ITeam> getNewTeams() {
		return this.newTeams;
	}
}
