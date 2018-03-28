public File showSaveDialog(File directory, FileFilter[] filters, String defaultName) {
    if (filters == null)
        filters = getFileFilters();
    return showFreeColDialog(new SaveDialog(freeColClient, frame, directory, filters, defaultName), null);
}