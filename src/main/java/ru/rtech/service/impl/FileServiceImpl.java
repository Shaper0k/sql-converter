package ru.rtech.service.impl;

import static ru.rtech.util.Constant.BRANCH;
import static ru.rtech.util.Constant.COMMA;
import static ru.rtech.util.Constant.CUSTOM_PATH_STRING;
import static ru.rtech.util.Constant.DEFAULT_SIZE_FOR_INSERT;
import static ru.rtech.util.Constant.ErrorText.BAD_REQUEST_ERROR_MESSAGE;
import static ru.rtech.util.Constant.PARENT_GUID;
import static ru.rtech.util.Constant.PATH_STRING;
import static ru.rtech.util.Constant.POINT;
import static ru.rtech.util.Constant.QueryText.END_INSERT_QUERY_TEXT;
import static ru.rtech.util.Constant.QueryText.INSERT_QUERY_TEXT;
import static ru.rtech.util.Constant.QueryText.START_SUBQUERY_TEXT;
import static ru.rtech.util.Constant.QueryText.SUBQUERY_TEXT_INPUT;
import static ru.rtech.util.Constant.QueryText.UPDATE_NETWORK_QUERY_TEXT;
import static ru.rtech.util.Constant.QueryText.UPDATE_TERRITORY_QUERY_TEXT;
import static ru.rtech.util.Constant.STRING_SEPARATOR;
import static ru.rtech.util.FieldUtils.getNeededConstantField;
import static ru.rtech.util.FieldUtils.getSQLValuesInStringBuilder;
import static ru.rtech.util.FieldUtils.setInNeededConstantField;
import static ru.rtech.util.StringUtils.getStringParamWithPostfix;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.rtech.model.CsvFieldDto;
import ru.rtech.model.FieldContext;
import ru.rtech.model.RequestBodyFieldDto;
import ru.rtech.service.CsvReadService;
import ru.rtech.service.FileService;
import ru.rtech.util.exception.BadRequestException;
import ru.rtech.util.exception.BadReturnFileException;
import ru.rtech.validator.NotNullFieldsValidator;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final CsvReadService csvReadService;
    private final NotNullFieldsValidator validator;

    @Override
    public void convertSVCToSQLScriptFile(MultipartFile file, RequestBodyFieldDto requestDto) {
        var csvField = csvReadService.getValuesFieldCsv(file);
        if (csvField.size() > DEFAULT_SIZE_FOR_INSERT) {
            int fileIterator = 1;
            for (int i = 0; i < csvField.size(); i += DEFAULT_SIZE_FOR_INSERT) {
                var context = new FieldContext(new StringBuilder(), new HashMap<>());
                int endIndex = Math.min(i + DEFAULT_SIZE_FOR_INSERT, csvField.size());
                var batch = csvField.subList(i, endIndex);
                context.getAllSqlQueryStringBuilder()
                        .append(START_SUBQUERY_TEXT);
                distinctSubQueryValue(batch, requestDto, context);
                addInsertTextInStringBuilder(context, requestDto);
                updateSubQueryField(batch, requestDto, context);
                createValuesForSqlQuery(context, requestDto, batch);
                endTextInStringBuilder(context);
                writeInFileForMoreRows(context, Integer.toString(fileIterator));
                fileIterator++;
            }
        } else {
            var context = new FieldContext(new StringBuilder(), new HashMap<>());
            context.getAllSqlQueryStringBuilder()
                    .append(START_SUBQUERY_TEXT);
            distinctSubQueryValue(csvField, requestDto, context);
            addInsertTextInStringBuilder(context, requestDto);
            updateSubQueryField(csvField, requestDto, context);
            createValuesForSqlQuery(context, requestDto, csvField);
            endTextInStringBuilder(context);
            writeInFile(context);
        }
    }

    private void createValuesForSqlQuery(FieldContext context, RequestBodyFieldDto requestDto,
                                         List<CsvFieldDto> batch) {
        batch.forEach(fields -> {
            ArrayList<Boolean> validateList = new ArrayList<>();
            requestDto.getNotNullFields()
                    .forEach(notNullField ->
                            validateList.add(validator.validateNotNullFields(notNullField, fields)));
            if (!validateList.contains(true)) {
                getSQLValuesInStringBuilder(fields, requestDto, context);
            }
        });
    }

    private void writeInFile(FieldContext context) {
        writeStringBuilderToFile(context.getAllSqlQueryStringBuilder(), PATH_STRING);
    }

    private void writeInFileForMoreRows(FieldContext context, String fileIterator) {
        writeStringBuilderToFile(context.getAllSqlQueryStringBuilder(), CUSTOM_PATH_STRING.formatted(fileIterator));
    }

    @Override
    public Resource updateSVCToSQLScriptFile(MultipartFile file, RequestBodyFieldDto requestDto) {
        var csvField = csvReadService.getValuesFieldCsv(file);
        StringBuilder stringBuilder = new StringBuilder();
        csvField.forEach(
                field -> {
                    if (BRANCH.contains(field.getFieldValueTwo().toString())) {
                        stringBuilder.append(UPDATE_NETWORK_QUERY_TEXT.formatted(field.getFieldValueThree(),
                                field.getFieldValueOne()));
                    } else {
                        stringBuilder.append(UPDATE_TERRITORY_QUERY_TEXT.formatted(field.getFieldValueThree(),
                                field.getFieldValueOne()));
                    }
                }
        );
        try {
            writeUpdateStringBuilderToFile(stringBuilder);
            return new ByteArrayResource(Files.readAllBytes(Path.of("src/main/resources/update-sql.sql")));
        } catch (IOException e) {
            throw new BadReturnFileException(e.getMessage());
        }
    }

    private void getStringBuilderWithFirstParams(String paramValue, String subQueryName,
                                                 FieldContext context, boolean isGuid, String guid) {
        context.getAllSqlQueryStringBuilder().append(SUBQUERY_TEXT_INPUT.formatted(
                getStringParamWithPostfix(paramValue),
                subQueryName.substring(0, subQueryName.lastIndexOf(POINT)),
                subQueryName.substring(subQueryName.lastIndexOf(POINT) + 1),
                isGuid ? guid : paramValue));
    }

    private void addInsertTextInStringBuilder(FieldContext context, RequestBodyFieldDto requestDto) {
        context.getAllSqlQueryStringBuilder()
                .append(INSERT_QUERY_TEXT.formatted(requestDto.getDbName() + POINT + requestDto.getSchemeName(),
                        requestDto.getValuesText()));
    }

    private void distinctSubQueryValue(List<CsvFieldDto> csvField, RequestBodyFieldDto requestDto,
                                       FieldContext context) {
        if (requestDto.getSubQueryData().size() == 0) {
            throw new BadRequestException(BAD_REQUEST_ERROR_MESSAGE);
        }
        Map<String, String> guidNameMap = new HashMap<>();
        AtomicReference<Integer> iterator = new AtomicReference<>(1);
        requestDto.getSubQueryData().forEach((key, value) -> {
                    var subQueryParam = csvField.stream()
                            .map(fields -> getNeededConstantField(value, fields))
                            .distinct()
                            .toList();
                    if ((Objects.equals(key, "SELECT id FROM db_client_profile.tproduct WHERE guid = "))) {
                        subQueryParam.forEach(string -> {
                            guidNameMap.put(string, PARENT_GUID.formatted(iterator));
                            getStringBuilderWithFirstParams(PARENT_GUID.formatted(iterator), key, context, true, string);
                            iterator.set(iterator.get() + 1);
                        });
                    } else {
                        subQueryParam.forEach(string -> getStringBuilderWithFirstParams(string, key, context, false, null));
                    }
                }
        );
        context.setGuidMap(guidNameMap);
    }

    private void updateSubQueryField(List<CsvFieldDto> csvField, RequestBodyFieldDto requestDto, FieldContext context) {
        csvField.forEach(csvFieldDto -> requestDto.getSubQueryData()
                .forEach((key, value) -> setInNeededConstantField(value, csvFieldDto, context)));
    }

    private void endTextInStringBuilder(FieldContext context) {
        var sb = context.getAllSqlQueryStringBuilder();
        sb.replace(sb.lastIndexOf(COMMA), sb.lastIndexOf(COMMA) + 1, STRING_SEPARATOR)
                .append(END_INSERT_QUERY_TEXT);
    }

    @SneakyThrows
    private File writeStringBuilderToFile(StringBuilder stringBuilder, String path) {
        File fileOutput = new File(path);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput))) {
            writer.append(stringBuilder);
        }
        return fileOutput;
    }

    @SneakyThrows
    private File writeUpdateStringBuilderToFile(StringBuilder stringBuilder) {
        File fileOutput = new File("src/main/resources/update-sql.sql");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileOutput))) {
            writer.append(stringBuilder);
        }
        return fileOutput;
    }

}
