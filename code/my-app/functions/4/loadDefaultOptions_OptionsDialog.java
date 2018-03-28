protected boolean loadDefaultOptions() {
    File f = FreeColDirectories.getOptionsFile(getDefaultFileName());
    return (f.exists()) ? load(f) : false;
}