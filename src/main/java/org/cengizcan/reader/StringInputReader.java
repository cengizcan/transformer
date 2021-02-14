package org.cengizcan.reader;

import java.io.Reader;
import java.io.StringReader;

public class StringInputReader implements InputReader{
    /**
     * Reads console input
     * This approach is verbose for this assessment but in real world here is a good place to validate input
     * like checking script/macro injections
     * @param input
     * @return
     */
    @Override
    public Reader read(String input) {

        return new StringReader(input);
    }
}
