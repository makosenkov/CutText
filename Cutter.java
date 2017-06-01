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
            int buf = end;
            StringBuilder builder = new StringBuilder();
            //Посимвольно
            if (symb) {
                if (begin >= line.length()) builder.append("\n");
                else {
                    if (buf == 1000 || buf > line.length()) buf = line.length() - 1;
                    builder.append(line, begin, buf + 1);
                    newLines.add(builder.toString());
                }

            } else {
                //По словам
                String[] words = line.split(" ");

                if (begin >= words.length || line.equals("")) builder.append("\n");
                else {

                    if (buf == 1000 || buf > words.length) buf = words.length;
                    for (int i = begin + 1; i <= buf; i++) {
                        builder.append(words[i - 1]);
                        if (i != buf) builder.append(" ");
                    }
                    newLines.add(builder.toString());
                }
            }
        }
        return newLines;
    }
}
