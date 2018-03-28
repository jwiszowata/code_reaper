public static List<File> getTcFileList() {
    return collectFiles(getRulesDirectory(), tcFileFilter);
}