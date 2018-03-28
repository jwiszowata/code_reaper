private static String getFontKey(FontType fontType) {
    String fontName;
    switch(fontType) {
        case NORMAL:
            fontName = (mainFont != null) ? null : "font.normal";
            break;
        case SIMPLE:
            fontName = "font.simple";
            break;
        case HEADER:
            fontName = "font.header";
            break;
        default:
            logger.warning("Unknown FontType: " + fontType.toString());
            return null;
    }
    return fontName;
}