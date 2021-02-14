package org.cengizcan;

import picocli.CommandLine;

public class Main {
    public static void main(String[] args) {
        int exitCode = new CommandLine(new Executer())
                .setAdjustLineBreaksForWideCJKCharacters(true)
                .execute(args);
        System.exit(exitCode);
    }
}
