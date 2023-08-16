public class Battleship {
    private String name; // Declare a private String variable to store the name of the battleship
    private String[] locationCells; // Declare a private String array to store the location cells of the battleship
    private int hits; // Declare a private integer variable to keep track of the number of hits on the battleship

    public void setLocationCells(String[] locations) {
        locationCells = locations; // Set the location cells of the battleship using the provided array
    }

    public void setName(String shipName) {
        name = shipName; // Set the name of the battleship using the provided shipName
    }

    public String checkGuess(String userGuess) {
        String result = "miss"; // Initialize the result as "miss"

        // Iterate through the location cells to check if the user's guess matches any of them
        for (int i = 0; i < locationCells.length; i++) {
            if (userGuess.equals(locationCells[i])) { // If the guess matches a location cell
                hits++; // Increment the hits counter
                locationCells[i] = null; // Mark the hit location as null (hit location is no longer valid)
                result = (hits == locationCells.length) ? "kill" : "hit"; // Update the result based on hits count
                break; // Exit the loop since a hit has been found
            }
        }
        return result; // Return the result ("miss", "hit", or "kill")
    }
}
