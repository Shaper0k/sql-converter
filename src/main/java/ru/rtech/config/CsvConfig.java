package ru.rtech.config;

import static ru.rtech.util.Constant.COLUMN_SEPARATOR;
import static ru.rtech.util.Constant.DELIMITER;
import static ru.rtech.util.Constant.ESCAPE_CHAR;
import static ru.rtech.util.Constant.QUOTE_CHAR;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser.Feature;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.rtech.model.CsvFieldDto;

@Configuration
public class CsvConfig {

    @Bean
    public ObjectReader getObjectReader() {
        CsvMapper csvMapper = new CsvMapper();
        return new CsvMapper()
                .configure(Feature.SKIP_EMPTY_LINES, true)
                .configure(Feature.TRIM_SPACES, true)
                .configure(Feature.FAIL_ON_MISSING_COLUMNS, true)
                .readerFor(CsvFieldDto.class)
                .with(getCsvSchema(csvMapper));
    }

    private CsvSchema getCsvSchema(CsvMapper csvMapper) {
        return csvMapper
                .typedSchemaFor(CsvFieldDto.class)
                .withHeader()
                .withQuoteChar(QUOTE_CHAR)
                .withEscapeChar(ESCAPE_CHAR)
                .withColumnSeparator(COLUMN_SEPARATOR)
                .withArrayElementSeparator(DELIMITER)
                .withComments();
    }

}
