package org.cengizcan.reader;

import java.io.FileNotFoundException;
import java.io.Reader;

public interface InputReader {
    Reader read(String input) throws FileNotFoundException;
}
