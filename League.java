import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:01 AM
 */
public class League implements ILeague {
    List<ITeam> teams;
    public String name;

    public League(String name)
    {
        this.name = name;
        teams = new ArrayList<ITeam>();
    }

    public boolean addToLeague(ITeam team) {
        return teams.add(team);
    }
}
