package coms362.scoretracker.model;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:02 AM
 */
public interface ILeague {

    public boolean addToLeague(ITeam team);
    
    public String getLeagueName();
    
    public void setLeagueName(String name);

	public int getLeagueId();

	public void setLeagueId(int leagueId);

	public List<ITeam> getTeams();

	public void setTeams(List<ITeam> teams);
	
	public List<ITeam> getNewTeams();
}
