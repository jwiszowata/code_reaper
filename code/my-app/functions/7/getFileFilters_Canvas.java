private FileFilter[] getFileFilters() {
    if (fileFilters == null) {
        String s = Messages.message("filter.savedGames");
        fileFilters = new FileFilter[] { new FileNameExtensionFilter(s, FreeCol.FREECOL_SAVE_EXTENSION) };
    }
    return fileFilters;
}