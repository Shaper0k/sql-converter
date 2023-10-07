package ru.rtech.service.impl;

import static ru.rtech.util.Constant.CHARSET;
import static ru.rtech.util.Constant.QueryText.START_SUBQUERY_TEXT;
import static ru.rtech.util.Constant.QueryText.SUBQUERY_TEXT_INPUT;

import com.fasterxml.jackson.databind.ObjectReader;
import com.fasterxml.jackson.dataformat.csv.CsvReadException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.rtech.model.CsvFieldDto;
import ru.rtech.model.RequestBodyFieldDto;
import ru.rtech.service.FileService;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final ObjectReader objectReader;

    @Override
    public Resource convertSVCToSQLScriptFile(MultipartFile file, RequestBodyFieldDto requestDto) {
        var csvField = getValuesFieldCsv(file);
        var stringBuilder = new StringBuilder();
        stringBuilder.append(START_SUBQUERY_TEXT);
        var a = csvField.stream()
                .map(CsvFieldDto::getFieldValueFour)
                .distinct()
                .toList();
        var subQueryParam = csvField.stream()
                .map(CsvFieldDto::getFieldValueFour)
                .distinct()
                .map(string ->
                        stringBuilder.append(SUBQUERY_TEXT_INPUT.formatted(
                                string.replace("\\.", "_") + "_FIELD",
                                requestDto.getSubQueryName(),
                                requestDto.getSubQueryName().
                                        substring(requestDto.getSubQueryName().lastIndexOf(".") + 1),
                                string))
                )
                .toList();
        System.out.println(stringBuilder);

        return null;
    }

    private List<CsvFieldDto> getValuesFieldCsv(MultipartFile file) {
        List<CsvFieldDto> fieldsDto;
        try {
            fieldsDto = read(file.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fieldsDto;
    }

    public List<CsvFieldDto> read(InputStream stream) {
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
