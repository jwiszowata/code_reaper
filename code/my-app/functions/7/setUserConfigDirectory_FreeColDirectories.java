public static String setUserConfigDirectory(String path) {
    File dir = new File(path);
    String ret = checkDir(dir);
    if (ret == null)
        userConfigDirectory = dir;
    return ret;
}