package org.cengizcan.transformer;

import com.opencsv.bean.CsvToBeanBuilder;
import org.cengizcan.model.CsvToJsonModel;
import org.cengizcan.writer.OutputWriter;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Reader;
import java.util.HashMap;
import java.util.List;

public class CsvToJsonTransformer implements Transformer {

    private final static String MAP_KEY = "person";

    /**
     * Transforms CSV to JSON and writes result to supplied writer
     * @param reader
     * @param writer
     * @throws Exception
     */
    @Override
    public void transform(Reader reader, OutputWriter writer) throws Exception {

        var list = new CsvToBeanBuilder(reader).withType(CsvToJsonModel.class).build().parse();
        if(list == null || list.size() == 0) throw new Exception("Transform failed");
        // hack for required JSON format
        var map = new HashMap<String, List<CsvToJsonModel>>();
        map.put(MAP_KEY, list);

        var mapper = new ObjectMapper();
        var str = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map);
        writer.write(str);
    }
}
