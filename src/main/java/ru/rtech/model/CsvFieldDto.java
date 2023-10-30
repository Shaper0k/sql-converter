package ru.rtech.model;


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

    @JsonProperty("uid")
    private Object fieldValueOne;
    @JsonProperty("ext_id")
    private Object fieldValueTwo;
    @JsonProperty("type")
    private Object fieldValueThree;
    @JsonProperty("title")
    private Object fieldValueFour;
    @JsonProperty("code")
    private Object fieldValueFive;
    @JsonProperty("is_const")
    private Object fieldValueSix;
    @JsonProperty("service_type")
    private Object fieldValueSeven;
    @JsonProperty("equip_type")
    private Object fieldValueEight;
    @JsonProperty("tdictionary_instance.ref_id")
    private Object fieldValueNine;
    @JsonIgnore
    private Object fieldValueTen;

}
