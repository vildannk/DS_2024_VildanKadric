package homework3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileUtils {


    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            for (Entry entry : entries) {
                bufferedWriter.write(entry.toString());
                bufferedWriter.newLine();
            }
        }
    }

    public static RedBlackTree readFile(String filePath) throws IOException {
        RedBlackTree tree = new RedBlackTree();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = parseLine(line);
                if (data.length == 7) {
                    Entry entry = new Entry(data[0], data[1], data[2], data[3], data[4], data[5], data[6]);
                    tree.put(entry.getName(), entry);
                }
            }
        }
        return tree;
    }

    private static String[] parseLine(String line) {
        List<String> result = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        char[] dontNeed = {',', ';'};
        boolean inQuotes = false;

        for (char ch : line.toCharArray()) {
            if (ch == '\"') {
                inQuotes = !inQuotes;
            } else if (!inQuotes && (ch == dontNeed[0] || ch == dontNeed[1])) {
                result.add(stringBuilder.toString().trim());
                stringBuilder.setLength(0);
            } else {
                stringBuilder.append(ch);
            }
        }
        result.add(stringBuilder.toString().trim());

        return result.toArray(new String[0]);
    }
}
