package com.academy.course.utils;

public class Constants {
    public static final int DEFAULT_ARRAY_CAPACITY = 10;
    public static final String ALLOWED_CHARS = "^[0-9\\s,;\\-\\u2013\\u2014]+$";
    public static final String POSITIVE_ONE_NUMBER = "\\d";
    public static final String DASH_ENCLOSED_WHITESPACES = "(?<=\\d)\\s+-\\s+(?=\\d)";
    public static final String DASH_ENCLOSED_NUMBERS = "(?<=\\d)-(?=\\d)";
    public static final String WHITESPACE = " ";
    public static final String SEPARATOR = "[,;\\s]+";
    public static final String DASH_IS_NOT_BETWEEN_NUMBERS = ".*(^|[^0-9])-($|[^0-9]).*";

}
