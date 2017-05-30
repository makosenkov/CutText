import java.util.*;

public final class Cutter {
    private boolean symb;
    private int begin;
    private int end;

    public Cutter(boolean symb, int begin, int end) {
        this.symb = symb;
        this.begin = begin;
        this.end = end;
    }

    public ArrayList<String> cut(int begin, int end, ArrayList<String> lines, boolean symb) {
        ArrayList<String> newLines = new ArrayList<>();
        for (String line : lines) {
            StringBuilder builder = new StringBuilder();
            //Посимвольно
            if (symb) {
                if (begin >= line.length()) builder.append("\n");
                else {
                    if (end == 1000) end = line.length();
                    builder.append(line, begin, end);
                    newLines.add(builder.toString());
                }
            } else {
                //По словам
                String[] words = line.split(" ");

                if (begin >= words.length) builder.append("\n");
                else {
                    if (end == 1000) end = words.length;
                    for (int i = begin + 1; i <= end; i++) {
                        builder.append(words[i - 1]);
                        if (i != end) builder.append(" ");
                    }
                    newLines.add(builder.toString());
                }
            }
        }
        return newLines;
    }
}
