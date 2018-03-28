public static List<FreeColTcFile> getRulesList() {
    List<FreeColTcFile> ret = new ArrayList<>();
    for (File f : FreeColDirectories.getTcFileList()) {
        try {
            ret.add(new FreeColTcFile(f));
        } catch (IOException ioe) {
            logger.log(Level.WARNING, "Failed to load TC from: " + f, ioe);
        }
    }
    return ret;
}