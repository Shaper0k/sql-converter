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

    @JsonProperty("service_catalog")
    private Object fieldValueOne;
    @JsonProperty("standart")
    private Object fieldValueTwo;
    @JsonProperty("product_guid")
    private Object fieldValueThree;
    @JsonProperty("ext_system")
    private Object fieldValueFour;
    @JsonProperty("guid")
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
