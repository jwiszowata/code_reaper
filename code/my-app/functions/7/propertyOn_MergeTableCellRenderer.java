private static String propertyOn(String line) {
    if (null == line) {
        return "";
    }
    int indexOfEquals = line.indexOf('=');
    return (indexOfEquals != -1) ? line.substring(0, indexOfEquals) : "";
}