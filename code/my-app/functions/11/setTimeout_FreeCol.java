public static boolean setTimeout(String timeout) {
    try {
        long result = Long.parseLong(timeout);
        if (TIMEOUT_MIN <= result && result <= TIMEOUT_MAX) {
            FreeCol.timeout = result;
            return true;
        }
    } catch (NumberFormatException nfe) {
    }
    return false;
}