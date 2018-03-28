public static String setUserCacheDirectory(String path) {
    File dir = new File(path);
    String ret = checkDir(dir);
    if (ret == null)
        userCacheDirectory = dir;
    return ret;
}