package com.demo.poc.commons;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

public class CsvReader {

    public static List<CSVRecord> getRecords(String filePath, char delimiter) throws IOException {
        InputStream inputStream = CsvReader.class.getResourceAsStream(filePath);
        InputStreamReader reader = new InputStreamReader(inputStream);
        CSVFormat csvFormat = CSVFormat.newFormat(delimiter).withHeader().withTrim();
        CSVParser csvParser = new CSVParser(reader, csvFormat);
        return csvParser.getRecords();
    }

}
