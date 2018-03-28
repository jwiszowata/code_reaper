private static List<File> collectFiles(File dir, Predicate<File> pred) {
    return transform(fileStream(dir), pred, Function.<File>identity(), fileNameComparator);
}