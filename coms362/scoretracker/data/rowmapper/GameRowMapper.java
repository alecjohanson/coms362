package coms362.scoretracker.data.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import coms362.scoretracker.model.Game;

public class GameRowMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Game game = new Game(rs.getString("team1"), rs.getString("team2"), rs.getString("sport"));
		game.setGameId(rs.getInt("gameid"));
		game.setTimeleft(rs.getLong("timeleft"));
		game.setStarttime(rs.getLong("starttime"));
		return game;
	}
}
