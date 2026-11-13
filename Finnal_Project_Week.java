import java.util.Scanner;
import java.util.Random;

public class Finnal_Project_Week { 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in); //scanner using system's keyboard
		Random random = new Random(); //generates random numbers 
		boolean running = true; 
		
		System.out.println("=========== WELCOME TO BINGO GAME ============");
		
		//ask player's info
		System.out.println("Please enter your name: ");
		String name = input.nextLine();
		
		while (running) {
			//Menu List
			System.out.println("\n --- Menu ---");
			System.out.println("1. Draw a bing number");
			System.out.println("2. Quit");
			System.out.println("Enter your choice: ");
			
			//store user's choice 
			int choice = input.nextInt();
			
			//if else statement to determine user's decision
			if (choice == 1) {
                // Draw a random number between 1 and 75
                int number = random.nextInt(75) + 1;
                String letter;

                if (number <= 15) {
                    letter = "B";
                } else if (number <= 30) {
                    letter = "I";
                } else if (number <= 45) {
                    letter = "N";
                } else if (number <= 60) {
                    letter = "G";
                } else {
                    letter = "O";
                }

                System.out.println("Called number: " + letter + "-" + number);

            } else if (choice == 2) {
                System.out.println("Thanks for playing! Goodbye.");
                running = false;

            } else {
                System.out.println("Invalid choice. Please enter 1 or 2");
            }
        }

        input.close();
    }
}