package ru.rtech.model;

import static ru.rtech.util.Constant.Field.DICT_INST_REF_ID;
import static ru.rtech.util.Constant.Field.EXT_ID;
import static ru.rtech.util.Constant.Field.TITLE;

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

    @JsonProperty(EXT_ID)
    private Object fieldValueOne;
    @JsonProperty(TITLE)
    private Object fieldValueTwo;
    @JsonProperty(DICT_INST_REF_ID)
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
