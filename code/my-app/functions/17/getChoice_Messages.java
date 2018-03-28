private static String getChoice(String input, String key) {
    int keyIndex = input.indexOf(key);
    if (keyIndex < 0) {
        return null;
    } else {
        int start = keyIndex + key.length() + 1;
        int end = input.indexOf('|', start);
        if (end < 0) {
            end = input.indexOf("}}", start);
            if (end < 0) {
                logger.warning("Failed to find end of choice for key " + key + " in input " + input);
                return null;
            }
        }
        return input.substring(start, end);
    }
}