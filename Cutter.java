import java.util.*;


/**
 * Created by Михаил on 26.04.2017.
 */

public final class Cutter {
    private final boolean symb;
    private final boolean word;
    private final String range;

    public Cutter(boolean symb, boolean word, String range) {
        this.symb = symb;
        this.word = word;
        this.range = range;
    }

    public String[] cut(String range, String[] lines) {
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

        ArrayList<String> newLines = new ArrayList<>();

        for (int i = 0; i < lines.length - 2; i++) {
            if (symb) newLines.add(lines[i].substring(begin, end + 1));

            if (word) {
                List<String> words = new ArrayList<>();
                words.addAll(Arrays.asList(lines[i].split(" ")));
                words = words.subList(begin, end + 1);
                String line = "";
                for (int k = 0; k < words.size() - 2; k++) {
                    line += words.get(k) + " ";
                }
                line += words.get(words.size() - 1);
                newLines.add(line);
            }
        }
        return newLines.toArray(new String[newLines.size()]);
    }
}
