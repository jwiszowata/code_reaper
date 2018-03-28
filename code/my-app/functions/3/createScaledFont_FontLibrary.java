public Font createScaledFont(FontType fontType, FontSize fontSize, int style) {
    return createFont(fontType, fontSize, style, scaleFactor);
}