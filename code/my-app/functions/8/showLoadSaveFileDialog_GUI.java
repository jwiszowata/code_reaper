public final File showLoadSaveFileDialog() {
    File file = showLoadDialog(FreeColDirectories.getSaveDirectory());
    if (file != null && !file.isFile()) {
        showErrorMessage(FreeCol.badFile("error.noSuchFile", file));
        file = null;
    }
    return file;
}