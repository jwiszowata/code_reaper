public Font getFont() {
    if (font == null) {
        font = FontResource.getEmergencyFont();
        logger.warning("Font is null");
    }
    return font;
}