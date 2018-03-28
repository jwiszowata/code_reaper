protected void setUp() throws Exception {
    FreeColTcFile.loadTCs();
    if (updateLocale) {
        updateLocale = false;
        Messages.loadMessageBundle(Locale.US);
    }
}