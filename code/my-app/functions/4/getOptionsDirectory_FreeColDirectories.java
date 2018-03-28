public static File getOptionsDirectory() {
    File dir = new File(getUserConfigDirectory(), FreeCol.getTC());
    return (insistDirectory(dir)) ? dir : null;
}