public static String lastPart(String s, String delim) {
    int last = (s == null) ? -1 : s.lastIndexOf(delim);
    return (last > 0) ? s.substring(last + delim.length(), s.length()) : s;
}