public static List<File> getModFileList() {
    List<File> ret = new ArrayList<>();
    ret.addAll(collectFiles(getStandardModsDirectory(), modFileFilter));
    ret.addAll(collectFiles(getUserModsDirectory(), modFileFilter));
    return ret;
}