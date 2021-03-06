package coms362.scoretracker.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: alecjohanson
 * Date: 3/24/14
 * Time: 11:01 AM
 */
public class Player implements IPlayer
{

	private String firstName;
	private String lastName;
	private int number;
	private String position;
	private double weight;
	private int rowid;
	private List<String> notes;
	private List<String> newNotes;
	
	public Player(String firstName, String lastName, int number, String position, double weight) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.number = number;
		this.position = position;
		this.weight = weight;
		this.newNotes = new ArrayList<String>();
	}
	
	public void addNote(String note) {
		this.newNotes.add(note);
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public int getRowid() {
		return rowid;
	}

	public void setRowid(int rowid) {
		this.rowid = rowid;
	}
	
	public String toString() {
		return "#" + this.number + " " + this.firstName + " " + this.lastName + ", " + this.position;
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
}
