package homework3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PhonebookV2 {
    public static void main(String[] args) {
        try {
            RedBlackTree tree = FileUtils.readFile("raw_phonebook_data.csv");
            int[] counts = tree.countRedAndBlackEdges();
            System.out.println("Red edges: " + counts[1] + ", Black edges: " + counts[0]);

            Scanner scanner = new Scanner(System.in);
            String name;

            do {
                System.out.print("Enter 'Surname, Name' to search, or '-1' to quit: ");
                name = scanner.nextLine();

                if (!name.equals("-1")) {
                    ArrayList<Entry> entries = tree.get(name);
                    if (entries != null) {
                        System.out.println("Found " + entries.size() + " entries:");
                        for (Entry entry : entries) {
                            System.out.println(entry);
                        }
                    } else {
                        System.out.println("Entry not found.");
                    }
                }
            } while (!name.equals("-1"));

            scanner.close();
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
}