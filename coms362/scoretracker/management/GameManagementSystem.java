package coms362.scoretracker.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coms362.scoretracker.data.IGameDAO;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:43 AM
 */

@Service
public class GameManagementSystem implements IGameManagementSystem{
<<<<<<< HEAD:coms362/scoretracker/management/GameManagementSystem.java
	
	@Autowired
	private IGameDAO gameDAO;
	
	public GameManagementSystem() {
		
	}
	
    public boolean createGame(String team1, String team2) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
=======
>>>>>>> origin/master:GameManagementSystem.java

    public boolean createGame(String team1, String team2) {
        Game game = new Game(team1, team2);
        //TODO: Add game where needed
        return false;
    }
}
