package org.cengizcan;

import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Option;

import java.util.concurrent.Callable;
@CommandLine.Command(name = "transformer.jar", mixinStandardHelpOptions = true, version = "transformer 0.1",
        description = "Transforms CSV to jSON (for now)")
public class Executer implements Callable<Integer> {
    @ArgGroup(exclusive = true, multiplicity = "1")
    InputOption inputOption;

    static class InputOption {
        @Option(names = {"-i", "--input"}, required = true, description = "User input to transform") String input;
        @Option(names = {"-f", "--file"}, required = true, description = "File to transform") String inputFilePath;
    }
    @Override
    public Integer call() throws Exception {
        return null;
    }
}
