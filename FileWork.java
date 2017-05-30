import java.io.*;
import java.util.ArrayList;

public final class FileWork {

    public static ArrayList<String> read(String inputFileName) throws IOException {
        InputStream in;
        if (inputFileName.equals("")) {
            in = System.in;
        } else {
            File file = new File(inputFileName);
            in = new FileInputStream(file);
        }
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        String line = reader.readLine();
        while (line != null) {
            lines.add(line);
            line = reader.readLine();
        }

        if (lines.size() == 0) throw new IndexOutOfBoundsException();
        return lines;
    }

    public static void write(ArrayList<String> newLines, String outputFileName) throws IOException {
        OutputStream out;
        if (outputFileName.equals("")) {
            out = System.out;
        } else {
            File file = new File(outputFileName);
            out = new FileOutputStream(file);
        }
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

        for (String line : newLines) {
            writer.write(line);
            writer.newLine();
        }

        writer.close();
    }
}



