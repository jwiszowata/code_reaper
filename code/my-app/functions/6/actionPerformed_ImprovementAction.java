public void actionPerformed(ActionEvent ae) {
    Unit unit = getGUI().getActiveUnit();
    if (unit == null)
        return;
    igc().changeWorkImprovementType(unit, improvement);
}