package coms362.scoretracker.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import coms362.scoretracker.data.rowmapper.LeagueRowMapper;
import coms362.scoretracker.model.ILeague;
import coms362.scoretracker.model.ITeam;
import coms362.scoretracker.model.League;
import coms362.scoretracker.model.Team;

@Repository
public class LeagueDAO implements ILeagueDAO {

	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;

	public LeagueDAO() {
		
	}
	
	public void addLeague(ILeague league) {
		
		String sql = "INSERT INTO league " + "(leaguename) VALUES (?)";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(sql, new Object[] { league.getLeagueName() });
		
		System.out.println("League Added: " + league.getLeagueName());

	}

	public ILeague getLeague(String league) {
		String sql = "SELECT * FROM league WHERE leaguename = ?";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		ILeague returnTeam = (League) jdbcTemplate.queryForObject(sql, new Object[] { league }, new LeagueRowMapper());
		returnTeam.setTeams(getTeams(returnTeam.getLeagueId()));
		return returnTeam;
	}

	public void putLeague(ILeague league) {
		String sql = "INSERT INTO league_team_map (leagueid, teamid) VALUES(?,?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		for (ITeam t : league.getNewTeams()) {
			jdbcTemplate.update(sql, new Object[] { league.getLeagueId(), t.getTeamId() });
		}
	}

	private List<ITeam> getTeams(int leagueid) {
		String sql = "SELECT * FROM team WHERE teamid IN (SELECT teamid FROM league_team_map WHERE leagueid = ?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		List<ITeam> teams = new ArrayList<ITeam>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { leagueid } );
		for (Map row : rows) {
			Team team = new Team((String)row.get("teamname"));
			team.setTeamId((Integer)row.get("teamid"));
			teams.add(team);
			System.out.println(team);
		}
		return teams;
	}
}
