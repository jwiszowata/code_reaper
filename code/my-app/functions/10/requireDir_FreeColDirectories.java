private static File requireDir(File dir) {
    if (dir.exists()) {
        if (dir.isDirectory() && dir.canWrite())
            return dir;
    } else {
        if (dir.mkdir())
            return dir;
    }
    return null;
}