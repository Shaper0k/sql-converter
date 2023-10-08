package ru.rtech.service.impl;

import static ru.rtech.util.Constant.CHARSET;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvReadException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.rtech.model.CsvFieldDto;
import ru.rtech.service.CsvReadService;

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
            throw new RuntimeException(e);
        }
        return fieldsDto;
    }

    private List<CsvFieldDto> read(InputStream stream) {
        List<CsvFieldDto> csvFieldDtoList;

        try {
            csvFieldDtoList = objectReader.<CsvFieldDto>readValues(new InputStreamReader(stream, CHARSET)).readAll();
        } catch (CsvReadException csvReadException) {
            throw new RuntimeException();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return csvFieldDtoList;
    }

}
