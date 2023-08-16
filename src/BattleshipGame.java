import java.util.ArrayList; // Import the ArrayList class

public class BattleshipGame {
    private ArrayList<Battleship> battleships = new ArrayList<>(); // Declare an ArrayList to hold Battleship objects
    private GameHelper helper = new GameHelper(); // Create an instance of the GameHelper class
    private int numOfGuesses = 0; // Initialize a counter for the number of guesses

    public void setupGame() {
        // Create three Battleship objects and set their names
        Battleship ship1 = new Battleship();
        ship1.setName("Chelsea");

        Battleship ship2 = new Battleship();
        ship2.setName("Real Madrid");

        Battleship ship3 = new Battleship();
        ship3.setName("Man City");

        battleships.add(ship1); // Add the Battleship objects to the battleships ArrayList
        battleships.add(ship2);
        battleships.add(ship3);

        System.out.println("Welcome to Battleship! Try to sink all the ships.");
        System.out.println("Ship locations are random. Coordinates are in the format (letter)(number), e.g., a1, b3, etc.");

        // Iterate through the battleships ArrayList and place them on the grid
        for (Battleship battleship : battleships) {
            ArrayList<String> newLocation = helper.placeStartup(3); // Get a random placement for the ship
            battleship.setLocationCells(newLocation.toArray(new String[0])); // Set the ship's location
        }
    }

    public void startPlaying() {
        // Continue playing while there are still battleships remaining
        while (!battleships.isEmpty()) {
            String userGuess = helper.getUserInput("Enter your guess"); // Get user's guess
            checkUserGuess(userGuess); // Check if the guess is a hit or miss
        }
        finishGame(); // When all ships are sunk, finish the game
    }

    private void checkUserGuess(String userGuess) {
        numOfGuesses++; // Increment the guess counter
        String result = "miss"; // Initialize the result to "miss"

        // Iterate through each battleship to check the user's guess
        for (Battleship battleship : battleships) {
            result = battleship.checkGuess(userGuess); // Check the user's guess against the battleship's location
            if (result.equals("hit") || result.equals("kill")) {
                break; // If a hit or kill is detected, exit the loop
            }
        }
        System.out.println(result); // Print the result of the user's guess
        if (result.equals("kill")) {
            battleships.removeIf(ship -> ship.checkGuess(userGuess).equals("kill")); // Remove sunk ships from the list
            System.out.println("Ship sunk!"); // Display a message if a ship is sunk
        }
    }

    private void finishGame() {
        System.out.println("All ships are sunk! You took " + numOfGuesses + " guesses."); // Display the game's conclusion
    }

    public static void main(String[] args) {
        BattleshipGame game = new BattleshipGame(); // Create an instance of BattleshipGame
        game.setupGame(); // Set up the game by placing battleships
        game.startPlaying(); // Start playing the game
    }
}
