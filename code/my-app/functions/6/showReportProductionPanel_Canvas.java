public void showReportProductionPanel() {
    ReportProductionPanel r = getExistingFreeColPanel(ReportProductionPanel.class);
    if (r == null) {
        showSubPanel(new ReportProductionPanel(freeColClient), true);
    }
}