public static List<File> getMapFileList() {
    final File mapsDirectory = getMapsDirectory();
    return (mapsDirectory == null || !mapsDirectory.isDirectory()) ? null : collectFiles(mapsDirectory, saveGameFilter);
}