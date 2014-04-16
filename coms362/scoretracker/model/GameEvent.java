package coms362.scoretracker.model;

public class GameEvent {
	private int eventid;
	private String sport;
	private int points;
	private String name;
	
	public int getEventid() {
		return eventid;
	}
	public void setEventid(int eventid) {
		this.eventid = eventid;
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
