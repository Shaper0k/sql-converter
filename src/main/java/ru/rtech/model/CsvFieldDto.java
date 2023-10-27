package ru.rtech.model;

import static ru.rtech.util.Constant.Field.ACTIVE;
import static ru.rtech.util.Constant.Field.COMPONENT_REF_ID;
import static ru.rtech.util.Constant.Field.DESCRIPTION;
import static ru.rtech.util.Constant.Field.DICT_INST_REF_ID;
import static ru.rtech.util.Constant.Field.EXT_ID;
import static ru.rtech.util.Constant.Field.FUNCTION_GROUP;
import static ru.rtech.util.Constant.Field.GUID;
import static ru.rtech.util.Constant.Field.IS_ACTIVE;
import static ru.rtech.util.Constant.Field.REF_ID;
import static ru.rtech.util.Constant.Field.TITLE;
import static ru.rtech.util.Constant.Field.TYPE;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder({"fieldValueOne", "fieldValueTwo", "fieldValueThree", "fieldValueFour", "fieldValueFive",
        "fieldValueSix", "fieldValueSeven", "fieldValueEight", "fieldValueNine", "fieldValueTen"}
)
@JsonSerializableSchema
@Data
public class CsvFieldDto {

    @JsonProperty("guid")
    private Object fieldValueOne;
    @JsonProperty("parrentType")
    private Object fieldValueTwo;
    @JsonProperty("parrentGuid")
    private Object fieldValueThree;
    @JsonIgnore
    private Object fieldValueFour;
    @JsonIgnore
    private Object fieldValueFive;
    @JsonIgnore
    private Object fieldValueSix;
    @JsonIgnore
    private Object fieldValueSeven;
    @JsonIgnore
    private Object fieldValueEight;
    @JsonIgnore
    private Object fieldValueNine;
    @JsonIgnore
    private Object fieldValueTen;

}
