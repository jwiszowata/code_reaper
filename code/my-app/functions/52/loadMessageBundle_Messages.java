public static void loadMessageBundle(Locale locale) {
    messageBundle.clear();
    if (!Locale.getDefault().equals(locale)) {
        Locale.setDefault(locale);
    }
    if (!NumberRules.isInitialized()) {
        File cldr = FreeColDirectories.getI18nPluralsFile();
        if (cldr.exists()) {
            try {
                try (FileInputStream in = new FileInputStream(cldr)) {
                    NumberRules.load(in);
                }
            } catch (IOException e) {
                System.err.println("Failed to read CLDR rules: " + e.getMessage());
            }
        } else {
            System.err.println("Could not find CLDR rules: " + cldr.getPath());
        }
    }
    Locale loc = (AUTOMATIC.equalsIgnoreCase(locale.getLanguage())) ? Locale.getDefault() : locale;
    setGrammaticalNumber(NumberRules.getNumberForLanguage(loc.getLanguage()));
    for (File f : FreeColDirectories.getI18nMessageFileList(locale)) {
        if (!f.canRead())
            continue;
        try {
            loadMessages(new FileInputStream(f));
        } catch (IOException ioe) {
            System.err.println("Failed to load messages from " + f.getPath() + ": " + ioe.getMessage());
        }
    }
    List<String> filenames = FreeColDirectories.getMessageFileNameList(locale);
    for (FreeColTcFile fctf : FreeColTcFile.getRulesList()) {
        for (String fn : filenames) {
            InputStream is = null;
            try {
                is = fctf.getInputStream(fn);
            } catch (IOException ioe) {
                continue;
            }
            try {
                loadMessages(is);
            } catch (IOException ioe) {
                System.err.println("Failed to load rules messages from " + fn + ": " + ioe.getMessage());
            } finally {
                try {
                    is.close();
                } catch (IOException x) {
                }
            }
        }
    }
}