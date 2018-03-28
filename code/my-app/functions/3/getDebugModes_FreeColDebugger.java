public static String getDebugModes() {
    return transform(DebugMode.values(), m -> isInDebugMode(m), DebugMode::toString, Collectors.joining(","));
}