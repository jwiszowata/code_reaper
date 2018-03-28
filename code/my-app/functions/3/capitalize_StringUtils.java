public static String capitalize(String s, Locale locale) {
    return (s == null || s.length() == 0) ? s : s.substring(0, 1).toUpperCase(locale) + s.substring(1);
}