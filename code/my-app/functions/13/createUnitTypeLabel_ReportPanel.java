protected JLabel createUnitTypeLabel(AbstractUnit au) {
    UnitType unitType = au.getType(getSpecification());
    String roleId = au.getRoleId();
    int count = au.getNumber();
    ImageIcon unitIcon = new ImageIcon(getImageLibrary().getSmallUnitImage(unitType, roleId, (count == 0)));
    JLabel unitLabel = new JLabel(unitIcon);
    unitLabel.setText(String.valueOf(count));
    if (count == 0) {
        unitLabel.setForeground(Color.GRAY);
    }
    unitLabel.setToolTipText(au.getDescription());
    return unitLabel;
}