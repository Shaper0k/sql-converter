package ru.rtech.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    private String subQueryName; // - полный путь до значения подзапроса в бд
                                 // - Пример: db.tdictionary_instance.ref_id
    private String valuesText; // текст из VALUES
                               // Пример (id, ref_id, code, title, tdictionary_instance.id, create_date)
    private Integer countField; // колличество полей переданых на вход
    private Integer subQueryFieldNumber; // номер колонки с значением для подзапроса
    private Boolean updateTime; // если при insert нужно заполнить поле время обновления записи
                                // то в каждом запросе добавиться в конце 'current_timestamp'
    private Boolean createTime; // поднять флаг если в запросе есть время создания записи
                                // к каждой записи добавиться в конце 'current_timestamp'

}
