private static String sanitize(String fileName) {
    List<String> strings = new ArrayList<String>();
    for (int i = 0; i < fileName.length(); i++) {
        String s = fileName.substring(i, i + 1);
        if (SEPARATOR.equals(s))
            continue;
        strings.add(s);
    }
    return join("", strings);
}