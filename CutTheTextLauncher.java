/**
 * Created by Михаил
 */

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.FileNotFoundException;
import java.io.IOException;

public final class CutTheTextLauncher {
    @Option(name = "-c", usage = "Symbols")
    private boolean symb = false;

    @Option(name = "-w", usage = "Words")
    private boolean word = false;

    @Option(name = "-o", metaVar = "OutputFile", usage = "output filename")
    private String outputFileName = "";

    @Argument(metaVar = "InputName", usage = "input filename")
    private String inputFileName = "";

    @Argument(metaVar = "range", usage = "input range")
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
            System.err.println("java -jar TextCut.jar [-c|-w] [-o ofile] [file] range");
            parser.printUsage(System.err);
            return;
        }

        try {
            if ((symb && word) || (!symb && !word)) System.out.println("Wrong format (-c or -w)");

            String[] lines;

            if (inputFileName.equals("")) lines = TextCmdReader.read();
            else{
                try {
                    lines = FileWork.read(inputFileName);
                } catch (FileNotFoundException e) {
                    System.out.println("Incorrect input file name");
                }
            }

            String[] newLines = Cutter.cut(range, lines);

            try {
                FileWork.write(newLines, outputFileName);
            }catch (FileNotFoundException){
                System.out.println("Incorrect output file name");
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
