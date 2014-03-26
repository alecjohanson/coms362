package coms362.scoretracker.data.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import coms362.scoretracker.model.ITeam;
import coms362.scoretracker.model.Team;

public class TeamRowMapper implements RowMapper {
	public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		Team team = new Team(rs.getString("teamname"));
		team.setTeamId(rs.getInt("teamid"));
		return team;
	}
}

