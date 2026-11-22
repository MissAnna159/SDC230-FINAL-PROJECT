package SDC230_Final_Project;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Finnal_Project_Week {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();

        ArrayList<Player> players = new ArrayList<Player>();
        ArrayList<BingoCall> calledNumbers = new ArrayList<BingoCall>();

        int choice = 0;
        int nextPlayerNumber = 1;

        System.out.println("********************************");
        System.out.println("*   WELCOME TO BINGO NIGHT!    *");
        System.out.println("********************************");
        System.out.println();

        while (choice != 5) {
            System.out.println("--- Bingo Menu ---");
            System.out.println("1. Add a player");
            System.out.println("2. Display players");
            System.out.println("3. Draw a bingo number");
            System.out.println("4. Display called numbers");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            if (!input.hasNextInt()) {
                System.out.println("Please enter a number from the menu.");
                input.nextLine();
                System.out.println();
                continue;
            }

            choice = input.nextInt();
            input.nextLine();
            System.out.println();

            switch (choice) {
                case 1:
                    System.out.print("Enter player name: ");
                    String name = input.nextLine().trim();

                    if (name.isEmpty()) {
                        System.out.println("Name cannot be blank.");
                        System.out.println();
                        break;
                    }

                    Player newPlayer = new Player(name, nextPlayerNumber);
                    players.add(newPlayer);
                    nextPlayerNumber++;

                    System.out.println(newPlayer.getName() + " was added to the game.");
                    System.out.println();
                    break;

                case 2:
                    if (players.isEmpty()) {
                        System.out.println("No players have been added yet.");
                    } else {
                        System.out.println("--- Players ---");
                        for (Player player : players) {
                            System.out.println(player);
                        }
                    }
                    System.out.println();
                    break;

                case 3:
                    if (calledNumbers.size() >= 75) {
                        System.out.println("All 75 numbers have already been called.");
                        System.out.println();
                        break;
                    }

                    int number;
                    boolean alreadyCalled;

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

                    BingoCall newCall = new BingoCall(number);
                    calledNumbers.add(newCall);

                    System.out.println("Called number: " + newCall);
                    System.out.println("Numbers called so far: " + calledNumbers.size());
                    System.out.println();
                    break;

                case 4:
                    if (calledNumbers.isEmpty()) {
                        System.out.println("No numbers have been called yet.");
                    } else {
                        System.out.println("--- Called Numbers ---");
                        for (BingoCall call : calledNumbers) {
                            System.out.println(call);
                        }
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Thanks for playing Bingo!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    System.out.println();
                    break;
            }
        }

        input.close();
    }
}
