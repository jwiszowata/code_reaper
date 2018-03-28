public final void setColor(Color color) {
    this.color = color;
    setBackground(color);
    setText(color == null ? "X" : null);
}