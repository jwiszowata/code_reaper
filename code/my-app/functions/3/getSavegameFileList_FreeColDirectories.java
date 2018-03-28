public static List<File> getSavegameFileList(File directory) {
    return toList(getSavegameFiles(directory));
}