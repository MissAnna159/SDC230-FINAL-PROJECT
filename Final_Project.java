import java.util.ArrayList; //a normal variable holds one thing. ArrayList let you put object in it and you can look at them later.
import java.util.Random;
import java.util.Scanner;

public class Final_Project {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        // ArrayList is a list that can grow.
        ArrayList<Player> players = new ArrayList<Player>(); //players holds Player objects. 
        ArrayList<BingoCall> calledNumbers = new ArrayList<BingoCall>(); //calledNumbers (Arraylist) holds BingoCalls.

        int choice = 0;

        // Starts at 1 so the first player added becomes Player #1, then #2, and so on.
        int nextPlayerNumber = 1;

        System.out.println("********************************");
        System.out.println("*   WELCOME TO BINGO NIGHT!    *");
        System.out.println("********************************");
        System.out.println();

        // Same loop idea as Week 1. It stays open until the user picks Quit.
        while (choice != 5) {

            System.out.println("--- Bingo Menu ---");
            System.out.println("1. Add a player");
            System.out.println("2. Display players");
            System.out.println("3. Draw a bingo number");
            System.out.println("4. Display called numbers");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            // Week 1 crashed if the user typed abc. This checks first.
            if (!input.hasNextInt()) { //! means not, !input.hasNext.Int means the scanner did not detect a number, this will run
                System.out.println("Please enter a number from the menu."); //tells the user they need to enter a number
                input.nextLine(); //give them a chance to enter a number again
                System.out.println(); //print the number
                continue; //this loop will continues to prevent the system crash
            }

            choice = input.nextInt(); // nextInt() reads the number but leaves the Enter key sitting in the scanner.
            
            input.nextLine(); // nextLine() throws that leftover Enter away. Without this, the name prompt is skipped.
            System.out.println();

            if (choice == 1) {

                System.out.print("Enter player name: ");
                String name = input.nextLine().trim(); // trim() removes extra spaces. An empty name should not become a player.
                if (name.isEmpty()) {
                    System.out.println("Name cannot be blank.");
                    System.out.println();

                } else {
                    Player newPlayer = new Player(name, nextPlayerNumber);

                    // add() puts that object into the list so we still have it after this menu choice ends.
                    players.add(newPlayer);
                    nextPlayerNumber++; //add in players to keep track total players

                    System.out.println(newPlayer.getName() + " was added to the game.");
                    System.out.println();
                }

            } else if (choice == 2) {

                // isEmpty() is true when nobody has been added yet.
                if (players.isEmpty()) {
                    System.out.println("No players have been added yet.");

                } else {
                    System.out.println("--- Players ---");

                    // For each Player object stored in the list, print it.
                    // Printing the object runs toString() in the Player class.
                    for (Player player : players) {
                        System.out.println(player);
                    }
                }
                System.out.println();

            } else if (choice == 3) {

                // A Bingo game only has 75 balls. Stop when the list already has all of them.
                if (calledNumbers.size() >= 75) {
                    System.out.println("All 75 numbers have already been called.");
                    System.out.println();

                } else {
                    int number;
                    boolean alreadyCalled;

                    // Week 1 could call the same number twice because it never saved the calls.
                    // This keeps drawing until it gets a number that is not already in the list.
                    do {
                        number = rand.nextInt(75) + 1;
                        alreadyCalled = false;

                        for (BingoCall call : calledNumbers) {
                            if (call.getNumber() == number) {
                                alreadyCalled = true;
                                break;
                            }
                        }
                    } while (alreadyCalled);

                    // Constructor stores the number and picks B, I, N, G, or O.
                    BingoCall newCall = new BingoCall(number);
                    calledNumbers.add(newCall);

                    System.out.println("Called number: " + newCall);
                    System.out.println("Numbers called so far: " + calledNumbers.size());
                    System.out.println();
                }

            } else if (choice == 4) {

                if (calledNumbers.isEmpty()) {
                    System.out.println("No numbers have been called yet.");

                } else {
                    System.out.println("--- Called Numbers ---");

                    for (BingoCall call : calledNumbers) {
                        System.out.println(call);
                    }
                }
                System.out.println();

            } else if (choice == 5) {

                System.out.println("Thanks for playing Bingo!");

            } else {

                System.out.println("Invalid choice. Please try again.");
                System.out.println();
            }
        }

        input.close();
    }
}
