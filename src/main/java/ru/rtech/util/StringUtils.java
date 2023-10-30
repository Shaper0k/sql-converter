package ru.rtech.util;

import static java.util.Objects.isNull;
import static ru.rtech.util.Constant.APOSTROPHE;
import static ru.rtech.util.Constant.COMMA;
import static ru.rtech.util.Constant.DOUBLE_APOSTROPHE;
import static ru.rtech.util.Constant.EMPTY;
import static ru.rtech.util.Constant.Field.CURRENT_TIMESTAMP;
import static ru.rtech.util.Constant.Field.FIELD_POSTFIX;
import static ru.rtech.util.Constant.POINT;
import static ru.rtech.util.Constant.QueryText.END_VALUES_QUERY_TEXT;
import static ru.rtech.util.Constant.QueryText.ON_EIGHT_VALUES_QUERY_TEXT;
import static ru.rtech.util.Constant.QueryText.ON_FIVE_VALUES_QUERY_TEXT;
import static ru.rtech.util.Constant.QueryText.ON_FOUR_VALUES_QUERY_TEXT;
import static ru.rtech.util.Constant.QueryText.ON_NINE_VALUES_QUERY_TEXT;
import static ru.rtech.util.Constant.QueryText.ON_SEVEN_VALUES_QUERY_TEXT;
import static ru.rtech.util.Constant.QueryText.ON_SIX_VALUES_QUERY_TEXT;
import static ru.rtech.util.Constant.QueryText.ON_TEN_VALUES_QUERY_TEXT;
import static ru.rtech.util.Constant.QueryText.ON_THREE_VALUES_QUERY_TEXT;
import static ru.rtech.util.Constant.SPACE;
import static ru.rtech.util.Constant.UNDERSCORE;

import java.nio.charset.StandardCharsets;
import lombok.experimental.UtilityClass;
import ru.rtech.model.CsvFieldDto;
import ru.rtech.model.FieldContext;

@UtilityClass
public class StringUtils {

    public static <T> String getStringParamWithPostfix(T paramValue) {
        return paramValue.toString().replace(POINT, UNDERSCORE) + FIELD_POSTFIX;
    }

    public static <T> String getStringValueParam(T value) {
        if (value instanceof String str) {
            if (str.isEmpty()) {
                return null;
            }
            str = str.replace(APOSTROPHE, DOUBLE_APOSTROPHE);
            return APOSTROPHE + str + APOSTROPHE;
        }
        return isNull(value) ? null : value.toString();
    }

    public static StringBuilder getValueParamForThree(CsvFieldDto csvFieldDto, FieldContext context,
                                                      Boolean updateDate, Boolean createDate) {
        return context.getAllSqlQueryStringBuilder()
                .append(ON_THREE_VALUES_QUERY_TEXT.formatted(getStringValueParam(csvFieldDto.getFieldValueOne()),
                        getStringValueParam(csvFieldDto.getFieldValueTwo()),
                        getStringValueParam(csvFieldDto.getFieldValueThree())))
                .append(COMMA + SPACE)
                .append(Boolean.TRUE.equals(updateDate) ? CURRENT_TIMESTAMP + COMMA : EMPTY)
                .append(Boolean.TRUE.equals(createDate) ? CURRENT_TIMESTAMP : EMPTY)
                .append(END_VALUES_QUERY_TEXT);
    }

    public static StringBuilder getValueParamForFour(CsvFieldDto csvFieldDto, FieldContext context,
                                                     Boolean updateDate, Boolean createDate) {
        return context.getAllSqlQueryStringBuilder()
                .append(ON_FOUR_VALUES_QUERY_TEXT.formatted(getStringValueParam(csvFieldDto.getFieldValueOne()),
                        getStringValueParam(csvFieldDto.getFieldValueTwo()),
                        getStringValueParam(csvFieldDto.getFieldValueThree()),
                        getStringValueParam(csvFieldDto.getFieldValueFour())
                ))
                .append(COMMA + SPACE)
                .append(Boolean.TRUE.equals(updateDate) ? CURRENT_TIMESTAMP + COMMA : EMPTY)
                .append(Boolean.TRUE.equals(createDate) ? CURRENT_TIMESTAMP : EMPTY)
                .append(END_VALUES_QUERY_TEXT);
    }

    public static StringBuilder getValueParamForFive(CsvFieldDto csvFieldDto, FieldContext context,
                                                     Boolean updateDate, Boolean createDate) {
        return context.getAllSqlQueryStringBuilder()
                .append(ON_FIVE_VALUES_QUERY_TEXT.formatted(getStringValueParam(csvFieldDto.getFieldValueOne()),
                        getStringValueParam(csvFieldDto.getFieldValueTwo()),
                        getStringValueParam(csvFieldDto.getFieldValueThree()),
                        getStringValueParam(csvFieldDto.getFieldValueFour()),
                        getStringValueParam(csvFieldDto.getFieldValueFive())
                ))
                .append(COMMA + SPACE)
                .append(Boolean.TRUE.equals(updateDate) ? CURRENT_TIMESTAMP + COMMA : EMPTY)
                .append(Boolean.TRUE.equals(createDate) ? CURRENT_TIMESTAMP : EMPTY)
                .append(END_VALUES_QUERY_TEXT);
    }

    public static StringBuilder getValueParamForSix(CsvFieldDto csvFieldDto, FieldContext context,
                                                    Boolean updateDate, Boolean createDate) {
        return context.getAllSqlQueryStringBuilder()
                .append(ON_SIX_VALUES_QUERY_TEXT.formatted(getStringValueParam(csvFieldDto.getFieldValueOne()),
                        getStringValueParam(csvFieldDto.getFieldValueTwo()),
                        getStringValueParam(csvFieldDto.getFieldValueThree()),
                        getStringValueParam(csvFieldDto.getFieldValueFour()),
                        getStringValueParam(csvFieldDto.getFieldValueFive()),
                        getStringValueParam(csvFieldDto.getFieldValueSix())
                ))
                .append(COMMA + SPACE)
                .append(Boolean.TRUE.equals(updateDate) ? CURRENT_TIMESTAMP + COMMA : EMPTY)
                .append(Boolean.TRUE.equals(createDate) ? CURRENT_TIMESTAMP : EMPTY)
                .append(END_VALUES_QUERY_TEXT);
    }

    public static StringBuilder getValueParamForSeven(CsvFieldDto csvFieldDto, FieldContext context,
                                                      Boolean updateDate, Boolean createDate) {
        return context.getAllSqlQueryStringBuilder()
                .append(ON_SEVEN_VALUES_QUERY_TEXT.formatted(getStringValueParam(csvFieldDto.getFieldValueOne()),
                        getStringValueParam(csvFieldDto.getFieldValueTwo()),
                        getStringValueParam(csvFieldDto.getFieldValueThree()),
                        getStringValueParam(csvFieldDto.getFieldValueFour()),
                        getStringValueParam(csvFieldDto.getFieldValueFive()),
                        getStringValueParam(csvFieldDto.getFieldValueSix()),
                        csvFieldDto.getFieldValueSeven()
                ))
                .append(COMMA + SPACE)
                .append(Boolean.TRUE.equals(updateDate) ? CURRENT_TIMESTAMP + COMMA : EMPTY)
                .append(Boolean.TRUE.equals(createDate) ? CURRENT_TIMESTAMP : EMPTY)
                .append(END_VALUES_QUERY_TEXT);
    }

    public static StringBuilder getValueParamForEight(CsvFieldDto csvFieldDto, FieldContext context,
                                                      Boolean updateDate, Boolean createDate) {
        return context.getAllSqlQueryStringBuilder()
                .append(ON_EIGHT_VALUES_QUERY_TEXT.formatted(getStringValueParam(csvFieldDto.getFieldValueOne()),
                        getStringValueParam(csvFieldDto.getFieldValueTwo()),
                        getStringValueParam(csvFieldDto.getFieldValueThree()),
                        getStringValueParam(csvFieldDto.getFieldValueFour()),
                        getStringValueParam(csvFieldDto.getFieldValueFive()),
                        getStringValueParam(csvFieldDto.getFieldValueSix()),
                        getStringValueParam(csvFieldDto.getFieldValueSeven()),
                        getStringValueParam(csvFieldDto.getFieldValueEight())
                ))
                .append(COMMA + SPACE)
                .append(Boolean.TRUE.equals(updateDate) ? CURRENT_TIMESTAMP + COMMA : EMPTY)
                .append(Boolean.TRUE.equals(createDate) ? CURRENT_TIMESTAMP : EMPTY)
                .append(END_VALUES_QUERY_TEXT);
    }

    public static StringBuilder getValueParamForNine(CsvFieldDto csvFieldDto, FieldContext context,
                                                     Boolean updateDate, Boolean createDate) {
        return context.getAllSqlQueryStringBuilder()
                .append(ON_NINE_VALUES_QUERY_TEXT.formatted(getStringValueParam(csvFieldDto.getFieldValueOne()),
                        getStringValueParam(csvFieldDto.getFieldValueTwo()),
                        getStringValueParam(csvFieldDto.getFieldValueThree()),
                        getStringValueParam(csvFieldDto.getFieldValueFour()),
                        getStringValueParam(csvFieldDto.getFieldValueFive()),
                        getStringValueParam(
                                csvFieldDto.getFieldValueSix().toString().replace("1", "true").replace("0", "false")),
                        getStringValueParam(csvFieldDto.getFieldValueSeven()),
                        getStringValueParam(csvFieldDto.getFieldValueEight()),
                        csvFieldDto.getFieldValueNine()
                ))
                .append(COMMA + SPACE)
                .append(Boolean.TRUE.equals(updateDate) ? CURRENT_TIMESTAMP + COMMA : EMPTY)
                .append(Boolean.TRUE.equals(createDate) ? CURRENT_TIMESTAMP : EMPTY)
                .append(END_VALUES_QUERY_TEXT);
    }

    public static StringBuilder getValueParamForTen(CsvFieldDto csvFieldDto, FieldContext context,
                                                    Boolean updateDate, Boolean createDate) {
        return context.getAllSqlQueryStringBuilder()
                .append(ON_TEN_VALUES_QUERY_TEXT.formatted(getStringValueParam(csvFieldDto.getFieldValueOne()),
                        getStringValueParam(csvFieldDto.getFieldValueTwo()),
                        getStringValueParam(csvFieldDto.getFieldValueThree()),
                        getStringValueParam(csvFieldDto.getFieldValueFour()),
                        getStringValueParam(csvFieldDto.getFieldValueFive()),
                        getStringValueParam(csvFieldDto.getFieldValueSix()),
                        getStringValueParam(csvFieldDto.getFieldValueSeven()),
                        getStringValueParam(csvFieldDto.getFieldValueEight()),
                        getStringValueParam(csvFieldDto.getFieldValueNine()),
                        getStringValueParam(csvFieldDto.getFieldValueTen())
                ))
                .append(COMMA + SPACE)
                .append(Boolean.TRUE.equals(updateDate) ? CURRENT_TIMESTAMP + COMMA + SPACE : EMPTY)
                .append(Boolean.TRUE.equals(createDate) ? CURRENT_TIMESTAMP : EMPTY)
                .append(END_VALUES_QUERY_TEXT);
    }

}
