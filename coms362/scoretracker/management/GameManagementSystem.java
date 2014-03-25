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
	
	@Autowired
	private IGameDAO gameDAO;
	
	public GameManagementSystem() {
		
	}
	
    public boolean createGame(String team1, String team2) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    public boolean addNoteToGame(String note, int gameID) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
