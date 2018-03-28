public static String getLanguageOption() {
    final File optionsFile = FreeColDirectories.getClientOptionsFile();
    FreeColXMLReader xr = findOption(optionsFile, LANGUAGE);
    if (xr != null) {
        String ret = xr.getAttribute("value", null);
        xr.close();
        return ret;
    }
    return null;
}