import java.util.*;


/**
 * Created by Михаил on 26.04.2017.
 */

public final class Cutter {
    private boolean symb;
    private rangeParser newRange;

    public Cutter(boolean symb, rangeParser newRange) {
        this.symb = symb;
        this.newRange = newRange;
    }

    public ArrayList<String> cut(rangeParser newRange, ArrayList<String> lines) {
//нужно переделать полностью, использовать StringBuilder
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
