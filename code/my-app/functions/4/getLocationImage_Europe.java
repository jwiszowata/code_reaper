public ImageIcon getLocationImage(int cellHeight, ImageLibrary library) {
    Nation nation = this.getOwner().getNation();
    return new ImageIcon(ImageLibrary.getMiscIconImage(nation, new Dimension(-1, cellHeight)));
}