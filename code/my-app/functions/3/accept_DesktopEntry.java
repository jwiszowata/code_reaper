public boolean accept(File dir, String name) {
    return name.startsWith("FreeColMessages") && name.endsWith(".properties");
}