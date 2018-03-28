private static int getWindowsDirs(File[] dirs) {
    if (onMacOSX() || !onWindows() || onUnix())
        return -1;
    File home = getUserDefaultDirectory();
    if (home == null)
        return -1;
    File d = requireDir(new File(home, FREECOL_DIRECTORY));
    if (d == null)
        return -1;
    dirs[0] = dirs[1] = dirs[2] = d;
    return 1;
}