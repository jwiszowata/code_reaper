protected boolean saveDefaultOptions() {
    File f = FreeColDirectories.getOptionsFile(getDefaultFileName());
    return save(f);
}