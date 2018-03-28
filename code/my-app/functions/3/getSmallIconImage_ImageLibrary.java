public BufferedImage getSmallIconImage(FreeColSpecObjectType type) {
    return getMiscImage("image.icon." + type.getId(), scaleDimension(ICON_SIZE, scaleFactor * 0.75f));
}