package edu.cscc.MusiciansCompanion.Models;

public class ChordChallenge {
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	private String type;
	//Number of Strings for guitar and num Octaves for Keyboard
	private int num;	
	private Note root;
	private ChordType chordType;
	private int inversion;
	
	public ChordChallenge() {
		
	}
	
	public ChordChallenge(String type, int num, Note root, ChordType chordType, int inversion) {
		this.type = type;
		this.num = num;
		this.root = root;
		this.chordType = chordType;
		this.inversion = inversion;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public Note getRoot() {
		return root;
	}
	public void setRoot(Note root) {
		this.root = root;
	}
	public ChordType getChordType() {
		return chordType;
	}
	public void setChordType(ChordType chordType) {
		this.chordType = chordType;
	}
	public int getInversion() {
		return inversion;
	}
	
	//If inversion doesn't exist, set to the highest possible inversion
	public void setInversion(int inversion) {
		if (inversion < chordType.getNumNotes()) {
			this.inversion = inversion;
		} else {
			inversion = chordType.getNumNotes() - 1;
		}
	}
	
	
}
