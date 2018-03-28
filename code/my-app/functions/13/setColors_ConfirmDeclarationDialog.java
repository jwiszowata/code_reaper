private void setColors() {
    this.flag.setUnionColor(this.unionColor.getColor());
    this.flag.setStarColor(this.starColor.getColor());
    this.flag.setDecorationColor(this.decorationColor.getColor());
    List<Color> colors = new ArrayList<>();
    for (ColorButton button : this.backgroundColors) {
        Color color = button.getColor();
        if (color != null) {
            colors.add(color);
        }
        this.flag.setBackgroundColors(colors);
    }
}