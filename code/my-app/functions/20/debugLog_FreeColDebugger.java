public static void debugLog(String msg) {
    FileOutputStream fos = null;
    PrintStream prs = null;
    try {
        fos = new FileOutputStream("/tmp/freecol.debug", true);
        prs = new PrintStream(fos, true, "UTF-8");
        prs.println(msg);
    } catch (FileNotFoundException | UnsupportedEncodingException ex) {
        ;
    } finally {
        try {
            if (prs != null)
                prs.close();
            if (fos != null)
                fos.close();
        } catch (IOException ioe) {
            ;
        }
    }
}