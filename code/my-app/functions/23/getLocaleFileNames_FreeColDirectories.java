public static List<String> getLocaleFileNames(String prefix, String suffix, Locale locale) {
    String language = locale.getLanguage();
    String country = locale.getCountry();
    String variant = locale.getVariant();
    List<String> result = new ArrayList<>(4);
    if (!language.isEmpty())
        language = "_" + language;
    if (!country.isEmpty())
        country = "_" + country;
    if (!variant.isEmpty())
        variant = "_" + variant;
    result.add(prefix + suffix);
    String filename = prefix + language + suffix;
    if (!result.contains(filename))
        result.add(filename);
    filename = prefix + language + country + suffix;
    if (!result.contains(filename))
        result.add(filename);
    filename = prefix + language + country + variant + suffix;
    if (!result.contains(filename))
        result.add(filename);
    return result;
}