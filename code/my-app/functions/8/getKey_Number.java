public String getKey(String selector, String template) {
    try {
        return getKey(Double.parseDouble(selector));
    } catch (NumberFormatException e) {
        logger.warning("Syntax error in string template '" + template + "'");
        return Category.other.toString();
    }
}