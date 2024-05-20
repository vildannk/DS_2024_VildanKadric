package homework1;


import java.io.IOException;
import java.util.Scanner;

public class PhonebookV1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Entry[] entries;

        try {
            entries = FileUtils.readFile("C:/Users/edind/Desktop/DS/Homework1/homework1/raw_phonebook_data.csv");
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
            return;
        }

        MergeSort.sort(entries);

        try {
            FileUtils.writeToFile(entries, "C:/Users/edind/Desktop/DS/Homework1/homework1/output.csv");
        } catch (IOException e) {
            System.err.println("Error writing output file: " + e.getMessage());
            return;
        }

        while (true) {
            System.out.print("Enter name that you wish to search for, or -1 to exit: ");
            String name = scanner.nextLine();
            System.out.println();

            if (name.equals("-1")) {
                System.out.println("Thank you for using the phonebook");
                break;
            }

            int[] range = BinarySearch.search(entries, name);

            if (range.length == 0) {
                System.out.println("No entries with the given name exist in phonebook. \n");
            } else {
                System.out.println("Entries found: " + (range[1] - range[0] + 1)+ "\n");
                for (int i = range[0]; i <= range[1]; i++) {
                    System.out.println(entries[i]);
                }
            }
        }

        scanner.close();
    }
}

