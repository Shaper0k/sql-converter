package ru.rtech.model;

import static ru.rtech.util.Constant.Field.CODE;
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
    private String fieldValueOne;
    @JsonProperty(CODE)
    private String fieldValueTwo;
    @JsonProperty(TITLE)
    private String fieldValueThree;
    @JsonProperty(DICT_INST_REF_ID)
    private String fieldValueFour;
    @JsonIgnore
    private String fieldValueFive;
    @JsonIgnore
    private String fieldValueSix;
    @JsonIgnore
    private String fieldValueSeven;
    @JsonIgnore
    private String fieldValueEight;
    @JsonIgnore
    private String fieldValueNine;
    @JsonIgnore
    private String fieldValueTen;

}
