package homework1;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    public static Entry[] readFile(String filePath) throws IOException {
        List<Entry> entries = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line = br.readLine(); // Skip header
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(";");
            if (fields.length == 6) {
                Entry entry = new Entry(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]);
                entries.add(entry);
            }
        }
        br.close();
        return entries.toArray(new Entry[0]);
    }

    public static void writeToFile(Entry[] entries, String filePath) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
        bw.write("Name;Street Address;City;Postcode;Country;Phone Number\n");
        for (Entry entry : entries) {
            bw.write(entry.toString() + "\n");
        }
        bw.close();
    }
}
