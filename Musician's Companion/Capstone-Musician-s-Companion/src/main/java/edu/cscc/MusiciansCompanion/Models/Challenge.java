package edu.cscc.MusiciansCompanion.Models;

public class Challenge {
	private Note homeNote;
	private Mode mode;
	private TimeSignature timeSig;
	private Mood mood;
	private Genre genre;
	
	public Challenge(Note note, Mode mode, TimeSignature timeSig, Mood mood, Genre genre) {
		this.homeNote = note;
		this.mode = mode;
		this.timeSig = timeSig;
		this.mood = mood;
		this.genre = genre;
	}

	public Challenge() {
		
	}
	
	
	//Getters and Setters
	public Note getHomeNote() {
		return homeNote;
	}
	
	public void setHomeNote(Note note) {
		homeNote = note;
	}
	
	public Mode getMode() {
		return mode;
	}
	
	public void setMode(Mode mode) {
		this.mode = mode;
	}
	
	public TimeSignature getTimeSig() {
		return timeSig;
	}


	public void setTimeSig(TimeSignature timeSig) {
		this.timeSig = timeSig;
	}


	public Mood getMood() {
		return mood;
	}


	public void setMood(Mood mood) {
		this.mood = mood;
	}


	public Genre getGenre() {
		return genre;
	}


	public void setGenre(Genre genre) {
		this.genre = genre;
	}



	public String toString() {
		String string = "Note: " + homeNote.toString() + "\nMode: " + mode.getName() + "Time Signature: " + timeSig.getBeatPerMeasure() + '/' + timeSig.getBeatNote()
		+ "Mood: " + mood.getName() + "Genre: " + genre.getName();
		
		return string;
	}
}
