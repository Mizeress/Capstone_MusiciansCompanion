package edu.cscc.MusiciansCompanion.Models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class ChallengeSettings {
	private Note[] homeNotes;
	private Mode[] modes;
	private TimeSignature[] timeSigs;
	private Mood[] moods;
	private Genre[] genres;
	
	public ChallengeSettings() {
		
	}
	
	public ChallengeSettings(Note[] homeNotes, Mode[] modes, TimeSignature[] timeSigs, Mood[] moods, Genre[] genres) {
		this.homeNotes = homeNotes;
		this.modes = modes;
		this.timeSigs = timeSigs;
		this.moods = moods;
		this.genres = genres;
	}
	
	
	public Note[] getHomeNotes() {
		return homeNotes;
	}
	public void setHomeNotes(Note[] homeNotes) {
		this.homeNotes = homeNotes;
	}
	public Mode[] getModes() {
		return modes;
	}
	public void setModes(Mode[] modes) {
		this.modes = modes;
	}
	public TimeSignature[] getTimeSigs() {
		return timeSigs;
	}
	public void setTimeSigs(TimeSignature[] timeSigs) {
		this.timeSigs = timeSigs;
	}
	public Mood[] getMoods() {
		return moods;
	}
	public void setMoods(Mood[] moods) {
		this.moods = moods;
	}
	public Genre[] getGenres() {
		return genres;
	}
	public void setGenres(Genre[] genres) {
		this.genres = genres;
	}
	
	
}
