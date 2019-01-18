package player;

import stats.PlayerStats;

public class Player implements PlayerStats {
	
	private double sanityLevel = 0;
	private double sanityCap = 100;
	private String playerName;
	private String playerUniversity;

	// Player constructors
	
	public Player() {
		sanityLevel = 100;
	}
	
	public Player(double sanity) {
		sanityLevel = sanity;
	}
	
	
	// Regenerates the sanity level of the character.
	public double meditate(double sanity) {
		sanityLevel += sanity;

		if (sanityLevel > sanityCap) {
			sanityLevel = sanityCap;
		}

		return sanityLevel;
	}

	// Reduces the sanity level of the character.
	public double insanitySurge(double sanity) {
		sanityLevel -= sanity;

		if (sanityLevel < 0) {
			sanityLevel = 0;
		} else
			sanityLevel = sanity;
		return sanityLevel;
	}
	
	// Character Status Check Methods
	
	// Checks if the character is still sane.
	public boolean isSane() {
		if (sanityLevel <= 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public String getName() {
		return playerName;
	}
	
	public void setName(String name) {
		playerName = name;
	}
	
	public String getUniversity() {
		return playerUniversity;
	}
	
	public void setUniversity(String name) {
		playerUniversity = name;
	}
	
	
	
	// PlayerStats Interface Methods

	public double getSanity() {
		return sanityLevel;
	}

	public void setSanity(double newSanity) {
		sanityLevel = newSanity;	
	}

	public void setSanityCap(double newSanityCap) {
		sanityCap = newSanityCap;
	}

}
