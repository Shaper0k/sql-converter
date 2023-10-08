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

    public static String getNeededConstantField(RequestBodyFieldDto request, CsvFieldDto dto) {
        return switch (request.getSubQueryFieldNumber()) {
            case 1 -> dto.getFieldValueOne();
            case 2 -> dto.getFieldValueTwo();
            case 3 -> dto.getFieldValueThree();
            case 4 -> dto.getFieldValueFour();
            case 5 -> dto.getFieldValueFive();
            case 6 -> dto.getFieldValueSix();
            case 7 -> dto.getFieldValueSeven();
            case 8 -> dto.getFieldValueEight();
            case 9 -> dto.getFieldValueNine();
            case 10 -> dto.getFieldValueTen();
            default -> throw new NotCorrectSubQueryNumberException(SUB_QUERY_FIELD_NUMBER_IS_NOT_CORRECT);
        };
    }

    public static void setInNeededConstantField(RequestBodyFieldDto request, CsvFieldDto dto) {
        switch (request.getSubQueryFieldNumber()) {
            case 1 -> dto.setFieldValueOne(getStringParamWithPostfix(dto.getFieldValueOne()));
            case 2 -> dto.setFieldValueTwo(getStringParamWithPostfix(dto.getFieldValueTwo()));
            case 3 -> dto.setFieldValueThree(getStringParamWithPostfix(dto.getFieldValueThree()));
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
