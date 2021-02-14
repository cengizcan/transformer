package org.cengizcan.reader;

import java.io.*;

public class FileInputReader implements InputReader{

    /**
     * Reads source file
     * @param input
     * @return BufferedReader
     * @throws FileNotFoundException
     */
    @Override
    public Reader read(String input) throws FileNotFoundException {
        File file = new File(input);
        return new BufferedReader(new FileReader(file));
    }
}
