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
        int buf = lines.get(0).length();

        for (int i = 0; i < lines.size() - 1; i++) {
            if (lines.get(i).length() > buf) buf = lines.get(i).length();
        }

        boolean BeginIsWrong = (begin > buf);
        if (BeginIsWrong) throw new IndexOutOfBoundsException();
        end = Math.min(buf, end);

        ArrayList<String> newLines = new ArrayList<>();
        StringBuilder builder = new StringBuilder();

        for (String line : lines) {
            //Посимвольно
            if (symb) builder.append(line, begin, end);
            else {
                //По словам
                String[] words = line.split(" ");
                for (int i = begin; i <= end; i++)
                    builder.append(words[i]);
            }
            newLines.add(builder.toString());
        }
        return newLines;
    }
}
