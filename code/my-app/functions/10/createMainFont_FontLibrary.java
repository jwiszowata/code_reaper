static Font createMainFont(String fontName, float scaleFactor) {
    final float defaultSize = 12f * scaleFactor;
    mainFont = null;
    if (fontName != null) {
        Font font = Font.decode(fontName);
        mainFont = font = font.deriveFont(defaultSize);
        return font;
    }
    return ResourceManager.getFont("font.normal").deriveFont(defaultSize);
}