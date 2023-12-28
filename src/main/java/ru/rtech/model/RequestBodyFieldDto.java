package ru.rtech.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
@Data
public class RequestBodyFieldDto {

    private String dbName; // - наименование БД
    private String schemeName; // - наименование схемы
    private String valuesText; // текст из VALUES
    // Пример (id, ref_id, code, title, tdictionary_instance.id, create_date)
    private Integer countField; // колличество полей переданых на вход
    private Map<String, Integer> subQueryData; // - key - полный путь до значения подзапроса в бд
                                               // - Пример: db.tdictionary_instance.ref_id
                                                // - value - номер колонки с значением для подзапроса
    private List<Integer> notNullFields; // номера полей которые не могу быть пустыми(строки с такими значениями будут игнорироваться)
    private Boolean updateTime; // если при insert нужно заполнить поле время обновления записи
    // то в каждом запросе добавиться в конце 'current_timestamp'
    private Boolean createTime; // поднять флаг если в запросе есть время создания записи
    // к каждой записи добавиться в конце 'current_timestamp'

}
