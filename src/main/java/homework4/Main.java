package homework4;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        // Specify the path to the CSV file
        String filePath = "C:\\Users\\selma\\Downloads\\social_network.csv";
        Scanner fileScanner = new Scanner(new File(filePath));

        // Initialize the social network with the data from the CSV file
        SocialNetwork network = new SocialNetwork(fileScanner);
        fileScanner.close();

        // Print network loading information
        System.out.println("Loading in the social network...");
        System.out.println("Network successfully loaded.");
        System.out.println("Total users: " + network.V);
        System.out.println("Total friendships: " + network.E);  // Check the initial count of friendships
        System.out.println("=====================================");

        Scanner inputScanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter a name to recommend for, or -1 to exit: ");
            String name = inputScanner.nextLine();
            if (name.equals("-1")) {
                System.out.println("Thank you for using our friendship recommender algorithm.");
                break;
            }

            // Get friend recommendations for the entered name
            ArrayList<FriendshipRecommendation> recommendations = network.recommendFriends(name);
            if (recommendations.isEmpty()) {
                System.out.println("The user you are looking for does not exist in the network.");
            } else {
                System.out.println("Total recommendations: " + recommendations.size());
                System.out.println("Top 10 recommendations based on friendship strength:");
                for (int i = 0; i < Math.min(10, recommendations.size()); i++) {
                    System.out.println(recommendations.get(i));
                }
            }
        }
        inputScanner.close();
    }
}
