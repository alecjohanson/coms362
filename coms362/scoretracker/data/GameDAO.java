package coms362.scoretracker.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import coms362.scoretracker.data.rowmapper.GameRowMapper;
import coms362.scoretracker.data.rowmapper.TeamRowMapper;
import coms362.scoretracker.model.Game;
import coms362.scoretracker.model.GameEvent;
import coms362.scoretracker.model.Team;

@Repository
public class GameDAO implements IGameDAO {

	/* SQL STATIC STRINGS */
	private static final String PUT_GAME = "INSERT INTO game (team1, team2, status, sport) VALUES (?,?,?,?)";
	private static final String GET_TEAM = "SELECT * FROM team WHERE teamname = ?";
	private static final String GET_GAME = "SELECT * FROM game WHERE gameid = ?";
	private static final String PUT_GAME_EVENT = "INSERT INTO game_event (sport, name, points) VALUES (?,?,?)";
	private static final String PUT_SPORT = "INSERT INTO sport (sportname, timelength) VALUES (?,?)";
	private static final String GET_GAME_LENGTH = "SELECT timelength FROM sport WHERE sportname = ?";
	private static final String START_GAME = "UPDATE game SET status = ?, starttime = ?, timeleft = ? WHERE gameid = ?";
	private static final String STOP_GAME = "UPDATE game SET timeleft = ? WHERE gameid = ?";
	
	@Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	public GameDAO() {
		
	}
	
	public Game getGame(int gameID) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		
		return (Game) jdbcTemplate.queryForObject(GET_GAME, new Object[] { gameID }, new GameRowMapper());
	}

	public void putGame(Game game) {
		
		if (verifyTeams(game)) {
			jdbcTemplate = new JdbcTemplate(dataSource);
			jdbcTemplate.update(PUT_GAME, new Object[] { game.getTeam1(), game.getTeam2(),
							game.getStatus(), game.getSport() });
		}
		else {
			throw new NullPointerException("Invalid team names");
		}
	}
	
	public int createCustomSport(String file)
	{
		try {
			Object[] sport = CustomGameParser.parseSport(file);
			List<GameEvent> newEvents = CustomGameParser.parseEvents(file);
			putCustomGameEvents(newEvents);
			putSport(sport);
			return 0;
		} catch (NumberFormatException nex) {
			return 1;
		} catch (Exception ex) {
			System.out.println(ex);
			return 2;
		}
	}
	
	public int startGame(int gameId)
	{
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);
			Game game = getGame(gameId);
			game.setTimeleft(getGameLengthFromSport(game.getSport()) * 60000);
			game.setStatus(Game.STATUS_INPROGRESS);
			game.setStarttime(System.currentTimeMillis());
			jdbcTemplate.update(START_GAME, new Object[] { game.getStatus(), game.getStarttime(), game.getTimeleft(), gameId });
			return 0;
			// TODO Set error codes
		} catch (Exception ex) {
			System.out.println(ex);
			return 1;
		}
	}
	
	public void stopGame(int gameId)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
		Game game = getGame(gameId);
		Long curTime = System.currentTimeMillis();
		Long timeLeft = game.getTimeleft() - (curTime - game.getStarttime());
		jdbcTemplate.update(STOP_GAME, new Object[] { timeLeft, gameId });
	}
	
	public Long getGameLengthFromSport(String sport)
	{
		try {
			jdbcTemplate = new JdbcTemplate(dataSource);
			return jdbcTemplate.queryForObject(GET_GAME_LENGTH, new Object[] {sport}, Long.class);
		} catch (Exception ex) {
			System.out.println(ex);
			return null;
		}
	}
	
	private void putSport(Object[] sport) 
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(PUT_SPORT, sport);
	}
	
	private void putCustomGameEvents(List<GameEvent> events)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
		List<Object[]> input = new ArrayList<Object[]>();
		for (GameEvent event : events) {
			input.add(new Object[] { event.getSport(), event.getName(), event.getPoints() });
		}
		jdbcTemplate.batchUpdate(PUT_GAME_EVENT, input);
	}
	
	private boolean verifyTeams(Game game) {
		jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			Team team1 = (Team) jdbcTemplate.queryForObject(GET_TEAM, new Object[] { game.getTeam1() }, new TeamRowMapper());
			Team team2 = (Team) jdbcTemplate.queryForObject(GET_TEAM, new Object[] { game.getTeam2() }, new TeamRowMapper());
			return true;
		} catch (Exception ex) {
			return false;
		}
	}

}
