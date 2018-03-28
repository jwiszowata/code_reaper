public static int getBreakingPoint(String string, String delim) {
    int center = string.length() / 2;
    for (int offset = 0; offset < center; offset++) {
        if (delim.indexOf(string.charAt(center + offset)) >= 0) {
            return center + offset;
        } else if (delim.indexOf(string.charAt(center - offset)) >= 0) {
            return center - offset;
        }
    }
    return -1;
}