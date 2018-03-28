public static List<FreeColModFile> getModsList() {
    List<FreeColModFile> ret = new ArrayList<>();
    for (File f : FreeColDirectories.getModFileList()) {
        try {
            ret.add(new FreeColModFile(f));
        } catch (IOException ioe) {
            logger.log(Level.WARNING, "Failed to load mod from: " + f, ioe);
        }
    }
    return ret;
}