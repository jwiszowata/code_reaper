public static void installFont(Font defaultFont) {
    UIDefaults u = UIManager.getDefaults();
    java.util.Enumeration<Object> keys = u.keys();
    while (keys.hasMoreElements()) {
        Object key = keys.nextElement();
        if (u.get(key) instanceof javax.swing.plaf.FontUIResource) {
            u.put(key, defaultFont);
        }
    }
}