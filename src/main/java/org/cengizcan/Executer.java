package org.cengizcan;

import org.apache.commons.text.StringEscapeUtils;
import org.cengizcan.transformer.CsvToJsonTransformer;
import org.cengizcan.reader.FileInputReader;
import org.cengizcan.reader.StringInputReader;
import org.cengizcan.writer.ConsoleOutputWriter;
import org.cengizcan.writer.FileOutputWriter;
import org.cengizcan.writer.OutputWriter;
import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Option;

import java.io.Reader;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "transformer.jar", mixinStandardHelpOptions = true, version = "transformer 0.1",
        description = "Transforms CSV to jSON (for now)")
public class Executer implements Callable<Integer> {

    private final static String ERROR_HEADER = "AN ERROR OCCURRED:";

    @ArgGroup(exclusive = true, multiplicity = "1")
    InputOption inputOption;

    static class InputOption {
        @Option(names = {"-i", "--input"}, required = true, description = "User input to transform")
        String input;
        @Option(names = {"-f", "--file"}, required = true, description = "Path of the file to transform")
        String inputFilePath;
    }

    @Option(names = {"-of", "--out-file"}, description = "If set output will be written to the given path instead of console")
    String outputFilePath;

    /**
     * Creates and executes CsvToJsonTransformer with requested reader and writer type
     * @return
     */
    @Override
    public Integer call() {
        try {
            new CsvToJsonTransformer().transform(createReader(inputOption), createOutputWriter(outputFilePath));
            return 0;
        } catch (Exception e) {
            System.err.println(ERROR_HEADER);
            System.err.println(e.getMessage());
            return 1;
        }
    }

    private Reader createReader(InputOption options) throws Exception {
        if(options.input != null) return new StringInputReader().read(StringEscapeUtils.unescapeJava(options.input));
        if(options.inputFilePath != null) return new FileInputReader().read(options.inputFilePath);
        throw new Exception("This should not be happen");
    }

    private OutputWriter createOutputWriter(String path) {
        if(path != null) return new FileOutputWriter(path);
        else return new ConsoleOutputWriter();
    }
}
