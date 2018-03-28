public static final void launchBrowser(String url) {
    try {
        URI uri = java.net.URI.create(url);
        java.awt.Desktop.getDesktop().browse(uri);
    } catch (IOException e) {
        logger.log(Level.FINEST, "Web browser failed to launch via Desktop Class.", e);
        String[] browser = getBrowserExecString(url);
        if (browser != null) {
            try {
                Runtime.getRuntime().exec(browser);
            } catch (IOException re) {
                logger.log(Level.FINEST, "Web browser failed to launch via Runtime Class.", re);
            }
        }
    }
}