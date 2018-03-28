public BufferedImage getSmallerIconImage(FreeColSpecObjectType type) {
    return getMiscImage("image.icon." + type.getId(), scaleDimension(ICON_SIZE, scaleFactor * 0.5f));
}