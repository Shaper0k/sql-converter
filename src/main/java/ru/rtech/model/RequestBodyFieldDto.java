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
    private String subQueryName; // - наименование схемы
    private String fieldNameOne; // поля из csv по дефолту считаем String если не нужны кавычки при конвератации
                             // стоит указывать тип в скобках
                             // Пример: id(Long)
                             // Если нужен подзапрос то указывать вместе с таблицей
                             // Пример: tcase.id(Long)
    private String fieldNameTwo;
    private String fieldNameThree;
    private String fieldNameFour;
    private String fieldNameFive;
    private String fieldNameSix;
    private String fieldNameSeven;
    private String fieldNameEight;
    private String fieldNameNine;
    private String fieldNameTen;
    private Integer countField; // колличество полей переданых на вход
    private Boolean updateTime; // если при insert нужно заполнить поле время обновления записи
                                // то в каждом запросе добавиться 'current_timestamp'
    private Boolean createTime; // поднять флаг если в запросе есть время создания записи
                                // к каждой записи добавиться 'current_timestamp'

}
