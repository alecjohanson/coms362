package coms362.scoretracker.model;
/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:02 AM
 */
public interface ILeague {
    public boolean addLeague(String leagueName);
    public boolean addToLeague(ITeam team);
}
