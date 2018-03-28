public BufferedImage getSmallerUnitImage(UnitType unitType) {
    return getUnitImage(unitType, unitType.getDisplayRoleId(), false, false, scaleFactor * 0.5f);
}