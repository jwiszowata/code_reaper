public void showCompactLabourReport(UnitData unitData) {
    CompactLabourReport details = new CompactLabourReport(freeColClient, unitData);
    details.initialize();
    showSubPanel(details, false);
}