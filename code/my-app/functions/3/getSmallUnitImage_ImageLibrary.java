public BufferedImage getSmallUnitImage(UnitType unitType, String roleId, boolean grayscale) {
    return getUnitImage(unitType, roleId, false, grayscale, scaleFactor * 0.75f);
}