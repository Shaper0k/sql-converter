package ru.rtech.model;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class FieldContext {

    StringBuilder allSqlQueryStringBuilder;
    Map<String, String> guidMap;

}
