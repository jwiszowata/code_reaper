public static boolean setSavegameFile(String path) {
    File file = new File(path);
    if (!file.exists() || !file.isFile() || !file.canRead()) {
        file = new File(getSaveDirectory(), path);
        if (!file.exists() || !file.isFile() || !file.canRead())
            return false;
    }
    savegameFile = file;
    File parent = file.getParentFile();
    if (parent == null)
        parent = new File(".");
    saveDirectory = parent;
    deriveAutosaveDirectory();
    return true;
}