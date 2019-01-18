package stats;

public interface PlayerStats {
	// General Setters

	// Sets a new sanity value.
	public void setSanity(double newSanity);

	// Sets a new sanity cap value.
	public void setSanityCap(double newSanityCap);
	
	public double getSanity();
}
