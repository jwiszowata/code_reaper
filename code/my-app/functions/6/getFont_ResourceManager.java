public static Font getFont(final String key) {
    final FontResource r = getFontResource(key);
    if (r == null)
        return FontResource.getEmergencyFont();
    return r.getFont();
}