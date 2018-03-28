public static StringTemplate errorFromException(Exception ex, String fallbackKey) {
    return errorFromException(ex, StringTemplate.template(fallbackKey));
}