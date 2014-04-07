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
import coms362.scoretracker.model.ITeam;
import coms362.scoretracker.model.Player;
import coms362.scoretracker.model.Team;

/**
 * @author jack_ultra
 *
 */
@Repository
public class TeamDAO implements ITeamDAO {

	/* SQL STATIC STRINGS */
	public static final String ADD_TEAM = "INSERT INTO team " + "(teamname) VALUES (?)";
	public static final String GET_TEAM = "SELECT * FROM team WHERE teamname = ?";
	public static final String PUT_PLAYERS = "INSERT INTO team_player_map (first_name, last_name, number, team, position, weight) VALUES(?,?,?,?,?,?)";
	public static final String PUT_TEAM_NOTES = "INSERT INTO team_notes (teamid, note) VALUES (?,?)";
	public static final String GET_PLAYERS = "SELECT * FROM team_player_map WHERE team = ?";
	public static final String GET_TEAM_NOTES = "SELECT * FROM team_notes WHERE teamid = ?";
	
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	public TeamDAO() {
		
	}
	
	public void addTeam(ITeam team) {
	
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(ADD_TEAM, new Object[] { team.getTeamName() });
		
		System.out.println("Team Added: " + team.getTeamName());
	}

	public ITeam getTeam(String team) {
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		Team returnTeam = (Team) jdbcTemplate.queryForObject(GET_TEAM, new Object[] { team }, new TeamRowMapper());
		returnTeam.setPlayers(getPlayers(returnTeam.getTeamId()));
		returnTeam.setNotes(getNotesForTeam(returnTeam.getTeamId()));
		return returnTeam;
	}

	public void putTeam(ITeam team) {
			
		jdbcTemplate = new JdbcTemplate(dataSource);
		for (String note : team.getNewNotes()) {
			jdbcTemplate.update(PUT_TEAM_NOTES, new Object[] {team.getTeamId(), note });
		}
		for (Player p : team.getNewPlayers()) {
			jdbcTemplate.update(PUT_PLAYERS, new Object[] { p.getFirstName(), p.getLastName(), p.getNumber(), team.getTeamId(), p.getPosition(), p.getWeight() });
		}
		
	}
	
	public List<Player> getPlayers(int teamid) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		List<Player> players = new ArrayList<Player>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(GET_PLAYERS, new Object[] { teamid } );
		for (Map row : rows) {
			Player player = new Player((String)row.get("first_name"), (String)row.get("last_name"), (Integer)row.get("number"), (String)row.get("position"), (Double)row.get("weight"));
			player.setRowid((Integer)row.get("team_player_id"));
			players.add(player);
		}
		return players;
	}
	
	private List<String> getNotesForTeam(int teamid) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		List<String> notes = new ArrayList<String>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(GET_TEAM_NOTES, new Object[] { teamid } );
		for (Map row : rows) {
			String note = (String)row.get("note");
			notes.add(note);
		}
		return notes;
 	}
	
	public DataSource getDataSource() {
		return dataSource;
	}

}
