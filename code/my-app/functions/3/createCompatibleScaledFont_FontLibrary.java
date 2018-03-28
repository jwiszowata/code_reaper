public Font createCompatibleScaledFont(String string, FontType fontType, FontSize fontSize, int style) {
    return createCompatibleFont(string, fontType, fontSize, style, scaleFactor);
}