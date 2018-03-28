public void showReportMilitaryPanel() {
    ReportMilitaryPanel r = getExistingFreeColPanel(ReportMilitaryPanel.class);
    if (r == null) {
        showSubPanel(new ReportMilitaryPanel(freeColClient), true);
    }
}