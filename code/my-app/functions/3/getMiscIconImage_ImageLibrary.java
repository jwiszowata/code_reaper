public static BufferedImage getMiscIconImage(FreeColSpecObjectType type, Dimension size) {
    return ResourceManager.getImage("image.miscicon." + type.getId(), size);
}