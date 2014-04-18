package coms362.scoretracker.data;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import coms362.scoretracker.data.rowmapper.GameRowMapper;
import coms362.scoretracker.data.rowmapper.TeamRowMapper;
import coms362.scoretracker.model.Game;
import coms362.scoretracker.model.GameEvent;

@Repository
public class GameDAO implements IGameDAO {

	/* SQL STATIC STRINGS */
	private static final String PUT_GAME = "INSERT INTO game (team1, team2, status, starttime, timeleft, sport) VALUES (?,?,?,?,?,?)";
	private static final String GET_TEAM = "SELECT * FROM team WHERE teamname = ?";
	private static final String GET_GAME = "SELECT * FROM game WHERE gameid = ?";
	private static final String PUT_GAME_EVENT = "INSERT INTO game_event (sport, name, points) VALUES (?,?,?)";
	private static final String PUT_SPORT = "INSERT INTO sport (sportname, timelength) VALUES (?,?)";
	private static final String GET_GAME_LENGTH = "SELECT timelength FROM sport WHERE sportname = ?";
    private static final String RESCHED_GAME = "UPDATE game SET starttime = ? WHERE gameid = ?";
	private static final String START_GAME = "UPDATE game SET status = ?, laststarttime = ? WHERE gameid = ?";
	private static final String PAUSE_GAME = "UPDATE game SET status = ?, timeleft = ? WHERE gameid = ?";
	private static final String LOG_EVENT = "INSERT INTO game_event_map (eventid, playerid, time, gameid) VALUES (?,?,?,?)";

    @Autowired
	private DataSource dataSource;
	
	private JdbcTemplate jdbcTemplate;
	
	public GameDAO() {
		
	}
	
	public Game getGame(int gameID) {
        if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
        Game ret;
        try {
            ret = (Game) jdbcTemplate.queryForObject(GET_GAME, new Object[]{gameID}, new GameRowMapper());
        } catch (Exception ex) {
            return null;
        }
		return ret;
	}

	public int putGame(Game game) {
		game.setTimeleft(getGameLengthFromSport(game.getSport()) * 60000);
		if (game.getStarttime() == null)
			game.setStarttime(System.currentTimeMillis());
		int verification = verifyTeams(game);
		try {
			if (verification == 0) {
				if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
				jdbcTemplate.update(PUT_GAME, game.getTeam1(),
                        game.getTeam2(), game.getStatus(), game.getStarttime(),
                        game.getTimeleft(), game.getSport());
				return verification;
			} else
				return verification;
		} catch (Exception ex) {
			return 3;
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
			ex.printStackTrace();
			return 2;
		}
	}
	
	public int startGame(int gameId)
	{
		try {
            if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
			Game game = getGame(gameId);
			game.setStatus(Game.STATUS_INPROGRESS);
            Long curTime = System.currentTimeMillis();
			jdbcTemplate.update(START_GAME, game.getStatus(), curTime, gameId);
			return 0;
			// TODO Set error codes
		} catch (Exception ex) {
			ex.printStackTrace();
			return 1;
		}
	}
	
	public int pauseGame(int gameId)
	{
        if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
		Game game = getGame(gameId);
		Long curTime = System.currentTimeMillis();
        game.setStatus(Game.STATUS_PAUSED);
		game.setTimeleft(game.getTimeleft() - (curTime - game.getLaststarttime()));
		jdbcTemplate.update(PAUSE_GAME, game.getStatus(), game.getTimeleft(), gameId);
        // TODO Set error codes
        return 0;
	}

    public int logEvent(int eventId, int playerId, int gameId) {
        if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
        Game game = getGame(gameId);
        if (game == null)
            return 2;
        if (game.getStatus() != Game.STATUS_INPROGRESS)
            return 1;
        Long curTime = System.currentTimeMillis();
        Long timeLeft = game.getTimeleft() - (curTime - game.getLaststarttime());
        jdbcTemplate.update(LOG_EVENT, eventId, playerId, timeLeft, gameId);
        return 0;
    }

	public int addScheduledGame(String team1Name, String team2Name,
			String sport, Calendar cal) {
		if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
		Game game = new Game(team1Name, team2Name, sport);
		game.setStarttime(cal.getTimeInMillis());
		return putGame(game);
	}

    public int editScheduledGame(int gameId, Calendar cal) {
        try {
            if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
            jdbcTemplate.update(RESCHED_GAME, cal.getTimeInMillis(), gameId);
            return 0;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 3;
        }
    }

    private Long getGameLengthFromSport(String sport)
	{
		try {
            if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
			return jdbcTemplate.queryForObject(GET_GAME_LENGTH, new Object[] {sport}, Long.class);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	private void putSport(Object[] sport) 
	{
        if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
		jdbcTemplate.update(PUT_SPORT, sport);
	}
	
	private void putCustomGameEvents(List<GameEvent> events)
	{
        if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
		List<Object[]> input = new ArrayList<Object[]>();
		for (GameEvent event : events) {
			input.add(new Object[] { event.getSport(), event.getName(), event.getPoints() });
		}
		jdbcTemplate.batchUpdate(PUT_GAME_EVENT, input);
	}
	
	private int verifyTeams(Game game) {
        if (jdbcTemplate == null) jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			jdbcTemplate.queryForObject(GET_TEAM, new Object[] { game.getTeam1() }, new TeamRowMapper());
		} catch (Exception ex) {
			return 1;
		} try {
			jdbcTemplate.queryForObject(GET_TEAM, new Object[] { game.getTeam2() }, new TeamRowMapper());
		} catch (Exception ex) {
			return 2;
		}
		return 0;
	}

}
