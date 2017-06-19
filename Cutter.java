import java.util.*;

public final class Cutter {
    private boolean symb;
    private int begin;
    private int end;
    static final int myMagicConstant = -1;

    public Cutter(boolean symb, int begin, int end) {
        this.symb = symb;
        this.begin = begin;
        this.end = end;
    }

    public String cut(String line) {
        int buf = end;
        StringBuilder builder = new StringBuilder();
        //Посимвольно
        if (symb) {
            if (begin < line.length()){
                if (buf == Cutter.myMagicConstant || buf > line.length()) buf = line.length() - 1;
                builder.append(line, begin+1, buf+1);
            }
            else return  null;
        } else {
            //По словам
            String[] words = line.split(" ");
            if (begin >= words.length || line.equals("")) return  null;
            else {
                if (buf == Cutter.myMagicConstant || buf > words.length) buf = words.length;
                if (begin == Cutter.myMagicConstant) begin = 0;
                for (int i = begin + 1; i <= buf; i++) {
                    builder.append(words[i - 1]);
                    if (i != buf) builder.append(" ");
                }
            }
        }
        return builder.toString();
    }
}
