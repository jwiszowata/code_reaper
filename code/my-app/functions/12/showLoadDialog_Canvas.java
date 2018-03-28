public File showLoadDialog(File directory, FileFilter[] filters) {
    if (filters == null)
        filters = getFileFilters();
    File file = null;
    for (; ; ) {
        file = showFreeColDialog(new LoadDialog(freeColClient, frame, directory, filters), null);
        if (file == null || file.isFile())
            break;
        showErrorMessage(Messages.message(FreeCol.badFile("error.noSuchFile", file)), null);
    }
    return file;
}