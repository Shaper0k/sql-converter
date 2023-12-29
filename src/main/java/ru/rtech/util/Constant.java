package ru.rtech.util;

import java.nio.file.Path;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {

    public static final String DELIMITER = "|";
    public static final Integer DEFAULT_SIZE_FOR_INSERT = 40000;
    public static final Character COLUMN_SEPARATOR = ';';
    public static final Character COLUMN_СOMMA = ',';
    public static final Character ESCAPE_CHAR = 'Ø';
    public static final Character QUOTE_CHAR = '"';
    public static final String SPACE = " ";
    public static final String UNDERSCORE = "_";
    public static final String POINT = ".";
    public static final String APOSTROPHE = "'";
    public static final String EMPTY = "";
    public static final String DOUBLE_APOSTROPHE = "''";
    public static final String COMMA = ",";
    public static final String STRING_SEPARATOR = ";";
    public static final String CHARSET = "windows-1251";
    public static final String BRANCH = "Branch";
    public static final String PARENT_GUID = "PARENT_GUID_%s";
    public static final Path PATH_CONVERT = Path.of("src/main/resources/converted-sql.sql");
    public static final String PATH_STRING = "src/main/resources/converted-sql.sql";
    public static final String CUSTOM_PATH_STRING = "src/main/resources/bigconverted/converted-sql-%s.sql";

    public class Field {

        public static final String DICT_INST_REF_ID = "tdictionary_instance.ref_id";
        public static final String EXT_ID = "ext_id";
        public static final String REF_ID = "ref_id";
        public static final String DESCRIPTION = "description";
        public static final String ACTIVE = "active";
        public static final String IS_ACTIVE = "is_active";
        public static final String COMPONENT_REF_ID= "tcomponent.ref_id";
        public static final String FUNCTION_GROUP= "function_group";
        public static final String CODE = "code";
        public static final String TITLE = "title";
        public static final String GUID = "guid";
        public static final String TYPE = "type";
        public static final String IS_VISIBLE = "is_visible";
        public static final String FIELD_POSTFIX = "_FIELD";
        public static final String CURRENT_TIMESTAMP = "current_timestamp";

    }

    public class QueryText {

        public static final String START_SUBQUERY_TEXT = """
                do\s
                $$\s
                DECLARE\s
                """;

        public static final String QUERY_DELIMITER = """
               _______________________________________________________________________________________\s
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
                END\s
                $$\s
                """;

        public static final String UPDATE_NETWORK_QUERY_TEXT = "update db_dictionary_administration.tnetwork_branch set parent_tnetwork_branch_id = (select id from db_dictionary_administration.tnetwork_branch where guid = '%s') where guid = '%s';\n";
        public static final String UPDATE_TERRITORY_QUERY_TEXT = "update db_dictionary_administration.tnetwork_branch set parent_tterritory_id = (select id from db_dictionary_administration.tterritory where guid = '%s') where guid = '%s';\n";

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
        public static final String CSV_IS_NOT_CORRECT = "file cannot read";
        public static final String CSV_FORMAT_IS_NOT_CORRECT = "format in file is not correct";
        public static final String NOT_NULL_FIELDS_HAVE_BAD_VALUE = "NotNullFields have bad value = %s";
        public static final String BAD_REQUEST_ERROR_MESSAGE = "Колличество полей подзапроса и колличество значений "
                + "подзапроса не совпадают";

    }

}
