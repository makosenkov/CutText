import java.io.*;
import java.util.ArrayList;

public final class FileWork {

    public static ArrayList<String> read(String inputFileName) throws IOException {
        InputStream in = null;
        if (inputFileName.equals("")) {
            in = System.in;
        } else {
            File file = new File(inputFileName);
            in = new FileInputStream(file);
        }
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = reader.readLine();
        while ( line != null)
        {
            lines.add(line);
            line = reader.readLine();
        }
        if (lines.size() == 0) throw new IndexOutOfBoundsException();
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
        }catch (FileNotFoundException e) {
            for (String line: newLines) {
                System.out.println(line);
            }
        }
    }

}

