package ru.rtech.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {

    public static final String DELIMITER = "|";
    public static final Character COLUMN_SEPARATOR = ';';
    public static final Character ESCAPE_CHAR = 'Ø';
    public static final Character QUOTE_CHAR = '"';
    public static final String SPACE = " ";
    public static final String UNDERSCORE = "_";
    public static final String POINT = ".";
    public static final String APOSTROPHE = "'";
    public static final String DOUBLE_APOSTROPHE = "''";
    public static final String COMMA = ",";
    public static final String CHARSET = "windows-1251";

    public class Field {

        public static final String DICT_INST_REF_ID = "tdictionary_instance.ref_id";
        public static final String EXT_ID = "ext_id";
        public static final String CODE = "code";
        public static final String TITLE = "title";
        public static final String FIELD_POSTFIX = "_FIELD";
        public static final String CURRENT_TIMESTAMP = "current_timestamp";

    }

    public class QueryText {

        public static final String START_SUBQUERY_TEXT = """
                do\s
                $$\s
                DECLARE\s
                """;
        public static final String SUBQUERY_TEXT_INPUT = """     
                %s bigint = (select id from %s where %s = '%s');\s
                """;

        public static final String INSERT_QUERY_TEXT = """
                BEGIN\s
                INSERT INTO %s (%s)\s
                VALUES\s
                """;

        public static final String END_INSERT_QUERY_TEXT = """
                $$\s
                END
                """;

        public static final String ON_THREE_VALUES_QUERY_TEXT = "(%s, %s, %s";
        public static final String ON_FOUR_VALUES_QUERY_TEXT = "(%s, %s, %s, %s";
        public static final String ON_FIVE_VALUES_QUERY_TEXT = "(%s, %s, %s, %s, %s";
        public static final String ON_SIX_VALUES_QUERY_TEXT = "(%s, %s, %s, %s, %s, %s";
        public static final String ON_SEVEN_VALUES_QUERY_TEXT = "(%s, %s, %s, %s, %s, %s, %s";
        public static final String ON_EIGHT_VALUES_QUERY_TEXT = "(%s, %s, %s, %s, %s, %s, %s, %s";
        public static final String ON_NINE_VALUES_QUERY_TEXT = "(%s, %s, %s, %s, %s, %s, %s, %s, %s";
        public static final String ON_TEN_VALUES_QUERY_TEXT = "(%s, %s, %s, %s, %s, %s, %s, %s, %s, %s";
        public static final String END_VALUES_QUERY_TEXT = "),\n";

    }

    public class ErrorText {

        public static final String SUB_QUERY_FIELD_NUMBER_IS_NOT_CORRECT = "field subQueryFieldNumber have <0 or >10";
        public static final String COUNT_FIELD_IS_NOT_CORRECT = "count fields is maybe >3 or <10";

    }

}
