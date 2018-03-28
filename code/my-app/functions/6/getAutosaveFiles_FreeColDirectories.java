private static List<File> getAutosaveFiles(String prefix, Predicate<File> pred) {
    final String suffix = "." + FreeCol.FREECOL_SAVE_EXTENSION;
    final File asd = getAutosaveDirectory();
    final Predicate<File> fullPred = pred.and(f -> f.getName().startsWith(prefix) && f.getName().endsWith(suffix));
    return (asd == null) ? Collections.emptyList() : collectFiles(asd, fullPred);
}