public JButton createColonyButton(final Colony colony) {
    String text = colony.getName();
    if (!unitData.isSummary()) {
        if (colony.canTrain(unitData.getUnitType())) {
            text += "*";
        }
    }
    return createButton(text, (ActionEvent ae) -> {
        getGUI().showColonyPanel(colony, null);
    });
}