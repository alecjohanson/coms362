package coms362.scoretracker.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms362.scoretracker.data.ILeagueDAO;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:42 AM
 */

@Service
public class LeagueManagementSystem implements ILeagueManagementSystem{
	
	@Autowired
	private ILeagueDAO leagueDAO;
	
	public LeagueManagementSystem() {
		
	}
	
    public boolean addTeam(String teamName, String leagueName) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean addLeague(String leagueName) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
