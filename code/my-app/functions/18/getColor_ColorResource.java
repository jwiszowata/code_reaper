public static Color getColor(String colorName) {
    if (isHexString(colorName)) {
        try {
            int col = Integer.decode(colorName);
            return new Color(col, colorName.length() > 8);
        } catch (NumberFormatException e) {
            logger.warning("Failed to decode hex colour string: " + colorName);
        }
    } else {
        try {
            Field field = Color.class.getField(colorName);
            return (Color) field.get(null);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException | SecurityException e) {
            logger.log(Level.WARNING, "Failed to decode colour", e);
        }
    }
    return REPLACEMENT_COLOR;
}