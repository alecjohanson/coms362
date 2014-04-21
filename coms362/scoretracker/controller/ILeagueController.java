package coms362.scoretracker.controller;
/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:20 AM
 */
public interface ILeagueController {
    public boolean addTeam(String teamName, String leagueName);
    public boolean addLeague(String leagueName);
}
