public static Stream<File> fileStream(File dir, Predicate<? super File> predicate) {
    return fileStream(dir).filter(predicate);
}