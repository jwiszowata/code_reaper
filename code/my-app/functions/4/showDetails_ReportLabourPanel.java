private void showDetails() {
    UnitType unitType = panelList.getSelectedValue().unitType;
    getGUI().showReportLabourDetailPanel(unitType, this.data, this.unitCount, this.colonies);
}