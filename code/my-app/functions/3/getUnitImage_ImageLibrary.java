public static BufferedImage getUnitImage(Unit unit, Dimension size) {
    return getUnitImage(unit.getType(), unit.getRole().getId(), unit.hasNativeEthnicity(), size);
}