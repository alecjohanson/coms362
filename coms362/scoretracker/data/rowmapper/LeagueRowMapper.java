package coms362.scoretracker.data.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import coms362.scoretracker.model.League;

public class LeagueRowMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		League league = new League(rs.getString("leaguename"));
		league.setLeagueId(rs.getInt("leagueid"));
		return league;
	}
}
