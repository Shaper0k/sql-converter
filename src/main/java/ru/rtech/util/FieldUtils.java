package ru.rtech.util;

import static ru.rtech.util.Constant.ErrorText.COUNT_FIELD_IS_NOT_CORRECT;
import static ru.rtech.util.Constant.ErrorText.SUB_QUERY_FIELD_NUMBER_IS_NOT_CORRECT;
import static ru.rtech.util.StringUtils.getStringParamWithPostfix;
import static ru.rtech.util.StringUtils.getValueParamForEight;
import static ru.rtech.util.StringUtils.getValueParamForFive;
import static ru.rtech.util.StringUtils.getValueParamForFour;
import static ru.rtech.util.StringUtils.getValueParamForNine;
import static ru.rtech.util.StringUtils.getValueParamForSeven;
import static ru.rtech.util.StringUtils.getValueParamForSix;
import static ru.rtech.util.StringUtils.getValueParamForTen;
import static ru.rtech.util.StringUtils.getValueParamForThree;

import lombok.experimental.UtilityClass;
import ru.rtech.model.CsvFieldDto;
import ru.rtech.model.FieldContext;
import ru.rtech.model.RequestBodyFieldDto;
import ru.rtech.util.exception.CountFieldIsNotCorrectException;
import ru.rtech.util.exception.NotCorrectSubQueryNumberException;

@UtilityClass
public class FieldUtils {

    public static String getNeededConstantField(Integer subQueryFieldNumber, CsvFieldDto dto) {
        return switch (subQueryFieldNumber) {
            case 1 -> String.valueOf(dto.getFieldValueOne());
            case 2 -> String.valueOf(dto.getFieldValueTwo());
            case 3 -> String.valueOf(dto.getFieldValueThree());
            case 4 -> String.valueOf(dto.getFieldValueFour());
            case 5 -> String.valueOf(dto.getFieldValueFive());
            case 6 -> String.valueOf(dto.getFieldValueSix());
            case 7 -> String.valueOf(dto.getFieldValueSeven());
            case 8 -> String.valueOf(dto.getFieldValueEight());
            case 9 -> String.valueOf(dto.getFieldValueNine());
            case 10 -> String.valueOf(dto.getFieldValueTen());
            default -> throw new NotCorrectSubQueryNumberException(SUB_QUERY_FIELD_NUMBER_IS_NOT_CORRECT);
        };
    }

    public static void setInNeededConstantField(Integer subQueryFieldNumber, CsvFieldDto dto, FieldContext context) {
        switch (subQueryFieldNumber) {
            case 1 -> dto.setFieldValueOne(getStringParamWithPostfix(dto.getFieldValueOne()));
            case 2 -> dto.setFieldValueTwo(getStringParamWithPostfix(dto.getFieldValueTwo()));
            case 3 -> dto.setFieldValueThree(context.getGuidMap().get(dto.getFieldValueThree().toString()));
            case 4 -> dto.setFieldValueFour(getStringParamWithPostfix(dto.getFieldValueFour()));
            case 5 -> dto.setFieldValueFive(getStringParamWithPostfix(dto.getFieldValueFive()));
            case 6 -> dto.setFieldValueSix(getStringParamWithPostfix(dto.getFieldValueSix()));
            case 7 -> dto.setFieldValueSeven(getStringParamWithPostfix(dto.getFieldValueSeven()));
            case 8 -> dto.setFieldValueEight(getStringParamWithPostfix(dto.getFieldValueEight()));
            case 9 -> dto.setFieldValueNine(getStringParamWithPostfix(dto.getFieldValueNine()));
            case 10 -> dto.setFieldValueTen(getStringParamWithPostfix(dto.getFieldValueTen()));
            default -> throw new NotCorrectSubQueryNumberException(SUB_QUERY_FIELD_NUMBER_IS_NOT_CORRECT);
        }
    }

    public static StringBuilder getSQLValuesInStringBuilder(CsvFieldDto fieldDto,
                                                            RequestBodyFieldDto request, FieldContext context) {
        return switch (request.getCountField()) {
            case 3 -> getValueParamForThree(fieldDto, context, request.getUpdateTime(), request.getCreateTime());
            case 4 -> getValueParamForFour(fieldDto, context, request.getUpdateTime(), request.getCreateTime());
            case 5 -> getValueParamForFive(fieldDto, context, request.getUpdateTime(), request.getCreateTime());
            case 6 -> getValueParamForSix(fieldDto, context, request.getUpdateTime(), request.getCreateTime());
            case 7 -> getValueParamForSeven(fieldDto, context, request.getUpdateTime(), request.getCreateTime());
            case 8 -> getValueParamForEight(fieldDto, context, request.getUpdateTime(), request.getCreateTime());
            case 9 -> getValueParamForNine(fieldDto, context, request.getUpdateTime(), request.getCreateTime());
            case 10 -> getValueParamForTen(fieldDto, context, request.getUpdateTime(), request.getCreateTime());
            default -> throw new CountFieldIsNotCorrectException(COUNT_FIELD_IS_NOT_CORRECT);
        };
    }

}
