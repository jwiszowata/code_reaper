public Dimension getPreferredSize() {
    if (this.goodsIcon == null)
        return new Dimension(0, 0);
    int drawImageCount = Math.max(1, Math.min(Math.abs(getAmount()), this.maxIcons));
    int iconWidth = this.goodsIcon.getIconWidth();
    int pixelsPerIcon = iconWidth / 2;
    if (pixelsPerIcon - iconWidth < 0) {
        pixelsPerIcon = (compressedWidth - iconWidth) / drawImageCount;
    }
    int maxSpacing = iconWidth;
    boolean iconsTooFarApart = pixelsPerIcon > maxSpacing;
    if (iconsTooFarApart)
        pixelsPerIcon = maxSpacing;
    int width = pixelsPerIcon * (drawImageCount - 1) + iconWidth;
    if (this.stringImage != null) {
        width = Math.max(this.stringImage.getWidth(null), width);
    }
    return new Dimension(width, goodsIcon.getImage().getHeight(null));
}