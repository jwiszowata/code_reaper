public static boolean setDebugModes(String optionValue) {
    if (optionValue == null)
        return false;
    if (optionValue.isEmpty())
        return true;
    for (String s : optionValue.split(",")) {
        try {
            DebugMode mode = Enum.valueOf(DebugMode.class, s.toUpperCase(Locale.US));
            enableDebugMode(mode);
        } catch (RuntimeException e) {
            logger.warning("Unrecognized debug mode: " + optionValue);
            return false;
        }
    }
    return true;
}