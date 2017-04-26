import java.util.*;

/**
 * Created by Михаил on 26.04.2017.
 */
public final class TextCmdReader {
    public static String[] read(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<String> lines = new ArrayList<>();
        do{
            lines.add(in.nextLine());
        }while(!in.hasNext());
        return lines.toArray(new String[lines.size()]);
    }
}
