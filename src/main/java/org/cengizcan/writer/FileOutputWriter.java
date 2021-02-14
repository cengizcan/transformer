package org.cengizcan.writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileOutputWriter implements OutputWriter{
    private final String path;

    public FileOutputWriter(String path) {
        this.path = path;
    }

    /**
     * Writes output to the file
     * @param output
     * @throws IOException
     */
    @Override
    public void write(String output) throws IOException {
        try (var bw = new BufferedWriter(new FileWriter(this.path))) {
            bw.write(output);
        }
    }
}
