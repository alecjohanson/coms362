/**
 * 
 */
package coms362.scoretracker.data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import coms362.scoretracker.data.rowmapper.TeamRowMapper;
import coms362.scoretracker.model.IPlayer;
import coms362.scoretracker.model.ITeam;
import coms362.scoretracker.model.Player;
import coms362.scoretracker.model.Team;

/**
 * @author jack_ultra
 *
 */
@Repository
public class TeamDAO implements ITeamDAO {

	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	public TeamDAO() {
		
	}
	
	@Override
	public void addTeam(Team team) {
	
		// TODO see if teamname exists before inserting
		String sql = "INSERT INTO team " + "(teamname) VALUES (?)";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(sql, new Object[] { team.getTeamName() });
		
		System.out.println("Team Added: " + team.getTeamName());
	}

	@Override
	public ITeam getTeam(String team) {
		String sql = "SELECT * FROM team WHERE teamname = ?";
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		Team returnTeam = (Team) jdbcTemplate.queryForObject(sql, new Object[] { team }, new TeamRowMapper());
		returnTeam.setPlayers(getPlayers(returnTeam.getTeamId()));
		return returnTeam;
	}

	@Override
	public void putTeam(Team team) {
		String sql = "INSERT INTO team_player_map (first_name, last_name, number, team, position, weight) VALUES(?,?,?,?,?,?)";
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		for (Player p : team.getNewPlayers()) {
			jdbcTemplate.update(sql, new Object[] { p.getFirstName(), p.getLastName(), p.getNumber(), team.getTeamId(), p.getPosition(), p.getWeight() });
		}
		
	}
	
	private List<Player> getPlayers(int teamid) {
		String sql = "SELECT * FROM team_player_map WHERE team = ?";
		jdbcTemplate = new JdbcTemplate(dataSource);
		List<Player> players = new ArrayList<Player>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, new Object[] { teamid } );
		for (Map row : rows) {
			Player player = new Player((String)row.get("first_name"), (String)row.get("last_name"), (Integer)row.get("number"), (String)row.get("position"), (Double)row.get("weight"));
			player.setRowid((Integer)row.get("team_player_id"));
			players.add(player);
			System.out.println(player);
		}
		return players;
	}
	
	
	public DataSource getDataSource() {
		return dataSource;
	}

}
