import java.io.*;
import java.util.*;

/**
 * Created by Михаил
 */

public class CutTheText {
    private final boolean symb;
    private final boolean word;
    private String outputFileName;
    private String inputFileName;
    private final String range;

    public CutTheText(boolean symb, boolean word, String outputFileName,
                      String inputFileName, String range) {
        this.symb = symb;
        this.word = word;
        this.outputFileName = outputFileName;
        this.inputFileName = inputFileName;
        this.range = range;
    }

    public void writeCut(String inputFileName, String outputFileName) throws IOException {
        try (FileInputStream inputStream = new FileInputStream(inputFileName)) {
            try (FileOutputStream outputStream = new FileOutputStream(outputFileName, true)) {
                writeCut(inputStream, outputStream);
            }
        }
    }

    public void writeCut(InputStream in, OutputStream out) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out))) {
                int begin = 0;
                int end = 0;

                if (range.matches("-\\d")) {
                    begin = 0;
                    end = Integer.parseInt(range.split("")[1]);
                }

                if (range.matches("\\d-")) {
                    begin = Integer.parseInt(range.split("")[1]);
                    end = 0;
                }

                if (range.matches("\\d-\\d")) {
                    begin = Integer.parseInt(range.split("")[0]);
                    end = Integer.parseInt(range.split("")[2]);
                }

                String line = reader.readLine();
                do {
                    if (symb) line = line.substring(begin, end + 1);

                    if (word) {
                        List<String> words = new ArrayList<>();
                        words.addAll(Arrays.asList(line.split(" ")));
                        words = words.subList(begin, end + 1);
                        for (int i = 0; i < words.size(); i++) {
                            line = "" + words.get(i);
                        }
                    }
                    writer.write(line);
                    line = reader.readLine();
                } while (line != null);
            }
        }
    }
}
