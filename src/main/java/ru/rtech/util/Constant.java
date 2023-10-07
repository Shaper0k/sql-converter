package ru.rtech.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Constant {

    public static final String X_SSO_ID = "X-Sso-Id";
    public static final String DELIMITER = "|";
    public static final Character COLUMN_SEPARATOR = ';';
    public static final Character ESCAPE_CHAR = 'Ø';
    public static final Character QUOTE_CHAR = '"';
    public static final Character WHITE_SPACE = ' ';
    public static final String CHARSET = "windows-1251";

    public class Field {

        public static final String DICT_INST_REF_ID = "tdictionary_instance.ref_id";
        public static final String EXT_ID = "ext_id";
        public static final String CODE = "code";
        public static final String TITLE = "title";

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

        public static final String SELECT_TEXT = " bigint = (select id from %s where %s = ";
        public static final String END_SELECT = """
                 '%s');\s
                """;

        public static final String INSERT_QUERY_TEXT = """
                BEGIN\s
                INSERT INTO %s (%s)\s
                VALUES\s
                %s\s
                """;

    }

}
