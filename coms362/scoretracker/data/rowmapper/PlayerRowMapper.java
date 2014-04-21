package coms362.scoretracker.data.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import coms362.scoretracker.model.Player;

public class PlayerRowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Player player = new Player(rs.getString("firstName"), rs.getString("lastName"), rs.getInt("number"), rs.getString("position"), rs.getDouble("weight"));
		return player;
	}
}
