public static List<File> getI18nMessageFileList(Locale locale) {
    List<File> result = new ArrayList<>();
    File i18nDirectory = getI18nDirectory();
    for (String name : getMessageFileNameList(locale)) {
        File f = new File(i18nDirectory, name);
        if (f.canRead())
            result.add(f);
    }
    return result;
}