public Color getColor() {
    Color color = null;
    try {
        int rgb = getIntegerAttribute(COLOR_TAG, 0);
        color = new Color(rgb);
    } catch (NumberFormatException nfe) {
    }
    return color;
}