public static String getModifierAsString(Modifier modifier) {
    return transform(getModifierStrings(modifier), isNotNull(), Function.identity(), Collectors.joining());
}