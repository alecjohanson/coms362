package coms362.scoretracker.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:28 AM
 */
public class Game implements IGame {
	public static int STATUS_NEW = 0;
	public static int STATUS_INPROGRESS = 1;
    public static int STATUS_PAUSED = 2;
	public static int STATUS_COMPLETE = 3;
	
	private List<String> notes;
	private List<String> newNotes;
	private String team1;
	private String team2;
	private int gameId;
	private int status;
	private String sport;
	private Long starttime;
	private Long timeleft;

	public Game(String team1, String team2, String sport) {
		this.team1 = team1;
		this.team2 = team2;
		this.sport = sport;
		notes = new ArrayList<String>();
		newNotes = new ArrayList<String>();
	}

	public void addNote(String note) {
		this.newNotes.add(note);
	}

	public List<String> getNotes() {
		return notes;
	}

	public void setNotes(List<String> notes) {
		this.notes = notes;
	}

	public List<String> getNewNotes() {
		return newNotes;
	}

	public void setNewNotes(List<String> newNotes) {
		this.newNotes = newNotes;
	}

	public String getTeam1() {
		return team1;
	}

	public void setTeam1(String team1) {
		this.team1 = team1;
	}

	public String getTeam2() {
		return team2;
	}

	public void setTeam2(String team2) {
		this.team2 = team2;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getGameId() {
		return gameId;
	}

	public void setGameId(int gameId) {
		this.gameId = gameId;
	}

	public Long getStarttime() {
		return starttime;
	}

	public void setStarttime(Long starttime) {
		this.starttime = starttime;
	}

	public Long getTimeleft() {
		return timeleft;
	}

	public void setTimeleft(Long timeleft) {
		this.timeleft = timeleft;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}
}
