package org.cengizcan.transformer;

import org.cengizcan.writer.OutputWriter;

import java.io.Reader;

public interface Transformer {
    void transform(Reader reader, OutputWriter writer) throws Exception;
}
