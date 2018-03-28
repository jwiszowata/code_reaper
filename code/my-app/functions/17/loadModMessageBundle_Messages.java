public static void loadModMessageBundle(Locale locale) {
    List<String> filenames = FreeColDirectories.getMessageFileNameList(locale);
    LogBuilder lb = new LogBuilder(32);
    lb.add("Failed to load mod messages:");
    lb.mark();
    for (FreeColModFile fcmf : FreeColModFile.getModsList()) {
        for (String name : filenames) {
            try {
                loadMessages(fcmf.getInputStream(name));
            } catch (IOException e) {
                lb.add(' ', fcmf.getId(), '/', name);
            }
        }
    }
    if (lb.grew())
        lb.log(logger, Level.FINE);
}