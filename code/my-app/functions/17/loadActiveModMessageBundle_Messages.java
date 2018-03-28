public static void loadActiveModMessageBundle(List<FreeColModFile> mods, Locale locale) {
    List<String> filenames = FreeColDirectories.getModMessageFileNames(locale);
    LogBuilder lb = new LogBuilder(32);
    lb.add("Failed to load active mod messages:");
    lb.mark();
    for (FreeColModFile fcmf : mods) {
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