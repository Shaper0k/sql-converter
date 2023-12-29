package ru.rtech.service.impl;

import static ru.rtech.util.Constant.CHARSET;
import static ru.rtech.util.Constant.ErrorText.CSV_FORMAT_IS_NOT_CORRECT;
import static ru.rtech.util.Constant.ErrorText.CSV_IS_NOT_CORRECT;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvReadException;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.rtech.model.CsvFieldDto;
import ru.rtech.service.CsvReadService;
import ru.rtech.util.exception.FileNotCorrectException;

@Service
@RequiredArgsConstructor
public class CsvReadServiceImpl implements CsvReadService {

    private final ObjectReader objectReader;

    @Override
    public List<CsvFieldDto> getValuesFieldCsv(MultipartFile file) {
        List<CsvFieldDto> fieldsDto;
        try {
            fieldsDto = read(file.getInputStream());
        } catch (IOException e) {
            throw new FileNotCorrectException(e.getMessage());
        }
        return fieldsDto;
    }

    private List<CsvFieldDto> read(InputStream stream) {
        List<CsvFieldDto> csvFieldDtoList;
        try {
            Charset charset = Charset.forName(CHARSET);
            csvFieldDtoList = objectReader.<CsvFieldDto>readValues(new InputStreamReader(stream, charset)).readAll();
        } catch (CsvReadException csvReadException) {
            throw new FileNotCorrectException(CSV_FORMAT_IS_NOT_CORRECT + " " + csvReadException.getMessage());
        } catch (IOException e) {
            throw new FileNotCorrectException(CSV_IS_NOT_CORRECT);
        }
        return csvFieldDtoList;
    }

}
