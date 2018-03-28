protected JButton getUnitButton(final UnitType unitType, String roleId) {
    ImageIcon unitIcon = new ImageIcon(getImageLibrary().getSmallUnitImage(unitType, roleId, false));
    JButton unitButton = getButton(unitType, null, unitIcon);
    unitButton.setHorizontalAlignment(JButton.LEFT);
    return unitButton;
}