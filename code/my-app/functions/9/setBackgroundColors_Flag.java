public Flag setBackgroundColors(Color... colors) {
    backgroundColors.clear();
    for (Color color : colors) {
        if (color != null) {
            backgroundColors.add(color);
        }
    }
    return this;
}