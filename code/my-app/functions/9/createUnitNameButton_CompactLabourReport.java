private JButton createUnitNameButton(String name, LabourData.UnitData unitData) {
    JButton button = createButton(name, (ActionEvent ae) -> {
        getGUI().showCompactLabourReport(unitData);
    });
    if (!unitData.isSummary()) {
        button.setIcon(new ImageIcon(getImageLibrary().getUnitImage(unitData.getUnitType())));
    }
    return button;
}