public static String removeOutdatedAutosaves(String prefix, List<String> excludeSuffixes, long validDays) {
    if (validDays <= 0L)
        return null;
    final long validMS = 1000L * 24L * 60L * 60L * validDays;
    final long timeNow = System.currentTimeMillis();
    final Predicate<File> outdatedPred = f -> f.lastModified() + validMS < timeNow;
    final String extension = "." + FreeCol.FREECOL_SAVE_EXTENSION;
    final List<String> ex = transform(excludeSuffixes, alwaysTrue(), s -> sanitize(s));
    final Predicate<File> suffixPred = f -> ex.stream().noneMatch(suf -> f.getName().endsWith(suf + extension));
    List<File> files = getAutosaveFiles(sanitize(prefix), outdatedPred.and(suffixPred));
    if (files.isEmpty())
        return null;
    Utils.deleteFiles(files);
    StringBuilder sb = new StringBuilder();
    sb.append("Deleted outdated (> ").append(validDays).append(" old) autosave/s: ");
    for (File f : files) sb.append(" ").append(f.getPath());
    return sb.toString();
}