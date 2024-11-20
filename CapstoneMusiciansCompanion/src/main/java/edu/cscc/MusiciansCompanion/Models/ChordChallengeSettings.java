package edu.cscc.MusiciansCompanion.Models;

public class ChordChallengeSettings {
	//Guitar or Piano
	private String type;
	
	//What chord types are allowed in the challenge
	private ChordType[] chordTypes;
	
	//Possible Root notes in challenge
	private Note[] notes;
	
	//Num strings for guitar or num octaves for piano
	private int num;


	public ChordChallengeSettings() {
		
	}
	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ChordType[] getChordTypes() {
		return chordTypes;
	}

	public void setChordTypes(ChordType[] chordTypes) {
		this.chordTypes = chordTypes;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	
	public Note[] getNotes() {
		return notes;
	}


	public void setNotes(Note[] notes) {
		this.notes = notes;
	}
	
}
