private static int getMacOSXDirs(File[] dirs) {
    if (!onMacOSX())
        return -1;
    int ret = 0;
    File homeDir = getUserDefaultDirectory();
    if (homeDir == null)
        return -1;
    File libDir = new File(homeDir, "Library");
    if (!isGoodDirectory(libDir))
        return -1;
    if (dirs[0] == null) {
        File prefsDir = new File(libDir, "Preferences");
        if (isGoodDirectory(prefsDir)) {
            dirs[0] = prefsDir;
            File d = new File(prefsDir, FREECOL_DIRECTORY);
            if (d.exists()) {
                if (d.isDirectory() && d.canWrite()) {
                    dirs[0] = d;
                    ret++;
                } else
                    return -1;
            }
        } else
            return -1;
    }
    if (dirs[1] == null) {
        File appsDir = new File(libDir, "Application Support");
        if (isGoodDirectory(appsDir)) {
            dirs[1] = appsDir;
            File d = new File(appsDir, FREECOL_DIRECTORY);
            if (d.exists()) {
                if (d.isDirectory() && d.canWrite()) {
                    dirs[1] = d;
                    ret++;
                } else
                    return -1;
            }
        } else
            return -1;
    }
    if (dirs[2] == null) {
        dirs[2] = dirs[1];
    }
    if (ret == 2)
        return 1;
    File d = requireDir(new File(dirs[0], FREECOL_DIRECTORY));
    if (d == null)
        return -1;
    dirs[0] = d;
    d = requireDir(new File(dirs[1], FREECOL_DIRECTORY));
    if (d == null)
        return -1;
    dirs[1] = d;
    return 0;
}