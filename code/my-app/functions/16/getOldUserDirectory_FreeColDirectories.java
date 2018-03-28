private static File getOldUserDirectory() {
    File home = getUserDefaultDirectory();
    File old = new File(home, "FreeCol");
    if (old.exists() && old.isDirectory() && old.canRead())
        return old;
    old = new File(home, ".freecol");
    if (old.exists() && old.isDirectory() && old.canRead())
        return old;
    old = new File(home, "Library");
    if (old.exists() && old.isDirectory() && old.canRead()) {
        old = new File(old, "FreeCol");
        if (old.exists() && old.isDirectory() && old.canRead())
            return old;
    }
    return null;
}