public void showReportCargoPanel() {
    ReportCargoPanel r = getExistingFreeColPanel(ReportCargoPanel.class);
    if (r == null) {
        showSubPanel(new ReportCargoPanel(freeColClient), true);
    }
}