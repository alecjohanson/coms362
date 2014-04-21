package coms362.scoretracker.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms362.scoretracker.data.ILeagueDAO;
import coms362.scoretracker.data.ITeamDAO;
import coms362.scoretracker.model.ILeague;
import coms362.scoretracker.model.League;
import coms362.scoretracker.model.Team;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:42 AM
 */

@Service
public class LeagueManagementSystem implements ILeagueManagementSystem {

	@Autowired
	private ILeagueDAO leagueDAO;

	@Autowired
	private ITeamDAO teamDAO;

	public LeagueManagementSystem() {

	}

	public boolean addTeam(String teamName, String leagueName) {
		try {
			ILeague curLeague = leagueDAO.getLeague(leagueName);
			if (curLeague == null)
				return false;
			Team curTeam = (Team) teamDAO.getTeam(teamName);
			curLeague.addToLeague(curTeam);
			leagueDAO.putLeague((League) curLeague);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	public boolean addLeague(String leagueName) {
		try {
			League league = new League(leagueName);
			leagueDAO.addLeague(league);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
