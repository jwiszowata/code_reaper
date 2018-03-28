public void showReportIndianPanel() {
    ReportIndianPanel r = getExistingFreeColPanel(ReportIndianPanel.class);
    if (r == null) {
        showSubPanel(new ReportIndianPanel(freeColClient), true);
    }
}