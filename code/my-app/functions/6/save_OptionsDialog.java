protected boolean save(File file) {
    if (this.group.save(file, null, true))
        return true;
    getGUI().showErrorMessage(FreeCol.badFile("error.couldNotSave", file));
    return false;
}