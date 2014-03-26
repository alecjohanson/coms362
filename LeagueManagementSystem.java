import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:42 AM
 */
public class LeagueManagementSystem implements ILeagueManagementSystem{
    public List<ILeague> leagues;

    public LeagueManagementSystem()
    {
        //TODO: get leagues from DB?
        leagues = new ArrayList<ILeague>();
    }

    public boolean addTeam(String teamName, String leagueName) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean addLeague(String leagueName) {
        return leagues.add(new League(leagueName));
    }

}
