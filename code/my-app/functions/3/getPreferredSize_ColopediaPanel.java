public Dimension getPreferredSize() {
    return new Dimension((int) (200 * getImageLibrary().getScaleFactor()), super.getPreferredSize().height);
}