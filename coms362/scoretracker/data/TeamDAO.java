/**
 * 
 */
package coms362.scoretracker.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import coms362.scoretracker.stats.BasketballStats;
import coms362.scoretracker.stats.BasketballStatsParser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
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
    public static final String GET_TEAM_BY_ID = "SELECT * FROM team WHERE teamid = ?";
	public static final String PUT_PLAYER = "INSERT INTO team_player_map (first_name, last_name, number, team, position, weight) VALUES(?,?,?,?,?,?)";
	public static final String PUT_TEAM_NOTES = "INSERT INTO team_notes (teamid, note) VALUES (?,?)";
	public static final String GET_PLAYERS = "SELECT * FROM team_player_map WHERE team = ?";
	public static final String GET_PLAYER_NOTES = "SELECT * FROM player_notes WHERE team_playerid = ?";
	public static final String PUT_PLAYER_NOTES = "INSERT INTO player_notes (team_playerid, note) VALUES(?,?)";
	public static final String GET_TEAM_NOTES = "SELECT * FROM team_notes WHERE teamid = ?";
    public static final String FIND_TEAM_BY_PLAYER = "SELECT team FROM team_player_map WHERE first_name = ? AND last_name = ?";
    public static final String GET_PLAYER_STATS = "SELECT * FROM game_event_map WHERE playerid = ?";
	
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	public TeamDAO() {
		
	}
	
	public void addTeam(ITeam team) {
	
		if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
		
		jdbcTemplate.update(ADD_TEAM, team.getTeamName());
		
		System.out.println("Team Added: " + team.getTeamName());
	}

	public ITeam getTeam(String team) {
		
		if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);

		Team returnTeam = (Team) jdbcTemplate.queryForObject(GET_TEAM, new Object[] { team }, new TeamRowMapper());
		returnTeam.setPlayers(getPlayers(returnTeam.getTeamId()));
		returnTeam.setNotes(getNotesForTeam(returnTeam.getTeamId()));
		return returnTeam;
	}

    public ITeam getTeamById(int teamid) {
        if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);

        Team returnTeam = (Team) jdbcTemplate.queryForObject(GET_TEAM_BY_ID, new Object[] { teamid }, new TeamRowMapper());
        returnTeam.setPlayers(getPlayers(returnTeam.getTeamId()));
        returnTeam.setNotes(getNotesForTeam(returnTeam.getTeamId()));
        return returnTeam;
    }

	public void putTeam(ITeam team) {
			
		if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
		for (String note : team.getNewNotes()) {
			jdbcTemplate.update(PUT_TEAM_NOTES, team.getTeamId(), note);
		}
		for (Player p : team.getNewPlayers()) {
			jdbcTemplate.update(PUT_PLAYER, p.getFirstName(), p.getLastName(), p.getNumber(), team.getTeamId(), p.getPosition(), p.getWeight());
		}
		for (Player p : team.getPlayers()) {
			for (String note : p.getNewNotes()) {
				jdbcTemplate.update(PUT_PLAYER_NOTES, p.getRowid(), note);
			}
		}
		
	}

    public Map<String, BasketballStats> getTeamStats(String teamName) {
    	ITeam team = getTeam(teamName);
        BasketballStats teamStats = new BasketballStats();
        teamStats.setSubjectName(team.getTeamName());
        Map<String, BasketballStats> statsMap = new HashMap<String, BasketballStats>();
        BasketballStats playerStats;
        List<Map<String, Object>> rawStats;
        for (Player player : team.getPlayers()) {
            rawStats = jdbcTemplate.queryForList(GET_PLAYER_STATS, player.getRowid());
            playerStats = BasketballStatsParser.parseRowsIntoStats(rawStats);
            playerStats.setSubjectName(player.getFirstName() + " " + player.getLastName());
            playerStats.setNotes(player.getNotes());
            statsMap.put(playerStats.getSubjectName(), playerStats);
            teamStats.addBasketballStats(playerStats);
        }
        teamStats.setNotes(team.getNotes());
        statsMap.put(team.getTeamName(), teamStats);
        return statsMap;
    }

	public Map<String, BasketballStats> getPlayerStats(String playerName) {
        ITeam team = getTeamByPlayerName(playerName);
        return getTeamStats(team.getTeamName());
	}
    
    public List<Player> getPlayers(int teamid) {
		if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
		List<Player> players = new ArrayList<Player>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(GET_PLAYERS, teamid);
		for (Map row : rows) {
			Player player = new Player((String)row.get("first_name"), (String)row.get("last_name"), (Integer)row.get("number"), (String)row.get("position"), (Double)row.get("weight"));
			player.setRowid((Integer)row.get("team_player_id"));
			player.setNotes(getNotesForPlayer(player.getRowid()));
			players.add(player);
		}
		return players;
	}

    private ITeam getTeamByPlayerName(String playerName) {
        if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
        String firstname = playerName.substring(0, playerName.lastIndexOf(' '));
        String lastname = playerName.substring(playerName.lastIndexOf(' ')+1);
        Integer teamid = (Integer) jdbcTemplate.queryForObject(FIND_TEAM_BY_PLAYER, new Object[]{firstname, lastname},
                new RowMapper<Object>() {
                    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
                        return rs.getInt(1);
                    }
                }
        );
        return getTeamById(teamid);
    }
    
	private List<String> getNotesForTeam(int teamid) {
		if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
		List<String> notes = new ArrayList<String>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(GET_TEAM_NOTES, teamid);
		for (Map row : rows) {
			String note = (String)row.get("note");
			notes.add(note);
		}
		return notes;
 	}
	private List<String> getNotesForPlayer(int playerid) {
		if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
		List<String> notes = new ArrayList<String>();
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(GET_PLAYER_NOTES, playerid);
		for (Map row : rows) {
			String note = (String)row.get("note");
			notes.add(note);
		}
		return notes;
	}

}
