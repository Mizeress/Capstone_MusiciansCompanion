package edu.cscc.MusiciansCompanion.Models.ChordVoicingAlgorithm;


public class ChordVoicingAlgorithmSettings {
	
	private int numFrets;
	
	private String tuning;
	
	private String chord;
	
	private int maxDistance;
	
	
	public ChordVoicingAlgorithmSettings() {
		
	}
	
	
	public String getTuning() {
		return tuning;
	}

	public void setTuning(String tuning) {
		this.tuning = tuning;
	}

	public String getChord() {
		return chord;
	}

	public void setChord(String chord) {
		this.chord = chord;
	}

	public int getMaxDistance() {
		return maxDistance;
	}

	public void setMaxDistance(int maxDistance) {
		this.maxDistance = maxDistance;
	}

	public int getNumFrets() {
		return numFrets;
	}

	public void setNumFrets(int numFrets) {
		this.numFrets = numFrets;
	}
	
	
}
