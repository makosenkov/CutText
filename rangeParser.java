/**
 * Created by Михаил on 11.05.2017.
 */
//Вспомогательный класс для разрора диапазона (начало с 0)
public final class rangeParser {
    private int begin;
    private int end;

    public rangeParser(int begin, int end){
        this.begin = begin;
        this.end = end;
    }
//доделать и решить проблему с полями, учесть большие диапазоны
//должен помочь Math.max
    public rangeParser parse (String range) {
        int begin = 0;
        int end = range.length();
        if (range.matches("-[\\d+]")) {
            end = Integer.parseInt(range.substring(1));
        }

        if (range.matches("[\\d+]-")) {
            begin = Integer.parseInt(range.substring(range.length() - 1));
        }

        if (range.matches("[\\d+]-[\\d+]")) {
            begin = Integer.parseInt(range.split("-")[0]);
            end = Integer.parseInt(range.split("-")[1]);
        }
        rangeParser newRange = new rangeParser(begin, end);
        return newRange;
    }
}
