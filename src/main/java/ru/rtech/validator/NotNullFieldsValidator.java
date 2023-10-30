package ru.rtech.validator;

import static ru.rtech.util.Constant.ErrorText.NOT_NULL_FIELDS_HAVE_BAD_VALUE;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import ru.rtech.model.CsvFieldDto;
import ru.rtech.util.exception.BadValidationFiledNumber;

@Component
public class NotNullFieldsValidator {

    public Boolean validateNotNullFields(Integer fieldCount, CsvFieldDto csvFieldDto) {
        return switch (fieldCount) {
            case 1 -> StringUtils.isEmpty(csvFieldDto.getFieldValueOne().toString());
            case 2 -> StringUtils.isEmpty(csvFieldDto.getFieldValueTwo().toString());
            case 3 -> StringUtils.isEmpty(csvFieldDto.getFieldValueThree().toString());
            case 4 -> StringUtils.isEmpty(csvFieldDto.getFieldValueFour().toString());
            case 5 -> StringUtils.isEmpty(csvFieldDto.getFieldValueFive().toString());
            case 6 -> StringUtils.isEmpty(csvFieldDto.getFieldValueSix().toString());
            case 7 -> StringUtils.isEmpty(csvFieldDto.getFieldValueSeven().toString());
            case 8 -> StringUtils.isEmpty(csvFieldDto.getFieldValueEight().toString());
            case 9 -> StringUtils.isEmpty(csvFieldDto.getFieldValueNine().toString());
            case 10 -> StringUtils.isEmpty(csvFieldDto.getFieldValueTen().toString());
            default -> throw new BadValidationFiledNumber(NOT_NULL_FIELDS_HAVE_BAD_VALUE.formatted(fieldCount));

        };

    }

}
