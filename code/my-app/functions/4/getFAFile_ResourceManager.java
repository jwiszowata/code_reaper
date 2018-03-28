public static FAFile getFAFile(final String key) {
    final FAFileResource r = getFAFileResource(key);
    return (r == null) ? null : r.getFAFile();
}