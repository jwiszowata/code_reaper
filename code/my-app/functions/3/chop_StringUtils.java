public static String chop(String str, int maxLength) {
    return (str.length() > maxLength) ? str.substring(0, maxLength) : str;
}