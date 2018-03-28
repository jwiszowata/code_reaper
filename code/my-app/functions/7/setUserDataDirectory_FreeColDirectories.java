public static String setUserDataDirectory(String path) {
    File dir = new File(path);
    String ret = checkDir(dir);
    if (ret == null)
        userDataDirectory = dir;
    return ret;
}