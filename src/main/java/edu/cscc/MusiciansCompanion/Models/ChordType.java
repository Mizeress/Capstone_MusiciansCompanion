package edu.cscc.MusiciansCompanion.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ChordType {
	@Id
	private long id;
	
	private String chordType;
	private int numNotes;
	
	public ChordType() {
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getChordType() {
		return chordType;
	}
	public void setChordType(String chordType) {
		this.chordType = chordType;
	}
	public int getNumNotes() {
		return numNotes;
	}
	public void setNumNotes(int numNotes) {
		this.numNotes = numNotes;
	}
	
	
}
