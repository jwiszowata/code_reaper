public static File getLastSaveGameFile() {
    return maximize(getSavegameFiles(null), fileModificationComparator);
}