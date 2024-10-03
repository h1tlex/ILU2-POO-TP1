package exceptions;

public class VillageSansChefException extends Exception {
	

    // Recommended serialVersionUID declaration
    private static final long serialVersionUID = 1L;

    // Default constructor
    public VillageSansChefException() {
        super("Le village n'a pas de chef");
    }

    // Constructor with custom error message
    public VillageSansChefException(String message) {
        super(message);
    }
	
}
