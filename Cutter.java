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
        //Вычисление диапазона
        int buf;
        if (symb) {
            buf = lines.get(0).length();
            for (int i = 0; i < lines.size() - 1; i++) {
                if (lines.get(i).length() > buf) buf = lines.get(i).length();
            }
        } else {
            buf = lines.get(0).split(" ").length;
            for (int i = 0; i < lines.size() - 1; i++) {
                if (lines.get(i).split(" ").length > buf) buf = lines.get(i).split(" ").length;
            }
        }
        boolean BeginIsWrong = (begin >= buf);
        if (BeginIsWrong) throw new IndexOutOfBoundsException();
        end = Math.min(buf, end);
        //Нарезка строки
        ArrayList<String> newLines = new ArrayList<>();

        for (String line : lines) {
            StringBuilder builder = new StringBuilder();
            //Посимвольно
            if (symb) {
                builder.append(line, begin, end);
                newLines.add(builder.toString());
            }
            else {
                //По словам
                String[] words = line.split(" ");
                for (int i = begin; i <= end; i++) {
                    builder.append(words[i - 1]);
                    if (i != end) builder.append(" ");
                }
                newLines.add(builder.toString());
            }
        }
        return newLines;
    }
}
