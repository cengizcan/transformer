package org.cengizcan.writer;

public class ConsoleOutputWriter implements OutputWriter{

    /**
     * Writes output to the console
     * @param output
     */
    @Override
    public void write(String output) {
        System.out.println(output);
    }
}
