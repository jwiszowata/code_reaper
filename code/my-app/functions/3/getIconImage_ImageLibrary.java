public BufferedImage getIconImage(FreeColSpecObjectType type) {
    return getMiscImage("image.icon." + type.getId(), scaleDimension(ICON_SIZE, scaleFactor));
}