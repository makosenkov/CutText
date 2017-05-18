import java.io.*;
import java.util.ArrayList;

public final class FileWork {

    public static ArrayList<String> read(String inputFileName) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        if (inputFileName.equals("")) {
            BufferedInputStream inputStream = new BufferedInputStream(System.in);
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line = reader.readLine();
                do {
                    lines.add(line);
                } while (line != null);
                reader.close();
            }
        } else {
            FileInputStream inputStream = new FileInputStream(inputFileName);
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            do {
                lines.add(line);
            } while (line != null);
            reader.close();
        }
        return lines;
    }


    public static void write(ArrayList<String> newLines, String outputFileName) throws IOException {
        try (FileOutputStream outputStream = new FileOutputStream(outputFileName)) {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                for (String line : newLines) {
                    writer.write(line);
                    writer.newLine();
                }
                writer.close();
            }
        }
    }

}

