public BufferedImage getTinyUnitImage(UnitType unitType, boolean grayscale) {
    return getUnitImage(unitType, unitType.getDisplayRoleId(), false, grayscale, scaleFactor * 0.25f);
}