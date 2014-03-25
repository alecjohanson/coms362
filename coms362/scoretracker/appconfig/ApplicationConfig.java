package coms362.scoretracker.appconfig;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import coms362.scoretracker.controller.ILeagueController;
import coms362.scoretracker.controller.ITeamController;
import coms362.scoretracker.controller.LeagueController;
import coms362.scoretracker.controller.TeamController;

@Configuration
@ComponentScan("coms362.scoretracker")
public class ApplicationConfig {
	
	@Value("jdbc:sqlite:C:/Users/jack_ultra/git/coms362/data/scoretracker_db.sqlite") String jdbcUrl;
	@Value("org.sqlite.JDBC") String driverClassName;

	
	@Bean(name="dataSource")
	public DataSource getDataSource() {
	   DriverManagerDataSource ds = new DriverManagerDataSource(jdbcUrl);
	   ds.setDriverClassName(driverClassName);
	   return ds;
	}
	
	@Bean(name="teamController")
	public ITeamController getTeamController() {
		return new TeamController();
	}
	
	@Bean(name="leagueController") 
	public ILeagueController getLeagueController() {
		return new LeagueController();
	}
	
	
//	@Bean(name="teamManager")
//	public ITeamManagementSystem getTeamManager() {
//		return new TeamManagementSystem();
//	}
//	
//	@Bean(name="leagueManager")
//	public ILeagueManagementSystem getLeagueManager() {
//		return new LeagueManagementSystem();
//	}
//	
//	@Bean(name="gameManager")
//	public IGameManagementSystem getGameManager() {
//		return new GameManagementSystem();
//	}
//	
//	@Bean(name="teamDAO")
//	public ITeamDAO getTeamDAO() {
//		return new TeamDAO();
//	}
//	
//	@Bean(name="leagueDAO")
//	public ILeagueDAO getLeagueDAO() {
//		return new LeagueDAO();
//	}
//	
//	@Bean(name="gameDAO")
//	public IGameDAO getGameDAO() {
//		return new GameDAO();
//	}
}
