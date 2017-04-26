import java.io.*;
import java.util.ArrayList;

/**
 * Created by Михаил on 26.04.2017.
 */

public final class FileWork {
    public static String[] read(String inputFileName) throws IOException {
        File file = new File(inputFileName);
        if (!file.exists() || file.isDirectory()) throw new FileNotFoundException();
        ArrayList<String> lines = new ArrayList<>();
        try (FileInputStream inputStream = new FileInputStream(inputFileName)) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line = reader.readLine();
                do {
                    lines.add(line);
                } while (line != null);
            }
        }
        return lines.toArray(new String[lines.size()]);
    }

    public static void write(String[] newLines, String outputFileName) throws IOException {
        File file = new File(outputFileName);
        if (file.exists() || file.isDirectory()) throw new FileNotFoundException();
        try (FileOutputStream outputStream = new FileOutputStream(outputFileName)) {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                for(int i = 0; i < newLines.length - 1; i++){
                    writer.write(newLines[i]);
                }
                writer.close();
            }
        }
    }

}

