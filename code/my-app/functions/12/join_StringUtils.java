public static String join(String delimiter, String... strings) {
    if (strings == null || strings.length == 0) {
        return null;
    } else {
        StringBuilder result = new StringBuilder(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            result.append(delimiter);
            result.append(strings[i]);
        }
        return result.toString();
    }
}