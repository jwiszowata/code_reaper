public static Color getStringBorderColor(Color color) {
    return (color.getRed() * 0.3 + color.getGreen() * 0.59 + color.getBlue() * 0.11 < 10) ? Color.WHITE : Color.BLACK;
}