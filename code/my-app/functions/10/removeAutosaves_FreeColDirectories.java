public static String removeAutosaves(String prefix) {
    List<File> files = getAutosaveFiles(sanitize(prefix), alwaysTrue());
    if (files.isEmpty())
        return null;
    Utils.deleteFiles(files);
    StringBuilder sb = new StringBuilder();
    sb.append("Deleted autosave/s: ");
    for (File f : files) sb.append(" ").append(f.getPath());
    return sb.toString();
}