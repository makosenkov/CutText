import java.io.*;
import java.util.ArrayList;

/**
 * Created by Михаил on 26.04.2017.
 */

public final class FileWork {

//всунуть чтение из консоли

    public static ArrayList<String> read(String inputFileName) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
         try (FileInputStream inputStream = new FileInputStream(inputFileName)) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line = reader.readLine();
                do {
                    lines.add(line);
                } while (line != null);
            }
        }
        return lines;
    }


    public static void write(ArrayList<String> newLines, String outputFileName) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(outputFileName)) {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                for (int i = 0; i < newLines.size() - 1; i++) {
                    writer.write(newLines[i]);
                }
                writer.close();
            }
        }
    }

}

