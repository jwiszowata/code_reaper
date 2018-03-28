public static int selectEuropeanCount(String arg) {
    try {
        int n = Integer.parseInt(arg);
        if (n >= EUROPEANS_MIN) {
            setEuropeanCount(n);
            return n;
        }
    } catch (NumberFormatException nfe) {
    }
    return -1;
}