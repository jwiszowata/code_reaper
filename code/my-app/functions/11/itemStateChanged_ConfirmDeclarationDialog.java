public void itemStateChanged(ItemEvent e) {
    Background newBackground = (Background) this.background.getSelectedItem();
    Decoration newDecoration = (Decoration) this.decoration.getSelectedItem();
    UnionPosition newPosition = (UnionPosition) this.unionPosition.getSelectedItem();
    UnionShape newShape = (UnionShape) this.unionShape.getSelectedItem();
    this.flag = new Flag(newBackground, newDecoration, newPosition, newShape);
    this.flag.setStars(this.stars.getSelectedIndex() + 1);
    this.flag.setStripes(this.stripes.getSelectedIndex() + 1);
    setColors();
    this.label.setIcon(new ImageIcon(this.flag.getImage()));
}