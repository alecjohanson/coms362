package coms362.scoretracker.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import coms362.scoretracker.data.rowmapper.LeagueRowMapper;
import coms362.scoretracker.model.Game;
import coms362.scoretracker.model.ILeague;
import coms362.scoretracker.model.ITeam;
import coms362.scoretracker.model.League;
import coms362.scoretracker.model.Team;

@Repository
public class LeagueDAO implements ILeagueDAO {


	private static final String ADD_LEAGUE = "INSERT INTO league " + "(leaguename) VALUES (?)";
	private static final String GET_LEAGUE = "SELECT * FROM league WHERE leaguename = ?";
	private static final String PUT_LEAGUE_TEAMS = "INSERT INTO league_team_map (leagueid, teamid) VALUES(?,?)";
	private static final String GET_TEAMS = "SELECT * FROM team WHERE teamid IN (SELECT teamid FROM league_team_map WHERE leagueid = ?)";
	
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;

	public LeagueDAO() {
		
	}
	
	public void addLeague(ILeague league) {
		
		if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(ADD_LEAGUE, new Object[] { league.getLeagueName() });
		
		System.out.println("League Added: " + league.getLeagueName());

	}

	public ILeague getLeague(String league) {
		
		if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
		
		ILeague returnLeague = (League) jdbcTemplate.queryForObject(GET_LEAGUE, new Object[] { league }, new LeagueRowMapper());
		returnLeague.setTeams(getTeams(returnLeague.getLeagueId()));
		return returnLeague;
	}

	public void putLeague(ILeague league) {
		if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
		for (ITeam t : league.getNewTeams()) {
			jdbcTemplate.update(PUT_LEAGUE_TEAMS, new Object[] { league.getLeagueId(), t.getTeamId() });
		}
	}

	private List<ITeam> getTeams(int leagueid) {
		if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
		List<ITeam> teams = new ArrayList<ITeam>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(GET_TEAMS, new Object[] { leagueid } );
		for (Map row : rows) {
			Team team = new Team((String)row.get("teamname"));
			team.setTeamId((Integer)row.get("teamid"));
			teams.add(team);
		}
		return teams;
	}
	
	/*
	 * Stopped working on this use case in favor of others...
	 * League scheduling algorithm is hard to solve
	 * 
	 * private List<Game> genGames(ILeague league, int numGamesPerTeam) {
		List<Game> ret = new ArrayList<Game>();
		List<ITeam> teams = league.getTeams();
		List<ITeam> teams_concurrent = teams;
		Calendar[] gameTimes = getGameTimes();
		Map<Integer, List<Game>> teamGameMap = new HashMap<Integer, List<Game>>();
		for (ITeam team : teams) {
			if (!teamGameMap.containsKey(team.getTeamId()))
				teamGameMap.put(team.getTeamId(), new ArrayList<Game>());
			for (int i=0; i<numGamesPerTeam; i++) {
				if (team.getTeamId() == teams_concurrent.get(i).getTeamId()) continue;
				Game game = new Game(team.getTeamName(), teams_concurrent.get(i%numGamesPerTeam).getTeamName(), "Basketball");
				game.setStarttime(gameTimes[i%numGamesPerTeam].getTimeInMillis());
				teamGameMap.get(team).add(game);
			}
		}
		
		return ret;
	}
	
	private Calendar[] getGameTimes() {
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, Calendar.SATURDAY);
		Calendar[] ret = new Calendar[5];
		for (int i=0; i<5; i++) {
			Calendar temp = cal;
			temp.set(Calendar.HOUR_OF_DAY, 12+(i*2));
			temp.set(Calendar.MINUTE, 0);
			temp.set(Calendar.SECOND, 0);
			ret[i] = temp;
		}
		return ret;
	}*/
}
