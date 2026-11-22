
// One object of this class holds one player's data.
// Week 1 could only keep a single String. A class lets us keep many players.
public class Player {

    // private means only this class can touch these variables directly.
    // Other classes must use the getters and setters. That is encapsulation.
    private String name;
    private int playerNumber;

    // This runs when main says: new Player("Anna", 1)
    // It copies those two values into this object's fields.
    public Player(String name, int playerNumber) {
        // "this.name" is the field above. "name" is the value passed in.
        // Same word, so "this" tells Java which one is the object's field.
        this.name = name;
        this.playerNumber = playerNumber;
    }

    // Getter: lets main read the name without touching the private field.
    public String getName() {
        return name;
    }

    // Setter: lets main change the name later. Required this week even if we do not use it yet.
    public void setName(String name) {
        this.name = name;
    }

    public int getPlayerNumber() {
        return playerNumber;
    }

    public void setPlayerNumber(int playerNumber) {
        this.playerNumber = playerNumber;
    }

    // Java calls this automatically when we print a Player.
    // Without it, the print would look like Player@5e2de80c instead of a name.
    public String toString() {
        return "Player #" + playerNumber + ": " + name;
    }
}
