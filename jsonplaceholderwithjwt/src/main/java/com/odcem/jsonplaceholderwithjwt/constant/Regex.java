package com.odcem.jsonplaceholderwithjwt.constant;

public class Regex {
    public static final String NAME_REGEX = "^([a-zA-Z]+[,.]?[ ]?|[a-zA-Z]+['-]?)+$";
    public static final String PHONE_REGEX = "^((\\+|00)(\\d{1,3})[\\s-]?)?(\\d{10})$";
    public static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
    public static final String URL_REGEX =
            "((https?|ftp|www)([:\\/\\/|\\.]" + "[-_.!~*\\'()a-zA-Z0-9;\\/?:\\@&=+\\$,%#]+))";
    public static final String HTML_TAG_REGEX = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>";
}
