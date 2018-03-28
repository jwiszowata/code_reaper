public static Font createFont(FontType fontType, FontSize fontSize, int style, float scaleFactor) {
    float scaledSize = calcScaledSize(fontSize, scaleFactor);
    String fontKey = getFontKey(fontType);
    Font font = (fontKey == null) ? mainFont : ResourceManager.getFont(fontKey);
    font = font.deriveFont(style, scaledSize);
    return font;
}