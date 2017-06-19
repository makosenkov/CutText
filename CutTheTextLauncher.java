import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class CutTheTextLauncher {

    @Option(name = "-c", usage = "Symbols", forbids = {"-w"})
    private boolean symb = false;

    @Option(name = "-w", usage = "Words", forbids = {"-c"})
    private boolean word = false;

    @Option(name = "-o", metaVar = "OutputFile", usage = "output filename")
    private String outputFileName = "";

    @Argument(metaVar = "InputFile", usage = "input filename")
    private String inputFileName = "";

    @Argument(required = true, metaVar = "range", usage = "input range", index = 1)
    private String range = "";

    public static void main(String[] args) {
        new CutTheTextLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar TextCut.jar -c|-w -o OutputFile InputFile range");
            parser.printUsage(System.err);
            return;
        }


        List<String> lines = new ArrayList<>();
        try {

            int begin = 0;
            int end = 0;
            if (range.matches(" -\\d+")) {
                begin = Cutter.myMagicConstant;
                end = Integer.parseInt(range.substring(2));
            }

            if (range.matches("\\d+-")) {
                begin = Integer.parseInt(range.substring(0, range.length() - 1));
                end = Cutter.myMagicConstant;
            }

            if (range.matches("\\d+-\\d+")) {
                begin = Integer.parseInt(range.split("-")[0]);
                end = Integer.parseInt(range.split("-")[1]);
            }
            boolean BeginMoreThanEnd = begin >= end && end != Cutter.myMagicConstant && begin != Cutter.myMagicConstant;
            if (BeginMoreThanEnd) throw new IllegalArgumentException("Wrong range");

            if (word) symb = false;

            try {
                lines = FileWork.readAndCut(inputFileName, begin, end, symb);
            } catch (FileNotFoundException e) {
                System.out.println("Incorrect input file name");
            }

            FileWork.write(lines, outputFileName);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
