package ru.rtech.service.impl;

import static ru.rtech.util.Constant.POINT;
import static ru.rtech.util.Constant.QueryText.END_INSERT_QUERY_TEXT;
import static ru.rtech.util.Constant.QueryText.INSERT_QUERY_TEXT;
import static ru.rtech.util.Constant.QueryText.START_SUBQUERY_TEXT;
import static ru.rtech.util.Constant.QueryText.SUBQUERY_TEXT_INPUT;
import static ru.rtech.util.FieldUtils.getNeededConstantField;
import static ru.rtech.util.FieldUtils.getSQLValuesInStringBuilder;
import static ru.rtech.util.FieldUtils.setInNeededConstantField;
import static ru.rtech.util.StringUtils.getStringParamWithPostfix;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.rtech.model.CsvFieldDto;
import ru.rtech.model.FieldContext;
import ru.rtech.model.RequestBodyFieldDto;
import ru.rtech.service.CsvReadService;
import ru.rtech.service.FileService;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final CsvReadService csvReadService;

    @Override
    public Resource convertSVCToSQLScriptFile(MultipartFile file, RequestBodyFieldDto requestDto) {
        var csvField = csvReadService.getValuesFieldCsv(file);
        var context = new FieldContext(new StringBuilder(START_SUBQUERY_TEXT));
        distinctSubQueryValue(csvField, requestDto, context);
        addInsertTextInStringBuilder(context, requestDto);
        updateSubQueryField(csvField, requestDto);
        csvField.forEach(fields -> getSQLValuesInStringBuilder(fields, requestDto, context));
        endTextInStringBuilder(context);
        System.out.println(context.getAllSqlQueryStringBuilder().toString());
        return null;
    }

    private void getStringBuilderWithFirstParams(String paramValue, RequestBodyFieldDto requestDto,
                                                 FieldContext context) {
        context.getAllSqlQueryStringBuilder().append(SUBQUERY_TEXT_INPUT.formatted(
                getStringParamWithPostfix(paramValue),
                requestDto.getSubQueryName(),
                requestDto.getSubQueryName().
                        substring(requestDto.getSubQueryName().lastIndexOf(POINT) + 1), paramValue));
    }

    private void addInsertTextInStringBuilder(FieldContext context, RequestBodyFieldDto requestDto) {
        context.getAllSqlQueryStringBuilder()
                .append(INSERT_QUERY_TEXT.formatted(requestDto.getDbName() + POINT + requestDto.getSchemeName(),
                        requestDto.getValuesText()));
    }

    private void distinctSubQueryValue(List<CsvFieldDto> csvField, RequestBodyFieldDto requestDto,
                                       FieldContext context) {
        var subQueryParam = csvField.stream()
                .map(fields -> getNeededConstantField(requestDto, fields))
                .distinct()
                .toList();
        subQueryParam.forEach(string -> getStringBuilderWithFirstParams(string, requestDto, context));
    }

    private void updateSubQueryField(List<CsvFieldDto> csvField, RequestBodyFieldDto requestDto) {
        for (CsvFieldDto dto : csvField) {
            setInNeededConstantField(requestDto, dto);
        }
    }

    private void endTextInStringBuilder(FieldContext context) {
        var sb = context.getAllSqlQueryStringBuilder();
        sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",") + 1, ";")
                .append(END_INSERT_QUERY_TEXT);
    }

}
