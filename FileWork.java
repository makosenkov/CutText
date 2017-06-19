import java.io.*;
import java.util.ArrayList;
import java.util.List;

public final class FileWork {

    public static List<String> readAndCut(String inputFileName, int begin, int end, boolean symb) throws IOException {
        InputStream in;
        if (inputFileName.equals("")) {
            in = System.in;
        } else {
            File file = new File(inputFileName);
            in = new FileInputStream(file);
        }
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            String line = reader.readLine();
            Cutter cutter = new Cutter(symb, begin, end);
            while (line != null) {
                String newLine = cutter.cut(line);
                if (newLine != null) lines.add(newLine);
                line = reader.readLine();
            }
            return lines;
        }
    }

    public static void write(List<String> lines, String outputFileName) throws IOException {
        OutputStream out;
        if (outputFileName.equals("")) {
            out = System.out;
        } else {
            File file = new File(outputFileName);
            out = new FileOutputStream(file);
        }
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}



